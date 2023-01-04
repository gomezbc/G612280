import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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
	private HashMap<People, Integer> peopleHashMap;
    private HashMap<Integer, People> indexHashMap;
	private Integer peopleCont;

	/**
	 * Network constructor that creates the people ArrayList
	 */
	private Network() {
		this.indexHashMap = new HashMap<Integer, People>();
		this.peopleHashMap = new HashMap<People, Integer>();
		this.peopleCont = 0;
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
		People temp = new People(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown, pStudiedat,pWorkedat, pMovies, pGroupCode);
		if(peopleHashMap.containsKey(temp)) throw new IllegalArgumentException("This person already exists");
		peopleHashMap.put(temp, peopleCont);
		indexHashMap.put(peopleCont, temp);
		peopleCont++;
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
				try{
					addToNetwork(pIdentifier, pName, pSurname, pBirthday, pGender, pBirthplace, pHometown, pStudiedat,
						pWorkedat, pMovies, pGroupCode);
				}catch(IllegalArgumentException e){
					System.out.println(e.getMessage());
				}
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
		Collection<People> tempPeople = indexHashMap.values();
		try {
			PrintWriter wrfile = new PrintWriter(wrname);
			for (People p : tempPeople) {
				wrfile.println(p.toString());
			}
			wrfile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that prints to the console, the people in the network.
	 */
	public void printToConsole(){
		Collection<People> tempPeople = indexHashMap.values();
		for (People p : tempPeople) {
			System.out.println(p.toString());
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
					Integer index0 = peopleHashMap.get(findByIdHashMap(line[0]));
					Integer index1 = peopleHashMap.get(findByIdHashMap(line[1]));
					if(peopleHashMap.containsKey(findByIdHashMap(line[0]))&&peopleHashMap.containsKey(findByIdHashMap(line[1]))){
						for (People p : indexHashMap.get(index0).getFriends()) {
							if(p.equals(indexHashMap.get(index1)))throw new IllegalArgumentException(indexHashMap.get(index0).getIdentifier()+ " and " + indexHashMap.get(index1).getIdentifier() + " already are friends");
						}
						indexHashMap.get(index0).addFriend(indexHashMap.get(index1));
						indexHashMap.get(index1).addFriend(indexHashMap.get(index0));
					}
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
	 * Method that search a person by id in the hashmap.
	 * @param id Identifier of the people we want to find.
	 * @return person with that id.
	 */

	 public People findByIdHashMap(String id) {
		Collection<People> tempPeople = indexHashMap.values();
		for (People p : tempPeople) {
			if (p.getIdentifier().equals(id)) return p;
		}
		throw new IllegalArgumentException(id+" <-- The id is incorrect!");
	}

	/**
	 * Method that prints people from the hometown given by parameter pCity
	 * @param pCity name of the city
	 */
	public String printPeopleByCity(String pCity) {
		Collection<People> tempPeople = indexHashMap.values();
		String s = "";
	    s += "People in "+pCity+": \n";
		for (People p : tempPeople) {
			if (p.getHometown().equals(pCity)) {
				s += p.getIdentifier() + " " + p.getSurname() + "\n";
			}
		}
		return s;
	}

	/**
	 * Method that prints the friends of a person by he/she surname
	 * @param surname surname of the person
	 */
	public String findFriendsBySurname(String surname) {
		Collection<People> tempPeople = indexHashMap.values();
		String s = "";
		for (People p : tempPeople) {
			if (p.getSurname().equals(surname)) {
			    s += "Friends of "+p.toString()+"\n";
				for (People f : p.getFriends()) {
					s += f.toString() + "\n";
				}
			}
		}
		return s;
	}

	/**
	 * Method that collects people born between two dates, and sorts them by borndate,surname and name
	 * @param d1 first date
	 * @param d2 second date (higher than d1)
	 */
	public String retriveByBorndDates(String d1, String d2) {
		Collection<People> tempPeople = indexHashMap.values();
		ArrayList<People> pArray = new ArrayList<People>();
		String s = "";
		try {
		    String pD1 = d1.substring(6, 10);
	        String pD2 = d2.substring(6, 10);
	        for (People p : tempPeople) {
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
				s += p.toString() + "\n";
	        }  
		}catch(Exception e1) {
		    System.out.println("Dates are incorrect!");
		}
		return s;
	}

	/**
	 * Method that prints the name, surname, birthdate and place of study of the people whose birthplace is the same hometown of the different people in residential.txt
	 */
	public String residential() {
		String currentDir = System.getProperty("user.dir");
		String read = currentDir + "/src/data/" + "residential.txt";
		File myfilename = new File(read);
		Collection<People> tempPeople = indexHashMap.values();
		String s = "";
		try (Scanner input2program = new Scanner(myfilename)) {
			while (input2program.hasNextLine()) {
				String id = input2program.nextLine();
				for(People p: tempPeople){
					if(p.getHometown()!=null && p.getIdentifier().equals(id)){
						for(People q: tempPeople){
							if(p.getHometown().equals(q.getBirthplace())){							
									s += q.getName() + " " + q.getSurname() + " " + q.getBirthdate() + " " + q.getStudiedat() + "\n";				
							}
						}
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		return s;
	}
	
	/**
	 * Method that splits all the people in the network into groups with the same films
	 * @return  arraylist of groups(arraylist of people)
	 */
	public ArrayList<ArrayList<People>> splitInGroups(){
	    ArrayList<ArrayList<People>> ret = new ArrayList<ArrayList<People>>();
		Collection<People> tempPeople = indexHashMap.values();
	    Boolean b = false;
	    for(People p: tempPeople) {
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

	public String printAllGroups(){
		String s = "";
		ArrayList<ArrayList<People>> groups = splitInGroups();
		int i = 0;
		for(ArrayList<People> pA: groups) {
			s += "\nGroup: "+i+" Movies: ";
			for(String m: pA.get(0).getMovies()) s+=" "+m;
			s+="\n";
			for(People p: pA) s+= p.toString() + "\n";
			i++;
		}
		return s;
	}
}