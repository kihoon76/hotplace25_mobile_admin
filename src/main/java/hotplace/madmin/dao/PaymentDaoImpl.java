package hotplace.madmin.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import hotplace.madmin.domain.Payment;

@Repository("paymentDao")
public class PaymentDaoImpl implements PaymentDao {

	private final static String namespace = "mappers.paymentMapper";
	
	@Resource(name = "msSqlSession")
	SqlSession msSqlSession;
	
	@Override
	public List<Payment> selectPaymentList(Map map) {
		return msSqlSession.selectList(namespace + ".selectPayment", map);
	}

	@Override
	public void updatePayment(Map<String, String> param) {
		msSqlSession.update(namespace + ".updatePayment", param);
	}

}
