package date0712;

/**
 * 嗖嗖移动卡
 * 
 * @author CSH
 * @date 2018年7月11日下午8:04:55
 */
public class MobileCard {

	private String cardNumber;//卡号
	private String userName;//用户名
	private String passWord;//密码
	private ServicePackage serPackage;//套餐
	private double consumAmount;//消费话费
	private double money;//话费余额
	private int realTalkTime;//通话时间
	private int realSMSCount;//发送短信条数
	private int realFlow;//消耗流量
	
	public MobileCard() {
		super();
	}
	
	public MobileCard(String cardNumber, String userName, String passWord,double money ,ServicePackage serPackage) {
		super();
		this.cardNumber = cardNumber;
		this.userName = userName;
		this.passWord = passWord;
		this.serPackage = serPackage;
		this.consumAmount = 0;
		this.money = money;
		this.realTalkTime = 0;
		this.realSMSCount = 0;
		this.realFlow = 0;
	}

	public MobileCard(String cardNumber, String userName, String passWord, ServicePackage serPackage) {
		super();
		this.cardNumber = cardNumber;
		this.userName = userName;
		this.passWord = passWord;
		this.serPackage = serPackage;
		this.consumAmount = 0;
		this.money = 0;
		this.realTalkTime = 0;
		this.realSMSCount = 0;
		this.realFlow = 0;
	}

	//显示移动卡信息
	public void showMeg(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "移动卡信息 [卡号=" + cardNumber + ", 用户名=" + userName + ", 密码=" + passWord
				+ ", \n套餐=" + serPackage + ", \n消费话费=" + consumAmount + ", 话费余额=" + money
				+ ", 通话时间=" + realTalkTime + ", 发送短信条数=" + realSMSCount + ", 消耗流量=" + realFlow + "]\n";
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public ServicePackage getSerPackage() {
		return serPackage;
	}

	public void setSerPackage(ServicePackage serPackage) {
		this.serPackage = serPackage;
	}

	public double getConsumAmount() {
		return consumAmount;
	}

	public void setConsumAmount(double consumAmount) {
		this.consumAmount = consumAmount;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public int getRealTalkTime() {
		return realTalkTime;
	}

	public void setRealTalkTime(int realTalkTime) {
		this.realTalkTime = realTalkTime;
	}

	public int getRealSMSCount() {
		return realSMSCount;
	}

	public void setRealSMSCount(int realSMSCount) {
		this.realSMSCount = realSMSCount;
	}

	public int getRealFlow() {
		return realFlow;
	}

	public void setRealFlow(int realFlow) {
		this.realFlow = realFlow;
	}
	
}
