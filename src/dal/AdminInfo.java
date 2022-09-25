package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import dol.Alumno;



public class AdminInfo {
	private AdminInfo AdminInfo;
	private String filePath;
	private String fileName;
	
	public AdminInfo() {
		super();
	}



	public AdminInfo getAdminInfo() {
		return AdminInfo;
	}


	public void setAdminInfo(Alumno alumno) {
		this.AdminInfo = AdminInfo;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	

	public void CargarInformation() {
		
		File archivo = new File ("./datos/info.txt");
		ObjectOutputStream a;
		try {
			a = new ObjectOutputStream(new FileOutputStream(archivo));
		    a.writeObject(getAdminInfo());
		   a.flush();
			FileWriter fw = new FileWriter(archivo, true);
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public Scanner Abrir() {
		 try{
	        	File archivo = new File(filePath);
	            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(archivo));
	            return (Scanner)ois.readObject();
	        }
	        catch(FileNotFoundException e){
	        	e.printStackTrace();
	        } catch (IOException | ClassNotFoundException ex) {
	        	ex.printStackTrace();
	        }
	        return null;
		}
	}

