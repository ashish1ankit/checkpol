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
}
