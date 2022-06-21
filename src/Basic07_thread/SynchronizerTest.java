package Basic07_thread;

public class SynchronizerTest {

	public SynchronizerTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ATM atm = new ATM();
		
		Thread mother = new Thread(atm, "mother");
		Thread son = new Thread(atm, "son");
		
		mother.start();
		son.start();
	}

}

class ATM implements Runnable{
	private int money = 10000;

	// 스레도 메소드 동기화 : synchronized
	// public synchronized void run()
	@Override
	public void run() {
		synchronized(this) { // 동기화 시키고 싶은 부분만
			for(int i = 1; i <= 7; i++) {
				try {
					Thread.sleep(1000);
					getCash(1000);
				} catch (Exception e) {
					
				}
			}
		}
	}
	
	public void getCash(int howMuch) {
		if(money > 0) {
			money -= howMuch;
			System.out.printf("%s -> 잔액은 %d원입니다. \n", Thread.currentThread().getName(), money);
		} else {
			// 스레드 중단
			try{
				this.wait(); // 현재 실행 중인 스레드 중지
			} catch (Exception e) {
				System.out.println("잔액이 부족합니다");
			}
		}
	}
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
}