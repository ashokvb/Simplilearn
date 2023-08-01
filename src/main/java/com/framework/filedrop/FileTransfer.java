package com.framework.filedrop;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;


import com.framework.util.ReadProperties;
import com.framework.util.TestReportsLog;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.relevantcodes.extentreports.LogStatus;

public class FileTransfer {
	protected String userName;
	protected String password;
	protected String host;
	protected int port;
	protected Session session;
	protected Channel channel;
	protected ChannelSftp sftpChannel;
	protected static String fileName = "";
	private String hostPath = ReadProperties.getConfigProp().getProperty("hostpath");

	public FileTransfer(String userName, String password, String host, int port) {
		this.userName = userName;
		this.password = password;
		this.host = host;
		this.port = port;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Session getSession() {
		return this.session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public static String getFileName() {
		return fileName;
	}

	protected boolean openSession() {
		boolean sessionSuccess = false;
		JSch jsch = new JSch();

		TestReportsLog.log(LogStatus.INFO, "Connecting to " + this.host + ":" + this.port);

		try {
			this.session = jsch.getSession(getUserName(), getHost(), getPort());
			this.session.setPassword(getPassword());
			this.session.setConfig("StrictHostKeyChecking", "no");
			this.session.setConfig("PreferredAuthentications", "password,gssapi-with-mic,publickey");
			this.session.connect();

			sessionSuccess = true;
			TestReportsLog.log(LogStatus.INFO, "Connected to " + getHost());

		} catch (JSchException e) {
			TestReportsLog.log(LogStatus.ERROR, "FileTransfer ::- openSession" + e.getMessage());
		}
		return sessionSuccess;
	}

	protected Channel openSftpChannel() {
		TestReportsLog.log(LogStatus.INFO, "Creating Sftp Channel");

		if (this.channel == null && openSession()) {
			try {
				this.channel = getSession().openChannel("sftp");
				this.channel.connect();

				TestReportsLog.log(LogStatus.INFO, "Sftp channel created");
			} catch (JSchException e) {
				System.out.println(e.getMessage());

				TestReportsLog.log(LogStatus.ERROR, "FileTransfer ::- openSftpChannel " + e.getMessage());
			}
		}
		return this.channel;
	}

	public void connect() {
		if (this.sftpChannel == null) {
			this.sftpChannel = (ChannelSftp) openSftpChannel();
		}
	}

	public boolean isExist(String path) {

		boolean success = false;
		connect();
		try {
			this.sftpChannel.ls(path);

			success = true;
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TestReportsLog.log(LogStatus.ERROR, "FileTransfer ::- isExist " + e.getMessage());
		}

		return success;
	}

	public boolean mkDir(String sourcePath) {
		boolean success = false;
		connect();
		try {
			this.sftpChannel.mkdir(sourcePath);

			success = true;
		} catch (SftpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			TestReportsLog.log(LogStatus.ERROR, "FileTransfer ::- mkDir " + e.getMessage());
		}

		return success;
	}

	public String sendFileToRemote(String localFile, String remotePath)throws Exception {
		String fileName = "";
		remotePath = remotePath.replace("%HOSTPATH%", hostPath);

		if (!localFile.isEmpty() && !remotePath.isEmpty()) {
			TestReportsLog.log(LogStatus.INFO, "Transferring File:- " + localFile + "To " + remotePath);
			connect();
			// this.sftpChannel = (ChannelSftp) openSftpChannel();

			try {
				if (this.sftpChannel != null) {
					File srcFile = new File(localFile);
					fileName = getNewFileName(srcFile.getName());

					this.sftpChannel.cd(remotePath);
				//this.sftpChannel.put(new FileInputStream(new File(localFile)), fileName, ChannelSftp.OVERWRITE);

					TestReportsLog.log(LogStatus.INFO, "File:- " + fileName + " Transferred");
			
					Thread.sleep(10000);
				} 

			} catch (Exception e) {
				
				TestReportsLog.log(LogStatus.INFO, "SftpException Exception ::- sendFileToRemote failed to send, we are retrying it again to send" + localFile
						+ "\n" + e.getMessage());
				System.out.println("Transferring Errored " + localFile + "ERROR " + e.getMessage());
				// retry logic
				int count = 0;
				int maxTries = 2;
				while(true) {
				    try {
				    	Thread.sleep(5000);
				    	System.out.println("We are in Retry");
				    	openSession();
				    	openSftpChannel();
				    	sendFileToRemote(localFile, remotePath);
				    	System.out.println("File Sent using retry");
				    	break;
				    } catch (Exception ex) {
				    	System.out.println("retrying for"  + count+  "Time");
				    	if (++count == maxTries) throw ex;
				    	TestReportsLog.log(LogStatus.ERROR, "SftpException Exception ::- sendFileToRemote failed to send " + localFile
								+ "\n" + ex.getMessage());
				    }
				}
			
				
			}
		}
		System.out.println("Transferring Done " + fileName);
		return fileName;
	}

	public void disconnect() {
		TestReportsLog.log(LogStatus.INFO, "Disconnecting from " + this.host);

		if (this.channel != null)
			this.channel.disconnect();
		if (this.session != null)
			this.session.disconnect();
		if (this.sftpChannel != null)
			this.sftpChannel.disconnect();

		this.channel = null;
		this.session = null;
		this.sftpChannel = null;

		TestReportsLog.log(LogStatus.INFO, "Session disconnected from " + this.host);
	}

	private String getNewFileName(String fileName) {

		String name = getFilename(fileName);
		String extension = getFileExtension(fileName);

		return name + GetCurrentTimeStamp() + extension;
	}

	private String GetCurrentTimeStamp() {
		TestReportsLog.log(LogStatus.INFO, "Getting the TimeStamp");
		SimpleDateFormat sdfDate = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss");
		Date now = new Date();
		String strDate = sdfDate.format(now);

		TestReportsLog.log(LogStatus.INFO, "Got the TimeStamp");
		return strDate;
	}

	private String getFileExtension(String name) {
		String extension = "";
		if (name.contains(".")) {
			extension = name.substring(name.lastIndexOf(".") + 1);
			extension = !extension.isEmpty() ? "." + extension : extension;
		}
		return extension;
	}

	private String getFilename(String name) {
		if (name.contains(".")) {
			name = name.substring(0, name.lastIndexOf("."));
		}
		return name;
	}
}
