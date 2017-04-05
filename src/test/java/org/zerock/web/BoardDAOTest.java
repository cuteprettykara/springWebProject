package org.zerock.web;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
	@Inject
	private BoardDAO dao;
	
	@Test
	public void testCreate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setTitle("새로운 글을 넣습니다.");
		vo.setContent("새로운 글을 넣습니다.");
		vo.setWriter("user00");
		dao.create(vo);
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(4).toString());
	}
	
	@Test
	public void testUpdate() throws Exception {
		BoardVO vo = new BoardVO();
		vo.setBno(4);
		vo.setTitle("수정된 글입니다.");
		vo.setContent("수정 테스트");
		dao.update(vo);
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(4);
	}
}
