package Ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import Core.Execution;
import Core.Tools;

/**
	 * <b>Menu is the class displaying the menu.</b>
	 * <p>
	 * The menu allow the user to interact with the software via all the buttons.
	 * </p>
	 * 
	 * 
	 * @author Giordani
	 * @version 1.0
 */
@SuppressWarnings("serial")
public class Menu extends JPanel implements ActionListener{

	/** The frame. */
	private MainView frame;
	
	/** The menu. */
	private JDialog menu;
	
	/** The remove index. */
	private int removeIndex = 0;
	
	/** The index input lines. */
	private int indexInputLines = 0;
	
	/** The index output lines. */
	private int indexOutputLines = 0;
	
	/** The index default reverse. */
	private int indexDefaultReverse = 0;
	
	/** The command cpt. */
	public static int commandCpt = 0;
	
	/** The jar text. */
	private JTextField jarText;
	
	/** The reverse jar text. */
	private JTextField reverseJarText;
	
	/** The additional arguments. */
	private JTextField additionalArguments;
	
	/** The redo string. */
	private JTextField redoString;
	
	/** The first string. */
	private JTextField firstString;
	
	/** The last string. */
	private JTextField lastString;
	
	/** The text area input. */
	private JTextArea textAreaInput;
	
	/** The text area output. */
	private JTextArea textAreaOutput;
	
	/** The text area command done. */
	private JTextArea textAreaCommandDone;
	
	/** The input file. */
	private ArrayList<String> inputFile = new ArrayList<String>();
	
	/** The output file. */
	private ArrayList<String> outputFile = new ArrayList<String>();
	
	/** The args. */
	private ArrayList<String> args = new ArrayList<String>();
	
	/** The reverse info. */
	private ArrayList<String> reverseInfo = new ArrayList<String>();
	
	/** The jar file. */
	private String jarFile = null;
	
	/** The reverse jar file. */
	private String reverseJarFile = null;
	
	/** The command done. */
	private ArrayList<Execution> commandDone = new ArrayList<Execution>();
	
	/** The details. */
	private String details = new String();
	

	/** The comboboxfile width. */
	private final int COMBOBOXFILE_WIDTH = 200;
	
	/** The comboboxfile height. */
	private final int COMBOBOXFILE_HEIGHT = 30;
	
	/** The btnadd width. */
	private final int BTNADD_WIDTH = 100;
	
	/** The btnadd height. */
	private final int BTNADD_HEIGHT = 20;
	
	/** The valid width. */
	private final int VALID_WIDTH = 100;
	
	/** The valid height. */
	private final int VALID_HEIGHT = 20;
	
	/** The btnremove width. */
	private final int BTNREMOVE_WIDTH = 100;
	
	/** The btnremove height. */
	private final int BTNREMOVE_HEIGHT = 20;
	
	/** The filelabel width. */
	private final int FILELABEL_WIDTH = 200;
	
	/** The filelabel height. */
	private final int FILELABEL_HEIGHT = 20;
	
	/** The btnreturn height. */
	private final int BTNRETURN_HEIGHT = 20;
	
	/** The btnexecutejar width. */
	private final int BTNEXECUTEJAR_WIDTH = 150;
	
	/** The btnexecutejar height. */
	private final int BTNEXECUTEJAR_HEIGHT = 20;

	/** The textarea width. */
	private final int TEXTAREA_WIDTH = 500;
	
	/** The textarea height. */
	private final int TEXTAREA_HEIGHT = 100;
	
