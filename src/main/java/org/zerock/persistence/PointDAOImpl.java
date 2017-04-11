package org.zerock.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(PointDAOImpl.class);
	
	private static final String namespace = "org.zerock.mapper.MessageMapper";
	
	@Inject
	private SqlSession session;
	
	@Override
	public void updatePoint(String uid, int point) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("uid", uid);
		paramMap.put("point", point);
		
		session.update(namespace + ".updatePoint", paramMap);
	}

}
