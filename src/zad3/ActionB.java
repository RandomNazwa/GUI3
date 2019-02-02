package zad3;

public class ActionB implements Runnable {

	double weighNextProduct() {
		synchronized (this){
			double weight = Main.lista.get(0).weight;
			Main.lista.remove(0);
			return weight;
		}
	}
	
	public void run() {
		double sum = 0;
		while (true) {
			try {
				synchronized (this) {
					wait();
				}
				sum += weighNextProduct();
				if (Stuff.counter % 100 == 0) {
					System.out.println("podliczono wage " + Stuff.counter + " towarów");
				}
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			} 
			if (Main.lista.size() == 0) {
				break;
			}
		}
		System.out.println("suma wag wszystkich towarów: " + sum);
	}

	
}
