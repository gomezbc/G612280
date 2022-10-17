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
	
	public People(String pIdentifier, String pName, String pSurname, String pBirthday, String pGender, String pBirthplace, String pHometown, ArrayList<String> pStudiedat, ArrayList<String> pWorkedat, ArrayList<String> pMovies, String pGroupCode) {
		this.setIdentifier(pIdentifier);
		this.setName(pName);
		this.setSurname(pSurname);
		this.setBirthdate(pBirthday);
		this.setGender(pGender);
		this.setBirthplace(pBirthplace);
		this.setHometown(pHometown);
		this.setStudiedat(pStudiedat);
		this.setWorkedat(pWorkedat);
		this.setMovies(pMovies);
		this.groupCode = pGroupCode;
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

}
