package date0712;

/**
 * ServicePackage������
 * 
 * @author CSH
 * @date 2018��7��11������8:09:45
 */
public class ServicePackage {

	private double price;//�ʷѼ۸�

	public ServicePackage() {
		
	}

	public ServicePackage(double price) {
		this.price = price;
	}

	//��ʾ�ײ���Ϣ
	public void showInfo(){
		toString();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "�ײ� [�ʷѼ۸�=" + price + "]";
	}
	
}
