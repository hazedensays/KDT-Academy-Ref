package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.JoDTO;
import mapperInterface.JoMapper;

@Service
public class JoServiceImpl implements JoService {
	// ** 전역변수 정의
	@Autowired
	JoMapper mapper;

	// ** selectList
	@Override
	public List<JoDTO> selectList() {
		return mapper.selectList();
	}

	// ** selectOne
	@Override
	public JoDTO selectOne(JoDTO sVO) {
		return mapper.selectOne(sVO);
	}

	// ** insert
	@Override
	public int insert(JoDTO dto) {
		return mapper.insert(dto);
	}

	// ** update
	@Override
	public int update(JoDTO dto) {
		return mapper.update(dto);
	}

	// ** delete
	@Override
	public int delete(JoDTO dto) {
		return mapper.delete(dto);
	}

} // JoService
