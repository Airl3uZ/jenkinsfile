
#!groovy
node('node') {

    stages {
        stage('checkout code') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Airl3uZ/demo-php-ci.git']]])
            }
        }
        stage('build docker') {
            steps {
                script {
                    // docker.image('webdevops:php-nginx:latest').withRuns('-d=true -p 8888:80'){
                        docker.image('webdevops/php-nginx:latest').inside("-v app:/app") {
                            sh 'cd /app && pwd && composer update'
                        }
                    }
                // }
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