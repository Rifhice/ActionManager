package Core;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JTextArea;

import Ui.Menu;

/**
 * The Class Execution.	 
 * * <p>
 * This class allow to hold all the information of an execution.
 * </p>
 * 
 * 
 * @author Giordani
 * @version 1.0
 */
public class Execution implements Serializable {

	/** The command. */
	private ArrayList<String> command;
	
	/** The input files. */
	private ArrayList<String> inputFiles;
	
	/** The output files. */
	private ArrayList<String> outputFiles;
	
	/** The arguments. */
	private ArrayList<String> arguments;
	
	/** The jar file. */
	private String jarFile;
	
	/** The reverse jar file. */
	private String reverseJarFile;
	
	/** The reverse information. */
	private ArrayList<String> reverseInformation;
	
	/** The details. */
	private String details;
	
	/**
	 * Instantiates a new execution.
	 *
	 * @param command the command
	 * @param inputFiles the input files
	 * @param outputFiles the output files
	 * @param jarFile the jar file
	 */
	public Execution(ArrayList<String> command,ArrayList<String> inputFiles,ArrayList<String> outputFiles,String jarFile){
		this.reverseJarFile = new String();
		this.arguments = new ArrayList<String>();
		this.reverseInformation = new ArrayList<String>();
		this.command = new ArrayList<String>(command);
		this.inputFiles = new ArrayList<String>(inputFiles);
		this.outputFiles = new ArrayList<String>(outputFiles);
		this.jarFile = new String(jarFile);
	}
	
	/**
	 * Instantiates a new execution.
	 *
	 * @param command the command
	 * @param inputFiles the input files
	 * @param outputFiles the output files
	 * @param jarFile the jar file
	 * @param reverseJarFile the reverse jar file
	 */
	public Execution(ArrayList<String> command,ArrayList<String> inputFiles,ArrayList<String> outputFiles,String jarFile,String reverseJarFile){
		this.reverseJarFile = reverseJarFile;
		this.arguments = new ArrayList<String>();
		this.reverseInformation = new ArrayList<String>();
		this.command = new ArrayList<String>(command);
		this.inputFiles = new ArrayList<String>(inputFiles);
		this.outputFiles = new ArrayList<String>(outputFiles);
		this.jarFile = new String(jarFile);
	}
	
	/**
	 * Instantiates a new execution.
	 *
	 * @param command the command
	 * @param inputFiles the input files
	 * @param outputFiles the output files
	 * @param jarFile the jar file
	 * @param reverseJarFile the reverse jar file
	 * @param reverseInformation the reverse information
	 */
	public Execution(ArrayList<String> command,ArrayList<String> inputFiles,ArrayList<String> outputFiles,String jarFile,String reverseJarFile,ArrayList<String> reverseInformation){
		this.reverseJarFile = reverseJarFile;
		this.arguments = new ArrayList<String>();
		this.reverseInformation = new ArrayList<String>(reverseInformation);
		this.command = new ArrayList<String>(command);
		this.inputFiles = new ArrayList<String>(inputFiles);
		this.outputFiles = new ArrayList<String>(outputFiles);
		this.jarFile = new String(jarFile);
	}
	
	/**
	 * Instantiates a new execution.
	 *
	 * @param command the command
	 * @param inputFiles the input files
	 * @param outputFiles the output files
	 * @param arguments the arguments
	 * @param jarFile the jar file
	 */
	public Execution(ArrayList<String> command,ArrayList<String> inputFiles,ArrayList<String> outputFiles,ArrayList<String> arguments,String jarFile){
		this.reverseJarFile = new String();
		this.arguments = new ArrayList<String>(arguments);
		this.reverseInformation = new ArrayList<String>();
		this.command = new ArrayList<String>(command);
		this.inputFiles = new ArrayList<String>(inputFiles);
		this.outputFiles = new ArrayList<String>(outputFiles);
		this.jarFile = new String(jarFile);
	}
	
	/**
	 * Instantiates a new execution.
	 *
	 * @param command the command
	 * @param inputFiles the input files
	 * @param outputFiles the output files
	 * @param arguments the arguments
	 * @param jarFile the jar file
	 * @param reverseJarFile the reverse jar file
	 */
	public Execution(ArrayList<String> command,ArrayList<String> inputFiles,ArrayList<String> outputFiles,ArrayList<String> arguments,String jarFile,String reverseJarFile){
		this.reverseJarFile = reverseJarFile;
		this.arguments = new ArrayList<String>(arguments);
		this.reverseInformation = new ArrayList<String>();
		this.command = new ArrayList<String>(command);
		this.inputFiles = new ArrayList<String>(inputFiles);
		this.outputFiles = new ArrayList<String>(outputFiles);
		this.jarFile = new String(jarFile);
	}
	
	/**
	 * Instantiates a new execution.
	 *
	 * @param command the command
	 * @param inputFiles the input files
	 * @param outputFiles the output files
	 * @param arguments the arguments
	 * @param jarFile the jar file
	 * @param reverseJarFile the reverse jar file
	 * @param reverseInformation the reverse information
	 */
	public Execution(ArrayList<String> command,ArrayList<String> inputFiles,ArrayList<String> outputFiles,ArrayList<String> arguments,String jarFile,String reverseJarFile,ArrayList<String> reverseInformation){
		this.reverseJarFile = reverseJarFile;
		this.arguments = new ArrayList<String>(arguments);
		this.reverseInformation = new ArrayList<String>(reverseInformation);
		this.command = new ArrayList<String>(command);
		this.inputFiles = new ArrayList<String>(inputFiles);
		this.outputFiles = new ArrayList<String>(outputFiles);
		this.jarFile = new String(jarFile);
	}
	
	
	
