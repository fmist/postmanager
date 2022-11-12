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
        stage('Deploy') {
            steps {
                docker build --tag=app:latest .
                docker run -p8887:8883 app:latest  
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}