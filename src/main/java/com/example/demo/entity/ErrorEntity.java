package com.example.demo.entity;

import org.springframework.http.HttpStatus;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorEntity {
	private HttpStatus statusCode;
	private String message;

}