	/**
		 * Constructor Menu.
		 * <p>
		 * The menu constructor is initializing the UI by placing all the elements and giving them their 
		 * action command.
		 * </p>
		 * 
		 * @param frame
		 *            The mainview where it will be displayed on.
		 * @see MainView
	 */
	public Menu(MainView frame) {

		this.frame = frame;
		setBackground(Color.LIGHT_GRAY);
		this.setLayout(null);
        this.setVisible(true);
		setLayout(null);
		setSize(640, 480);


		JButton btnExecuteJarFile = new JButton("Execute Jar file");
		btnExecuteJarFile.setBounds((int)(frame.getWidth() * 0.1), (int)(frame.getHeight() * 0.9),BTNEXECUTEJAR_WIDTH, BTNEXECUTEJAR_HEIGHT);
		btnExecuteJarFile.addActionListener(this);
		btnExecuteJarFile.setActionCommand("ExecuteJar");
		add(btnExecuteJarFile);

		JButton btnSaveSession = new JButton("Save session");
		btnSaveSession.setBounds(btnExecuteJarFile.getX() + btnExecuteJarFile.getWidth() + 20, btnExecuteJarFile.getY(),BTNEXECUTEJAR_WIDTH, BTNEXECUTEJAR_HEIGHT);
		btnSaveSession.addActionListener(this);
		btnSaveSession.setActionCommand("saveSession");
		add(btnSaveSession);		
		
		JButton btnLoadSession = new JButton("Load Session");
		btnLoadSession.setBounds(btnSaveSession.getX() + btnSaveSession.getWidth() + 20, btnExecuteJarFile.getY(),BTNEXECUTEJAR_WIDTH, BTNEXECUTEJAR_HEIGHT);
		btnLoadSession.addActionListener(this);
		btnLoadSession.setActionCommand("loadSession");
		add(btnLoadSession);
		
		JButton btnGetLoad = new JButton("Get Log");
		btnGetLoad.setBounds(btnLoadSession.getX() + btnLoadSession.getWidth() + 20, btnExecuteJarFile.getY(),BTNEXECUTEJAR_WIDTH, BTNEXECUTEJAR_HEIGHT);
		btnGetLoad.addActionListener(this);
		btnGetLoad.setActionCommand("getlog");
		add(btnGetLoad);
		
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(frame.getWidth() / 10, frame.getHeight() / 10,BTNADD_WIDTH, BTNADD_HEIGHT);
		btnAdd.addActionListener(this);
		btnAdd.setActionCommand("AddInput");
		add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(btnAdd.getX() + btnAdd.getWidth() + 10, btnAdd.getY(),BTNREMOVE_WIDTH, BTNREMOVE_HEIGHT);
		btnRemove.addActionListener(this);
		btnRemove.setActionCommand("RemoveInput");
		add(btnRemove);
		
		
		JLabel fileLabel = new JLabel("Current input Files selected : ");
		fileLabel.setBounds(btnAdd.getX(), btnAdd.getY() + BTNADD_HEIGHT * 2 , FILELABEL_WIDTH, FILELABEL_HEIGHT);
		add(fileLabel);
		

		textAreaInput = new JTextArea();
		textAreaInput.setEditable(false);
		JScrollPane scrollpane = new JScrollPane(textAreaInput);
		scrollpane.setBounds(fileLabel.getX() , fileLabel.getY() + FILELABEL_HEIGHT , TEXTAREA_WIDTH / 2, TEXTAREA_HEIGHT);
		add(scrollpane);
		
		
		JButton btnAddOutput = new JButton("Add");
		btnAddOutput.setBounds(scrollpane.getX() + TEXTAREA_WIDTH / 2 + 20 , frame.getHeight() / 10,BTNADD_WIDTH, BTNADD_HEIGHT);
		btnAddOutput.addActionListener(this);
		btnAddOutput.setActionCommand("AddOutput");
		add(btnAddOutput);
		
		JButton btnRemoveOutput = new JButton("Remove");
		btnRemoveOutput.setBounds(btnAddOutput.getX() + btnAddOutput.getWidth() + 10, btnAddOutput.getY(),BTNREMOVE_WIDTH, BTNREMOVE_HEIGHT);
		btnRemoveOutput.addActionListener(this);
		btnRemoveOutput.setActionCommand("RemoveOutput");
		add(btnRemoveOutput);
		
		
		JLabel fileLabelOutput = new JLabel("Current output Files selected : ");
		fileLabelOutput.setBounds(btnAddOutput.getX(), btnAddOutput.getY() + BTNADD_HEIGHT * 2 , FILELABEL_WIDTH, FILELABEL_HEIGHT);
		add(fileLabelOutput);
		
		textAreaOutput = new JTextArea();
		textAreaOutput.setEditable(false);
		JScrollPane scrollpaneOutput = new JScrollPane(textAreaOutput);
		scrollpaneOutput.setBounds(fileLabelOutput.getX() , fileLabelOutput.getY() + FILELABEL_HEIGHT , TEXTAREA_WIDTH / 2, TEXTAREA_HEIGHT);
		add(scrollpaneOutput);
		
		
		JButton btnAddJar = new JButton("Jar file");
		btnAddJar.setBounds(frame.getWidth() / 10, scrollpaneOutput.getY() + scrollpaneOutput.getHeight() + 20,BTNADD_WIDTH, BTNADD_HEIGHT);
		btnAddJar.addActionListener(this);
		btnAddJar.setActionCommand("AddJar");
		add(btnAddJar);
	
		
		JLabel fileLabelJar = new JLabel("Current jar file selected : ");
		fileLabelJar.setBounds(btnAddJar.getX(), btnAddJar.getY() + BTNADD_HEIGHT , FILELABEL_WIDTH, FILELABEL_HEIGHT);
		add(fileLabelJar);
		
		jarText = new JTextField();
		jarText.setBounds(fileLabelJar.getX() , fileLabelJar.getY() + FILELABEL_HEIGHT , FILELABEL_WIDTH , FILELABEL_HEIGHT);
		add(jarText);
		
		
		JButton btnAddReverseJar = new JButton("Reverse Jar file");
		btnAddReverseJar.setBounds(btnAddOutput.getX(), btnAddJar.getY(),(int)(BTNADD_WIDTH * 1.5), BTNADD_HEIGHT);
		btnAddReverseJar.addActionListener(this);
		btnAddReverseJar.setActionCommand("AddReverseJar");
		add(btnAddReverseJar);
	
		JLabel fileLabelArguments = new JLabel("Write down any additional args : ");
		fileLabelArguments.setBounds(scrollpaneOutput.getX() + scrollpaneOutput.getWidth() + 5, scrollpaneOutput.getY() - FILELABEL_HEIGHT , FILELABEL_WIDTH, FILELABEL_HEIGHT);
		add(fileLabelArguments);
		
		additionalArguments = new JTextField();
		additionalArguments.setBounds(fileLabelArguments.getX() , fileLabelArguments.getY() + FILELABEL_HEIGHT , FILELABEL_WIDTH , FILELABEL_HEIGHT);
		add(additionalArguments);
		
		JButton btnAddInfo = new JButton("Give information");
		btnAddInfo.setBounds(additionalArguments.getX(), additionalArguments.getY() + additionalArguments.getHeight() + 20,additionalArguments.getWidth(), BTNRETURN_HEIGHT);
		btnAddInfo.addActionListener(this);
		btnAddInfo.setActionCommand("addInformation");
		add(btnAddInfo);
		
		
		JLabel fileLabelReverseJar = new JLabel("Current reverse jar file selected : ");
		fileLabelReverseJar.setBounds(btnAddReverseJar.getX(), btnAddReverseJar.getY() + BTNADD_HEIGHT , FILELABEL_WIDTH, FILELABEL_HEIGHT);
		add(fileLabelReverseJar);
		
		reverseJarText = new JTextField();
		reverseJarText.setBounds(fileLabelReverseJar.getX() , fileLabelReverseJar.getY() + FILELABEL_HEIGHT , FILELABEL_WIDTH , FILELABEL_HEIGHT);
		add(reverseJarText);
		
		
		JLabel commandLabel = new JLabel("Current execution done : ");
		commandLabel.setBounds((int)(frame.getWidth() * 0.61), btnAdd.getY() + BTNADD_HEIGHT * 2 , FILELABEL_WIDTH, FILELABEL_HEIGHT);
		add(commandLabel);
		

		textAreaCommandDone = new JTextArea();
		textAreaCommandDone.setEditable(false);
		JScrollPane scrollpaneCommand = new JScrollPane(textAreaCommandDone);
		scrollpaneCommand.setBounds(commandLabel.getX() , commandLabel.getY() + FILELABEL_HEIGHT , TEXTAREA_WIDTH, TEXTAREA_HEIGHT);
		add(scrollpaneCommand);
		
		JButton btnRedoAll = new JButton("Redo all execution");
		btnRedoAll.setBounds(commandLabel.getX(), scrollpaneCommand.getY() + scrollpaneCommand.getHeight() + 20,TEXTAREA_WIDTH / 3 - 10, BTNRETURN_HEIGHT);
		btnRedoAll.addActionListener(this);
		btnRedoAll.setActionCommand("redoAll");
		add(btnRedoAll);
		
		JButton btnRedoSpecific = new JButton("Redo specific execution");
		btnRedoSpecific.setBounds(btnRedoAll.getX() + btnRedoAll.getWidth() + 10, btnRedoAll.getY(),TEXTAREA_WIDTH / 3 + 5, BTNRETURN_HEIGHT);
		btnRedoSpecific.addActionListener(this);
		btnRedoSpecific.setActionCommand("redoSpecific");
		add(btnRedoSpecific);
		
		JButton btnRedoFromTo = new JButton("Redo from-to");
		btnRedoFromTo.setBounds(btnRedoSpecific.getX() + btnRedoSpecific.getWidth() + 10, btnRedoSpecific.getY(),TEXTAREA_WIDTH / 3 - 15, BTNRETURN_HEIGHT);
		btnRedoFromTo.addActionListener(this);
		btnRedoFromTo.setActionCommand("redoFromTo");
		add(btnRedoFromTo);
		
		JButton btnReverseAll = new JButton("Reverse all execution");
		btnReverseAll.setBounds(btnRedoAll.getX(), btnRedoAll.getY() + btnRedoAll.getHeight() + 15,TEXTAREA_WIDTH / 3 - 10, BTNRETURN_HEIGHT);
		btnReverseAll.addActionListener(this);
		btnReverseAll.setActionCommand("reverseAll");
		add(btnReverseAll);
		
		
		JButton btnReverseSpecific = new JButton("Reverse specific execution");
		btnReverseSpecific.setBounds(btnReverseAll.getX() + btnReverseAll.getWidth() + 10, btnReverseAll.getY(),TEXTAREA_WIDTH / 3 + 5, BTNRETURN_HEIGHT);
		btnReverseSpecific.addActionListener(this);
		btnReverseSpecific.setActionCommand("reverseSpecific");
		add(btnReverseSpecific);
		
		setVisible(true);
	}


