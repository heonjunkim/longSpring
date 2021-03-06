package com.biz.shop.service;


import java.util.List;

import com.biz.shop.model.ProductVO;

/*
 * ProductService 인터페이스는 GenericService 인터페이스를 상속(extends)함으로써
 *CRUD 기본 method를 별도로 선언하지 않아도 된다.
 *필요한 추가 method가 있으면 별도로 선언을 해주고
 *이 인터페이스를 implements한 클래스는 인터페이스의 영향을 받아
 *method를 구현하게 된다.
 */

public interface ProductService 
		extends GenericService<ProductVO, String>{
	
	// Generic에는 없지만 Product를 구현하는데 필요한 메서드가 있으면
	// 그 메서드를 별도로 선언해준다.
	// object relation method
	public List<ProductVO> findByTitle(String title);
	
	
	
	
 	
	

}
