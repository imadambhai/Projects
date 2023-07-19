package hibernateDemo;

public class User {

	private int id;
	private String name, password;
	private long phno;

	public int getId() {
		return id;
	}
	

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", phno=" + phno + "]";
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getPhno() {
		return phno;
	}

	public void setPhno(long phno) {
		this.phno = phno;
	}

}
