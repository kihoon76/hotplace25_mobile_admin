package hotplace.madmin.dao;

import java.util.List;
import java.util.Map;

import hotplace.madmin.domain.Payment;

public interface PaymentDao {

	List<Payment> selectPaymentList(Map map);

	void updatePayment(Map<String, String> param);
	
}
