package date0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;

public class Server {
	
	ServerSocket serverSocket;
	Socket socket;
	InputStream inputStream;
	InputStreamReader inputStreamReader;
	BufferedReader bufferedReader;

	public static void main(String[] args) throws IOException {
		/*URL url = new URL("http://www.java5200.com/");
		Socket socket2 = new Socket(url.getHost(),80);
		System.out.println(socket2);*/
				
				
		new Server().fun();
	}

	public void fun() throws IOException{

		serverSocket=new ServerSocket(9999);
		System.out.println("����������");
		socket=serverSocket.accept();
		System.out.println("�ͻ���IP��ַ��"+socket.getInetAddress());
		inputStream=socket.getInputStream();
		byte[] b=new byte[1024];
		//��ͣ��������
		new Thread(){
			public void run(){
				int n=0;
				try {
					n = inputStream.read(b);
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.out.print("�������ݣ�\n"+new String(b, 0, n)+"\n");
			}
		}.start();
		
		//��ͣ��������
		while(true){
			inputStreamReader=new InputStreamReader(System.in);
			bufferedReader=new BufferedReader(inputStreamReader);
			String string=bufferedReader.readLine();
			socket.getOutputStream().write(string.getBytes());
			System.out.println("�������ѷ���");
			if(socket.isClosed()){
				break;
			}
		}
		bufferedReader.close();
		inputStreamReader.close();
		inputStream.close();
		socket.close();
		serverSocket.close();
	}
}
