package com.aia.it.daily.service;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.it.daily.dao.DailyDaoInterface;
import com.aia.it.daily.model.DailyOrderEditForm;

@Service
public class DailyOrderEditService {

	private DailyDaoInterface dao;

	
	@Autowired
	private SqlSessionTemplate template;
	
	
	public int editOrder (DailyOrderEditForm dailyOrderEdit) {
		
		
		
		dao=template.getMapper(DailyDaoInterface.class);
	
		
		
		
		System.out.println(dailyOrderEdit);
		
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
		 
		
		
		
		return dao.editDailyOrder(dailyOrderEdit);
		
	}
	
	
	
	
	
	
	
	
}
