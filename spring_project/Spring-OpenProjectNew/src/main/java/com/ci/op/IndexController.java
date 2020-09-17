package com.ci.op;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
   
   @RequestMapping("/index")
   public String index() {
      System.out.println("인덱스 컨트롤러");
//      String str = null;
//	    str.toString();
      
      return "index";
   }
   
   @ExceptionHandler(NullPointerException.class)
   public String handleNullPointerException(NullPointerException e) {
      e.printStackTrace();
      
      return "error/nullException"; 
      
   }

}