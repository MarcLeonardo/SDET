package challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge2 {
	
	public static void main(String[] args) {
		
			try (Scanner input = new Scanner(System.in)) {
				System.out.println("Enter word: "); //enter word line
				String word = input.nextLine(); //enter word here
				
				int wordLength = word.length(); //counts the letters of String word
				int maxCount = 1;
				int tempCount = 0;
				char currentChar = word.charAt(0); //starts at the first letter of the String word
				char answer = '-';

				for (int i = 0; i < wordLength; i++) {
					  currentChar = word.charAt(i);
					  for (int j = 0; j < wordLength; j++) { //second loop
						  
						  if (currentChar == word.charAt(j)) {
							  tempCount++;
						  }
						  
					  }
					  
					  if (tempCount > maxCount) {
						  maxCount = tempCount;
						  answer = currentChar;
					  }
					  
					  tempCount = 0;
					  
				}
				System.out.println(answer);
			}
	}
}