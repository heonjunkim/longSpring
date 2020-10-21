package com.biz.bbs.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.biz.bbs.model.BBsVO;

public interface BBsService {

	public List<BBsVO> selectAll();
	
	public void insert(BBsVO bbsVO);
	public void insert(BBsVO bbsVO, MultipartFile file);
	
	public BBsVO findBySeq(long seq);
	public int delete(long seq);
	
	
	

}
