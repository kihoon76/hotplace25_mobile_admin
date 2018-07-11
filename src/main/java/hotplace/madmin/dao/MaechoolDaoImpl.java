package hotplace.madmin.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import hotplace.madmin.domain.Maechool;

@Repository("maechoolDao")
public class MaechoolDaoImpl implements MaechoolDao {

	private final static String namespace = "mappers.maechoolMapper";
	
	@Resource(name = "msSqlSession")
	SqlSession msSqlSession;

	@Override
	public List<Maechool> selectMaechoolDay(Map m) {
		return msSqlSession.selectList(namespace + ".selectMaechool", m);
	}

	@Override
	public List<Maechool> selectMaechoolToday(Map m) {
		return msSqlSession.selectList(namespace + ".selectMaechool", m);
	}
	
	
}
