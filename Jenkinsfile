pipeline {
    agent any

    environment {
            ANDROID_SDK_ROOT = '/var/jenkins_home/tools/android-sdk'
        }

    stages {
        stage('Build') {
            steps {
                echo 'building....'
                sh "build"
            }
        }
        stage('Test') {
            steps {
                echo 'test'
                sh "./gradlew clean build"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}