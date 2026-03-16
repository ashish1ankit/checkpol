pipeline {
    agent any // Run on any available Jenkins worker

    stages {
        stage('Checkout') {
            steps {
                // This step pulls your code from Git automatically
                checkout scm
            }
        }

        stage('Build & Test') {
            steps {
                // Use the Gradle wrapper included in your project
                // 'chmod +x' ensures the script has permission to run
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }

        stage('Archive Artifact') {
            steps {
                // This saves the JAR file so you can download it from Jenkins
                archiveArtifacts artifacts: 'build/libs/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            // Good for interviews: Always clean up after yourself
            deleteDir()
        }
        success {
            echo 'Build finished successfully!'
        }
    }
}