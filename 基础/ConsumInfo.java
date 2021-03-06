package date0712;

/**
 * ConsumInfo消费记录
 * @author CSH
 * @date 2018年7月11日下午8:28:12
 */
public class ConsumInfo {

	private String cardNumber;//卡号
	private String type;//类型
	private int consumData;//消费数据
	
	public ConsumInfo() {
		super();
	}
	
	public ConsumInfo(String cardNumber, String type, int consumData) {
		super();
		this.cardNumber = cardNumber;
		this.type = type;
		this.consumData = consumData;
	}

	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getConsumData() {
		return consumData;
	}
	public void setConsumData(int consumData) {
		this.consumData = consumData;
	}
	
}
