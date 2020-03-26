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
            }
            steps {
                sh label: '', script: 'cd demo-php-ci'
            }
            steps {
                sh label: '', script: 'pwd'
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