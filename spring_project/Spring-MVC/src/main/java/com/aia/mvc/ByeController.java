package com.aia.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ByeController {
   
   
   @RequestMapping("/bye")
   public ModelAndView bye(){
      
      ModelAndView mav = new ModelAndView(); 
      
      
      //data 저장은 addObject , 경로를 만들어주는건 setView
      
      //view 이름(경로)  설정
      mav.setViewName("hello/bye");   // /WEB-INF/views/hello/bye.jsp 
   
      
      //view에 공유할 데이터 설정 
      mav.addObject("msg", "다음에 만나요"); 
      
      
      return mav; 
      
      
   }
   
   

}