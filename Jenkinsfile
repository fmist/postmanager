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
                sh 'sudo docker build -t <fmist>/<dckr_pat_zSn9mAYwkaeVLFXiAYo2coim9bE>:$post .'
                sh 'docker run -p8887:8083 post:latest'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}