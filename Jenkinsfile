pipeline {
    agent any
  
    stages{
        stage('Build Maven'){
            steps{
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/ashokvb/Simplilearn']]])
                bat 'mvn clean package'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t javatechie/devops-integration .'
                }
            }
        }

        }
   
    }

