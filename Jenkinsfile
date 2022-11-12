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
        stage('Deploy') {
            steps {
                bat 'docker build --tag=post:latest .'
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