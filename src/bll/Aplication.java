package bll;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


import dol.Alumno;
import misc.DateUtil;
public class Aplication {

	public void lectura() {

		imprimirMenu();
	}
	
	 private static void salir() {
	    	System.out.println("El programa ha finalizado");
	    	System.exit(0);
	    }
	 
	 

	         public  void imprimirMenu() {
	        	 
	   File file=new File ("C:\\TareadeCurso\\src\\INFORMATION.txt");
       int opcion =0;
       List<Alumno>objetivo=obtenerListaDeAlumno (file);
        Scanner sc=new Scanner (System.in);
        	
            System.out.println ("Online University Registration");
            System.out.println ("===============================\n");
            System.out.println ("1-Ingresar un nuevo alumno");
            System.out.println ("2-Listar registro de alumnos");
            System.out.println ("3-Buscar alumno");
            System.out.println ("4-Eliminar alumno");
            System.out.println ("5-Modificar datos de alumno");
            System.out.println ("6-Salir");
            System.out.println ("\nIngresar una opcion\n");
            opcion=sc.nextInt ();

            switch (opcion){
                case 1:
                    System.out.println ("Registro de alumno");
                    System.out.println ("===================\n");
                    System.out.println ("Ingrese los siguientes datos:\n");
                    sc.nextLine ();
                    System.out.println ("Numero de codigo:");
                    String Numcodigo=sc.nextLine ();
                    System.out.println ("Nombre:");
                    String nombre=sc.nextLine ();
                    System.out.println ("Apellido:");
                    String apellido=sc.nextLine ();
                    System.out.println ("Carrera:");
                    String carrera=sc.nextLine ();
                    Date Inscripdate= DateUtil.catchValidDate(sc, "Fecha de incripcion (dd/MM/yyyy):");
                    objetivo.add (new Alumno(Numcodigo, nombre, apellido, carrera,Inscripdate ));
                    guardarListaDeAlumno(file, objetivo);
    
                    break;
                case 2:
                    System.out.println ("Listar datos de alumnos");
                    System.out.println ("=======================\n");
                    System.out.println (FlipTableConverters.fromIterable (objetivo,Alumno.class));
                    break;
                case 3:
                    System.out.println ("Buscar Alumno");
                    System.out.println ("===============\n");
                    System.out.println ("Ingresa el numero de codigo del alumno");
                    String buscado=sc.next ();
                    String mensaje="No se encontro al estudiante\n";
                    Alumno x=null;
                    for (Alumno o:objetivo){
                        if(o.getNumCodigo ().equals (buscado)){
                            mensaje="Alumno encontrad@\n";
                            x=o;
                        }
                    }
                    System.out.println ("\n"+mensaje);
                    String []headers={"Nombre","Apellido","Carrera","Numero de codigo"};
                    if(x!=null){
                        String [][] data={{x.getNombre (),x.getApellido (),String.valueOf (x.getCarrera ()),x.getNumCodigo ()}};
                        System.out.println (FlipTable.of(headers,data));
                    }
                    break;
                case 4:
                    System.out.println ("Eliminar Alumno");
                    System.out.println ("================\n");
                    System.out.println ("Ingrese el numero de codigo del estudiante");
                    String eliminar=sc.next ();
                    String mensaje2="No se encontro al alumno\n";
                    for (int i=0;i< objetivo.size ();i++){

                        if(objetivo.get (i).getNumCodigo().equals (eliminar)){
                            objetivo.remove (i);
                            mensaje2="Alumno eliminad@\n";
                        }
                    }
                    guardarListaDeAlumno (file,objetivo);
                    System.out.println (mensaje2);
                    break;
                case 5:
                    System.out.println ("Modificar Alumno");
                    System.out.println ("=================\n");
                    System.out.println ("Ingrese el numero de codigo del alumno");
                    String modificar=sc.next ();
                    String mensaje3="No se encontro al alumno\n";
                    Alumno alumno=null;
                    for(Alumno o:objetivo){
                        if(o.getNumCodigo ().equals (modificar)){
                            alumno=o;
                            mensaje3="Alumno encontrad@";
                        }
                    }
                    System.out.println (mensaje3);
                    int opcion2=0;
                    if(alumno!=null){
                        do{
                            System.out.println ("1-Modificar nombre");
                            System.out.println ("2-Modificar apellido");
                            System.out.println ("3-Modificar carrera");
                            System.out.println ("4-Modificar numero de codigo");
                            System.out.println ("5-Cancelar");
                            opcion2=sc.nextInt ();
                            switch (opcion2){
                                case 1:
                                    sc.nextLine ();
                                    System.out.println ("Nombre actual: "+alumno.getNombre ());
                                    alumno.setNombre (sc.nextLine ());
                                    break;
                                case 2:
                                    System.out.println ("Apellido actual: "+alumno.getApellido());
                                    alumno.setApellido(sc.nextLine ());
                                    break;
                                case 3:
                                    System.out.println ("Carrera actual: "+alumno.getCarrera());
                                    alumno.setCarrera (sc.nextLine ());
                                    sc.nextLine ();
                                    break;
                                case 4:
                                    System.out.println ("Num Codigo actual: "+alumno.getNumCodigo());
                                    alumno.setNumCodigo (sc.nextLine ());
                                    break;
                                case 5:
                                    System.out.println ("\nOpcion cancelada\n");
                                    guardarListaDeAlumno (file,objetivo);
                                    break;
                                default:
                                    System.out.println ("\nOpcion invalida\n");
                            }
                        }while (opcion2!=5);
                    }
                    break;
                case 6:
                    System.out.println ("Saliendo del programa");
                    break;
                default:
                    System.out.println ("Opcion invalida");
            }


        	
        
       
    
    }

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
		
}
