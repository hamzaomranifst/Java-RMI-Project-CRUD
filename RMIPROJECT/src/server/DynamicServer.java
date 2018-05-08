
import java.rmi.RMISecurityManager;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClassLoader;

public class DynamicServer {

	public static void main(String[] args) {
		
		System.setSecurityManager(new RMISecurityManager());
		
		try {
			
			String urlCodebase = System.getProperty("java.rmi.server.codebase");
			ClassLoader loader =  RMIClassLoader.getClassLoader(urlCodebase);
			
			Registry registry = LocateRegistry.createRegistry(1099); 
			System.out.println( "Serveur : Construction de l'implementation");
			Class fabClass = loader.loadClass("FabricImpl");
		    System.out.println("Objet Fabrique lie dans le RMIregistry");
		    registry.rebind ("Fabric", (Remote) fabClass.newInstance());
		    System.out.println ("Serveur prêt.") ;
		    System.out.println("Attente des invocations des clients ...");
		    
		}
		catch (Exception e) {
            System.out.println("Erreur de liaison de l'objet Fabrique");
            e.printStackTrace();
		}
		
	}

}
