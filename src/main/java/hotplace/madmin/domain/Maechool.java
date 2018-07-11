package hotplace.madmin.domain;

import org.apache.ibatis.type.Alias;

@Alias("Maechool")
public class Maechool {

	private String typeCode;			//매출타입(전체서비스 연결제:1, 전체서비스 월결제:2, 투자유망검색:3, 경공매검색:4, 물건보기:5, 히트맵:6)
	private String typeName;
	private int	price;
	
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
