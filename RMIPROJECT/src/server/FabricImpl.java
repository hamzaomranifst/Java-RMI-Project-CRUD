
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FabricImpl extends UnicastRemoteObject implements FabricInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FabricImpl() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public InstitutionCatalogCRUDInterface newInstitutionCatalogCRUD(String catalogName) throws RemoteException, CatalogNotFoundException {
		// TODO Auto-generated method stub
		return new InstitutionCatalogCRUDImpl(catalogName);
	}

	@Override
	public InstitutionCatalogCreatorInterface newInstitutionCatalogCreator() throws RemoteException {
		// TODO Auto-generated method stub
		return new InstitutionCatalogCreatorImpl();
	}

}
