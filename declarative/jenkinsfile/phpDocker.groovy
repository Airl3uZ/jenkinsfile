pipeline {

  /*
   * Run everything on an existing agent configured with a label 'docker'.
   * This agent will need docker, git and a jdk installed at a minimum.
   */
  agent any

  // environment {
  //   //Use Pipeline Utility Steps plugin to set env variables
  //   IMAGE = webdevops/php-nginx
  //   VERSION = latest
  // }

  stages {
    stage('checkout git'){
      // git url: https://github.com/Airl3uZ/demo-php-ci.git
      steps {
          checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: 'https://github.com/Airl3uZ/demo-php-ci.git']]])
      }    
    }
    stage('run php docker') {
      steps {
        script {
          docker.image('webdevops/php-nginx:latest').inside("-v app:/app -p 80:80 ,
            -e TZ="Asia/Bangkok" ,
            -e PHP_UPLOAD_MAX_FILESIZE=500m ,
            -e FPM_PM_MAX_CHILDREN=100 ,
            -e FPM_PM_START_SERVERS=50 ,
            -e FPM_PM_MIN_SPARE_SERVERS=25 ,
            -e FPM_PM_MAX_SPARE_SERVERS=100 ,
            -e FPM_PROCESS_IDLE_TIMEOUT=10s ,
            -e fpm.pool.listen=0.0.0.0:9000 ,
            -e fpm.pool.pm.status_path='/status.php'") {
            sh 'cd /app && pwd && composer update && ./vendor/bin/phpunit'
          }
        }
      }
      post {
        success {
          // we only worry about archiving the jar file if the build steps are successful
          // archiveArtifacts(artifacts: '**/target/*.jar', allowEmptyArchive: true)
          echo 'success'
        }
      }
    }

  //   stage('Quality Analysis') {
  //     parallel {
  //       // run Sonar Scan and Integration tests in parallel. This syntax requires Declarative Pipeline 1.2 or higher
  //       stage ('Integration Test') {
  //         agent any  //run this stage on any available agent
  //         steps {
  //           echo 'Run integration tests here...'
  //         }
  //       }
  //       stage('Sonar Scan') {
  //         agent {
  //           docker {
  //             // we can use the same image and workspace as we did previously
  //             reuseNode true
  //             image 'maven:3.5.0-jdk-8'
  //           }
  //         }
  //         environment {
  //           //use 'sonar' credentials scoped only to this stage
  //           SONAR = credentials('sonar')
  //         }
  //         steps {
  //           sh 'mvn sonar:sonar -Dsonar.login=$SONAR_PSW'
  //         }
  //       }
  //     }
  //   }

  //   stage('Build and Publish Image') {
  //     when {
  //       branch 'master'  //only run these steps on the master branch
  //     }
  //     steps {
  //       /*
  //        * Multiline strings can be used for larger scripts. It is also possible to put scripts in your shared library
  //        * and load them with 'libaryResource'
  //        */
  //       sh """
  //         docker build -t ${IMAGE} .
  //         docker tag ${IMAGE} ${IMAGE}:${VERSION}
  //         docker push ${IMAGE}:${VERSION}
  //       """
  //     }
  //   }
  // }

  // post {
  //   failure {
  //     // notify users when the Pipeline fails
  //     mail to: 'team@example.com',
  //         subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
  //         body: "Something is wrong with ${env.BUILD_URL}"
  //   }
  // }
}
