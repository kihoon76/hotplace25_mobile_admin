package hotplace.madmin.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import hotplace.madmin.domain.QnA;

@Repository("qnaDao")
public class QnaDaoImpl implements QnaDao {

	private final static String namespace = "mappers.qnaMapper";
	
	@Resource(name = "msSqlSession")
	SqlSession msSqlSession;

	@Override
	public List<QnA> selectQnaList(String searchDate) {
		return msSqlSession.selectList(namespace + ".selectQnaList", searchDate);
	}

	@Override
	public void updateProcess(Map<String, String> param) {
		msSqlSession.update(namespace + ".updateProcess", param);
	}

}
