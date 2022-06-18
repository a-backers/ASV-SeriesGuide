pipeline {
    agent any

    environment {
            ANDROID_SDK_ROOT = '/var/jenkins_home/tools/android-sdk'
            JAVA_HOME = '/Program Files/Java/jdk1.8.0_291'
        }

    stages {
        stage('Build') {
            steps {
                echo 'building....'
                bat "gradlew build"
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