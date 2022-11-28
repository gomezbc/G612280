import java.util.ArrayList;
/**
 * Class that represents People.
 *
 */
public class People {
    
    //Attributes
	
	private String identifier;
	private String name;
	private String surname;
	private String birthdate;
	private String gender;
	private String birthplace;
	private String hometown;
	private ArrayList<String> studiedat;
	private ArrayList<String> workedat;
	private ArrayList<String> movies;
	private String groupCode;
	private ArrayList<People> friends;

	/**
     * Method constructor of People which has as parameter all the caracteristics required.
     */
	public People(String pIdentifier, String pName, String pSurname, String pBirthday, String pGender, String pBirthplace, String pHometown, ArrayList<String> pStudiedat, ArrayList<String> pWorkedat, ArrayList<String> pMovies, String pGroupCode) {
		this.identifier = pIdentifier;
		this.name = pName;
		this.surname = pSurname;
		this.birthdate = pBirthday;
		this.gender = pGender;
		this.birthplace = pBirthplace;
		this.hometown = pHometown;
		this.studiedat = pStudiedat;
		this.workedat = pWorkedat;
		this.movies = pMovies;
		this.groupCode = pGroupCode;
		this.friends = new ArrayList<People>();
	}
	
	/**
     * toString method override, returns an string with the method-calling people
     * attributes.
     * @return String.
     */

	@Override
	public String toString(){
		return "Identifier: " + this.identifier + " Name: " + this.identifier + " Surname: " + this.surname + " Birthdate: " + this.birthdate + "Group Code: " + this.groupCode;
	}
	
	/**
     * Method that returns the identifier of the method-calling people.
     * @return description of the person.
     */

	public String getIdentifier() {
		return identifier;
	}
	
	/**
     * Changes the method-calling people Identifier to the one given from parameter.
     * @param identifier the identifier of the method-calling people to set.
     */

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	/**
     * Method that returns the Name of the method-calling people.
     * @return name of the person.
     */

	public String getName() {
		return name;
	}
	
	/**
     * Changes the method-calling people name to the one given from parameter.
     * @param name the name of the method-calling people to set.
     */

	public void setName(String name) {
		this.name = name;
	}
	
	/**
     * Method that returns the surname of the method-calling people.
     * @return surname of the person.
     */

	public String getSurname() {
		return surname;
	}
	
	/**
     * Changes the method-calling people surname to the one given from parameter.
     * @param surname the surname of the method-calling people to set.
     */

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
     * Method that returns the Birthdate of the method-calling people.
     * @return Birthdate of the person.
     */

	public String getBirthdate() {
		return birthdate;
	}
	
    /**
     * Changes the method-calling people birthdate to the one given from parameter.
     * @param birthdate the birthdate of the method-calling people to set.
     */


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	
	/**
     * Method that returns the Gender of the method-calling people.
     * @return Gender of the person.
     */

	public String getGender() {
		return gender;
	}
	
    /**
     * Changes the method-calling people gender to the one given from parameter.
     * @param gender the gender of the method-calling people to set.
     */

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
     * Method that returns the Birthplace of the method-calling people.
     * @return Birthplace of the person.
     */

	public String getBirthplace() {
		return birthplace;
	}
	
    /**
     * Changes the method-calling people birthplace to the one given from parameter.
     * @param birthplace the birthplace of the method-calling people to set.
     */

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	
	/**
     * Method that returns the Hometown of the method-calling people.
     * @return Hometown of the person.
     */

	public String getHometown() {
		return hometown;
	}
	
	 /**
     * Changes the method-calling people hometown to the one given from parameter.
     * @param hometown the hometown of the method-calling people to set.
     */

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}
	
	 /**
     * Method that returns the ArrayList Studiedat of the method-calling people.
     * @return Stuiedat of the person.
     */
	
	
	public ArrayList<String> getStudiedat() {
		return studiedat;
	}
	
    /**
     * Changes the method-calling people Studiedat ArrayList to the one given from parameter.
     * @param Studiedat the Studiedat ArrayList of the method-calling people to set.
     */

	public void setStudiedat(ArrayList<String> studiedat) {
		this.studiedat = studiedat;
	}
	
	/**
     * Method that returns the Workedat of the method-calling people.
     * @return Workedat of the person.
     */

	public ArrayList<String> getWorkedat() {
		return workedat;
	}
	
    /**
     * Changes the method-calling people workedat ArrayList to the one given from parameter.
     * @param workedat the workedat ArrayList of the method-calling people to set.
     */

	public void setWorkedat(ArrayList<String> workedat) {
		this.workedat = workedat;
	}
	
	   /**
     * Method that returns the Movies of the method-calling people.
     * @return Movies of the person.
     */

	public ArrayList<String> getMovies() {
		return movies;
	}
	
    /**
     * Changes the method-calling people movies ArrayList to the one given from parameter.
     * @param movies the movies ArrayList of the method-calling people to set.
     */

	public void setMovies(ArrayList<String> movies) {
		this.movies = movies;
	}
	
	/**
     * Method that returns the GroupCode of the method-calling people.
     * @return BroupCode of the person.
     */

	public String getGroupCode() {
		return groupCode;
	}
	
    /**
     * Changes the method-calling people groupCode ArrayList to the one given from parameter.
     * @param groupCode the groupCode ArrayList of the method-calling people to set.
     */

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}
	
	/**
     * Method that returns the Friends of the method-calling people.
     * @return Friends of the person.
     */

	public ArrayList<People> getFriends() {
		return friends;
	}
	
    /**
     * Changes the method-calling people pfriends ArrayList to the one given from parameter.
     * @param pfriends the pfriends ArrayList of the method-calling people to set.
     */

	public void setFriends(ArrayList<People> pfriends) {
	    this.friends = pfriends;
	}
	
	/**
     * Method that adds a person to friends
     * @param People pFriend
     */

    public void addFriend(People pFriend) {
        friends.add(pFriend);
    }
}