	/**
	 * To string.
	 *
	 * @return the string representation of the execution
	 */
	public String toString(){
		String res = new String(Tools.getNameOfTheFile(jarFile));
		if(!arguments.isEmpty()){
			res += " executed with the following arguments :";
			for(int x = 0 ; x < arguments.size() ; x++){
				if(x != arguments.size() - 1){
					res += arguments.get(x) + ",";
				}
				else{
					res += arguments.get(x) + " on :";
				}
			}
		}
		else{
			res +=  " executed on : ";
		}
		for(int x = 0 ; x < inputFiles.size() ; x++){
			if(x != inputFiles.size() - 1){
				res += Tools.getNameOfTheFile(inputFiles.get(x)) + ",";
			}
			else{
				res += Tools.getNameOfTheFile(inputFiles.get(x)) + " the results has been stored in : ";
			}
		}
		for(int x = 0 ; x < outputFiles.size() ; x++){
			if(x != inputFiles.size() - 1){
				res += Tools.getNameOfTheFile(outputFiles.get(x)) + ",";
			}
			else{
				res += Tools.getNameOfTheFile(outputFiles.get(x)) + ".";
			}
		}
		if(!reverseJarFile.isEmpty()){
			res += "The file " + Tools.getNameOfTheFile(reverseJarFile) + " will be the file used to traceback.";
		}
		if(!reverseInformation.isEmpty()){
			res += " the following information has been given ";
			for(int x = 0 ; x < reverseInformation.size() ; x++){
				if(x != reverseInformation.size() - 1){
					res += reverseInformation.get(x) + ",";
				}
				else{
					res += reverseInformation.get(x) + ".";
				}
			}
		}
		else{
			res += ".";
		}
		return res;
	}
	
	/**
	 * To string detailed.
	 *
	 * @return the detailed string representation of the execution
	 */
	public String toStringDetailed(){
		return this.toString() + details; 
	}
	
	/**
	 * Sets the details.
	 *
	 * @param s the new details
	 */
	public void setDetails(String s){
		details = s;
	}
	
	/**
	 * Gets the command.
	 *
	 * @return the command
	 */
	public ArrayList<String> getCommand() {
		return command;
	}

	/**
	 * Gets the input files.
	 *
	 * @return the input files
	 */
	public ArrayList<String> getInputFiles() {
		return inputFiles;
	}

	/**
	 * Gets the output files.
	 *
	 * @return the output files
	 */
	public ArrayList<String> getOutputFiles() {
		return outputFiles;
	}

	/**
	 * Gets the jar file.
	 *
	 * @return the jar file
	 */
	public String getJarFile() {
		return jarFile;
	}

	/**
	 * Gets the reverse jar file.
	 *
	 * @return the reverse jar file
	 */
	public String getReverseJarFile(){
		return reverseJarFile;
	}
	
	/**
	 * Gets the reverse information.
	 *
	 * @return the reverse information
	 */
	public ArrayList<String> getReverseInformation() {
		return reverseInformation;
	}
	
	
	
	/**
	 * Execute.
	 * <p>
	 * This method execute the execution with all it's parameters, depending on the record boolean, it will display or not
	 * the execution.
	 * </p>
	 * @param commandDone the command done
	 * @param textAreaCommandDone the text area command done
	 * @param record the record
	 */
	public void execute(ArrayList<Execution> commandDone , JTextArea textAreaCommandDone,boolean record){
		if(!arguments.isEmpty()){			
			if(reverseJarFile.isEmpty()){
				if(!reverseInformation.isEmpty()){
					Menu.executeJar(null,jarFile,reverseJarFile, reverseInformation, inputFiles, outputFiles,arguments, commandDone,details, textAreaCommandDone,record);
				}
				else{
					Menu.executeJar(null,jarFile,reverseJarFile, null, inputFiles, outputFiles,arguments, commandDone,details, textAreaCommandDone,record);
				}
			}
			else{
				Menu.executeJar(null,jarFile,null, null, inputFiles, outputFiles,arguments, commandDone,details, textAreaCommandDone,record);
			}
		}
		else{
			if(reverseJarFile.isEmpty()){
				if(!reverseInformation.isEmpty()){
					Menu.executeJar(null,jarFile,reverseJarFile, reverseInformation, inputFiles, outputFiles,null, commandDone,details, textAreaCommandDone,record);
				}
				else{
					Menu.executeJar(null,jarFile,reverseJarFile, null, inputFiles, outputFiles,null, commandDone,details, textAreaCommandDone,record);
				}
			}
			else{
				Menu.executeJar(null,jarFile,null, null, inputFiles, outputFiles,null, commandDone,details, textAreaCommandDone,record);				
			}
		}
	}
	
	/**
	 * Traceback.
	 * <p>
	 * This method execute the reverse jar file with all it's parameters, depending on the record boolean, it will display or not
	 * the execution.
	 * </p>
	 * @param commandDone the command done
	 * @param textAreaCommandDone the text area command done
	 * @param record the record
	 */
	public void traceback(ArrayList<Execution> commandDone , JTextArea textAreaCommandDone,boolean record){
		Menu.executeJar(null, reverseJarFile, null, null, inputFiles, outputFiles, null, commandDone,details, textAreaCommandDone, record);
	}

}
