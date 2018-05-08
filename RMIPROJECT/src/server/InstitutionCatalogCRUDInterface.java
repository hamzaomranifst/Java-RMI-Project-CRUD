
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InstitutionCatalogCRUDInterface extends Remote {
	
	public void add(Employe e) throws RemoteException;
	public void update(String cin , Employe newEmp) throws RemoteException;
	public void delete(String cin) throws RemoteException;
	public List<Employe> all() throws RemoteException;
	public List<Employe> search(String nom) throws RemoteException;

}
