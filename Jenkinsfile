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
               sh 'sudo docker build -t fmist/post:$BUILD_NUMBER .'
               echo 'Build Image Completed'
           }
        }
        stage('Login to Docker Hub') {
              steps{
        	sh 'echo $DOCKERHUB_CREDENTIALS_PSW | sudo docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
        	echo 'Login Completed'
            }
        }
        stage('Push Image to Docker Hub') {
              steps{
        	sh 'sudo docker push fmist/post:$BUILD_NUMBER'
        	echo 'Push Image Completed'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}