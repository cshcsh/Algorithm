package date0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class LogicThread implements Runnable {
	Socket socket = null;
	InputStream in = null;

	public LogicThread(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.println(socket.getInetAddress());
		try {
			in = socket.getInputStream();
			byte[] b = new byte[1024];
			// ʵ��һ�����Ӷ��ͨ��
			while (true) {
				// �ѽ�������д���߳�
				new Thread() {
					public void run() {
						while (true) {
							byte[] b = new byte[1024];
							int n;
							try {
								n = in.read(b);// ������������
								System.out.println("�������ݣ�" + new String(b, 0, n));
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								try {
									socket.close();
									break;
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
					}
				}.start();
				// ��������
				InputStreamReader input = new InputStreamReader(System.in);// ������������
				BufferedReader br = new BufferedReader(input);
				String outN;
				try {
					outN = br.readLine();
					socket.getOutputStream().write(outN.getBytes());
					System.out.println("������ѷ���");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (socket.isClosed()) {
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
