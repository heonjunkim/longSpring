package com.biz.shop.service;

import java.util.List;

import com.biz.shop.model.DeptVO;

public interface DeptService 
	extends GenericService<DeptVO, String>  {
	
	public List<DeptVO> findByTitle(String title);

}
