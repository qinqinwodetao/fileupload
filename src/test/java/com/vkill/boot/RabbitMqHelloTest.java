package com.vkill.boot;

import com.vkill.boot.rabbitmq.HelloReceiver;
import com.vkill.boot.rabbitmq.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wucy
 * Date: 2017-11-30 16:02:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {

	@Autowired
	private HelloSender helloSender;

	@Autowired
	private HelloReceiver helloReceiver;

	@Test
	public void hello() throws Exception {
		helloSender.send();

	}

}
