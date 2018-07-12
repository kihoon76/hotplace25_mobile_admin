package hotplace.madmin.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotplace.madmin.service.PaymentService;

@RequestMapping("/payment")
@Controller
public class PaymentController {

	@Resource(name="paymentService")
	PaymentService paymentService;
	
	@GetMapping("list")
	public String getPaymentList(ModelMap m) {
		Map<String, HashMap<String, Object>> result = null;
		
		try {
			Map map = new HashMap<>();
			result = paymentService.getPaymentList(map);
		}
		catch(Exception e) {
			m.addAttribute("error", e.getMessage());
		}
		
		m.addAttribute("menuNav", "[결제관리]");
		m.addAttribute("result", result);
		return "payment/list";
	}
}
