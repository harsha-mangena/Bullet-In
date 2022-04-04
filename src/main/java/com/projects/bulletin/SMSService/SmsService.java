package com.projects.bulletin.SMSService;

import io.github.cdimascio.dotenv.Dotenv;
//import io.github.cdimascio.dotenv.DotenvException;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SmsService{
    Dotenv dotenv = Dotenv.configure().load();
    private final String ACCT_SID = dotenv.get("ACCT_ID");
    private final String AUTH_TKN = dotenv.get("AUTH");
    public void sendNews(String number, String newsUpadte)
    {
         //Twilio Console Details 
         Twilio.init(ACCT_SID, AUTH_TKN);
         //Sending Message
         Message newmessage = Message.creator(new PhoneNumber("+91"+number), new PhoneNumber("+14422455771"), newsUpadte).create();
         System.out.println(newmessage.getSid());
    }
}
