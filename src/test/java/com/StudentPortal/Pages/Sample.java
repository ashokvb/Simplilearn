package com.StudentPortal.Pages;



import java.util.Base64;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Sample {



public static void main(String[] args) throws InterruptedException {
//System.setProperty("webdriver.chrome.driver", "C:\\Drivers1\\chromedriver.exe");
//WebDriver driver = new ChromeDriver();
//driver.get("https://sisclientweb-900070.campusnexus.cloud");
//Thread.sleep(15000);
//driver.manage().window().maximize();
//Thread.sleep(5000);
String encrptData= "Dcrc@2024";
//String decrptData  ="VGVzdEA0MzIx";
//byte[] decodeBytes = Base64.getDecoder().decode(decrptData.getBytes());
//driver.findElement(By.xpath("//input[@id='username']")).sendKeys("vasudevv@900070cust.campusnexus.cloud");
//Thread.sleep(2000);
//driver.findElement(By.xpath("//input[@id='password']")).sendKeys(new String(decodeBytes));
//Thread.sleep(2000);
//driver.findElement(By.xpath("//button[@id='btnLogin']")).click();
byte[] encodedBytes = Base64.getEncoder().encode(encrptData.getBytes());



       
System.out.println("encodedBytes --------------->" + new String(encodedBytes));
//System.out.println("decodedBytes --------------->" + new String(decodeBytes));



}
}