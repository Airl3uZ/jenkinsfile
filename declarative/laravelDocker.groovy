pipeline{
    environment{
        dockerfile = "pipeline\laravel\dockerfile"
        args = "-p 80:3000"
    }
}