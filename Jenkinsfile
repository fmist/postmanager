pipeline {
    agent any
    tools {
        gradle "GRADLE"
    }
    stages {
        stage('Build') {
            steps {
                git 'https://github.com/fmist/postmanager.git'
                sh "gradle clean build -DskipTests"
            }
        }

        stage('Prepare container') {
             steps {
               sh 'gradle dockerStop'
               sh 'gradle dockerRemoveContainer'
             }
        }

        stage('Build Docker image') {
            steps {
                sh 'gradle docker'
            }
        }

        stage('Run docker container') {
            steps {
                sh 'gradle dockerRun'
            }
        }

        stage('Delete unused images') {
            steps {
                sh 'docker image prune --all -f'
            }
        }
    }
      post {
          always {
            cleanWs()
          }
      }
}