pipeline {
    agent any
        tools {
            gradle "gradle"
        }
    stages {
        stage('Build') {
             steps {
                git 'https://github.com/fmist/postmanager.git'
                sh "./gradlew clean build -DskipTests"
             }
        }
        stage('Docker build') {
           steps {
               sh 'docker build --tag=post:latest .'
               echo 'Build Image Completed'
           }
        }
        stage('Docker run') {
              steps{
        	sh 'docker run -p8887:8083 post:latest'
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