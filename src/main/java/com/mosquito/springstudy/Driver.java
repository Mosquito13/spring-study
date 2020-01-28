package com.mosquito.springstudy;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Student s = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
