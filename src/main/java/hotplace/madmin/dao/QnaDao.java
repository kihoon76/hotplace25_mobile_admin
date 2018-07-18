package hotplace.madmin.dao;

import java.util.List;
import java.util.Map;

import hotplace.madmin.domain.QnA;

public interface QnaDao {

	List<QnA> selectQnaList(String searchDate);

	void updateProcess(Map<String, String> param);
}
