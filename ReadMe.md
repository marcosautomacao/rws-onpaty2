docker build --tag teste .

docker run --publish 8000:8080 --detach teste