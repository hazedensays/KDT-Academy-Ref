package service;

import java.util.List;

import domain.BoardDTO;

public interface BoardService {

	// ** selectList
	List<BoardDTO> selectList();
	
	int rinsert(BoardDTO dto);

	// ** selectOne
	BoardDTO selectOne(BoardDTO sVO);

	// ** insert
	int insert(BoardDTO dto);

	// ** update
	int update(BoardDTO dto);

	// ** delete
	int delete(BoardDTO dto);

}