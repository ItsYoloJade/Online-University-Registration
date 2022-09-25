package ui;

import java.util.Date;
import java.util.Scanner;

import dal.AdminInfo;
import dol.Alumno;
import misc.DateUtil;

public class AlumnoForm {
	Scanner scan;
	Alumno alumno;
	
	public AlumnoForm(Scanner adminInfo) {
		scan = adminInfo;
	}
	
	public  AlumnoForm(Alumno a) {
		alumno = a;
	}
	
	
	public Alumno catchAlumno() {
		Alumno a = new Alumno();
		
		System.out.println("Ingrese el codigo del estudiante: ");
		a.setNumCodigo(scan.nextInt());
		
		System.out.println("Ingrese el nombre: ");
		a.setNombre(scan.next());
		
		System.out.println("Ingrese el apellido: ");
		a.setApellido(scan.next());
		
		System.out.println("Ingrese la carrera: ");
		a.setCarrera(scan.next());
		
		Date date = DateUtil.catchValidDate(scan, "Ingrese la fecha de ingreso: (dd/MM/yyyy): ");
		a.setInscripdate(date);
			
		return a;
	}
	
	public void showAlumno() {
		System.out.printf("Ingrese el codigo del estudiante: %o\n" , alumno.getNumCodigo());		
		
		System.out.printf("Ingrese el nombre: %s\n", alumno.getNombre());
		
		System.out.printf("Ingrese el apellido: %s\n", alumno.getApellido());
		
		System.out.printf("Ingrese la carrera: %s\n", alumno.getCarrera());
		
		System.out.printf("Ingrese la fecha de ingreso: %s\n", DateUtil.dateToString(alumno.getInscripdate(), "dd/MM/yyyy"));

			
	}
}
