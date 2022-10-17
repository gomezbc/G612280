import java.util.Scanner;
public class main_menu {

	private static Scanner sc = new Scanner(System.in);
	private static Network network;

	public static void main(String[] args) {
		network = Network.getNetwork();
		menu();
		int selec = selection();
		switch (selec) {
		case 1:
			System.out.println("Loading 'People' into the network...");
			network.loadFromFile("peopleG612280.txt");
			break;
		case 2:
			System.out.println("peopleG612280.txt");
			break;
		case 3:
			System.out.println("Printing out people...");
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
