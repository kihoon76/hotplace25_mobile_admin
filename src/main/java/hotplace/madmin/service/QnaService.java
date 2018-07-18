package hotplace.madmin.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hotplace.madmin.dao.QnaDao;
import hotplace.madmin.domain.QnA;

@Service("qnaService")
public class QnaService {

	@Resource(name="qnaDao")
	QnaDao qnaDao;
	
	public List<QnA> getQnaList(String searchDate) {
		return qnaDao.selectQnaList(searchDate);
	}
	
	public void resolveProcess(Map<String, String> param) {
		 qnaDao.updateProcess(param);
	}

}
