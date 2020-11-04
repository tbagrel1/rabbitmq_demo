# RabbitMQ Demo

## Build

```bash
./mvnw clean package
```

## Launch sender

```bash
java -Dserver.port=8081 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active="sender"
```

## Launch receiver

```bash
java -Dserver.port=8082 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active=receiver
```
