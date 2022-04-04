package com.projects.bulletin.SMSService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface ISendSms {
    //Method to extraxt the News/Updates from FILE 
    public String NewsFromFile(String fileName) throws FileNotFoundException, IOException;
    //Method toextract the Numbers from File
    public ArrayList<String> NumbersFromFile(String fileName) throws FileNotFoundException, IOException; 
    //Method to Push the news to Mobiles
    public void sendNews() throws IOException ;
    
}
