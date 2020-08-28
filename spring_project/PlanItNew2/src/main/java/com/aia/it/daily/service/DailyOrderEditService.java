package com.aia.it.daily.service;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.daily.dao.DailyDaoInterface;
import com.aia.it.daily.model.DailyOrderEdit;
import com.aia.it.daily.model.DailyOrderEditForm;

@Service
public class DailyOrderEditService {

	private DailyDaoInterface dao;

	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public int editOrder (DailyOrderEdit daily) {
		
		
		int result = 0;
		
		dao=template.getMapper(DailyDaoInterface.class);
	
		
		
		System.out.println(daily);

		/*
		 * System.out.println(dailyOrderEdit);
		 */		
		/* System.out.println(dailyOrderEdit.getOrderEdit()); */

		
		
		/*
		 * System.out.println(orderEdit.getOrderEdit().get(0).getDdidx());
		 * System.out.println(orderEdit.getOrderEdit().get(1).getDdidx());
		 * System.out.println(orderEdit.getOrderEdit().get(2).getDdidx());
		 * 
		 */ 
		
		/*
		 * for(int i=0; i<orderEdit.getOrderEdit().size();i++) {
		 * result=dao.editDailyOrder(orderEdit.getOrderEdit().get(i));
		 * 
		 * }
		 */
		/*
		 * dao.editDailyOrder(dailyOrderEdit.getOrderEdit().get(0));
		 */		
		
		
		
		
		for(int i=0; i >= daily.getDailyOrderEdit().size(); i++) {
			
		result=dao.editDailyOrder(daily.getDailyOrderEdit().get(i));
		
		System.out.println("나서비스"+daily.getDailyOrderEdit().get(i).getDidx());
		
		}
		
		return result;
		
	}
	
	
	
	
	
	
	
	
}
