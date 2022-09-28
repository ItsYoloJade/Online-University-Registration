package dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dol.Alumno;

public class AdminInfo {
	public static void guardarListaDeAlumno(File file, List<Alumno> lista){

	      try{
	          FileOutputStream ficheroSalida= new FileOutputStream (file);
	          ObjectOutputStream objetoSalida=new ObjectOutputStream (ficheroSalida);
	          objetoSalida.writeObject (lista);
	          objetoSalida.close ();
	      }catch (FileNotFoundException e){
	          System.out.println ("El fichero no existe");
	      } catch(Exception e){
	          System.out.println (e.getMessage ());
	      }

	    }

	    public static List<Alumno>obtenerListaDeAlumno(File file){

	        List<Alumno>lista= new ArrayList<> ();
	        try{
	            FileInputStream fis=new FileInputStream (file);
	            ObjectInputStream ois=new ObjectInputStream (fis);
	            lista=(List<Alumno>)ois.readObject ();
	            ois.close ();
	        }catch(FileNotFoundException e){
	            System.out.println ("Fichero no existe");
	        }catch (Exception e){
	            System.out.println (e.getMessage ());
	        }
	        return lista;
	    }
	    
	    private static void salir() {
	    	System.out.println("El programa ha finalizado");
	    	System.exit(0);
	    }
}
