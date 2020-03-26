pipeline {
    agent any

    stages {
        stage('checkout code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Airl3uZ/demo-php-ci.git']]])
            }
        }
        stage('Build') {
            steps {
                echo 'deploy docker'
                sh "docker-compose up -d"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "./vendor/bin/phpunit"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}