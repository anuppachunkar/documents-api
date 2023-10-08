package com.infybuzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infybuzz.entity.Document;
import com.infybuzz.repository.DocumentRepository;
import com.infybuzz.request.DocumentRequest;
import com.infybuzz.response.DocumentResponse;

@Service
public class DocumentService {

	@Autowired
	DocumentRepository documentRepository;

	public DocumentResponse createDocument(DocumentRequest documentRequest) {

		DocumentResponse response  = new DocumentResponse();
		
		System.out.println("createDocument called");
		
		Document document = new Document();
		document.setContent(documentRequest.getContent());
		document.setDocumentName(documentRequest.getDocumentName());
		
		document = documentRepository.save(document);
		System.out.println(" Document saved ");
		response.setId(document.getId());
		response.setDocumentName(document.getDocumentName());
		response.setContent(document.getContent());
		
		return response;
	}
	
	public DocumentResponse getById (long id) {
		
		DocumentResponse response = new DocumentResponse();
		
		Document document = documentRepository.findById(id).get();
		
		response.setId(document.getId());
		response.setDocumentName(document.getDocumentName());
		response.setContent(document.getContent());
		
		return response;
	}
	
	public void deleteById (long id) {
		documentRepository.deleteById(id);
	}
	
	
}
