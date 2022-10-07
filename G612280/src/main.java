import java.util.Scanner;

public class main {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		menu();
		int selec = selection();
		switch (selec) {
		case 1:
			System.out.println("Loading 'People' into the network...");
			break;
		case 2:
			System.out.println("Loading 'relationships'...");
			break;
		case 3:
			System.out.println("Printing out people...");
			System.out.println("Github prueba");
			break;
		}


		sc.close();
	}

	private static void menu() {
		System.out.println("1. Load 'people' into the network\n2. Load 'relationships'\n3. Print out people");
	}

	private static int selection(){
		System.out.println("Please select an option: ");
		int selection = sc.nextInt();
		if (selection < 1 || selection > 3) {
			System.out.println("Invalid selection. Please try again.");
			selection();
		}
		return selection;
	}
}
