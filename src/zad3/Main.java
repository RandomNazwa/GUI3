/**
 *
 *  @author Trembowska Katarzyna S18233
 *
 */

package zad3;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Main {
  
	static List<Stuff> lista = new ArrayList<Stuff>();
	
	public static void main(String ... args) throws FileNotFoundException {
	
	  ActionB actionB = new ActionB();
	  ActionA actionA = new ActionA(actionB);
	  Thread threadA = new Thread(actionA);
	  Thread threadB = new Thread(actionB);	  

	  threadA.start();
	  threadB.start();
  }
}
