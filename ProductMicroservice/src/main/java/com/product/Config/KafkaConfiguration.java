package com.product.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.client.RestTemplate;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.Entity.ProductReviews;


@Configuration
@EnableKafka

public class KafkaConfiguration {
	

	
	@Bean
	public ProducerFactory<String, Product> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1000000 );
		config.put(ProducerConfig.ACKS_CONFIG,"all");
		config.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		config.put(ProducerConfig.RETRIES_CONFIG,0);
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
		config.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		config.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_IDLE_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, 1000000);
		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, Product> kafkaInvoiceTemplate() {
		KafkaTemplate<String, Product> kafkaInvoiceTemplate = new KafkaTemplate<String, Product>(producerFactory());
		return kafkaInvoiceTemplate;
	}
	@Bean
	public ProducerFactory<String, ProductDTO> producerFactoryDTO() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1000000 );
		config.put(ProducerConfig.ACKS_CONFIG,"all");
		config.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		config.put(ProducerConfig.RETRIES_CONFIG,0);
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
		config.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		config.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_IDLE_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, 1000000);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String, ProductDTO> kafkaInvoiceTemplateDTO() {
		KafkaTemplate<String, ProductDTO> kafkaInvoiceTemplate = new KafkaTemplate<String, ProductDTO>(producerFactoryDTO());
		return kafkaInvoiceTemplate;
	}
	
	@Bean
	public ProducerFactory<String, ProductReviews> producerFactoryReviews() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1000000 );
		config.put(ProducerConfig.ACKS_CONFIG,"all");
		config.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		config.put(ProducerConfig.RETRIES_CONFIG,0);
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
		config.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		config.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_IDLE_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, 1000000);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String, ProductReviews> kafkaInvoiceTemplateReviews() {
		KafkaTemplate<String, ProductReviews> kafkaInvoiceTemplate = new KafkaTemplate<String, ProductReviews>(producerFactoryReviews());
		return kafkaInvoiceTemplate;
	}
	
	@Bean
	public ProducerFactory<String, String> stringProducerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG, 1000000 );
		config.put(ProducerConfig.ACKS_CONFIG,"all");
		config.put(ProducerConfig.LINGER_MS_CONFIG, 1);
		config.put(ProducerConfig.RETRIES_CONFIG,0);
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
		config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, 300);
		config.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
		config.put(ProducerConfig.CONNECTIONS_MAX_IDLE_MS_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_IDLE_CONFIG, 1000000);
		config.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, 1000000);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<String, String>(stringProducerFactory());
		return kafkaTemplate;
	}

	


	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	
//    @Bean
//    public NewTopic addNewTopic() {
//    	
//    	 return TopicBuilder.name(TOPIC)
//    		      .partitions(1)
//    		      .replicas(1)
//    		      .compact()
//    		      .build();
//    }

}