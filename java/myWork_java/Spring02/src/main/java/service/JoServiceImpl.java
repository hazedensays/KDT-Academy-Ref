package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.JoDTO;
import model.JoDAO;

@Service
public class JoServiceImpl implements JoService {
	// ** 전역변수 정의
	// JoDAO dao = new JoDAO();

	@Autowired
	JoDAO dao;

	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return dao.selectList();
	}

	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO sVO) {
		return dao.selectOne(sVO);
	}

	// ** insert
	@Override
	public int insert(JoDTO dto) {
		return dao.insert(dto);
	}

	// ** update
	@Override
	public int update(JoDTO dto) {
		return dao.update(dto);
	}

	// ** delete
	@Override
	public int delete(JoDTO dto) {
		return dao.delete(dto);
	}

} // JoService
