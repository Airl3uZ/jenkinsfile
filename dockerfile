FROM webdevops/php-nginx:latest
git clone https://github.com/Airl3uZ/demo-php-ci.git
WORKDIR demo-php-ci
COPY ./* /app
WORKDIR /app
RUN composer update


