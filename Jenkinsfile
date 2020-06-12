pipeline {
    agent any
    tools {
        maven 'Maven 3'
        jdk 'Java 8'
    }
    options {
        buildDiscarder(logRotator(artifactNumToKeepStr: '5'))
    }
    stages {
        stage ('Build') {
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    archiveArtifacts artifacts: '**/target/*.jar', excludes: '**/target/floodgate-*-*.jar', fingerprint: true
                }
            }
        }

        stage ('Deploy') {
            when {
                anyOf {
                    branch "master"
                    branch "development"
                }
            }
            steps {
                sh 'echo Skipping'
            }
        }
    }

    post {
        always {
            deleteDir()
        }
    }
}
