import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class that represent the network and contains all the methods.
 * Contains one ArrayLists, people.
 */
public class Network {

	// Attributes

	private static Network network;
	private ArrayList<People> people;

	/**
	 * Network constructor that creates the people ArrayList
	 */
	private Network() {
		people = new ArrayList<People>();
	}

	// Getter

	public static Network getNetwork() {
		if (network == null)
			network = new Network();
		return network;
	}

	/**
	 * Method that adds a new person to the network.
	 * 
	 * @param all the attributes of people.
	 */
	public void addToNetwork(String pIdentifier, String pName, String pSurname, String pBirthday, String pGender,
			String pBirthplace, String pHometown, ArrayList<String> pStudiedat, ArrayList<String> pWorkedat,
			ArrayList<String> pMovies, String pGroupCode) {
		network.people.add(new People(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown,
				pStudiedat, pWorkedat, pMovies, pGroupCode));
	}

	/**
	 * Method that loads from the file all the people given as example.
	 * 
	 * @param String fileName.
	 */

	public void loadFromFile(String fileName) {
		try {
			String currentDir = System.getProperty("user.dir");
			String read = currentDir + "/src/data/" + fileName;
			File myfilename = new File(read);
			Scanner input2program = new Scanner(myfilename);
			input2program.nextLine();
			while (input2program.hasNextLine()) {
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
				addToNetwork(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown, pStudiedat,
						pWorkedat, pMovies, pGroupCode);
			}
			input2program.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}
	}

	/**
	 * Method that prints on the file the people.
	 * 
	 * @param String fileName.
	 */

	public void printToFile(String fileName) {
		String currentDir = System.getProperty("user.dir");
		String write2file = currentDir + "/src/data/" + fileName;
		File wrname = new File(write2file);
		try {
			PrintWriter wrfile = new PrintWriter(wrname);
			for (People p : people) {
				wrfile.println(p.toString());
			}
			wrfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that loads from the file all the people given as example.
	 * 
	 * @param String fileName.
	 */

	public void loadFromFileFriends(String fileName) {
		try {
			String currentDir = System.getProperty("user.dir");
			File myfilename = new File(currentDir + "/src/data/" + fileName);
			Scanner input2program = new Scanner(myfilename);
			input2program.nextLine();
			while (input2program.hasNextLine()) {
				String[] line = input2program.nextLine().split(",");
				findById(line[0]).addFriend(findById(line[1]));
				findById(line[1]).addFriend(findById(line[0]));
			}
			input2program.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that search a person comparing the id.
	 * 
	 * @param String id.
	 */

	public People findById(String id) {
		for (People p : people) {
			if (p.getIdentifier().equals(id)) {
				return p;
			}
		}
		return null;
	}

	public People findBySurname(String surname) {
		People[] pArray;

		return null;
	}

	public void printPeopleByCity(String pCity) {
		for (People p : people) {
			if (p.getHometown().equals(pCity)) {
				System.out.println(p.getIdentifier() + " " + p.getSurname());
			}
		}

	}

	public void findFriends(String name) {
		for (People p : people) {
			if (p.getSurname().equals(name)) {
				for (People f : p.getFriends()) {
					System.out.println(f.toString());
				}
			}
		}

	}

	public void retriveByBorndDates(String d1, String d2) {
		ArrayList<People> pArray = new ArrayList<People>();
		for (People p : people) {
			String pD = p.getBirthdate().substring(5, 9);
			if (pD.compareTo(d1) >= 0 && pD.compareTo(d2) <= 0) {
				System.out.println(p.toString());
				pArray.add(p);
			}
		}
		Collections.sort(pArray, new Comparator<People>() {
			@Override
			public int compare(People p1, People p2) {
				if(p1.getBirthdate().compareTo(p2.getBirthdate())==0){
					if(p1.getSurname().compareTo(p2.getSurname())==0){
						return p1.getName().compareTo(p2.getName());
					}else {
						return p1.getSurname().compareTo(p2.getSurname());
					}
				}else{
					return p1.getBirthdate().compareTo(p2.getBirthdate());
				}
			}
		});
		for (People p : pArray) {
			System.out.println(p.toString());
		}
	}

	/*
	 * 9. Given a set of identifiers in a file named residential.txt, recover the
	 * values of the
	 * attributes name, surname, birthplace and studiedat of the people on the
	 * network
	 * whose birthplace matches the hometown of the people who are described in
	 * residential.txt. People whose birthplace/hometown is unknown do not affect
	 * the
	 * result of this operation. For example, if the file residential.txt contains
	 * the identifiers
	 * Mike222 and Mary123, your task is to retrieve the hometown of Mike222 and
	 * Mary123 people, and find all people who were born in thosetowns
	 */
	public String residential() {
		String currentDir = System.getProperty("user.dir");
		String read = currentDir + "/src/data/" + "residential.txt";
		File myfilename = new File(read);
		Scanner input2program = new Scanner(myfilename);
		while (input2program.hasNextLine()) {
			String id = input2program.nextLine();
			for(People p:people){
				if(p.getIdentifier().equals(id)){
					
				}
			}
			
		}
	}
}