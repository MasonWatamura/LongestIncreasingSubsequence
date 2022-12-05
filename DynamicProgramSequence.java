package program3cs232;
//got code from 
//https://www.geeksforgeeks.org/java-program-for-longest-increasing-subsequence/#:~:text=The%20Longest%20Increasing%20Subsequence%20(LIS,50%2C%2060%2C%2080%7D.

import java.util.ArrayList;

public class DynamicProgramSequence {
	public DynamicProgramSequence(ArrayList<Integer> num) {
		int n = num.size();   //gets the size and sets it to a variable
		int lis[] = new int[n];  //creates array of size n
		int max = 0;  //creating a max for the LIS
		
		//sets the number of each spot in the list to 1
		for(int i = 0; i < n; i++) {
			lis[i] = 1;
		}
		
		//finds all the LIS for each number in the array/list
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(num.get(i) > num.get(j) && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}
		
		//picks the highest LIS from the list
		for(int i = 0; i < n; i++) {
			if(max < lis[i]) {
				max = lis[i];
			}
		}
		System.out.println("DP: Length of longest increasing subsequence is " + max);   //prints out the DP highest part
	}
}
