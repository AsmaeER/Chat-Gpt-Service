package com.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.request.Request;
import com.api.models.response.ChatGptResponse;
import com.api.services.ChatGptService;


@RestController
public class ChatGptController {
	
	@Autowired
	private ChatGptService chatGptService;

	
	@PostMapping("/send")
	public ChatGptResponse sendMessage(@RequestBody Request request) {
		return chatGptService.getChatAnswer(request);
	}
	@PostMapping("/sendQuestion")
	public String sendQuestion(@RequestBody Request request) {
		return chatGptService.getChatQuestion(request);
	}

}
