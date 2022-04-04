package com.projects.bulletin.News;

import java.io.IOException;
import java.util.List;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.projects.bulletin.POJO.Article;

public interface IgetNews {
    //Only Method to get News -> return List of News object
    public List<Article> getTheNews() throws JsonParseException, JsonMappingException, IOException;
    //Only Method to print the News HeadLines
    public void writeNews() throws JsonParseException, JsonMappingException, IOException;
}
