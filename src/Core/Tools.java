package Core;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import Ui.MainView;
/**
	 * <b>The Tools class contains useful method.</b>
	 * <p>
	 * This class contains statics methods that are useful to the softwares.
	 * </p>
	 * 
	 * 
	 * @author Giordani
	 * @version 1.0
*/
public class Tools {

	/**
		 * getNameOfTheFile.
		 * <p>
		 * Given the path of the file, this method will return the name of the file with it's extension.
		 * </p>
		 * 
		 * @param filePath
		 *            The Path of the file.
         * @return The name of the file with it's extension. 
    */
	public static String getNameOfTheFile(String filePath){
		if(filePath != null){
			return filePath.substring(filePath.lastIndexOf("\\")+1);
		}
		else{
			return null;
		}
	}
	
	/**
		 * selectFile.
		 * <p>
		 * Open a menu to allow the user to select a file and then return the path of the file.
		 * </p>
		 * 
	     * @return The path of the chosen file. 
	*/
	public static String selectFile(){

		File file;
		File repertoireCourant = null;
		try {
			repertoireCourant = new File(".").getCanonicalFile();

		} catch(IOException e) {}

		JFileChooser dialogue = new JFileChooser(repertoireCourant);
		// display
		dialogue.showOpenDialog(null);
		file = dialogue.getSelectedFile();
		if (file !=null) {return file.toString();}
		return null;
	}
	
	/**
		 * serializeExecution.
		 * <p>
		 * Given an arrayList of object, it will serialize all the object and write them into the file at the given 
		 * filepath.
		 * </p>
		 * 
 		 * @param e
		 *            The ArrayList containing the objects.
		 * @param filepath
		 *            The Path of the file where the serialize object will be written.
	*/
	public static void serializeExecution(ArrayList<Execution> e, String filepath){
	   
	   try{
 
		   	FileOutputStream fout = new FileOutputStream(filepath);
		   	ObjectOutputStream oos = new ObjectOutputStream(fout);  
		   	for(int x = 0 ; x < e.size() ; x++){
		   		oos.writeObject(e.get(x));
		   	}
		   	oos.close();
		   	System.out.println("Done");
		   
	   }catch(Exception ex){
		   ex.printStackTrace();
	   }
   }
	
	/**
		 * deserializeExecution.
		 * <p>
		 * Given a filepath, it will deserialize all the object and return them.
		 * </p>
		 * 
		 * @param filepath
		 *            The Path of the file where the serialize object will be read.
	*/
	public static ArrayList<Execution> deserializeExecution(String filepath){
		   
		   ArrayList<Execution> execution = new ArrayList<Execution>();
		 
		   try{
			    
			   FileInputStream fin = new FileInputStream(filepath);
			   ObjectInputStream ois = new ObjectInputStream(fin);
			   try{
				   while(true){
					   execution.add((Execution) ois.readObject());
				   }
			   }
			   catch(EOFException n){
				   
			   }
			   ois.close();
			  
			   return execution;
			   
		   }catch(Exception ex){
			   ex.printStackTrace();
			   return null;
		   } 
	 } 
	
	/**
		 * doesFileExist.
		 * <p>
		 * Return true is the file exist and is accesible, false is it doesn't exist.
		 * </p>
		 * 
		 * @param filepath
		 *            The Path of the file.
	*/
	public static boolean doesFileExist(String filepath){

		try{
			FileInputStream ips = new FileInputStream(filepath); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			br.close(); 
			return true;
		}		
		catch (Exception e){
			return false;
		}
	}
	
}
