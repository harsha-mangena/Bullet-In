package com.projects.bulletin;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.projects.bulletin.News.*;
import com.projects.bulletin.SMSService.*;

//import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BulletinApplication {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		//SpringApplication.run(BulletinApplication.class, args);
		//Writing News
		getNews news = new getNews();
		news.writeNews();
		//Pushing the Written News to Numbers
		SendSms msg = new SendSms();
		msg.sendNews();
	}

}
