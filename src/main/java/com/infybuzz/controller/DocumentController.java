package com.infybuzz.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infybuzz.feignclients.PostFeignClient;
import com.infybuzz.request.CommentRequest;
import com.infybuzz.request.DocumentRequest;
import com.infybuzz.request.PostRequest;
import com.infybuzz.response.CommentReponse;
import com.infybuzz.response.DocumentResponse;
import com.infybuzz.response.PostResponse;
import com.infybuzz.service.DocumentService;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

	@Autowired
	DocumentService documentService;
	
	@Autowired
	PostFeignClient postFeignClient;

	@PostMapping("/upload")
	public DocumentResponse uploadDocument(@RequestParam("file") MultipartFile file) {

		DocumentRequest request = new DocumentRequest();
		System.out.println("upload api called");

		try {
			// String fileContentType = file.getContentType();
			String sourceFileContent = new String(file.getBytes(), StandardCharsets.UTF_8);
			String fileName = file.getOriginalFilename();
			request.setDocumentName(fileName);
			request.setContent(sourceFileContent);
			System.out.println("File Name : "+fileName);

		} catch (Exception e) {
			e.printStackTrace();
			DocumentResponse response = new DocumentResponse();
			return response;
		}

		return documentService.createDocument(request);
	}

	@GetMapping("/getDocument/{id}")
	public DocumentResponse getDocument(@PathVariable long id) {
		return documentService.getById(id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteDocument(@PathVariable long id) {
		documentService.deleteById(id);
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "application is up and running";
	}
	
	@GetMapping("/getPost/{id}")
	public PostResponse getPost(@PathVariable("id") long id) {
		ObjectMapper mapper = new ObjectMapper();
		PostResponse response = null;
		try {
			response = mapper.readValue(postFeignClient.getById(id), PostResponse.class) ;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
		 
	}
	
	/*
	 * @GetMapping("/getPosts") public String getPosts() { return
	 * postFeignClient.getPosts(); }
	 */
	/*
	 * Mapping documentId to userId for this api call, as it is 
	 * expecting userId as a part of request.
	 */
	@PostMapping("/posts")
	public PostResponse createPost(@RequestBody PostRequest request) {
		//PostResponse response = new PostResponse();
		System.out.println("Create Post called :" +request);
		ObjectMapper mapper = new ObjectMapper();
		PostResponse response = null;
		try {
			response = mapper.readValue(postFeignClient.createPost(request), PostResponse.class) ;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	@PostMapping("/posts/{id}/comments")
	public CommentReponse createComment(@RequestBody CommentRequest request) {
		//PostResponse response = new PostResponse();
		System.out.println("Create Comment called :" +request);
		ObjectMapper mapper = new ObjectMapper();
		CommentReponse response = null;
		try {
			response = mapper.readValue(postFeignClient.createComment(request), CommentReponse.class) ;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	
	
	
	
}
