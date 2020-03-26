pipeline {
    agent any

    stages {
        stage('welcome') {
            steps {
                echo 'Jenkinsfile from git'
            }
        }
    stages {
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