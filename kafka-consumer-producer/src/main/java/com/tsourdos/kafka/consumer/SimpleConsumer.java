package com.tsourdos.kafka.consumer;

import com.google.common.io.Resources;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Arrays;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author s.tsourdos
 */
public class SimpleConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleConsumer.class);
    private static final String CONFIG_FILE = "consumer.properties";

    public static void main(String[] args) throws Exception {

        Properties properties = loadApplicationProperties();

        String topicName = properties.getProperty("topic");
        properties.remove("topic");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(properties);
        consumer.subscribe(Arrays.asList(topicName));

        LOGGER.info("Consumer subscribed to topic {}", topicName);

        // simple poll implementation
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String, String> record : records) {
                // print the offset,key and value for the consumer records.
                LOGGER.info("offset = {}, key = {}, value = {}", record.offset(), record.key(), record.value());
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

    private static Properties getDefaultProperties () {
        Properties props = new Properties();

        props.put("topic", "example");
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "test");
        props.put("enable.auto.commit", "true");
        props.put("auto.commit.interval.ms", "1000");
        props.put("session.timeout.ms", "30000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        return props;
    }
}
