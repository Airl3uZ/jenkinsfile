pipeline {

  environment {
      dockerfile = "$app.'dockerfile'"

}
  agent {
    dockerfile {
      filename 'laravel.Dockerfile'
    }
  }
}
