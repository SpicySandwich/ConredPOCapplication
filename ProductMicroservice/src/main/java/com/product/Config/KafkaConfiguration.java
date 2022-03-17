package com.product.Config;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.springframework.web.client.RestTemplate;

import com.product.DTO.ProductDTO;
import com.product.Entity.Product;
import com.product.ModeException.ProductExecption;


@Configuration
@EnableKafka

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
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
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
	public ProducerFactory<String, String> stringProducerFactory() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
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
	public ProducerFactory<String, ProductExecption> producerProductException() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String,Long> kafkaInvoiceTemplateLong() {
		KafkaTemplate<String, Long> kafkaInvoiceTemplate = new KafkaTemplate<String,Long>( producerProductLong());
		return kafkaInvoiceTemplate;
	}
	
	@Bean
	public ProducerFactory<String, Long> producerProductLong() {
		Map<String, Object> config = new HashMap<>();
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(config);
	}
	
	@Bean
	public KafkaTemplate<String,ProductExecption> kafkaInvoiceTemplateExecption() {
		KafkaTemplate<String, ProductExecption> kafkaInvoiceTemplate = new KafkaTemplate<String,ProductExecption>( producerProductException());
		return kafkaInvoiceTemplate;
	}


	


	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	


}