package Basic07_thread;
// Thread Ŭ������ �̿��� ������ ����
// Thread Ŭ������ ��ӹް� ������ ó���� �ʿ��� �ڵ带 run()�� overriding
// �ڹٰ���ӽ��� �����彺���췯�� ������ ������

public class ThreadTest1 extends Thread{

	String threadName;
	
	public ThreadTest1() {
		// TODO Auto-generated constructor stub
	}

	public ThreadTest1(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		for(int i = 1; ;i++) {
			System.out.println(threadName + " -> " +i);
		}
	}
	
	public static void main(String[] args) {
		ThreadTest1 t1 = new ThreadTest1("ù��° ������");
		ThreadTest1 t2 = new ThreadTest1("�ι�° ������");
		
		// run() �޼ҵ�� start() �޼ҵ带 �̿��Ͽ� ȣ�� ������.
		
		t1.start();
		t2.start();
	}

}
