package Basic07_thread;
// Thread Ŭ������ �̿��� ������ ����
// Thread Ŭ������ ��ӹް� ������ ó���� �ʿ��� �ڵ带 run()�� overriding
// �ڹٰ���ӽ��� �����彺���췯�� ������ ������

public class ThreadTest2 implements Runnable{

	String threadName;
	
	public ThreadTest2() {
		// TODO Auto-generated constructor stub
	}

	public ThreadTest2(String threadName) {
		this.threadName = threadName;
	}
	
	public void run() {
		for(int i = 1; ;i++) {
			System.out.println(threadName + " -> " +i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // ������ �и��ʸ�ŭ �����.
		}
	}
	
	public static void main(String[] args) {
		ThreadTest2 t1 = new ThreadTest2("ù��° ������");
		ThreadTest2 t2 = new ThreadTest2("�ι�° ������");
		
		// �������̽��� ��ӹ����� �߻� �޼ҵ��̱� ������ Thread ��ü�� �����.
		Thread thr1 = new Thread(t1);
		Thread thr2 = new Thread(t2);
		
		thr1.start();
		thr2.start();
		
	}

}
