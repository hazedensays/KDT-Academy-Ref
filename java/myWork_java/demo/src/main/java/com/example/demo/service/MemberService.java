package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.domain.MemberDTO;

import mapperInterface.MemberMapper;

public interface MemberService {
	// ** RTestControler incheck2 Test
	MemberDTO selectOneJno(String id, Integer jno);

	// ** Jo_List 추가
	List<MemberDTO> joList(int jno);

	// ** selectList
	List<MemberDTO> selectList();

	// ** selectOne
	MemberDTO selectOne(MemberDTO sVO);

	// ** insert
	int insert(MemberDTO dto);

	// ** update
	int update(MemberDTO dto);

	// ** delete
	int delete(MemberDTO dto);

}