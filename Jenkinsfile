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
                
                # Start the new version (adjust port 8080:80 as needed)
                docker run -d -p 8081:80 --name my-app-container my-app
                '''
            }
        }
    }
}
