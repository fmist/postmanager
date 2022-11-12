pipeline {
    agent any
        tools {
            gradle "gradle"
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
                sh 'docker build --tag=app:latest .'
            }
        }
        stage('Docker run') {
            steps {
            sh 'docker run -p8887:8083 app:latest'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}