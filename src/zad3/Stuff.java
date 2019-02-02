package zad3;

public class Stuff {

	static int counter = 0;
	String id;
	double weight;
	
	Stuff(String id, double weight) {
		this.id = id;
		this.weight = weight;
		counter++;
	}
	
	public double getWeight() { return weight; }
}