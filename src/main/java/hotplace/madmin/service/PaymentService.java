package hotplace.madmin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hotplace.madmin.dao.PaymentDao;
import hotplace.madmin.domain.Payment;

@Service("paymentService")
public class PaymentService {

	@Resource(name="paymentDao")
	PaymentDao paymentDao;
	
	public LinkedHashMap<String, HashMap<String, Object>> getPaymentList(Map map) {
		List<Payment> list = paymentDao.selectPaymentList(map);
		
		LinkedHashMap<String, HashMap<String, Object>> result = null;
		int c = 0;
		String curYYMMDD = null;
		int curYYMMDDcnt = 0;
		Payment p = null;
		
		if(list != null && (c = list.size()) > 0) {
			result = new LinkedHashMap<>();
			
			for(int i = 0; i < c; i++) {
				p = list.get(i);
				
				if(i == 0) {
					curYYMMDD = p.getApplyDate();
					result.put(curYYMMDD, new HashMap<String, Object>());
					result.get(curYYMMDD).put("list", new ArrayList<Payment>());
				}
				
				if(!p.getApplyDate().equals(curYYMMDD)) {
					result.put(p.getApplyDate(), new HashMap<String, Object>());
					result.get(p.getApplyDate()).put("list", new ArrayList<Payment>());
				
					//이전 카운트 처리
					result.get(curYYMMDD).put("count", (Integer)curYYMMDDcnt);
						
					curYYMMDD = p.getApplyDate();
					curYYMMDDcnt = 0;
				
				}
				
				((ArrayList<Payment>)(result.get(curYYMMDD).get("list"))).add(p);
				curYYMMDDcnt++;
				
				if(i == c-1) {
					result.get(curYYMMDD).put("count", (Integer)curYYMMDDcnt);
				}
			}
		}
		
		
		return result;
	}
}
