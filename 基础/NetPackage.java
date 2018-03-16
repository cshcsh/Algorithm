package date0712;

/**
 * NetPackage网虫套餐
 * 
 * @author CSH
 * @date 2018年7月11日下午8:25:04
 */
public class NetPackage extends ServicePackage implements NetService {

	private int flow;// 上网流量

	public NetPackage() {
		super(68);
		this.flow = 3;
	}

	// 显示网虫套餐信息
	public void showInfo() {
		System.out.println(toString());
	}

	@Override
	// 上网操作
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
		return "网虫套餐 [资费价格=" + getPrice() + ",上网流量=" + flow + "]";
	}

}
