import java.util.ArrayList;
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
					"1. Load 'people' into the network\n2. Load 'friends' into the network\n3. Print out people\n4. Find friends by surname\n5. Find people by city\n6. Find people by born date sorted by its atribute\n7. Split people in groups by movies\n8. Residential\n9. Load all pruebas\n0. Exit");
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
					System.out.println("Find friends of surname: \n");
					String inputS = JOptionPane.showInputDialog("Write the surname you want: ");
					network.findFriendsBySurname(inputS);
					System.out.println("Printed!");
					break;

				case 5:
					System.out.println("Print People in the city: \n");
					String inputC = JOptionPane.showInputDialog("Write the city you want: ");
					network.printPeopleByCity(inputC);
					System.out.println("Printed!");
					break;

				case 6:
					System.out.println("Retrive by born dates: ");
					String inputD1 = JOptionPane.showInputDialog("Write the first date (dd-mm-yyyy): ");
					String inputD2 = JOptionPane.showInputDialog("Write the second date (dd-mm-yyyy): ");
					network.retriveByBorndDates(inputD1, inputD2);
					System.out.println("Printed!");
					break;
					
				case 7:
				    System.out.println("Split in groups");
				    ArrayList<ArrayList<People>> aux = new ArrayList<ArrayList<People>>();
				    aux = network.splitInGroups();
				    int i = 0;
				    for(ArrayList<People> pA: aux) {
				        String info = "\nGroup: "+i+" Movies: ";
				        for(String s: pA.get(0).getMovies()) info+=" "+s;
				        System.out.println(info);
				        for(People p: pA) System.out.println(p.toString());
				        i++;
				    }
				    break;

				case 8:
					System.out.println("Residential");
					network.residential();
					break;

				case 9:
					System.out.println("Loading all tests");
					network.loadFromFile("peopleG612278.txt");
					network.loadFromFileFriends("friendsG612278.txt");
					network.loadFromFile("peopleG612280.txt");
					network.loadFromFile("peopleG612279.txt");
					network.loadFromFileFriends("friendsG612279.txt");
					network.loadFromFileFriends("friendsG612280.txt");
					network.loadFromFile("peopleG612277.txt");
					network.loadFromFileFriends("friendsG612277.txt");
					network.loadFromFile("peopleG612275.txt");
					network.loadFromFileFriends("friendsG612275.txt");
					network.loadFromFile("df_people_55.txt");
                    network.loadFromFileFriends("df_friends_55L136.txt");
					break;
				
				case 0:
					System.out.println("Goodbye!");
					break;
			}
		}

		sc.close();
	}

	/**
	 * Method to select a method .
	 * 
	 * @return the selection.
	 */
	private static int selection() {
		System.out.println("Please select an option: ");
		int selection = sc.nextInt();
		if (selection < 0 || selection > 9) {
			System.out.println("Invalid selection. Please try again.");
			selection();
		}
		return selection;
	}
}
