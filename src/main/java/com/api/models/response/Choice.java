package com.api.models.response;

public class Choice {
	
    private String text;
    private Integer index;
    private String logprobs;
    
    
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public String getLogprobs() {
		return logprobs;
	}
	public void setLogprobs(String logprobs) {
		this.logprobs = logprobs;
	}
    
    

}
