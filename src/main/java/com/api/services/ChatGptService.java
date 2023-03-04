package com.api.services;

import com.api.models.request.Request;
import com.api.models.response.ChatGptResponse;

public interface ChatGptService {
	
    String getChatQuestion(Request request);

    ChatGptResponse getChatAnswer(Request request);

}
