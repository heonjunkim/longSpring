package com.biz.bbs.service;

import java.util.List;

import com.biz.bbs.model.BBsVO;

public interface EmployService {
	
	public List<BBsVO> selectAll();
	
	public BBsVO findById(long id);
	
	public int insert(BBsVO bbsVO);
	
	public int update(BBsVO bbsVO);
	
	public int delete(long id);

}
