package com.projects.bulletin.SMSService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SendSms  implements ISendSms{
    //SMS SERVICE PROVIDER
    private SmsService service = new SmsService();

    //NEWS EXTARCTION
    @Override
    public String NewsFromFile(String fileName) throws IOException {
        StringBuilder update = new StringBuilder();
        //File Reader
        FileReader reader = new FileReader(fileName+".txt");
        //Buffer Reader
        BufferedReader br = new BufferedReader(reader);
        //Appending to the update
        try
        {
            String line;
            while ((line=br.readLine()) != null)
            {
                update.append(line + "\n");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //Closing FileReader and Buffered Reader
        reader.close();
        br.close();

        System.out.println(update.toString());

        return update.toString();
    }

    //NUMBERS EXTRACTION
    @Override
    public ArrayList<String> NumbersFromFile(String fileName) throws FileNotFoundException, IOException {
        ArrayList<String> numbers = new ArrayList<>();

        FileReader reader = new FileReader(fileName+".txt");
        //Buffer Reader
        BufferedReader br = new BufferedReader(reader);
        //Appending to the update
        try
        {
            String line;
            while ((line=br.readLine()) != null)
            {
                numbers.add(line.toString());
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        //Closing FileReader and Buffered Reader
        reader.close();
        br.close();

        return numbers;

    }

    //SENDING SMS TO THE LIST OF NUMBERS

    @Override
    public void sendNews() throws IOException {

    String updates = NewsFromFile("Updates");
    List<String> phoneNumber = NumbersFromFile("Number");

    for(String Number : phoneNumber)
    {
        service.sendNews(Number, updates);
    }    
    
    }
}
