package date0710;

import java.io.File;

/**
 * 判断E盘目录下是否有后缀名为.jpg的文件，如果有，就输出此文件名称
 * @author CSH
 * @date 2018年7月10日下午5:25:26
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
				System.out.println("没有jpg文件");
			}
		}
	}

}
