package date0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	Socket socket;
	InputStream inputStream;
	InputStreamReader inputStreamReader;
	BufferedReader bufferedReader;

	public static void main(String[] args) throws UnknownHostException, IOException{

		new Client().fun();
	}
	
	public void fun() throws UnknownHostException, IOException{
		socket=new Socket("", 9999);
		System.out.println("�ͻ��˿���");
		
		new Thread(){
			public void run(){
				try {
					inputStream=socket.getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				byte[] b=new byte[1024];
				int n=0;
				try {
					n = inputStream.read(b);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.println("�������ݣ�\n"+new String(b,0,n)+"\n");
				
			}
		}.start();
		
		
		while(true){
			inputStreamReader=new InputStreamReader(System.in);
			bufferedReader=new BufferedReader(inputStreamReader);
			String string=bufferedReader.readLine();
			if("bye".equals(string)){
				break;
			}
			socket.getOutputStream().write(string.getBytes());
			System.out.println("�ͻ����ѷ���");
			
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		socket.close();
	}

}
