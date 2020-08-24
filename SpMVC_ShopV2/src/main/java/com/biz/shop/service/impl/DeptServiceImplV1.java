package com.biz.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.shop.model.DeptVO;
import com.biz.shop.persistence.DeptDao;
import com.biz.shop.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(DeptVO vo) {
		int ret = depDao.insert(vo);
		
		if(ret > 0) {
			log.debug("INSERT 성공 {} 개 데이터 추가", ret);
		} else {
			log.debug("INSERT 실패 {}", ret);
		}
		return ret;
	
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
	public List<DeptVO> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
