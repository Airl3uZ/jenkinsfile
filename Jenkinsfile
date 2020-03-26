pipeline {
    agent any

    stages {
        stage('checkout code') {
            steps {
                git clone 'https://github.com/Airl3uZ/demo-php-ci.git'
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}