package zad3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ActionA implements Runnable {

	ActionB thread;
	
	ActionA(ActionB newActionB) { thread = newActionB; }
	
	void addProduct(String id, double weight) {
		synchronized (thread) {
			Main.lista.add(new Stuff(id,weight));
			thread.notify();
		}
	}
	
	public void run() {
		FileReader myfile;
		try {
			myfile = new FileReader("C:/Users/Administrator/Desktop/mojeStafy.txt");
			BufferedReader file = new BufferedReader(myfile);
			String line;
			while ((line = file.readLine()) != null) {
				String[] productData = line.split(" ");
				addProduct(productData[0], Double.parseDouble(productData[1]));

				if (Stuff.counter % 200 == 0) {
					System.out.println("utworzono " + Stuff.counter + " obiektów");
				}
			}
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}