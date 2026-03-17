pipeline {
    agent any // Tells Jenkins to run this on the Ubuntu server

    stages {
        stage('Build Docker Image') {
            steps {
                echo 'Building the Docker Image...'
                // Builds the image and tags it as "my-app"
                sh 'docker build -t my-app .' 
            }
        }
        stage('Deploy Container') {
            steps {
                echo 'Deploying to Ubuntu Server...'
                sh '''
                // Stop and remove the old version if it's running
                docker stop my-app-container || true
                docker rm my-app-container || true
                
                // Start the new version (adjust port 8080:80 as needed for your app)
                docker run -d -p 8080:80 --name my-app-container my-app
                '''
            }
        }
    }
}
