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
 * @author Erik, Borja and Pablo
 */
public class Network {

	private static Network network;
	private ArrayList<People> people;

	/**
	 * Network constructor that creates the people ArrayList
	 */
	private Network() {
		people = new ArrayList<People>();
	}

	/**
	 * Implementation of the singleton pattern
	 * @return network object
	 */
	public static Network getNetwork() {
		if (network == null)
			network = new Network();
		return network;
	}

	/**
	 * Method that add a person to the network
	 * @param pIdentifier Identifier of the person
	 * @param pName Name of the person
	 * @param pSurname Surname of the person
	 * @param pBirthday Birthday of the person
	 * @param pGender Gender of the person
	 * @param pBirthplace Birthplace of the person
	 * @param pHometown Hometown of the person
	 * @param pStudiedat Where has the person studied
	 * @param pWorkedat Where has the person worked
	 * @param pMovies Favorites movies of the person
	 * @param pGroupCode Code of the group
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
	 * @param fileName name of the file we want to do the import from.
	 */

	public void loadFromFile(String fileName) {
		try {
			String currentDir = System.getProperty("user.dir");
			String read = currentDir + "/src/data/" + fileName;
			File myfilename = new File(read);
			Scanner input2program = new Scanner(myfilename);
			if(input2program.hasNextLine())input2program.nextLine();
			while (input2program.hasNextLine()) {
				String[] line = input2program.nextLine().split(",");
				if(line.length!=11){
					System.out.println("Missing arguments. Aborting");
				}
				else{
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
				}
					input2program.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
	}

	/**
	 * Method that prints on a file the people.
	 * 
	 * @param fileName name of the file where we want to print the people.
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
	 * Method that loads from a file all the people given as example.
	 * 
     * @param fileName name of the file we want to do the import from.
	 */

	public void loadFromFileFriends(String fileName) {
		try {
			String currentDir = System.getProperty("user.dir");
			File myfilename = new File(currentDir + "/src/data/" + fileName);
			Scanner input2program = new Scanner(myfilename);
			input2program.nextLine();
			while (input2program.hasNextLine()) {
				String[] line = input2program.nextLine().split(",");
				try {
				    findById(line[0]).addFriend(findById(line[1]));
	                findById(line[1]).addFriend(findById(line[0]));
				}catch(Exception e) {
				    System.out.println(e.getMessage());
				}
			
			}
			input2program.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that search a person by id.
	 * @param id Identifier of the people we want to find.
	 * @return person with that id.
	 */

	public People findById(String id) {
		for (People p : people) {
			if (p.getIdentifier().equals(id)) {
				return p;
			}else{
				throw new IllegalArgumentException(id+" <-- The id is incorrect!");
			}
		}
		return null;
	}

	/**
	 * Method that prints people from the hometown given by parameter pCity
	 * @param pCity name of the city
	 */
	public void printPeopleByCity(String pCity) {
	    System.out.println("People in "+pCity+": ");
		for (People p : people) {
			if (p.getHometown().equals(pCity)) {
				System.out.println(p.getIdentifier() + " " + p.getSurname());
			}
		}

	}

	/**
	 * Method that prints the friends of a person by he/she surname
	 * @param surname surname of the person
	 */
	public void findFriendsBySurname(String surname) {
		for (People p : people) {
			if (p.getSurname().equals(surname)) {
			    System.out.println("Friends of "+p.toString()+"\n");
				for (People f : p.getFriends()) {
					System.out.println(f.toString());
				}
			}
		}

	}

	/**
	 * Method that collects people born between two dates, and sorts them by borndate,surname and name
	 * @param d1 first date
	 * @param d2 second date (higher than d1)
	 */
	public void retriveByBorndDates(String d1, String d2) {
		ArrayList<People> pArray = new ArrayList<People>();
		try {
		    String pD1 = d1.substring(6, 10);
	        String pD2 = d2.substring(6, 10);
	        for (People p : people) {
	            try {
	                String pD = p.getBirthdate().substring(6, 10);
	                if (pD.compareTo(pD1) >= 0 && pD.compareTo(pD2) <= 0) {
	                    pArray.add(p);
	                }
	            }catch(IndexOutOfBoundsException e) {
	                System.out.println(p.getIdentifier()+" bithdate has an incorrect format");
	            }
	        }
	        System.out.println("");
	        Collections.sort(pArray, new Comparator<People>() {
	            @Override
	            public int compare(People p1, People p2) {
	                String pD1 = p1.getBirthdate().substring(6, 10);
	                String pD2 = p2.getBirthdate().substring(6, 10);
	                if(pD1.compareTo(pD2)==0){
	                    if(p1.getSurname().compareTo(p2.getSurname())==0){
	                        return p1.getName().compareTo(p2.getName());
	                    }else {
	                        return p1.getSurname().compareTo(p2.getSurname());
	                    }
	                }else{
	                    return pD1.compareTo(pD2);
	                }
	            }
	        });
	        for (People p : pArray) {
	            System.out.println(p.toString());
	        }  
		}catch(Exception e1) {
		    System.out.println("Dates are incorrect!");
		}
	}

	/**
	 * Method that prints the name, surname, birthdate and place of study of the people whose birthplace is the same hometown of the different people in residential.txt
	 */
	public void residential() {
		String currentDir = System.getProperty("user.dir");
		String read = currentDir + "/src/data/" + "residential.txt";
		File myfilename = new File(read);
		try (Scanner input2program = new Scanner(myfilename)) {
			while (input2program.hasNextLine()) {
				String id = input2program.nextLine();
				for(People p:people){
					if(p.getHometown()!=null && p.getIdentifier().equals(id)){
						for(People q:people){
							if(p.getHometown().equals(q.getBirthplace())){							
									System.out.println(q.getName() + " " + q.getSurname() + " " + q.getBirthdate() + " " + q.getStudiedat());					
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}
	
	/**
	 * Method that splits all the people in the network into groups with the same films
	 * @return  arraylist of groups(arraylist of people)
	 */
	public ArrayList<ArrayList<People>> splitInGroups(){
	    ArrayList<ArrayList<People>> ret = new ArrayList<ArrayList<People>>();
	    Boolean b = false;
	    for(People p: people) {
	        b = false;
	        for(ArrayList<People> pA: ret) {
	            if(p.getMovies().equals(pA.get(0).getMovies())) {
	                pA.add(p);
	                b = true;
	                break;
	            }
	        }
	        if(!b) {
	            ArrayList<People> aux = new ArrayList<People>();
                aux.add(p);
                ret.add(aux);
	        }
	    }
	    return ret;  
	}
	 
}