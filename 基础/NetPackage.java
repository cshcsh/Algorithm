package date0712;

/**
 * NetPackage�����ײ�
 * 
 * @author CSH
 * @date 2018��7��11������8:25:04
 */
public class NetPackage extends ServicePackage implements NetService {

	private int flow;// ��������

	public NetPackage() {
		super(68);
		this.flow = 3;
	}

	// ��ʾ�����ײ���Ϣ
	public void showInfo() {
		System.out.println(toString());
	}

	@Override
	// ��������
	public void netPlay(int flow, MobileCard card) {
		card.setRealFlow(card.getRealFlow()+flow);
		double consumAmount=flow * 102.4;
		card.setConsumAmount(card.getConsumAmount()+consumAmount);
		card.setMoney(card.getMoney() - consumAmount);
		
	}

	public int getFlow() {
		return flow;
	}

	public void setFlow(int flow) {
		this.flow = flow;
	}

	@Override
	public String toString() {
		return "�����ײ� [�ʷѼ۸�=" + getPrice() + ",��������=" + flow + "]";
	}

}
