
import java.io.Serializable;

public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nom;
	private String prenom;
	private String cin;
	private String telephone;
	
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String nom, String prenom, String cin, String telphone) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.telephone = telphone;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getTelphone() {
		return telephone;
	}

	public void setTelphone(String telphone) {
		this.telephone = telphone;
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", telphone=" + telephone + "]";
	}
	
	public String toJSON() {
		return "{\n\tnom:" + "\"" + nom + "\"" + ",\n\tprenom:" + "\"" + prenom + "\"" + ",\n\tcin:" + "\"" + cin + "\"" + ",\n\ttelephone:" + "\"" + telephone + "\"" + "\n}";
	}
	
	
	
	
}
