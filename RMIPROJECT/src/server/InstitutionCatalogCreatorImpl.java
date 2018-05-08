
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class InstitutionCatalogCreatorImpl extends UnicastRemoteObject implements InstitutionCatalogCreatorInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InstitutionCatalogCreatorImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int createInstitutionCatalog(String catalogName) throws RemoteException {
		// TODO Auto-generated method stub
		
		File dataFile = new File("./catalog/" + catalogName + ".json");
		
		if(dataFile.exists())
			return 1;
		
		try {
			dataFile.createNewFile();
			init_Catalog(dataFile);
			return 1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	private void init_Catalog(File dataFile) {
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
			writer.write("[]");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
