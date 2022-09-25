package dol;

import java.util.ArrayList;
import dol.Alumno;

public class Proceso {
private ArrayList<Object> a = new ArrayList<Object>();
    
    public Proceso(){}
    
    public Proceso(ArrayList<Object> a){
        this.a = a;
    }
    
    public void agregarRegistro(Alumno a){
        this.a.add(a);
    }

    public void modificarRegistro(int i, Alumno a){
        this.a.set(i, a);
    }
    
    public void eliminarRegistro(int i){
        this.a.remove(i);
    }
    
    public Alumno obtenerRegistro(int i){
        return (Alumno)a.get(i);
    }
    
    public int cantidadRegistro(){
        return this.a.size();
    }
    
    public int buscaNumCodigo(int codigo){
        for(int i = 0; i < cantidadRegistro(); i++){
            if(codigo == obtenerRegistro(i).getNumCodigo()) return i;
        }
        return codigo;
    }
}
