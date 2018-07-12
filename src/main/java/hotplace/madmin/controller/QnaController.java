package hotplace.madmin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hotplace.madmin.domain.QnA;
import hotplace.madmin.service.QnaService;

@RequestMapping("/qna")
@Controller
public class QnaController {

	@Resource(name="qnaService")
	QnaService qnaService;
	
	@GetMapping("list")
	public String getQnaList(ModelMap m) {
		List<QnA> result = null;
		try {
			result = qnaService.getQnaList();
		}
		catch(Exception e) {
			m.addAttribute("error", e.getMessage());
		}
		
		m.addAttribute("result", result);
		return "qna";
	}
	
	
}
