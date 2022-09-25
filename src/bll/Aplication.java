package bll;

import java.util.Date;
import java.util.Scanner;

import dol.Alumno;
import main.Principal;
import misc.DateUtil;
import ui.AlumnoForm;

import dal.AdminInfo;


public class Aplication {
	private Scanner scan;
	public Aplication() {
		 scan = new Scanner(System.in);
	}
 Scanner entrada= new Scanner (System.in);
   

	public void imprimirMenu() {
		System.out.println("---------------Online University Registration-----------------");
		System.out.println("1. Registrar estudiante");
		System.out.println("2. Actualizar estudiante");
		System.out.println("3. Mostrar lista de estudiantes");
		System.out.println("4. Eliminar estudiante");
		System.out.println("5. Salir");
		
		System.out.println("---------------------------------------------------------------\n");
		int opcion= entrada.nextInt(); 
		
		switch (opcion) {
		case 1: {
			CargarInformation();
			
			imprimirMenu();
			
			break;
		}
			case 2: {
			ActualizarRegistro();
			imprimirMenu();
				break;
			}
			
			case 3: {
				Abrir();
				imprimirMenu();
			    break;
			}  
			 
			case 4: {
				EliminarInformation();
				imprimirMenu();
				break;
			}
			
			case 5: {
				salir();
			}
		
		default: System.out.println("Ha ingresado una opcion invalida\n");
		imprimirMenu();
			break;
		}
	}
	
	
	public void CargarInformation() {
		AlumnoForm af = new AlumnoForm(scan);
		AdminInfo ad = new AdminInfo();
		ad.setAdminInfo(af.catchAlumno());
		
		
		System.out.println("Por favor indica la ruta para guardar el archivo: ");
		String filePath = scan.next();
		System.out.println("Por favor indica el nombre del archivo: ");
		String fileName = scan.next();
		
		ad.setFilePath(filePath);
		ad.setFileName(fileName);
		ad.CargarInformation();
	}
	
	public void ActualizarRegistro(){
		
	}
	
	public void Abrir() {
		
		System.out.println("Por favor indica la ruta del archivo a abrir");
		String filePath = scan.next();
		AdminInfo ad = new AdminInfo();
		ad.setFilePath(filePath);
		AlumnoForm af = new AlumnoForm(ad.Abrir());
		af.showAlumno();
	}
	
	public void EliminarInformation() {
		
	}
	  private static void salir() {
	    	System.out.println("Gracias por ser parte de nuestro servicio de registro online!");
	    	System.exit(0);
	    }
	        
}
