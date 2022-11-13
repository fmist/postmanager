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
                bat 'gradle docker'
            }
        }
        stage('Remove container') {
            steps {
                bat 'docker rm $(docker ps -a -q)'
            }
        }
        stage('Remove image') {
            steps {
                bat 'docker rmi $(docker images -q)'
            }
        }
        stage('Run docker container') {
            steps {
                bat 'gradle dockerRun'
            }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}