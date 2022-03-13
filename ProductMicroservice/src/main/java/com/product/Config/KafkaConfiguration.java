package com.product.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.client.RestTemplate;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.Entity.ProductReviews;


@Configuration
public class KafkaConfiguration {
	

	
	@Bean
	public ProducerFactory<String, Product> producerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
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
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
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
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
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
	
	 @Bean
	    public NewTopic topic() {
	        return new NewTopic("producttopic", 1, (short) 1);
	    }


}