package patterns.observable;

import java.util.*;

public class HighscoreProgram implements HighscoreListListener{
	
//	private Set <HighscoreList> topplister = new HashSet<HighscoreList>();
	private HighscoreList high;
	
	@Override
	public void listChanged(HighscoreList liste, int res) {
		// TODO Auto-generated method stub
		
		//hva er int i listchange?
		//skriv ut til konsoll
	}
	
	public void init() {
		Scanner input_size = new Scanner(System.in);
		System.out.println("How many results should the list show?");
		int maxSize = Integer.parseInt(input_size.nextLine());
		System.out.println("The size of the list is " + maxSize);
		input_size.close();
		
		high = new HighscoreList(maxSize);
		high.addHighscoreListListener(this);
	}
	
	public void run() {
		Scanner input_result = new Scanner(System.in);
		System.out.println("Register a result: ");
		int result = Integer.parseInt(input_result.nextLine());
		System.out.println("The registered result is: " + result);
		input_result.close();
		
		//henter inn high
		
		//hvordan får jeg inn HighscoreList hit?
		//må referere til listChanged
		
	}

}
