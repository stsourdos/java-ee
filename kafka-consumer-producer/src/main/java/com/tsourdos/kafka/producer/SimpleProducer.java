package com.tsourdos.kafka.producer;

import com.google.common.io.Resources;
import com.tsourdos.kafka.consumer.SimpleConsumer;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author s.tsourdos
 */
public class SimpleProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleConsumer.class);
    private static final String CONFIG_FILE = "producer.properties";

    public static void main(String[] args) throws Exception {

        Properties properties = loadApplicationProperties();

        String topicName = properties.getProperty("topic");
        properties.remove("topic");

        try (KafkaProducer<String, String> producer = new KafkaProducer(properties)) {
            LOGGER.info("To exit hit Ctrl+D/Z or type: 'quit'");
            Scanner scanner = new Scanner(System.in);
            int i = 1;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("quit")) {
                    break;
                }
                producer.send(new ProducerRecord(topicName, Integer.toString(i), line));
                LOGGER.info("Message sent successfully: {}", line);
                i++;
            }
        }
    }

    private static Properties loadApplicationProperties() {
        Properties properties = new Properties();

        try (InputStream props = Resources.getResource(CONFIG_FILE).openStream()) {
            properties.load(props);
        } catch (IOException | IllegalArgumentException exception) {
            LOGGER.warn("{} not found, with message: {}, loading defaults", CONFIG_FILE, exception.getMessage());
            properties = getDefaultProperties();
        }

        return properties;
    }

    private static Properties getDefaultProperties() {
        Properties props = new Properties();

        props.put("topic", "example");
        props.put("bootstrap.servers", "localhost:9092");
        props.put("acks", "all"); // Set acknowledgements for producer requests.
        props.put("retries", 0); // If the request fails, the producer can automatically retry
        props.put("batch.size", 16384); // Specify buffer size in config
        props.put("linger.ms", 1); // Reduce the no of requests less than 0
        props.put("buffer.memory", 33554432); // The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        return props;
    }
}
