import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Network {
	private static Network network;
	private ArrayList<People> people;

	private Network() {
		people = new ArrayList<People>();
	}

	public static Network getNetwork() {
		if (network == null) network = new Network();
		return network;
	}

	public void addToNetwork(String pIdentifier, String pName, String pSurname, String pBirthday, String pGender, String pBirthplace, String pHometown, ArrayList<String> pStudiedat, ArrayList<String> pWorkedat, ArrayList<String> pMovies) {
		network.people.add(new People(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown, pStudiedat, pWorkedat, pMovies));
	}

	public void loadFromFile(String fileName) {
		try{
			File myfilename = new File("C:/Users/borja/git/G612280/G612280/src/data/"+fileName);
			Scanner input2program = new Scanner (myfilename);
			input2program.nextLine();
			while ( input2program.hasNextLine() ){		
				input2program.useDelimiter("");
				String pIdentifier = input2program.next();
				String pName = input2program.next();
				String pSurname = input2program.next();
				String pBirthday = input2program.next();
				String pGender = input2program.next();
				String pBirthplace = input2program.next();
				String pHometown = input2program.next();
				ArrayList<String> pStudiedat = new ArrayList<String>();
				String[] pStudiedatArray = input2program.next().split(";");
				for (String s : pStudiedatArray) {
					pStudiedat.add(s);
				}
				ArrayList<String> pWorkedat = new ArrayList<String>();
				String[] pWorkedatArray = input2program.next().split(";");
				for (String s : pWorkedatArray) {
					pWorkedat.add(s);
				}
				ArrayList<String> pMovies = new ArrayList<String>();
				String[] pMoviesArray = input2program.next().split(";");
				for (String s : pMoviesArray) {
					pMovies.add(s);
				}
				addToNetwork(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown, pStudiedat, pWorkedat, pMovies);
			}
			input2program.close();
		}
		catch ( FileNotFoundException e ) {
				 e.printStackTrace();
		
		}
	}
}
