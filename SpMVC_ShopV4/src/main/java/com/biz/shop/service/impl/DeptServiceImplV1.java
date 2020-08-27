package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.DeptVO;
import com.biz.shop.persistence.DeptDao;
import com.biz.shop.service.DeptService;

import lombok.extern.slf4j.Slf4j;


@Service(value="depServiceV1")
public class DeptServiceImplV1 implements DeptService {
	
	@Autowired
	private DeptDao depDao;

	@Override
	public List<DeptVO> selectAll() {
		return depDao.selectAll();
	}

	@Override
	public DeptVO findByID(String id) {
		
		return depDao.findByID(id);

	}

	@Override
	public int insert(DeptVO vo) {
		return depDao.insert(vo);
	
	}

	@Override
	public int update(DeptVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public String getDCode() {
		
		String retDCode = "D001";
		
		try {
			String maxCode = depDao.maxDCode(); 
			String preCode = maxCode.substring(0,1);
			int dcode = Integer.valueOf(maxCode.substring(1)) + 1;
			retDCode = String.format("%s%03d", preCode, dcode);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return retDCode;
	}

}
