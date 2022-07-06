pipeline {
    agent any

    environment {
            ANDROID_SDK_ROOT = 'c:\\users\\Administrator\\AppData\\Local\\Android\\Sdk'
            JAVA_HOME = 'c:\\Program Files\\Java\\jdk-11.0.15'
            GRADLE_USER_HOME = 'c:\\Gradle'
        }

    stages {
        stage('Build') {
            steps {
                echo 'building....'
                bat "gradlew widgets:clean billing:clean api:clean app:clean widgets:assembleDebug api:assembleDebug billing:assembleDebug app:assemblePureDebug"
            }
        }
        stage('Test build') {
            steps {
                echo 'Test Build with Coverage'
                bat "set"
                // bat "gradlew app:assembleAndroidTest"
                bat "gradlew widgets:generateDebugSources widgets:createMockableJar widgets:generateDebugAndroidTestSources widgets:compileDebugUnitTestSources widgets:compileDebugAndroidTestSources widgets:compileDebugSources billing:generateDebugSources billing:createMockableJar billing:generateDebugAndroidTestSources billing:compileDebugUnitTestSources billing:compileDebugAndroidTestSources billing:compileDebugSources app:generatePureDebugSources app:createMockableJar app:generatePureDebugAndroidTestSources app:compilePureDebugUnitTestSources app:compilePureDebugAndroidTestSources app:compilePureDebugSources api:generateDebugSources api:createMockableJar api:generateDebugAndroidTestSources api:compileDebugUnitTestSources api:compileDebugAndroidTestSources api:compileDebugSources"
            }
        }
        
        stage('Test') {
            steps {
                echo 'test'
                bat "gradlew app:testPureDebugUnitTest"
            }
        }
        
        stage('Test Coverage') {
            steps {
                step( [ $class: 'JacocoPublisher',
                       execPattern: '**/build/jacoco/**.exec'
                ] )
            }
        }
        
        stage('SonarQube Analysis') {
        environment {
            SONARSCANNER_HOME = tool 'SonarQube_local'
            }
            steps {
                tool name: 'SonarQube_local', type: 'hudson.plugins.sonar.SonarRunnerInstallation'
                withSonarQubeEnv('SonarQube_local') {
                    bat "set"
                    bat "${SONARSCANNER_HOME}/bin/sonar-scanner \
                    -D sonar.projectKey=sonarqube_school_test \
                    -D sonar.java.binaries=** \
                    -D sonar.host.url=http://10.168.10.52:9000/"
                }
            }
        }

        stage('Sonar Quality Gate') {
            steps {
                timeout(time: 2, unit: 'MINUTES') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
