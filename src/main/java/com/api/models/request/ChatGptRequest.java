package com.api.models.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatGptRequest implements Serializable{
	
	
	private static final long serialVersionUID = 5256504830812825419L;
	
	private String model;
    private String prompt;
    private Double temperature;
    @JsonProperty("max_tokens")
    private Integer maxTokens;
    @JsonProperty("top_p")
    private Double topP;
    
    
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getPrompt() {
		return prompt;
	}
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public Integer getMaxTokens() {
		return maxTokens;
	}
	public void setMaxTokens(Integer maxTokens) {
		this.maxTokens = maxTokens;
	}
	public Double getTopP() {
		return topP;
	}
	public void setTopP(Double topP) {
		this.topP = topP;
	}
	public ChatGptRequest(String model, String prompt, Double temperature, Integer maxTokens, Double topP) {
		super();
		this.model = model;
		this.prompt = prompt;
		this.temperature = temperature;
		this.maxTokens = maxTokens;
		this.topP = topP;
	}
	public ChatGptRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    
    

}
