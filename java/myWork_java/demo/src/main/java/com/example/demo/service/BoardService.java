package com.example.demo.service;

import java.util.List;

import com.example.demo.domain.BoardDTO;

import criTest.SearchCriteria;

public interface BoardService {
	// ** Board_Cri_Pageing
	List<BoardDTO> bcriList(SearchCriteria cri); // 출력할 Data만 select
	int criTotalCount(SearchCriteria cri); // 출력 대상의 전체 row 개수

	// ** replyInsert
	int rinsert(BoardDTO dto);

	// ** selectList
	List<BoardDTO> selectList();

	// ** selectOne
	BoardDTO selectOne(BoardDTO sVO);

	// ** insert
	int insert(BoardDTO dto);

	// ** update
	int update(BoardDTO dto);

	// ** delete
	int delete(BoardDTO dto);

}