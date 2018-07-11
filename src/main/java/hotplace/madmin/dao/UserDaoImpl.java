package hotplace.madmin.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import hotplace.madmin.domain.Account;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private final static String namespace = "mappers.userMapper";
	
	@Resource(name = "msSqlSession")
	SqlSession msSqlSession;
	
	@Override
	public Account getAccount(String id) {
		return msSqlSession.selectOne(namespace + ".selectUser", id);
	}

}
