package com.api.services;

import java.io.FileWriter;
import java.io.IOException;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.api.configuration.ChatGptConfiguration;
import com.api.models.request.ChatGptRequest;
import com.api.models.request.Request;
import com.api.models.response.ChatGptResponse;
import com.opencsv.CSVWriter;



@Service
public class ChatGptServiceImp implements ChatGptService{
	
	public HttpEntity<ChatGptRequest> buildHttpEntity(ChatGptRequest chatRequest) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(ChatGptConfiguration.MEDIA_TYPE));
        headers.add(ChatGptConfiguration.AUTHORIZATION, ChatGptConfiguration.BEARER + ChatGptConfiguration.API_KEY);
        return new HttpEntity<>(chatRequest, headers);
    }
	
	public ChatGptResponse getResponse(HttpEntity<ChatGptRequest> chatRequestHttpEntity) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ChatGptResponse> responseEntity = restTemplate.postForEntity(
                ChatGptConfiguration.URL,
                chatRequestHttpEntity,
                ChatGptResponse.class);

        return responseEntity.getBody();
    }
	
	public void appendToFileCsv(String filename, String[] rowData) {
        try {
            FileWriter fileWriter = new FileWriter(filename, true);
            CSVWriter csvWriter = new CSVWriter(fileWriter);
            String[] header = {"Question", "Answer"};
            csvWriter.writeNext(header);
            fileWriter.append(String.join(";", rowData));
            fileWriter.append("\n");
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public ChatGptResponse getChatAnswer(Request request) {
		ChatGptResponse response =  this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequest(
                                ChatGptConfiguration.MODEL,
                                request.getQuestion(),
                                ChatGptConfiguration.TEMPERATURE,
                                ChatGptConfiguration.MAX_TOKEN,
                                ChatGptConfiguration.TOP_P)));
    	String answer = response.getChoices().get(0).getText();
    	String question = request.getQuestion();
    	String [] rowData = {question,answer};
    	appendToFileCsv("C:\\Users\\Asmae ER\\Desktop\\ChatGpt service\\data_question_answer.csv",rowData);
    	return response;
    }
	
	public String getChatQuestion(Request request) {
    	ChatGptResponse resp = this.getResponse(
                this.buildHttpEntity(
                        new ChatGptRequest(
                        		ChatGptConfiguration.MODEL,
                        		request.getQuestion(),
                                ChatGptConfiguration.TEMPERATURE,
                                ChatGptConfiguration.MAX_TOKEN,
                                ChatGptConfiguration.TOP_P)));
    	
    	String answer = resp.getChoices().get(0).getText();
    	String question = request.getQuestion();
    	String [] rowData = {question,answer};
    	appendToFileCsv("C:\\\\Users\\\\Asmae ER\\\\Desktop\\\\ChatGpt service\\\\data_question_answer.csv",rowData);
    	
    	return answer;
    }

}
