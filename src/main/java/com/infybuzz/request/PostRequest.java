package com.infybuzz.request;

public class PostRequest {
	
	
	private int documentId;
	private String title;
	private String body;
	private int userId;
	
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = this.documentId;
	}
	@Override
	public String toString() {
		return "PostRequest [documentId=" + documentId + ", title=" + title + ", body=" + body + ", userId=" + userId
				+ "]";
	}
	
	
	
	

}
