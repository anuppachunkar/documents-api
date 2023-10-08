package com.qdb.response;

public class DocumentResponse extends GenericResonse{
	
	private long id;

	private String documentName;

	private byte[] content;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}


	
	

}
