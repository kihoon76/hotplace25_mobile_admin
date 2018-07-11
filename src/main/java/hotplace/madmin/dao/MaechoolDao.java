package hotplace.madmin.dao;

import java.util.List;
import java.util.Map;

import hotplace.madmin.domain.Maechool;

public interface MaechoolDao {

	public List<Maechool> selectMaechoolDay(Map m);
	
	public List<Maechool> selectMaechoolToday(Map m);
}
