pipeline {
    agent any

    stages {
        stage('Build Docker Image') {
            steps {
                echo 'Building the Docker Image...'
                sh 'docker build -t my-app .' 
            }
        }
        stage('Deploy Container') {
            steps {
                echo 'Deploying to Ubuntu Server...'
                sh '''
                # Stop and remove the old version if it is running
                docker stop my-app-container || true
                docker rm my-app-container || true
                
                # Start the new version with a Volume mapped for logs
                docker run -d -p 8081:8080 --name my-app-container -v /var/log/my-spring-app:/app/logs my-app
                '''
            }
        }
    }
    // NEW: The Post block runs after the stages finish
    post {
        success {
            sh """
            curl -H "Content-Type: application/json" \
                 -X POST \
                 -d '{"content": "✅ **SUCCESS:** Spring Boot App built and deployed perfectly! Check it at http://myapp.local"}' \
                 https://discord.com/api/webhooks/1483537963190190222/bLZFaZ0F409QMHH1ylD2E--EGpFHD8sg7ZNC4TYYZIAgWaAQzsz49324ZFyflpOyBBDj
            """
        }
        failure {
            sh """
            curl -H "Content-Type: application/json" \
                 -X POST \
                 -d '{"content": "🚨 **FAILED:** Someone broke the build! The Jenkins pipeline crashed."}' \
                 https://discord.com/api/webhooks/1483537963190190222/bLZFaZ0F409QMHH1ylD2E--EGpFHD8sg7ZNC4TYYZIAgWaAQzsz49324ZFyflpOyBBDj
            """
        }
    }
}
