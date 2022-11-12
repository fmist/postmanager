pipeline {
    agent any
    tools {
        gradle "GRADLE"
    }
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/fmist/postmanager.git'
                bat "gradle clean build -DskipTests"
            }
        }
        stage('Build Docker image') {
            steps {
                bat 'docker build --tag=post:latest .'
            }
        }
        stage('Run docker image') {
            steps {
                bat 'docker run -p8887:8083 post:latest'
            }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}