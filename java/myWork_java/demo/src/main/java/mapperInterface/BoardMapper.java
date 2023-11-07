package mapperInterface;

import java.util.List;

import com.example.demo.domain.BoardDTO;

import criTest.SearchCriteria;

public interface BoardMapper {
	// ** Board_SearchCri_Paging
	// => Cri + 검색 조건
	List<BoardDTO> searchCri(SearchCriteria cri);
	int searchTotalCount(SearchCriteria cri);
	
	
	// ** Board_Cri_Pageing
	List<BoardDTO> bcriList(SearchCriteria cri); // 출력할 Data만 select
	int criTotalCount(); // 전체 row 개수

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
