
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public interface StaticClientInterface extends Serializable {
	

	public void addEmploye(Employe e) throws RemoteException;
	public void deleteEmploye(String cin) throws RemoteException;
	public void updateEmploye(String cin, Employe e) throws RemoteException;
	public List<Employe> allEmployes() throws RemoteException;
	public List<Employe> searchEmployes(String nom) throws RemoteException;

	public void createCatalog(String catalogName) throws RemoteException, CatalogNotFoundException;

}
