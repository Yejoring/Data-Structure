package Chapter6_Practice;

public class PeopleInfo {
	private String name;
	private String email;
	private String tel;
	public PeopleInfo() {
		this.name=null;
		this.email=null;
		this.tel=null;
	}
	public PeopleInfo(String name, String email, String tel) {
		this.name=name;
		this.email=email;
		this.tel=tel;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
