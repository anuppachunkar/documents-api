package com.qdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qdb.entity.Document;
import com.qdb.entity.Student;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

	
	
}
