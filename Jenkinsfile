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
                        echo 'Deploying to Ubuntu Server via Docker Compose...'
                        sh '''
                        # Stop and remove the old containers safely
                        docker compose down || true

                        # Start the database and the app together in the background
                        docker compose up -d
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
                 -d '{"content": "✅ **SUCCESS:** Spring Boot App built and deployed perfectly! Check it at http://192.168.1.23:8081/check"}' \
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
