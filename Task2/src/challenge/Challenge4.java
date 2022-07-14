package challenge;

import java.util.Scanner;

public class Challenge4 {
	
	public static void main(String[] args) {
		
		String foodType;
		String[] restaurant = {
			"Hot Pizza, Pepperoni Pizza, $15",
			"New Pizza Place, 3-Cheese Pizza, $12",
			"Pizza Club, Meat Lovers Pizza, $16",
			"Burger Joint, Double Cheese Burger, $10",
			"Grilld, Quarter Pounder Burger, $12",
			"Betty's, Chicken Burger, $11",
		};
		
		Scanner input = new Scanner(System.in);
		System.out.println("What food are you looking for?"); //line for food type input
		foodType=input.next();
		
		for (int i = 0; i < restaurant.length; i++) {
			
			if(restaurant[i].toLowerCase().contains(foodType.toLowerCase())) {
				System.out.println(restaurant[i]);
				
			}
		}
	}
}

