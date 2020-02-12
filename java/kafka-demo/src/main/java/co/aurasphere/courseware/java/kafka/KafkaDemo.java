/*
 * MIT License
 *
 * Copyright (c) 2020 Donato Rimenti
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package co.aurasphere.courseware.java.kafka;

import java.util.Arrays;
import java.util.Date;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

/**
 * Apache Kafka demo. This program assumes that there's a running Kafka server
 * at the address {@value #SERVER_ADDRESS}.
 * 
 * @author Donato Rimenti
 *
 */
public class KafkaDemo {

	/**
	 * Kafka server address.
	 */
	private static final String SERVER_ADDRESS = "localhost:9092";

	/**
	 * Consumer group.
	 */
	private static final String CONSUMER_GROUP_ID = "test-consumer";

	/**
	 * Topic for messages.
	 */
	private static final String TOPIC = "test";

	/**
	 * Kafka producer/consumer configuration. For simplicity, in this example we
	 * share the configuration. In practice, though, the configurations should be
	 * split up.
	 */
	@SuppressWarnings("serial")
	private static final Properties PROPS = new Properties() {
		{
			put("bootstrap.servers", SERVER_ADDRESS);
			put("group.id", CONSUMER_GROUP_ID);
			put("key.deserializer", StringDeserializer.class.getName());
			put("value.deserializer", StringDeserializer.class.getName());
			put("key.serializer", StringSerializer.class.getName());
			put("value.serializer", StringSerializer.class.getName());
		}
	};

	/**
	 * Starts a Kafka consumer for topic {@value #TOPIC} on server
	 * {@value #SERVER_ADDRESS} with consumer group {@value #CONSUMER_GROUP_ID}.
	 */
	public static void startConsumer() {
		// Creates a consumer with the given configuration and closes it automatically
		// when done.
		try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(PROPS)) {

			// Starts listening on the chosen topics.
//			consumer.subscribe(Arrays.asList(TOPIC));

			// Sets the partitions on a consumer manually (optional).
			TopicPartition partition = new TopicPartition(TOPIC, 0);
			consumer.assign(Arrays.asList(partition));

			// Sets the offset on a consumer, putting it at the beginning or at the end of
			// the log (optional).
			consumer.seek(partition, 5);
			consumer.seekToBeginning(Arrays.asList(partition));
			consumer.seekToEnd(Arrays.asList(partition));

			// Reads new messages each second (polling) and prints the elements returned.
			while (true) {
				consumer.poll(1000)
						.forEach((ConsumerRecord<String, String> record) -> System.out
								.println(record.topic() + "[" + record.partition() + "] offset=" + record.offset()
										+ ", key=" + record.key() + ", value=" + record.value()));
			}
		}
	}

	/**
	 * Starts a Kafka producer for the topic {@value #TOPIC} on server
	 * {@value #SERVER_ADDRESS}.
	 */
	public static void startProducer() {
		// Creates a consumer with the given configuration and closes it automatically
		// when done.
		try (Producer<String, String> producer = new KafkaProducer<>(PROPS)) {
			int i = 0;
			while (true) {
				// Message to be sent (key is optional).
				ProducerRecord<String, String> message = new ProducerRecord<>(TOPIC, Integer.toString(i++),
						new Date().toString());

				// Sends a message and executes a callback (optional) when ack is received.
				producer.send(message, (RecordMetadata metadata, Exception e) -> {
					if (e != null) {
						System.out.println("Error while saving message: " + e);
					} else {
						System.out.println("Message saved in partition " + metadata.partition());
					}
				});

				// Waits a second before sending the next message.
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			// Any exception is just printed.
			System.out.println(e);
		}
	}

	/**
	 * Starts a Kafka producer on a new thread and a Kafka consumer on the same
	 * thread.
	 * 
	 * @param args null
	 */
	public static void main(String[] args) {
		new Thread(KafkaDemo::startProducer).start();
		KafkaDemo.startConsumer();
	}
}