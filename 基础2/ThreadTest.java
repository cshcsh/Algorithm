package date0713;

class ThreadDemo extends Thread {
	@Override
	public void run() {
		System.out.println("��ǰ�߳���:" + Thread.currentThread().getName());
	}

}

public class ThreadTest {

	public static void main(String[] args) {

		ThreadDemo threadDemo=new ThreadDemo();
		
		/*1�� start��
����		��start�����������̣߳�����ʵ���˶��߳����У���ʱ����ȴ�run���������ִ����϶�ֱ�Ӽ���ִ������Ĵ��롣
		ͨ������Thread���start()����������һ���̣߳���ʱ���̴߳��ھ����������У�״̬����û�����У�һ���õ�cpuʱ��Ƭ��
		�Ϳ�ʼִ��run()���������﷽�� run()��Ϊ�߳��壬��������Ҫִ�е�����̵߳����ݣ�Run�������н��������߳��漴��ֹ��
		2�� run��
����		run()����ֻ�����һ����ͨ�������ѣ����ֱ�ӵ���Run��������������Ȼֻ�����߳���һ���̣߳������ִ��·������ֻ��һ����
		����Ҫ˳��ִ�У�����Ҫ�ȴ�run������ִ����Ϻ�ſɼ���ִ������Ĵ��룬������û�дﵽд�̵߳�Ŀ�ġ��ܽ᣺
		����start�������������̣߳���run����ֻ��thread��һ����ͨ�������ã����������߳���ִ�С�����������Ӧ�ö��Ƚ���Ϥ��
		����Ҫ���д���Ĵ������run()�����У�start()���������߳̽��Զ����� run()������������jvm���ڴ���ƹ涨�ġ�
		����run()����������public����Ȩ�ޣ�����ֵ����Ϊvoid��*/
		threadDemo.run();
		threadDemo.start();
	}

}
