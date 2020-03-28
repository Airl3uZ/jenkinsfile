pipeline {
  agent {
    // dockerfile {
    //   /*
    //    * This assumes that a "Dockerfile" is in the current workspace
    //    * A new container will be build with the args below and the pipeline will run inside that container.
    //    */
    //   args "-v /tmp:/tmp -p 8000:8000"
    // }
    docker {
      image "webdevops:php-nginx:latest"
      args "-v app:/app -p 80:80 \
      -e TZ="Asia/Bangkok" \
      -e PHP_UPLOAD_MAX_FILESIZE=500m \
      -e FPM_PM_MAX_CHILDREN=100 \
      -e FPM_PM_START_SERVERS=50 \
      -e FPM_PM_MIN_SPARE_SERVERS=25 \
      -e FPM_PM_MAX_SPARE_SERVERS=100 \
      -e FPM_PROCESS_IDLE_TIMEOUT=10s \
      -e fpm.pool.listen=0.0.0.0:9000 \
      -e fpm.pool.pm.status_path='/status.php'"
    }
  }
  stages {
    stage("composer update") {
      withDir('app') {
        pwd
      }
    }
  }
}
