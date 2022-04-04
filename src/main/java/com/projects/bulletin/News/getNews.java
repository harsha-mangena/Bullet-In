package com.projects.bulletin.News;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.bulletin.POJO.*;

import org.springframework.web.client.RestTemplate;

 
public class getNews implements IgetNews 
{
    //API KEY
    private final String key = "338bc48e235a4e4b9bb522a4b0ec67ed";

    //Method for ObjectMapper
    private ObjectMapper getObjectMapper()
    {
        return new ObjectMapper();
    }

    //Method for Rest Template
    private RestTemplate getRest()
    {
        return new RestTemplate();
    }

    //Method for URL
    private String getUrl()
    {   
        String url = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=" + key;
        return url; 
    
    }


    @Override
    public ArrayList<Article> getTheNews() throws JsonParseException, JsonMappingException, IOException {
        //Url
        String url = getUrl();

        //ObjectMapper
        ObjectMapper objectMapper = getObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        //Rest Template
        RestTemplate restObject = getRest();

        //Json to String
        String result = restObject.getForObject(url, String.class);

        //String to POJO Class
        //List<All> news = (List<All>) objectMapper.readValue(result, All.class);
        List<All> news = objectMapper.readValue(result, new TypeReference<List<All>>() {});
        ArrayList<Article> articles =  new ArrayList<>();
        for(All curentAll : news)
        {
            articles.addAll(curentAll.getArticles());
        }
        
        return articles;
    }

    @Override
    public void writeNews() throws JsonParseException, JsonMappingException, IOException {
        ArrayList<Article> currentUpdates = getTheNews();
        //Writing into File
        BufferedWriter writer = new BufferedWriter(new FileWriter("Updates.txt"));
        
        for(Article a : currentUpdates)
        {
            writer.append(a.getTitle() + "\n");
        }
        //Closing Writer    
        writer.close();

    }
    
}
