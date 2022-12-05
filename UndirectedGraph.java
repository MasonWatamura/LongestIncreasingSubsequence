package program3cs232;

import java.util.ArrayList;

public class UndirectedGraph {
	private int V;   //vertices;  don't need E because we will make edges as we go from the array
	private LinearProbing<Integer, String> st;   //creating linear probe hash st
	private int total = 0;
	private int highest = 0;
	
	public UndirectedGraph(ArrayList<Integer> num) {
		V = num.size(); //sets vertices
		st = new LinearProbing<Integer, String>(V);  //initializing linear probe hash st with set table size V
		for(int v = 0; v < num.size(); v++) {        //for each number in the array
			for(int w = v + 1; w < num.size(); w++) {  //it picks the number next to it and on
				if(num.get(v) < num.get(w)) {        //if that number is greater than the original number, it adds the edge
					addEdge(num.get(v), num.get(w).toString());  //adds the edge
				}
			}
		}
		for(int i : st.keys()) {  //goes through each of the keys
			total++;  //adds a base one for the key
			longestSubsequence(i); //goes through the method
			while(total != 0) {  //resets total to zero
				total--;
			}
		}
		System.out.println("Graph: Length of longest increasing subsequence is " + highest);
	}   //prints out the graph version of the answer
	
	private void addEdge(Integer v, String w) {
		if(st.contains(v)) {  //if the key already exists in the linear probing
			st.put(v, st.get(v) + " " + w);  //re-put the key and add the string value to the end of the new string value
		}
		else{
			st.put(v, w);  //for putting the first edge in per key to eliminate spaces
		}
	}
	
	private void longestSubsequence(int i) {  //use recursion
		String[] splitNums = st.get(i).split(" ");  //splits the value of the key
		for (String j : splitNums) {  //goes through each number of thhe string
			if(st.contains(Integer.parseInt(j))) {  //checks if the value is in the keys
				total++;  //adds one and goes through again for the next number
				longestSubsequence(Integer.parseInt(j));
			}
			else {  //if the number is not a key it still adds one and sets the highest number
				total++;
				if(highest < total) {
					highest = total;
				}
				total--;
			}
		}
		total--;
	}
}
