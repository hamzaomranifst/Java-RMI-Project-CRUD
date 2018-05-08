import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class StaticClient implements StaticClientInterface {
	
	private FabricInterface fabrique;
	private InstitutionCatalogCRUDInterface crud;
	private InstitutionCatalogCreatorInterface creator;
	
	
	public StaticClient(String catalogName) throws RemoteException, NotBoundException, CatalogNotFoundException {
		Registry reg = LocateRegistry.getRegistry("localhost",1099);
		fabrique = (FabricInterface) reg.lookup("Fabric");
		crud = fabrique.newInstitutionCatalogCRUD(catalogName);
	}

	public StaticClient() throws RemoteException, NotBoundException{
		Registry reg = LocateRegistry.getRegistry("localhost",1099);
		fabrique = (FabricInterface) reg.lookup("Fabric");
		creator = fabrique.newInstitutionCatalogCreator();
	}
	
	
	public void addEmploye(Employe e) throws RemoteException {
		if(crud == null) {
			System.out.println("Not Connected to Catalog!");
			return;
		}

		crud.add(e);

	}

	public void deleteEmploye(String cin) throws RemoteException {
		if(crud == null) {
			System.out.println("Not Connected to Catalog!");
			return;
		}

		crud.delete(cin);

	}

	public void updateEmploye(String cin, Employe e) throws RemoteException {
		if(crud == null) {
			System.out.println("Not Connected to Catalog!");
			return;
		}

		crud.update(cin, e);

	}

	public List<Employe> allEmployes() throws RemoteException {
		if(crud == null) {
			System.out.println("Not Connected to Catalog!");
			return null;
		}

		return crud.all();
	}

	public List<Employe> searchEmployes(String nom) throws RemoteException {
		if(crud == null) {
			System.out.println("Not Connected to Catalog!");
			return null;
		}

		return crud.search(nom);
	}

	public void createCatalog(String catalogName) throws RemoteException, CatalogNotFoundException {
		creator.createInstitutionCatalog(catalogName);
		crud = fabrique.newInstitutionCatalogCRUD(catalogName);

	}

}
