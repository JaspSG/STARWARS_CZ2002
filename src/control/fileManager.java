package control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entity.Student;

public class fileManager {
	
	//STUDENT OBJECTS READER
	
	public void saveFile(String filename, ArrayList<Student> listOfStudent) throws Exception {
		
		String outputfilepath = String.format("src\\\\%s.ser", filename);
		
	    FileOutputStream fileOut =
	    new FileOutputStream("outputfilepath");
	    ObjectOutputStream out = new ObjectOutputStream(fileOut);
	    out.writeObject(listOfStudent);
	    out.close();
	    fileOut.close();
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Student> loadFile(String filename) {
		
		String filepath = String.format("src\\\\%s.ser", filename);
		ArrayList<Student> value = new ArrayList<Student>();
		
	      try {
	          FileInputStream fileIn = new FileInputStream(filepath);
	          ObjectInputStream in = new ObjectInputStream(fileIn);
	          value = (ArrayList<Student>) in.readObject();
	          in.close();
	          fileIn.close();
	       } catch (IOException i) {
	          i.printStackTrace();
	       } catch (ClassNotFoundException c) {
	          System.out.println("Student class not found");
	          c.printStackTrace();
	       }
	      
	      return value;
	}
	
	// END OF STUDENT OBJECT READER
	


	
}
