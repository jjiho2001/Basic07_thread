package Basic07_thread;
// Thread 클래스를 이용한 스레드 구현
// Thread 클래스를 상속받고 스레드 처리가 필요한 코드를 run()를 overriding
// 자바가상머신의 스레드스케쥴러가 실행을 관리함

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
			} // 지정한 밀리초만큼 대기함.
		}
	}
	
	public static void main(String[] args) {
		ThreadTest2 t1 = new ThreadTest2("첫번째 스레드");
		ThreadTest2 t2 = new ThreadTest2("두번째 스레드");
		
		// 인터페이스를 상속받으면 추상 메소드이기 때문에 Thread 객체로 만든다.
		Thread thr1 = new Thread(t1);
		Thread thr2 = new Thread(t2);
		
		thr1.start();
		thr2.start();
		
	}

}
