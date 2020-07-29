package com.biz.hello.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.hello.model.StudentVO;
@Service
public interface StudentService {
	public List<StudentVO> selectAll();
	public StudentVO findBystNum(String st_num);
	
	public int insert(StudentVO studentVO);
	public int update(StudentVO studentVO);
	public int delete(String st_num);

}