	/** 
	 	* Action handler.
	 	* <p>
	 	* This method will be triggered everytime an action is performed, depending on the action the software will 
	 	* react differently.
	 	* </p>
	 	* 
	 	* @param e
	 	*            The action that has been performed.
	 	* @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 **/
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if(cmd.equals("AddInput")){ 
			String filePath = Tools.selectFile();
			inputOutputFileHandling(inputFile, textAreaInput, filePath, true, true);
		}	
		else if(cmd.equals("RemoveInput")){ 
			inputOutputFileHandling(inputFile, textAreaInput, null, false, true);
		}
		else if(cmd.equals("AddOutput")){ 
			String filePath = Tools.selectFile();
			inputOutputFileHandling(outputFile, textAreaOutput, filePath, true, false);
		}	
		else if(cmd.equals("RemoveOutput")){ 
			inputOutputFileHandling(outputFile, textAreaOutput, null, false, false);
		}
		else if(cmd.equals("AddJar")){
			jarText.setText("");
			jarFile = "";
			String filePath = Tools.selectFile();
			if(filePath != null){
				jarText.setText(Tools.getNameOfTheFile(filePath) + "\n");
				jarFile = filePath;
			}
		}
		else if(cmd.equals("AddReverseJar")){
			reverseJarText.setText("");
			reverseJarFile = "";
			String filePath = Tools.selectFile();
			if(filePath != null){
				reverseJarText.setText(Tools.getNameOfTheFile(filePath) + "\n");
				reverseJarFile = filePath;
			}
		}		
		else if(cmd.equals("ExecuteJar")){
			if(jarFile != null){
				if(!additionalArguments.getText().isEmpty()){
					
					String[] tmp = additionalArguments.getText().split(",");
					for(int x = 0 ;x < tmp.length ; x++){
						args.add(tmp[x]);
					}
					
					if(reverseJarFile != null){
						if(!reverseInfo.isEmpty()){
							executeJar(this,jarFile,reverseJarFile, reverseInfo, inputFile, outputFile,args, commandDone,details, textAreaCommandDone,true);
						}
						else{
							executeJar(this,jarFile,reverseJarFile, null, inputFile, outputFile,args, commandDone,details, textAreaCommandDone,true);
						}
					}
					else{
						executeJar(this,jarFile,null, null, inputFile, outputFile,args, commandDone,details, textAreaCommandDone,true);
					}
				}
				else{
					if(reverseJarFile != null){
						if(!reverseInfo.isEmpty()){
							executeJar(this,jarFile,reverseJarFile, reverseInfo, inputFile, outputFile,null, commandDone,details, textAreaCommandDone,true);
						}
						else{
							executeJar(this,jarFile,reverseJarFile, null, inputFile, outputFile,null, commandDone,details, textAreaCommandDone,true);
						}
					}
					else{
						executeJar(this,jarFile,null, null, inputFile, outputFile,null, commandDone,details, textAreaCommandDone,true);				
					}
				}
			}
		}	
		else if(cmd.equals("redoAll")){ 
			for(int x = 0 ; x < commandDone.size(); x++){
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				commandDone.get(x).execute(commandDone, textAreaCommandDone, false);
			}
		}
		else if(cmd.equals("redoSpecific")){
			openMenu();
			JScrollPane scrollpaneCommand = new JScrollPane(textAreaCommandDone);
			scrollpaneCommand.setBounds(menu.getWidth() / 2 - TEXTAREA_WIDTH / 2 , menu.getHeight() / 2 - (int)(TEXTAREA_HEIGHT * 0.9) , TEXTAREA_WIDTH , TEXTAREA_HEIGHT);
			menu.getContentPane().add(scrollpaneCommand);
			
			JLabel fileLabelJar = new JLabel("Write the execution you want to redo separated by spaces : ");
			fileLabelJar.setBounds(scrollpaneCommand.getX(), scrollpaneCommand.getY() + scrollpaneCommand.getHeight() + 20 , FILELABEL_WIDTH * 2, FILELABEL_HEIGHT);
			menu.getContentPane().add(fileLabelJar);
			
			redoString = new JTextField();
			redoString.setBounds(fileLabelJar.getX() , fileLabelJar.getY() + FILELABEL_HEIGHT , FILELABEL_WIDTH * 2 , FILELABEL_HEIGHT);
			menu.getContentPane().add(redoString);
			
			JButton homeButton = new JButton("Valid");
			homeButton.setBounds((int)(menu.getWidth() * 0.5) - VALID_WIDTH / 2 , (int)(menu.getHeight() * 0.83) - VALID_HEIGHT, VALID_WIDTH , VALID_HEIGHT );
			homeButton.addActionListener(new ActionListener( ) {
			      public void actionPerformed( ActionEvent e ){
			    	  String[] tmp = redoString.getText().split(" ");
			    	  for(int x = 0 ; x < tmp.length ; x++){
			    		  commandDone.get(Integer.parseInt(tmp[x])-1).execute(commandDone, textAreaCommandDone, false);
			    	  }
			    	  menu.dispose();
			      }
			    });
			menu.getContentPane().add(homeButton);
			
			menu.setVisible(true);
		}	
		else if(cmd.equals("redoFromTo")){ 
			openMenu();
			JScrollPane scrollpaneCommand = new JScrollPane(textAreaCommandDone);
			scrollpaneCommand.setBounds(menu.getWidth() / 2 - TEXTAREA_WIDTH / 2 , menu.getHeight() / 2 - (int)(TEXTAREA_HEIGHT * 0.9) , TEXTAREA_WIDTH , TEXTAREA_HEIGHT);
			menu.getContentPane().add(scrollpaneCommand);
			
			JLabel firstLabelJar = new JLabel("First : ");
			firstLabelJar.setBounds(scrollpaneCommand.getX(), scrollpaneCommand.getY() + scrollpaneCommand.getHeight() + 20 , FILELABEL_WIDTH / 2, FILELABEL_HEIGHT);
			menu.getContentPane().add(firstLabelJar);
			
			JLabel lastLabelJar = new JLabel("Last : ");
			lastLabelJar.setBounds(scrollpaneCommand.getX() + firstLabelJar.getWidth() + 20, scrollpaneCommand.getY() + scrollpaneCommand.getHeight() + 20 , FILELABEL_WIDTH / 2, FILELABEL_HEIGHT);
			menu.getContentPane().add(lastLabelJar);
			
			firstString = new JTextField();
			firstString.setBounds(firstLabelJar.getX() , firstLabelJar.getY() + FILELABEL_HEIGHT , FILELABEL_WIDTH / 2 , FILELABEL_HEIGHT);
			menu.getContentPane().add(firstString);
			
			lastString = new JTextField();
			lastString.setBounds(lastLabelJar.getX() , lastLabelJar.getY() + FILELABEL_HEIGHT , FILELABEL_WIDTH / 2 , FILELABEL_HEIGHT);
			menu.getContentPane().add(lastString);
			
			JButton homeButton = new JButton("Valid");
			homeButton.setBounds((int)(menu.getWidth() * 0.5) - VALID_WIDTH / 2 , (int)(menu.getHeight() * 0.83) - VALID_HEIGHT, VALID_WIDTH , VALID_HEIGHT );
			homeButton.addActionListener(new ActionListener( ) {
			      public void actionPerformed( ActionEvent e ){
			    	  if(Integer.parseInt(firstString.getText()) - 1 < 0 || Integer.parseInt(lastString.getText()) > commandDone.size() || Integer.parseInt(lastString.getText()) < Integer.parseInt(firstString.getText())){
			    		  System.out.println("Invalid values");
			    	  }
			    	  else{
				    	  for(int x =  Integer.parseInt(firstString.getText()) - 1; x < Integer.parseInt(lastString.getText()) - 1; x++){
								commandDone.get(x).execute(commandDone, textAreaCommandDone, false);
				    	  }
				    	  menu.dispose();
			    	  }
			      }
			    });
			menu.getContentPane().add(homeButton);
			
			menu.setVisible(true);
		}
		else if(cmd.equals("addInformation")){
			openMenu();			
			
			JLabel inputLines = new JLabel("x lines in input results in x lines in output ");
			inputLines.setBounds((int)(menu.getWidth() * 0.4) - FILELABEL_WIDTH / 4, (int)(menu.getHeight() * 0.4) - FILELABEL_HEIGHT, FILELABEL_WIDTH * 2, FILELABEL_HEIGHT);
			menu.getContentPane().add(inputLines);
			
			JTextArea detail = new JTextArea();
			detail.setEditable(true);
			JScrollPane scrollpaneCommand = new JScrollPane(detail);
			scrollpaneCommand.setBounds(inputLines.getX() - TEXTAREA_WIDTH / 4, inputLines.getY() - FILELABEL_HEIGHT - TEXTAREA_HEIGHT, TEXTAREA_WIDTH, TEXTAREA_HEIGHT);
			menu.getContentPane().add(scrollpaneCommand);		

			JLabel commentJarFileLabel = new JLabel("Write any comment on the execution :");
			commentJarFileLabel.setBounds(scrollpaneCommand.getX() , scrollpaneCommand.getY() - FILELABEL_HEIGHT, FILELABEL_WIDTH * 2, FILELABEL_HEIGHT);
			menu.getContentPane().add(commentJarFileLabel);
			
			JLabel reverseJarFileLabel = new JLabel("Select a default reverse jar or one of yours");
			reverseJarFileLabel.setBounds((int)(menu.getWidth() * 0.4) - FILELABEL_WIDTH / 4, (int)(menu.getHeight() * 0.57) - FILELABEL_HEIGHT, FILELABEL_WIDTH * 2, FILELABEL_HEIGHT);
			menu.getContentPane().add(reverseJarFileLabel);
			
			JButton btnAddReverseJar = new JButton("Reverse Jar file");
			btnAddReverseJar.setBounds((int)(menu.getWidth() * 0.5) - (int)(BTNADD_WIDTH * 1.5) / 2, (int)(menu.getHeight() * 0.7) -  BTNADD_HEIGHT / 2,(int)(BTNADD_WIDTH * 1.5), BTNADD_HEIGHT);
			btnAddReverseJar.addActionListener(this);
			btnAddReverseJar.setActionCommand("AddReverseJar");
			menu.getContentPane().add(btnAddReverseJar);
			
			
			String [] input = new String[]{"","1","many","all"};
			JComboBox<String> comboBoxInput = new JComboBox<String>(input);
			comboBoxInput.setBounds(inputLines.getX() , inputLines.getY() + inputLines.getHeight(),COMBOBOXFILE_WIDTH / 2,COMBOBOXFILE_HEIGHT);
			comboBoxInput.addActionListener(new ActionListener( ) {
			      public void actionPerformed( ActionEvent e ){
						JComboBox<String> choice = (JComboBox<String>)e.getSource();
						indexInputLines = choice.getSelectedIndex();
			      }
			    });
			menu.getContentPane().add(comboBoxInput);
			
			String [] output = new String[]{"","1","many","all"};
			JComboBox<String> comboBoxOutput = new JComboBox<String>(output);
			comboBoxOutput.setBounds(comboBoxInput.getX() + comboBoxInput.getWidth() + 20 , comboBoxInput.getY(),COMBOBOXFILE_WIDTH / 2,COMBOBOXFILE_HEIGHT);
			comboBoxOutput.addActionListener(new ActionListener( ) {
			      public void actionPerformed( ActionEvent e ){
						JComboBox<String> choice = (JComboBox<String>)e.getSource();
						indexOutputLines = choice.getSelectedIndex();
			      }
			    });
			menu.getContentPane().add(comboBoxOutput);
			
			JButton homeButton = new JButton("Valid");
			homeButton.setBounds((int)(menu.getWidth() * 0.5) - VALID_WIDTH / 2 , (int)(menu.getHeight() * 0.83) - VALID_HEIGHT, VALID_WIDTH , VALID_HEIGHT );
			homeButton.addActionListener(new ActionListener( ) {
			      public void actionPerformed( ActionEvent e ){
			    	  if(detail.getText() != ""){
			    		  details = detail.getText();
			    	  }
			    	  
			    	  if(indexOutputLines == 0 || indexInputLines == 0){
				    	  reverseInfo.add(input[indexInputLines]);
				    	  reverseInfo.add(input[indexOutputLines]);
				    	  menu.dispose();
			    	  }
			    	  else{
			    		  if(reverseJarFile == null){
			    			  
			    		  }
			    		  else{
					    	  reverseInfo.add(input[indexInputLines]);
					    	  reverseInfo.add(input[indexOutputLines]);
					    	  menu.dispose();
			    		  }
			    	  }
			      }
			    });
			menu.getContentPane().add(homeButton);
			menu.setVisible(true);
		}
		else if(cmd.equals("saveSession")){
			String filePath = Tools.selectFile();
			Tools.serializeExecution(commandDone, filePath);
		}
		else if(cmd.equals("loadSession")){
			String filePath = Tools.selectFile();
			commandDone = Tools.deserializeExecution(filePath);
			reset();
			for(int x = 0 ; x < commandDone.size() ; x++){
				commandCpt++;
				textAreaCommandDone.append(commandCpt + ")" + commandDone.get(x) + "\n");
			}
		}
		else if(cmd.equals("getlog")){
			String filepath = Tools.selectFile();
			BufferedWriter fichier;
			try{
				fichier = new BufferedWriter(new FileWriter(filepath));
				for(int x = 0 ; x < commandDone.size() ; x++){
					System.out.println(commandDone.get(x).toStringDetailed() + " lol ");
					fichier.write(commandDone.get(x).toStringDetailed());
					fichier.newLine();
				}
				fichier.close();
			}catch (Exception p) {
				p.printStackTrace();
			}
			
		}
		else if(cmd.equals("reverseAll")){
			for(int x = 0 ; x < commandDone.size() ; x++){
				commandDone.get(x).traceback(commandDone, textAreaCommandDone, false);
			}
		}	
		else if(cmd.equals("reverseSpecific")){
			openMenu();
			JScrollPane scrollpaneCommand = new JScrollPane(textAreaCommandDone);
			scrollpaneCommand.setBounds(menu.getWidth() / 2 - TEXTAREA_WIDTH / 2 , menu.getHeight() / 2 - (int)(TEXTAREA_HEIGHT * 0.9) , TEXTAREA_WIDTH , TEXTAREA_HEIGHT);
			menu.getContentPane().add(scrollpaneCommand);
			
			JLabel fileLabelJar = new JLabel("Select the execution you want to reverse : ");
			fileLabelJar.setBounds((int)(menu.getWidth() * 0.5) - FILELABEL_WIDTH / 2, scrollpaneCommand.getY() + scrollpaneCommand.getHeight() + 20 , FILELABEL_WIDTH * 2, FILELABEL_HEIGHT);
			menu.getContentPane().add(fileLabelJar);

			String [] choices = new String[commandCpt];
			for(int x = 1 ; x <= commandCpt ; x++){
				choices[x-1] = x + "";
			}
			JComboBox<String> comboBoxchoices = new JComboBox<String>(choices);
			comboBoxchoices.setBounds((int)(menu.getWidth() * 0.5) - COMBOBOXFILE_WIDTH / 2 / 2 , fileLabelJar.getY() + fileLabelJar.getHeight() + 20,COMBOBOXFILE_WIDTH / 2,COMBOBOXFILE_HEIGHT);
			comboBoxchoices.addActionListener(new ActionListener( ) {
			      public void actionPerformed( ActionEvent e ){
						JComboBox<String> choice = (JComboBox<String>)e.getSource();
						indexOutputLines = choice.getSelectedIndex();
			      }
			    });
			menu.getContentPane().add(comboBoxchoices);
		
			
			JButton homeButton = new JButton("Valid");
			homeButton.setBounds((int)(menu.getWidth() * 0.5) - VALID_WIDTH / 2 , (int)(menu.getHeight() * 0.83) - VALID_HEIGHT, VALID_WIDTH , VALID_HEIGHT );
			homeButton.addActionListener(new ActionListener( ) {
			      public void actionPerformed( ActionEvent e ){
			    	  String[] tmp = redoString.getText().split(" ");
			    	  for(int x = 0 ; x < tmp.length ; x++){
			    		  commandDone.get(Integer.parseInt(tmp[x])-1).execute(commandDone, textAreaCommandDone, false);
			    	  }
			    	  menu.dispose();
			      }
			    });
			menu.getContentPane().add(homeButton);
			
			menu.setVisible(true);
		}	
	}
	
	
	/**
		 * Execute jar.
		 * <p>
		 * This method will execute a given jar with all the parameters, it will also depending on the record boolean display
		 * the execution details and create an execution object with all the parameters and save it into the commandDone arrayList. 
		 * </p>
		 * 
		 * @param menu
		 *            The menu where the information will be displayed on.
		 * @param jarFile
		 *            The jarFile that will be executed.
		 * @param reverseJarFile
		 *            The reverse JarFile of the execution.
		 * @param reverseInfo
		 *            The information about the action of the computation.
		 * @param inputFile
		 *            The input files for the execution.
		 * @param outputFile
		 *            The output files for the execution.
		 * @param args
		 *            The additional arguments for the execution.
		 * @param commandDone
		 *            The arraylist where the execution should be saved in.
		 * @param details
		 *            The details for the execution.
		 * @param textAreaCommandDone
		 *            The Text area where the execution will be displayed on.
		 * @param record
		 *            Whether the execution should be saved and displayed or not.
		 *            
		 * @see Execution
	 */
	public static void executeJar(Menu menu,String jarFile,String reverseJarFile,ArrayList<String> reverseInfo,ArrayList<String> inputFile,ArrayList<String> outputFile,ArrayList<String> args, ArrayList<Execution> commandDone,String details, JTextArea textAreaCommandDone, boolean record){
		if(!(jarFile == "")){
			ArrayList<String> command = new ArrayList<String>();
			command.add("java");
			command.add("-jar");
			command.add(Tools.getNameOfTheFile(jarFile));
			for(int x = 0 ; x < inputFile.size() ; x++){
				command.add(inputFile.get(x));
			}
			for(int x = 0 ; x < outputFile.size() ; x++){
				command.add(outputFile.get(x));
			}
			if(args != null){
				for(int x = 0 ; x < args.size() ; x++){
					command.add(args.get(x));
				}
			}
			System.out.println(jarFile + "   " + (jarFile.length() - Tools.getNameOfTheFile(jarFile).length() - 1));
			String directory = jarFile.substring(0, jarFile.length() - Tools.getNameOfTheFile(jarFile).length() - 1);
			ProcessBuilder pb = new ProcessBuilder(command);
			pb.directory(new File(directory));
			try{
				Process p = pb.start();
				
				Execution tmp = null;
				if(args != null){
					if(reverseJarFile != null){
						if(reverseInfo != null){
							tmp = new Execution(command,inputFile,outputFile,args,jarFile,reverseJarFile,reverseInfo);
						}
						else{
							tmp = new Execution(command,inputFile,outputFile,args,jarFile,reverseJarFile);
						}
					}
					else{
						tmp = new Execution(command,inputFile,outputFile,args,jarFile);
					}
				}
				else{
					if(reverseJarFile != null){
						if(reverseInfo != null){
							tmp = new Execution(command,inputFile,outputFile,jarFile,reverseJarFile,reverseInfo);
						}
						else{
							tmp = new Execution(command,inputFile,outputFile,jarFile,reverseJarFile);
						}
					}
					else{
						tmp = new Execution(command,inputFile,outputFile,jarFile);					
					}
				}
				if(details != ""){
					tmp.setDetails(details);
				}
				System.out.println(tmp);
				commandCpt++;
				if(record){
					commandDone.add(tmp);
					textAreaCommandDone.append(commandCpt + ") " + tmp.toString() + "\n");
				}
				
				if(menu != null){
					menu.reset();
				}
			}
			catch(IOException e1) {
				e1.printStackTrace();
			}
		}
		else{
			System.out.println("No jar file selected");
		}
	}
	
	
	/**
		 * inputOutputFileHandling.
		 * <p>
		 * This method will handle when the user wants to add or remove an input or output file for the execution.
		 * </p>
		 * 
		 * @param file
		 *            The arraylist where the file should be saved in or remove from.
		 * @param textArea
		 *            The text area where the file should be written in or erase from.
		 * @param filePath
		 *            The path of the file.
		 * @param add
		 *            Whether it should add or remove the given file.
		 * @param input
		 *            Whether it is an input or output file.
	 */
	public void inputOutputFileHandling(ArrayList<String> file, JTextArea textArea,String filePath,boolean add,boolean input){
		if(add){
			if(filePath != null){
				textArea.append(Tools.getNameOfTheFile(filePath) + "\n");
			}
			file.add(filePath);
		}
		else{
			if(file.size() != 0){
				openMenu();
	
				JButton homeButton = new JButton("Valid");
				homeButton.setBounds((int)(menu.getWidth() * 0.5) - VALID_WIDTH / 2 , (int)(menu.getHeight() * 0.9) - VALID_HEIGHT, VALID_WIDTH , VALID_HEIGHT );
				homeButton.addActionListener(new ActionListener( ) {
				      public void actionPerformed( ActionEvent e ){
							if(input){
								String tmp = textAreaInput.getText();
								int begin = tmp.indexOf("\n" + Tools.getNameOfTheFile(inputFile.get(removeIndex))) + 1;
								tmp = tmp.substring(begin);
								int end = tmp.indexOf("\n") + begin + 1;
								textAreaInput.replaceRange("", begin, end);
								inputFile.remove(removeIndex);
								menu.dispose();
							}
							else{
								String tmp = textAreaOutput.getText();
								int begin = tmp.indexOf("\n" + Tools.getNameOfTheFile(outputFile.get(removeIndex))) + 1;
								tmp = tmp.substring(begin);
								int end = tmp.indexOf("\n") + begin + 1;
								textAreaOutput.replaceRange("", begin, end);
								outputFile.remove(removeIndex);
								removeIndex = 0;
								menu.dispose();
							}
				      }
				    });
				menu.getContentPane().add(homeButton);
				
				String [] files = new String[file.size()];
				for(int x = 0 ; x < file.size(); x++){
					files[x] = Tools.getNameOfTheFile(file.get(x));
				}
				JComboBox<String> comboBoxFiles = new JComboBox<String>(files);
				comboBoxFiles.setBounds((int)(menu.getWidth() * 0.5) - COMBOBOXFILE_WIDTH / 2 , (int)(menu.getHeight() * 0.5) - COMBOBOXFILE_HEIGHT * 2,COMBOBOXFILE_WIDTH,COMBOBOXFILE_HEIGHT);
				comboBoxFiles.addActionListener(new ActionListener( ) {
				      public void actionPerformed( ActionEvent e ){
							JComboBox<String> choice = (JComboBox<String>)e.getSource();
							removeIndex = choice.getSelectedIndex();
				      }
				    });
				menu.getContentPane().add(comboBoxFiles);
				
				menu.setVisible(true);
			}
			else{
				System.out.println("No files");
			}
		}		
	}
	
	
	/**
		 * Open Menu.
		 * <p>
		 * This method will open a dialog box in which the program will be able to add things to interact with the user.
		 * </p>
		 * 
	 */
	public void openMenu(){
		menu = new JDialog(frame,"Remove",true);
		menu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		menu.setSize(frame.getWidth() / 2, frame.getHeight() / 2);
		menu.setLocation(frame.getWidth() / 2 - menu.getWidth() / 2, frame.getHeight() / 2 - menu.getHeight() / 2);
		menu.setLayout(null);
		
		JPanel panelDisplay = new JPanel();
		menu.getContentPane().add(panelDisplay);
		menu.getContentPane().setBackground(Color.LIGHT_GRAY);
	}
	
	/**
		 * Reset.
		 * <p>
		 * This method will be called after every execution and it will reset all the variable of the session, to allow
		 * the user to do a new execution.
		 * </p>
		 * 
	 */
	public void reset(){
		removeIndex = 0;
		indexInputLines = 0;
		indexOutputLines = 0;
		
		jarText.setText("");
		reverseJarText.setText("");
		additionalArguments.setText("");
		if(redoString != null){
			redoString.setText("");
		}
		if(firstString != null){
			firstString.setText("");
		}
		if(lastString != null){
			lastString.setText("");
		}
		textAreaInput.setText("");
		textAreaOutput.setText("");
		
		
		inputFile = new ArrayList<String>();
		outputFile = new ArrayList<String>();
		args = new ArrayList<String>();
		reverseInfo = new ArrayList<String>();
		jarFile = null;
		reverseJarFile = null;
		details = new String();
	}
	
}
