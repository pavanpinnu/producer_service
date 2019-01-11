package com.wellsfargo.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wellsfargo.kafka.producer.ProducerService;

@RestController
@RequestMapping("/publish")
public class ProducerController {
	
	@Autowired
	private ProducerService producer;
	
	@PostMapping(path="/")
	public void publishMessage(@RequestParam(name="topic", required=true) String topic,
			@RequestParam(name="message", required=true) String message) throws Exception {
		producer.sendMessage(topic, message);
	}

}
