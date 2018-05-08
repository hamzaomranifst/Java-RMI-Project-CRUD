
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InstitutionCatalogCreatorInterface extends Remote {
	
	public int createInstitutionCatalog(String catalogName) throws RemoteException;

}
