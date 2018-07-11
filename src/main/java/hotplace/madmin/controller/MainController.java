package hotplace.madmin.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import hotplace.madmin.service.MainService;

@RequestMapping("/")
@Controller
public class MainController {

	@Resource(name="mainService")
	MainService mainService;
	
	
	@GetMapping("main")
	public String main(
			@RequestParam(name="date", required=false) String date,
			@RequestParam(name="type", required=false) String type,
			ModelMap m) {
		
		Map<String, String> param = new HashMap<>();
		
		Map<String, Object> result = null;
		
		if(date == null) {
			Calendar cal = Calendar.getInstance();
			//cal.add(Calendar.DATE, 0);
			SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
			String formatted = format1.format(cal.getTime());
			date = formatted;
		}
		
		if(type == null) {
			type = "MM";
		}
		
		param.put("type", type);
		param.put("date", date);
		
		result = mainService.getMaechool(param);
		String total = (result != null) ? result.get("total").toString() : "";
		
		m.addAttribute("type", type);
		m.addAttribute("total", total);
		m.addAttribute("date", date);
		
		if(result != null) {
			Gson json = new Gson();
			m.addAttribute("json", json.toJson(result));
		}
		else {
			m.addAttribute("json", null);
		}
		
		return "main";
	}
}
