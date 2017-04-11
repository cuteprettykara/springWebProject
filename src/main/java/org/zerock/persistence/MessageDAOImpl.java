package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MessageVO;

@Repository
public class MessageDAOImpl implements MessageDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(MessageDAOImpl.class);
	
	private static final String namespace = "org.zerock.mapper.MessageMapper";

	@Inject
	private SqlSession session;
	
	@Override
	public void create(MessageVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public MessageVO readMessage(Integer mid) throws Exception {
		return session.selectOne(namespace + ".readMessage", mid);
	}

	@Override
	public void updateState(Integer mid) throws Exception {
		session.update(namespace + ".updateState", mid);
	}

}
