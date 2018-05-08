
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FabricInterface extends Remote {
	
	public InstitutionCatalogCRUDInterface newInstitutionCatalogCRUD(String catalogName) throws RemoteException, CatalogNotFoundException;
	public InstitutionCatalogCreatorInterface newInstitutionCatalogCreator() throws RemoteException;
	
}
