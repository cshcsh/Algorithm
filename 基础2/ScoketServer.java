package date0714;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ScoketServer {
	ServerSocket serverSocket = null;

	Socket socket = null;

	public void sockets() {
		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("服务器开启。。。");
			int i = 0;
			// 实现多个客户端连接
			while (true) {
				socket = serverSocket.accept();
				System.out.println("客户端" + i + "连接成功。。。");
				if (socket != null) {
					Thread thread = new Thread(new LogicThread(socket));
					thread.setDaemon(true);//
					thread.start();
					i++;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new ScoketServer().sockets();
	}

}
