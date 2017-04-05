package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService {
	public void regist(BoardVO vo) throws Exception;
	public BoardVO read(Integer bno) throws Exception;
	public void modify(BoardVO vo) throws Exception;
	public void remove(Integer bno) throws Exception;
	public List<BoardVO> listAll() throws Exception;
}
