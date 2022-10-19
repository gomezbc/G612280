import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

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

	public void addToNetwork(String pIdentifier, String pName, String pSurname, String pBirthday, String pGender, String pBirthplace, String pHometown, ArrayList<String> pStudiedat, ArrayList<String> pWorkedat, ArrayList<String> pMovies, String pGroupCode) {
		network.people.add(new People(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown, pStudiedat, pWorkedat, pMovies, pGroupCode));
	}

	public void loadFromFile(String fileName) {
		try{
			String read = "G612280/src/data/"+fileName;
			File myfilename = new File(read);
			Scanner input2program = new Scanner (myfilename);
			input2program.nextLine();
			while ( input2program.hasNextLine() ){
				String[] line = input2program.nextLine().split(",");
				String pIdentifier = line[0];
				String pName = line[1];
				String pSurname = line[2];
				String pBirthday = line[3];
				String pGender = line[4];
				String pBirthplace = line[5];
				String pHometown = line[6];
				ArrayList<String> pStudiedat = new ArrayList<String>();
				String[] pStudiedatArray = line[7].split(";");
				for (String s : pStudiedatArray) {
					pStudiedat.add(s);
				}
				ArrayList<String> pWorkedat = new ArrayList<String>();
				String[] pWorkedatArray = line[8].split(";");
				for (String s : pWorkedatArray) {
					pWorkedat.add(s);
				}
				ArrayList<String> pMovies = new ArrayList<String>();
				String[] pMoviesArray = line[9].split(";");
				for (String s : pMoviesArray) {
					pMovies.add(s);
				}
				String pGroupCode = line[10];
				addToNetwork(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown, pStudiedat, pWorkedat, pMovies, pGroupCode);
			}
			input2program.close();
		}
		catch ( FileNotFoundException e ) {
				 e.printStackTrace();
		
		}
	}

	public void printToFile(String fileName) {
		String write2file = "G612280/src/data/"+fileName;
		File wrname = new File (write2file);
		try {
			PrintWriter wrfile = new PrintWriter (wrname);
			for (People p : people) {
				wrfile.println(p.toString());
			}
			wrfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void loadFromFileFriends(String fileName) {
		try{
			File myfilename = new File("G612280/src/data/"+fileName);
			Scanner input2program = new Scanner (myfilename);
			input2program.nextLine();
			while (input2program.hasNextLine()){
				String[] line = input2program.nextLine().split(",");
				findById(line[0]).addFriend(findById(line[1]));
				findById(line[1]).addFriend(findById(line[0]));
			}
			input2program.close();
		}
		catch ( FileNotFoundException e ) {
				 e.printStackTrace();
		}
	}

	public People findById(String id){
		for(People p: people){
			if(p.getIdentifier().equals(id)){
				return p;
			}
		}
        return null;
	}
}