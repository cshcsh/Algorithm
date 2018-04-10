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
			// 实现一次连接多次通话
			while (true) {
				// 把接受数据写入线程
				new Thread() {
					public void run() {
						while (true) {
							byte[] b = new byte[1024];
							int n;
							try {
								n = in.read(b);// 属于阻塞方法
								System.out.println("接受数据：" + new String(b, 0, n));
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
				// 发送数据
				InputStreamReader input = new InputStreamReader(System.in);// 属于阻塞方法
				BufferedReader br = new BufferedReader(input);
				String outN;
				try {
					outN = br.readLine();
					socket.getOutputStream().write(outN.getBytes());
					System.out.println("服务端已发送");
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
