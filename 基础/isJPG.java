package date0710;

import java.io.File;

/**
 * �ж�E��Ŀ¼���Ƿ��к�׺��Ϊ.jpg���ļ�������У���������ļ�����
 * @author CSH
 * @date 2018��7��10������5:25:26
 */
public class isJPG {

	public static void main(String[] args) {

		File file=new File("E:\\");
		String[] strings=file.list();
		for (int i = 0; i < strings.length; i++) {
			String string = strings[i];
			if(string.endsWith(".jpg")){
				System.out.println(string);
			}else{
				System.out.println("û��jpg�ļ�");
			}
		}
	}

}
