package mapperInterface;

import java.util.List;

import domain.BoardDTO;

public interface BoardMapper {
	// ** replyInsert
	// => rinsert, stepUpdate
	int rinsert(BoardDTO dto);
	int stepUpdate(BoardDTO dto);
	
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
