package hotplace.madmin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotplace.madmin.domain.Account;
import hotplace.madmin.domain.AjaxVO;
import hotplace.madmin.service.PaymentService;
import hotplace.madmin.utils.SessionUtil;

@RequestMapping("/payment")
@Controller
public class PaymentController {

	@Resource(name="paymentService")
	PaymentService paymentService;
	
	@GetMapping("list")
	public String getPaymentList(
			@RequestParam(name="searchYear", required=false) String searchYear,
			@RequestParam(name="searchMonth", required=false) String searchMonth,
			ModelMap m) {
		
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		String curMonth = String.valueOf(now.get(Calendar.MONTH) + 1);
		
		
		String year = (searchYear == null) ?  String.valueOf(curYear) : searchYear;
		String month = (searchMonth == null) ? curMonth : searchMonth;
		String searchDate = year + "-" + month + "-1";
		
		LinkedHashMap<String, HashMap<String, Object>> result = null;
		
		try {
			Map map = new HashMap<>();
			map.put("searchDate", searchDate);
			result = paymentService.getPaymentList(map);
		}
		catch(Exception e) {
			m.addAttribute("error", e.getMessage());
		}
		
		m.addAttribute("menuNav", "[결제관리]");
		m.addAttribute("result", result);
		m.addAttribute("year", year);
		m.addAttribute("month", month);
		m.addAttribute("startYear", curYear - 10);
		m.addAttribute("endYear", curYear);
		return "payment/list";
	}
	
	@PostMapping("confirm")
	@ResponseBody
	public AjaxVO confirmPayment(@RequestBody Map<String, String> param) {
		Account account = SessionUtil.getAccount();
		param.put("accountId", account.getId());
		AjaxVO vo = new AjaxVO();
		
		try {
			paymentService.confirmPayment(param);
			vo.setSuccess(true);
		}
		catch(Exception e) {
			vo.setSuccess(false);
			vo.setErrMsg(e.getMessage());
		}
		
		return vo;
	}
	
}
