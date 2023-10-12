pipeline {
    agent any
    tools{
        maven 'apache-maven-3.9.3'
    }
    stages{
        stage('Checkout and Build the Artifact'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ashokvb/Simplilearn']]])
                sh 'mvn clean package'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t javatechie/devops-integration .'
                }
            }
        }

        }
   
    }

