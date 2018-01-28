package com.wyzant.questions.dto.out;

public class AnswerDtoOut {

	private Long id;
	private String content;
	private boolean accepted;
	private int upvotes;
	
	public String getContent() {
		return content;
	}
	
	public long getId() {
		return id;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isAccepted() {
		return accepted;
	}
	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}
	public int getUpvotes() {
		return upvotes;
	}
	public void setUpvotes(int upvotes) {
		this.upvotes = upvotes;
	}
	
	
	
}
