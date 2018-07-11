package hotplace.madmin.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hotplace.madmin.dao.MaechoolDao;
import hotplace.madmin.domain.Maechool;

@Service("mainService")
public class MainService {

	@Resource(name="maechoolDao")
	MaechoolDao maechoolDao;
	
	public Map<String, Object> getMaechool(Map<String, String> m) {
		Map<String, Object> result = null;
		
		List<Maechool> list = maechoolDao.selectMaechoolDay(m);
		int sum = 0;
		int cnt = 0;
		
		if(list != null && (cnt = list.size()) > 0) {
			result = new HashMap<>();
			result.put("list", list);
			
			List<String> legend = new ArrayList<>();
			
			for(int i = 0; i < cnt; i++) {
				sum += list.get(i).getPrice();
				legend.add(list.get(i).getTypeName());
			}
			
			result.put("total", sum);
			result.put("legend", legend);
		}
		
		return result; 
	}
	
}
