package date0712;

/**
 * ServicePackage抽象父类
 * 
 * @author CSH
 * @date 2018年7月11日下午8:09:45
 */
public class ServicePackage {

	private double price;//资费价格

	public ServicePackage() {
		
	}

	public ServicePackage(double price) {
		this.price = price;
	}

	//显示套餐信息
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
		return "套餐 [资费价格=" + price + "]";
	}
	
}
