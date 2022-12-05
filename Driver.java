package program3cs232;

import java.util.ArrayList;
import java.util.Random;

public class Driver {
	public static void start() {
		Random rand = new Random();
		ArrayList<Integer> num = new ArrayList<Integer>(); //array to store the numbers
		for(int i = 0; i < 20; i++) { //does it 20 times
			int randInt = rand.nextInt(1, 21);  //1 through 20
			if (!num.contains(randInt)) {   //if the array does not contain the number add it
				num.add(randInt);
			}
		}
		for(int i : num) {  //prints out all the numbers
			System.out.print(i + " ");
		}
		System.out.println();
		new UndirectedGraph(num);  //goes through the graph first
		new DynamicProgramSequence(num);  //then goes through dynamic programming to get the same answer
	}
	
	public static void main(String[]args) {
		start();
	}
}
