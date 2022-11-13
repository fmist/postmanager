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
                bat 'docker build -t app.jar .'
            }
        }
        stage('Run docker image') {
            steps {
                bat 'docker run -p8887:8083 app.jar'
            }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}