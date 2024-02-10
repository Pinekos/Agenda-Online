package paqueteagenda;

public class Contacto {
	private String name, surname, phone;
	
	public Contacto(String name, String surname, String phone) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String newSurame) {
		this.surname = newSurame;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String newPhone) {
		this.phone = newPhone;
	}

}
