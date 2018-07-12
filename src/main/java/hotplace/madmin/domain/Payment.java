package hotplace.madmin.domain;

import org.apache.ibatis.type.Alias;

@Alias("Payment")
public class Payment {

	private String key;							//일련번호
	private String accountId;					//사용자계정
	private String serviceType;					//서비스타입
	private String serviceSubTypes;				//서비스서브타입
	private String couponNum;					//쿠폰번호
	private String couponValue;					//쿠폰할인값
	private String couponUnit;					//쿠폰할인단위
	private String useCoupon;					//쿠폰사용여부('N' | 'Y')
	private String applyDate;					//결제신청일자 (yyyy-mm-dd)
	private String applyTime;					//결제신청시간 (hh:mm)
	private String paymentDate;					//결제일자
	private String paymentConfirmDate;			//결제확인일자
	private String applyComment;				//결제내용
	private int sum;							//결제금액
	private String status;						//결제완료여부('N', 'Y')
	private String depositor;					//입금자명
	private String refundId;					//환불내역번호
	private String processorId;					//결제처리담당자계정
	private String processorName;				//결제처리담당자이름
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public String getServiceSubTypes() {
		return serviceSubTypes;
	}
	public void setServiceSubTypes(String serviceSubTypes) {
		this.serviceSubTypes = serviceSubTypes;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getCouponNum() {
		return couponNum;
	}
	public void setCouponNum(String couponNum) {
		this.couponNum = couponNum;
	}
	public String getUseCoupon() {
		return useCoupon;
	}
	public void setUseCoupon(String useCoupon) {
		this.useCoupon = useCoupon;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getApplyComment() {
		return applyComment;
	}
	public void setApplyComment(String applyComment) {
		this.applyComment = applyComment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getCouponValue() {
		return couponValue;
	}
	public void setCouponValue(String couponValue) {
		this.couponValue = couponValue;
	}
	public String getCouponUnit() {
		return couponUnit;
	}
	public void setCouponUnit(String couponUnit) {
		this.couponUnit = couponUnit;
	}
	public String getDepositor() {
		return depositor;
	}
	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentConfirmDate() {
		return paymentConfirmDate;
	}
	public void setPaymentConfirmDate(String paymentConfirmDate) {
		this.paymentConfirmDate = paymentConfirmDate;
	}
	public String getRefundId() {
		return refundId;
	}
	public void setRefundId(String refundId) {
		this.refundId = refundId;
	}
	public String getProcessorId() {
		return processorId;
	}
	public void setProcessorId(String processorId) {
		this.processorId = processorId;
	}
	public String getProcessorName() {
		return processorName;
	}
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
}
