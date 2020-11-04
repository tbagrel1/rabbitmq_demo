# RabbitMQ Demo

## Build

```bash
./mvnw clean package
```

## Launch Exercise 1

### Launch sender

```bash
java -Dserver.port=8081 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active=directMessage,sender
```

### Launch receiver

```bash
java -Dserver.port=8082 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active=directMessage,receiver
```

## Launch Exercise 2

### Launch sender

```bash
java -Dserver.port=8081 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active=workQueue,sender
```

### Launch receiver

```bash
java -Dserver.port=8082 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active=workQueue,receiver
```

## Launch Exercise 3

### Launch sender

```bash
java -Dserver.port=8081 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active=pubSub,sender
```

### Launch receiver

```bash
java -Dserver.port=8082 -jar target/rabbitmq_demo-0.1.0.jar --spring.profiles.active=pubSub,receiver
```
