pipeline {
    agent { docker { image 'webdevops/php-nginx:latest' } }

    stages {
    //     stage('checkout code') {
    //         steps {
    //             checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Airl3uZ/demo-php-ci.git']]])
    //         }
    //     }
        stage('build docker') {
            steps {
                sh 'git clone https://github.com/Airl3uZ/demo-php-ci.git'
                sh 'cp -r /demo-php-ci/ /app'
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