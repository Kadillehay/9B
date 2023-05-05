package com.coderscampus.assignment9.B.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderscampus.assignment9.B.service.FileService;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@RestController
@RequestMapping("/")
public class RecipeController {
	@Autowired
	private FileService fileService;
	
	@GetMapping("/")
	public List <String> readLines() throws IOException{
		System.out.println("hello world");  return
		
				fileService.readFile("recipes.txt");
	
	}

}
