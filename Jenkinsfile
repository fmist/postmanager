pipeline {
    agent any
        tools {
            gradle "gradle"
        }
        environment {
            DOCKERHUB_CREDENTIALS= credentials('pass')
        }
    stages {
        stage('Build') {
             steps {
                git 'https://github.com/fmist/postmanager.git'
                sh "gradle clean build -DskipTests"
             }
        }
        stage('Docker build') {
           steps {
               sh 'sudo docker build -t fmist/post:latest .'
               echo 'Build Image Completed'
           }
        }
        stage('Docker run') {
              steps{
        	sh 'sudo docker run -p8887:8083 post:latest'
        	echo 'Run completed'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}