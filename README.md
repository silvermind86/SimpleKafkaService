# kafka-simple-test
Just a kafka stream process sandbox in Java.

### Starting a local Kafka Server
At this project root directory, type:
```bash
sudo docker-compose up
```
> You will need to install [docker](http://www.docker.com) and [docker-compose](https://docs.docker.com/compose/install/)

## Testing
You will need a kafka installation to execute the following command at kafka/bin folder.


### Create Topics
```bash
kafka-topics.sh --create --bootstrap-server 127.0.0.1:9092 --replication-factor 1 --partitions 1  --topic treated.message.box
kafka-topics.sh --create --bootstrap-server 127.0.0.1:9092 --replication-factor 1 --partitions 1  --topic message.box
```

### Start the consumer service
```bash
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic treated.message.box --from-beginning
```

### Produce messages

```bash
kafka-console-producer.sh --broker-list localhost:9092 --topic message.box
```
Here some examples of valid payloads:

```json
{"name":"Maria","yearOfBirth":"1985", "metadata":["Hello","world"]}
```
```json
{"name":"Carlos","yearOfBirth":"1986", "metadata":[]}
```