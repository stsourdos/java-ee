# Kafka Producer Consumer

### Technologies used

1. Kafka Clients
2. Google Guava for reading properties files
3. Dependency Injection

### Compile
```
mvn clean package
```

### Prerequisites

1. Install Apache Kafka from [here](https://kafka.apache.org/downloads), by choosing: Scala 2.12  - kafka_2.12-0.10.2.0.tgz (asc, md5)
2. Unzip archive and move to kafka folder

### Start the server

Start a single node built-in ZooKeeper server. For windows hit (accordingly in Unix like systems):
```
bin\windows\zookeeper-server-start.bat config\zookeeper.properties
```

Then start Kafka server. For windows hit (accordingly in Unix like systems):
```
bin\windows\kafka-server-start.bat config\server.properties
```

### Run the app

Start the consumer:
```
java -cp kafka-consumer-producer-1.0-SNAPSHOT-jar-with-dependencies.jar com.tsourdos.kafka.consumer.SimpleConsumer
```

Start the producer and send some sample messages:
```
java -cp kafka-consumer-producer-1.0-SNAPSHOT-jar-with-dependencies.jar com.tsourdos.kafka.producer.SimpleProducer
```

### Sample Output

The app uses SLF4J for logging purposes.

In producer side:
```
[main] INFO com.tsourdos.kafka.consumer.SimpleConsumer - To exit hit Ctrl+D/Z or type: 'quit'
hello
[main] INFO com.tsourdos.kafka.consumer.SimpleConsumer - Message sent successfully: hello
```

In the consumer side:
```
[main] INFO com.tsourdos.kafka.consumer.SimpleConsumer - offset = 51, key = 1, value = hello
```
