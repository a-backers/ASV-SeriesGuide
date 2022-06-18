pipeline {
    agent any

    environment {
            ANDROID_SDK_ROOT = '/var/jenkins_home/tools/android-sdk'
        }

    stages {
        stage('Build') {
            steps {
                echo 'building....'
                bat "set"
            }
        }
        stage('Test') {
            steps {
                echo 'test'
                bat "set"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}