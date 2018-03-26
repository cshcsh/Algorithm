package date0712;

/**
 * TalkPackage�����ײ�
 * 
 * @author CSH
 * @date 2018��7��11������8:21:01
 */
public class TalkPackage extends ServicePackage implements CallService, SendService {

	private int talkTime;// ͨ��ʱ��
	private int smsCount;// ��������

	public TalkPackage() {
		super(58);
		this.talkTime = 500;
		this.smsCount = 30;
	}

	// ��ʾ�����ײ���Ϣ
	public void showInfo() {
		System.out.println(toString());
	}

	@Override
	// ���Ͷ���
	public void send(int count, MobileCard card) {
		card.setRealSMSCount(card.getRealSMSCount()+count);
		double consumAmount=count * 0.1;
		card.setConsumAmount(card.getConsumAmount()+consumAmount);
		card.setMoney(card.getMoney() - consumAmount);
	}

	@Override
	// ����绰
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
		return "�����ײ� [�ʷѼ۸�=" + getPrice() + ", ͨ��ʱ��=" + talkTime + ", ��������=" + smsCount + "]";
	}

}
