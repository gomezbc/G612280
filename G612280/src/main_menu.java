import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * Main_menu main class
 */
public class main_menu {

	private static Scanner sc;
	private static Network network;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		network = Network.getNetwork();
		int selec = -1;
		while (selec != 0) {
			System.out.println(
					"1. Load 'people' into the network\n2. Load 'friends' into the network\n3. Print out people\n0. Exit");
			selec = selection();
			switch (selec) {
				case 1:
					System.out.println("Write the file you want to open: ");
					String inputFileP = JOptionPane.showInputDialog("Write the file you want to open: ");
					System.out.println("Loading 'People' into the network...");
					network.loadFromFile(inputFileP);
					System.out.println("Loaded!");
					break;
				case 2:
					String inputFileF = JOptionPane.showInputDialog("Write the file you want to open: ");
					System.out.println("Loading 'Friends' into the network...");
					network.loadFromFileFriends(inputFileF);
					System.out.println("Loaded!");
					break;
				case 3:
					System.out.println("Printing out people...");
					network.printToFile("printPeopleG612280.txt");
					System.out.println("Printed!");
					break;

				case 4:
					System.out.println("Fiend friends");
					network.loadFromFile("peopleG612280.txt");
					network.loadFromFileFriends("friendsG612280.txt");
					network.findFriends("Saez");
					System.out.println("Printed!");
					break;

				case 5:
					System.out.println("Print People in the city");
					network.printPeopleByCity("Donostia");
					System.out.println("Printed!");
					break;

				case 6:
					System.out.println("Retrive by born dates");
					network.retriveByBorndDates("23-05-1990", "15-04-2001");
					System.out.println("Printed!");
					break;

				case 0:
					System.out.println("Goodbye!");
					break;
			}
		}

		sc.close();
	}

	/**
	 * Method with exceptions of the menu.
	 * 
	 * @return A message to rewrite a command.
	 */
	private static int selection() {
		System.out.println("Please select an option: ");
		int selection = sc.nextInt();
		if (selection < 0 || selection > 6) {
			System.out.println("Invalid selection. Please try again.");
			selection();
		}
		return selection;
	}
}