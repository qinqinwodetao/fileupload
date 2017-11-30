package com.vkill.boot.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author boot
 * Date: 2017-11-30 15:51:00
 */
@Configuration
public class RabbitMqConfig {
	@Bean
	public Queue Queue() {
		return new Queue("hello");
	}
}
