package test;

public class arrayTest {
	public static void main(String[] args) {
		String[] input =  { "alex pizza pasta", "alex pizza pizza", "alex noodle", "bob pasta",
			"bob noodle sandwich pasta", "bob steak noodle" };
		
		String[][] input2 = new String[input.length][5];
	
		for (int i = 0; i < input.length; i++) {
			String[] order_data = input[i].split(" ");
			for (int j = 0; j < order_data.length; j++) {
				input2[i][j] = order_data[j];
				
				System.out.println(input2[i][j]);
			}
		}
	}
}
