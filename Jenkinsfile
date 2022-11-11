pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        gradle "gradle"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/fmist/postmanager.git'
                // Run Maven on a Unix agent.
                sh "gradle clean build -DskipTests"
            }
        }
        stage('Deploy') {
            steps {
                sshPublisher(
                    publishers:
                        [sshPublisherDesc
                            (configName: 'deploy',
                            transfers:
                                [sshTransfer
                                    (cleanRemote: false,
                                    excludes: '',
                                    execCommand: '/home/mac/app.sh',
                                    execTimeout: 120000, flatten: false,
                                    makeEmptyDirs: false,
                                    noDefaultExcludes: false,
                                    patternSeparator: '[, ]+',
                                    remoteDirectory: '/app',
                                    remoteDirectorySDF: false,
                                    removePrefix: 'build/libs',
                                    sourceFiles: 'build/libs/*.jar',
                                    usePty: true)],
                                    usePromotionTimestamp: false,
                                    useWorkspaceInPromotion: false,
                                    verbose: false)])
            }
        }
    }
      post {
          always {
            cleanWs()
          }
        }
}