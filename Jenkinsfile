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

        stage('Prepare container') {
             steps {
               bat 'dockerStop'
               bat 'dockerRemoveContainer'
             }
        }

        stage('Build Docker image') {
            steps {
                bat 'gradle docker'
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