package date0712;

/**
 * Scene使用场景
 * @author CSH
 * @date 2018年7月11日下午8:29:53
 */
public class Scene {

	private String description;//描述
	private String type;//类型
	private int data;//数据
	
	public Scene() {
		super();
	}
	
	public Scene(String description, String type, int data) {
		super();
		this.description = description;
		this.type = type;
		this.data = data;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
