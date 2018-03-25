package date0712;

/**
 * SuperPackage�����ײ�
 * 
 * @author CSH
 * @date 2018��7��11������8:21:43
 */
public class SuperPackage extends ServicePackage implements CallService, NetService, SendService {

	private int talkTime;// ͨ��ʱ��
	private int smsCount;// ��������
	private int flow;// ��������

	public SuperPackage() {
		super(78);
		this.talkTime = 200;
		this.smsCount = 50;
		this.flow = 1;
	}

	@Override
	public void showInfo() {
		System.out.println(toString());
	}

	@Override
	// ���Ͷ���
	public void send(int count, MobileCard card) {
		card.setRealSMSCount(card.getRealSMSCount() + count);
		double consumAmount = count * 0.1;
		card.setConsumAmount(card.getConsumAmount() + consumAmount);
		card.setMoney(card.getMoney() - consumAmount);
	}

	@Override
	// ��������
	public void netPlay(int flow, MobileCard card) {
		card.setRealFlow(card.getRealFlow()+flow);
		double consumAmount = flow * 102.4;
		card.setConsumAmount(card.getConsumAmount() + consumAmount);
		card.setMoney(card.getMoney() - consumAmount);
	}

	@Override
	// ����绰
	public void call(int minCount, MobileCard card) {
		card.setRealTalkTime(card.getRealTalkTime()+minCount);
		double consumAmount = minCount * 0.2;
		card.setConsumAmount(card.getConsumAmount() + consumAmount);
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

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	@Override
	public String toString() {
		return "�����ײ� [�ʷѼ۸�=" + getPrice() + ",ͨ��ʱ��=" + talkTime + ", ��������=" + smsCount + ", ��������=" + flow + "]";
	}

}
