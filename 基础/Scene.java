package date0712;

/**
 * Sceneʹ�ó���
 * @author CSH
 * @date 2018��7��11������8:29:53
 */
public class Scene {

	private String description;//����
	private String type;//����
	private int data;//����
	
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
