pipeline {
    // agent any
    agent { 
        docker {
            image: 'webdevops/php-nginx:latest'
            registryUrl: 'https://hub.docker.com'
        }

    stages {
    //     stage('checkout code') {
    //         steps {
    //             checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Airl3uZ/demo-php-ci.git']]])
    //         }
    //     }
        stage('build docker') {
            // docker.image('webdevpos/php-nginx:lastest').inside('-v /var/run/docker.sock:/var/run/docker.sock') {
            steps {
                sh 'git clone https://github.com/Airl3uZ/demo-php-ci.git'
                sh 'cp -r /demo-php-ci/ /app'
                sh 'cd /app'
                sh 'composer update'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                // sh "./vendor/bin/phpunit"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}