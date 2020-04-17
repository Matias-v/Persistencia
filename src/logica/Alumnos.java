package logica;
import java.util.ArrayList;
public class Alumnos {
private ArrayList<Alumno> lista;
private int grupo;
    public Alumnos() { // El Constructor por defecto ...
        lista = new ArrayList<>(); // inicializa el objeto ArrayList
        
    }
    public void insertar(Alumno alu) { // Insertar un alumno
        lista.add(alu);
    }
    public void eliminar(Alumno alu) { // Eliminar un alumno
        lista.remove(alu);
    }
    public boolean encontrar(Alumno alu){ // Encontrar un alumno
        return ( lista.contains(alu) );
    }
    public Alumno devolver(int posicion) {// Devuelve el alumno de posición
        return ( lista.get(posicion) );
    }
    public boolean esVacia(){ // Saber si la lista es vacía
        return ( lista.isEmpty() );
    }
    public int cantidad() { // Cantidad de alumnos en la lista
        return ( lista.size() );
    }
    public int cantidadBecados(){ // Cantidad de becados en la lista
        int becados = 0;
        for (int i=0;i<lista.size();i++){
        if (lista.get(i) instanceof Becado)
        becados++;
        }
        return becados;
        }
    public Alumno cuotaBaseMaxima(){ // Alumnos con mayor cuota base
        Alumno alumnoCaro = new Alumno();
        for (int i=0;i<lista.size();i++) {
        if(lista.get(i).getCuotaBase() > alumnoCaro.getCuotaBase() )
        alumnoCaro = lista.get(i);
        }
        return alumnoCaro;
    }
    
    public void setGrupo(int grupoi){
        grupo=grupoi;
        
    }
    @Override
    public String toString() {
        return "Lista de Alumnos "+lista+"\n";
    }
} //Fin de la clase Alumnos
    