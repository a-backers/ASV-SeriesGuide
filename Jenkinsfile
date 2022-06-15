pipeline {
    agent any

    environment {
            ANDROID_SDK_ROOT = '/var/jenkins_home/tools/android-sdk'
        }

    stages {
        stage('Build') {
            steps {
                echo 'build has started'
            }
        }
        stage('Test') {
            steps {
                echo 'test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}