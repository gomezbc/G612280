import java.util.ArrayList;

public class People {
	
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

	@Override
	public String toString(){
		return "Identifier: " + this.identifier + " Name: " + this.identifier + " Surname: " + this.surname + " Birthdate: " + this.birthdate + "Group Code: " + this.groupCode;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthplace() {
		return birthplace;
	}

	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public ArrayList<String> getStudiedat() {
		return studiedat;
	}

	public void setStudiedat(ArrayList<String> studiedat) {
		this.studiedat = studiedat;
	}

	public ArrayList<String> getWorkedat() {
		return workedat;
	}

	public void setWorkedat(ArrayList<String> workedat) {
		this.workedat = workedat;
	}

	public ArrayList<String> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<String> movies) {
		this.movies = movies;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

	public ArrayList<People> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<People> pfriends) {
	    this.friends = pfriends;
	}

    public void addFriend(People pFriend) {
        friends.add(pFriend);
    }
}
