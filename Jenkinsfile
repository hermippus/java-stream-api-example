pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/hermippus/stream-api-study'
            }
        }
        stage('Build') {
            steps {
                sh './gradlew clean nativeCompile'
            }
        }
        stage('Archive Artifact') {
            steps {
                archiveArtifacts artifacts: 'build/native/nativeCompile/*', fingerprint: true
            }
        }
    }
}