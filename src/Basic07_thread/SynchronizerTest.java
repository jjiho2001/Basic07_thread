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

	// ������ �޼ҵ� ����ȭ : synchronized
	// public synchronized void run()
	@Override
	public void run() {
		synchronized(this) { // ����ȭ ��Ű�� ���� �κи�
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
			System.out.printf("%s -> �ܾ��� %d���Դϴ�. \n", Thread.currentThread().getName(), money);
		} else {
			// ������ �ߴ�
			try{
				this.wait(); // ���� ���� ���� ������ ����
			} catch (Exception e) {
				System.out.println("�ܾ��� �����մϴ�");
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