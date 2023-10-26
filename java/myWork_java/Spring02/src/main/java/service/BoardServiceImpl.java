package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.BoardDTO;
import model.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {
	// ** 전역변수 정의
	//BoardDAO dao = new BoardDAO();
	
	@Autowired
	BoardDAO dao;

	// ** selectList
	@Override
	public List<BoardDTO> selectList() {
		return dao.selectList();
	}
	
	// ** replyInsert
	@Override
	public int rinsert(BoardDTO dto) {
		return dao.rinsert(dto);
	}
	
	// ** selectOne
	@Override
	public BoardDTO selectOne(BoardDTO sVO) {
		return dao.selectOne(sVO);
	}
		
	// ** insert
	@Override
	public int insert(BoardDTO dto) {
		return dao.insert(dto);
	}
	
	// ** update
	@Override
	public int update(BoardDTO dto) {
		return dao.update(dto);
	}
	
	// ** delete
	@Override
	public int delete(BoardDTO dto) {
		return dao.delete(dto);
	}

	
} // BoardService
