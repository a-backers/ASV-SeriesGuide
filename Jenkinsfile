pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'build has started'
                sh "./gradlew clean build"
            }
        }
        stage('Test') {
            steps {
                sh "./gradlew clean test --refresh-dependencies"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}