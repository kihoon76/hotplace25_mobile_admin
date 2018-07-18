package hotplace.madmin.controller;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hotplace.madmin.domain.Account;
import hotplace.madmin.domain.AjaxVO;
import hotplace.madmin.domain.QnA;
import hotplace.madmin.service.QnaService;
import hotplace.madmin.utils.SessionUtil;

@RequestMapping("/qna")
@Controller
public class QnaController {

	@Resource(name="qnaService")
	QnaService qnaService;
	
	@GetMapping("list")
	public String getQnaList(
			@RequestParam(name="searchYear", required=false) String searchYear,
			@RequestParam(name="searchMonth", required=false) String searchMonth,
			ModelMap m) {
		
		Calendar now = Calendar.getInstance();
		int curYear = now.get(Calendar.YEAR);
		String curMonth = String.valueOf(now.get(Calendar.MONTH) + 1);
		
		
		String year = (searchYear == null) ?  String.valueOf(curYear) : searchYear;
		String month = (searchMonth == null) ? curMonth : searchMonth;
		String searchDate = year + "-" + month + "-1";
		
		List<QnA> result = null;
		try {
			result = qnaService.getQnaList(searchDate);
			
			if(result != null && result.size() == 0) result = null;
		}
		catch(Exception e) {
			m.addAttribute("error", e.getMessage());
		}
		
		m.addAttribute("year", year);
		m.addAttribute("month", month);
		m.addAttribute("startYear", curYear - 10);
		m.addAttribute("endYear", curYear);
		m.addAttribute("menuNav", "[문의사항관리]");
		m.addAttribute("result", result);
		return "qna";
	}
	
	@PostMapping("process")
	@ResponseBody
	public AjaxVO<Map<String, String>> processResolve(@RequestBody Map<String, String> param) {
		Account account = SessionUtil.getAccount();
		String currUser = account.getId();
		
		AjaxVO<Map<String, String>> vo = new AjaxVO<Map<String, String>>();
		
		param.put("accountId", currUser);
		param.put("processTime", "");;
		
		try{
			qnaService.resolveProcess(param); 
			vo.setSuccess(true);
			vo.addObject(param);
		}
		catch(Exception e) {
			vo.setSuccess(false);
			vo.setErrMsg(e.getMessage());
		}
		
		return vo;
	}
}
