package com.infybuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infybuzz.entity.Document;
import com.infybuzz.entity.Student;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	
	
}
