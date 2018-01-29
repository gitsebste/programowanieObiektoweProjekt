/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieprojekt.service;

import com.s.programowanieprojekt.model.Emailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


/**
 *
 * @author device02
 */
@Service
public class NotificationService {
//    
//    @Autowired
//    private static JavaMailSender sender;
//    @Autowired
//    private static SimpleMailMessage mailMessage;
// 
////    @Autowired
////    NotificationService(JavaMailSender sender)
////    {
////        this.sender=sender;
////    }
//    
//    public static void sendNotification (Emailable addressee,String from,String subject,String body)
//    {
//        try{
//        if(from==null && subject==null && body==null){
//        mailMessage.setTo(addressee.getEmail());
//        mailMessage.setFrom("From Spring Application");
//        mailMessage.setSubject("Just curious if it works...");
//        mailMessage.setText("It is the body of the message.");}
//        else
//        {
//        mailMessage.setTo(addressee.getEmail());
//        mailMessage.setFrom(from);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(body);
//        }
//        
//        sender.send(mailMessage);
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//            
//    }
}