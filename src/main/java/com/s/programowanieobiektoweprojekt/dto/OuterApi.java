/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s.programowanieobiektoweprojekt.dto;

import com.s.programowanieprojekt.model.Quote;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author device02
 */
public class OuterApi<T> {
    RestTemplate restTemplate= new RestTemplate();
     private  final String source = "http://api.icndb.com/jokes";
     //private static Class<?> goalClass;
               
     public List<T>  getAll()
     {
         Quote<T> quote = restTemplate.getForObject(source+"/all", Quote.class);        
         System.out.println( (quote.toString()));  
        
         return (List<T>) quote.getValue();
     }
     public List<T> getRandom(int n)
     {
                  Quote<T> quote = restTemplate.getForObject(source+"/random/"+n, Quote.class);        
         System.out.println( (quote.toString()));  
        
         return (List<T>) quote.getValue();
     }
    
}

//package com.s.programowanieobiektoweprojekt.dto;
//
//import com.s.programowanieprojekt.model.Quote;
//
//public class OuterApi {
//    
//     private static final String source = "http://api.icndb.com/jokes/";
//     
//     public static String getRandom(int n)
//     {
//         return source+"/random/"+n;
//     }
//     public static String getAll()
//     {
//         return source+"/all";
//     }
//    
//}
