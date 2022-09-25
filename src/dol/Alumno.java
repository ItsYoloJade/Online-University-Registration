package dol;

import java.util.Date;

public class Alumno {
	    private int NumCodigo;
	    private String Nombre;
	    private String Apellido;
	    private String Carrera; 
	    private Date Inscripdate;
	    
	    
		public Alumno() {
			super();
		}


		public Alumno(int numCodigo, String nombre, String apellido, String carrera, Date inscripdate) {
			super();
			NumCodigo = numCodigo;
			Nombre = nombre;
			Apellido = apellido;
			Carrera = carrera;
			Inscripdate = inscripdate;
		}


		public int getNumCodigo() {
			return NumCodigo;
		}


		public void setNumCodigo(int numCodigo) {
			NumCodigo = numCodigo;
		}


		public String getNombre() {
			return Nombre;
		}


		public void setNombre(String nombre) {
			Nombre = nombre;
		}


		public String getApellido() {
			return Apellido;
		}


		public void setApellido(String apellido) {
			Apellido = apellido;
		}


		public String getCarrera() {
			return Carrera;
		}


		public void setCarrera(String carrera) {
			Carrera = carrera;
		}


		public Date getInscripdate() {
			return Inscripdate;
		}


		public void setInscripdate(Date i) {
			Inscripdate = i;
		}


		@Override
		public String toString() {
			return "Alumno [NumCodigo=" + NumCodigo + ", Nombre=" + Nombre + ", Apellido=" + Apellido + ", Carrera="
					+ Carrera + ", Inscripdate=" + Inscripdate + "]";
		}
	    
	    
}
