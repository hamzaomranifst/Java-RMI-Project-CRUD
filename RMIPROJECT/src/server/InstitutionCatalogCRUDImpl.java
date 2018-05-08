
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;


public class InstitutionCatalogCRUDImpl extends UnicastRemoteObject implements InstitutionCatalogCRUDInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File dataFile;

	public InstitutionCatalogCRUDImpl(String catalaogName) throws RemoteException, CatalogNotFoundException {
		super();
		dataFile = new File("./catalog/" + catalaogName + ".json");
		if(! dataFile.exists())
			throw new CatalogNotFoundException("The Catalog " + catalaogName + "does not exist");
	}

	@Override
	public void synchronized add(Employe e) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			array.add(parser.parse(e.toJSON()).getAsJsonObject());
			reader.close();
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
			writer.write(array.toString());
			writer.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void synchronized update(String cin, Employe newEmp) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			reader.close();
			
			for( int i = 0 ; i < array.size() ; i++) {
				if(array.get(i).getAsJsonObject().get("cin").getAsString().equals(cin)) {
					array.set(i, parser.parse(newEmp.toJSON()).getAsJsonObject());
					break;
				}
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
			writer.write(array.toString());
			writer.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Override
	public void synchronized delete(String cin) throws RemoteException {
		// TODO Auto-generated method stub
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			reader.close();
			
			for( int i = 0 ; i < array.size() ; i++) {
				if(array.get(i).getAsJsonObject().get("cin").getAsString().equals(cin)) {
					array.remove(i);
					break;
				}
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
			writer.write(array.toString());
			writer.close();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}

	@Override
	public List<Employe> all() throws RemoteException {
		ArrayList<Employe> list = new ArrayList<Employe>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			reader.close();
			
			Gson gson = new Gson();
			for( int i = 0 ; i < array.size() ; i++) {
				Employe obj = gson.fromJson(array.get(i).getAsJsonObject().toString(), Employe.class);
				list.add(obj);
				
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<Employe> search(String nom) throws RemoteException {
		// TODO Auto-generated method stub
		
		ArrayList<Employe> list = new ArrayList<Employe>();
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(dataFile));
			JsonParser parser = new JsonParser();
			JsonArray array = parser.parse(reader).getAsJsonArray();
			reader.close();
			
			Gson gson = new Gson();
			for( int i = 0 ; i < array.size() ; i++) {
				if(array.get(i).getAsJsonObject().get("nom").getAsString().equals(nom)) {
					Employe obj = gson.fromJson(array.get(i).getAsJsonObject().toString(), Employe.class);
					list.add(obj);
				}
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return list;
	}

}
