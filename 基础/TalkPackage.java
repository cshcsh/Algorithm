package date0712;

/**
 * TalkPackage话唠套餐
 * 
 * @author CSH
 * @date 2018年7月11日下午8:21:01
 */
public class TalkPackage extends ServicePackage implements CallService, SendService {

	private int talkTime;// 通话时长
	private int smsCount;// 短信条数

	public TalkPackage() {
		super(58);
		this.talkTime = 500;
		this.smsCount = 30;
	}

	// 显示话唠套餐信息
	public void showInfo() {
		System.out.println(toString());
	}

	@Override
	// 发送短信
	public void send(int count, MobileCard card) {
		card.setRealSMSCount(card.getRealSMSCount()+count);
		double consumAmount=count * 0.1;
		card.setConsumAmount(card.getConsumAmount()+consumAmount);
		card.setMoney(card.getMoney() - consumAmount);
	}

	@Override
	// 拨打电话
	public void call(int minCount, MobileCard card) {
		card.setRealTalkTime(card.getRealTalkTime()+minCount);
		double consumAmount=minCount * 0.2;
		card.setConsumAmount(card.getConsumAmount()+consumAmount);
		card.setMoney(card.getMoney() - consumAmount);
	}

	public int getTalkTime() {
		return talkTime;
	}

	public void setTalkTime(int talkTime) {
		this.talkTime = talkTime;
	}

	public int getSmsCount() {
		return smsCount;
	}

	public void setSmsCount(int smsCount) {
		this.smsCount = smsCount;
	}

	@Override
	public String toString() {
		return "话唠套餐 [资费价格=" + getPrice() + ", 通话时长=" + talkTime + ", 短信条数=" + smsCount + "]";
	}

}
