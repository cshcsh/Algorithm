package date0712;

/**
 * ���ƶ���
 * 
 * @author CSH
 * @date 2018��7��11������8:04:55
 */
public class MobileCard {

	private String cardNumber;//����
	private String userName;//�û���
	private String passWord;//����
	private ServicePackage serPackage;//�ײ�
	private double consumAmount;//���ѻ���
	private double money;//�������
	private int realTalkTime;//ͨ��ʱ��
	private int realSMSCount;//���Ͷ�������
	private int realFlow;//��������
	
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

	//��ʾ�ƶ�����Ϣ
	public void showMeg(){
		System.out.println(toString());
	}

	@Override
	public String toString() {
		return "�ƶ�����Ϣ [����=" + cardNumber + ", �û���=" + userName + ", ����=" + passWord
				+ ", \n�ײ�=" + serPackage + ", \n���ѻ���=" + consumAmount + ", �������=" + money
				+ ", ͨ��ʱ��=" + realTalkTime + ", ���Ͷ�������=" + realSMSCount + ", ��������=" + realFlow + "]\n";
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
