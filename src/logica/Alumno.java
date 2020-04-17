package logica;
import java.io.*;
import javax.swing.JOptionPane;
import grafica.verAlumno;
import grafica.Principal;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
public class Alumno {
    JFrame ventana2=new JFrame();
    
    private String cedula;
    private String nombres;
    private String apellidos;
    private double cuotaBase;
    
    public Alumno(){
        
    }
    public Alumno(String cedula, double cuotaBase) {
        this.cedula = cedula;
        this.cuotaBase = cuotaBase;
    }

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
            this.cedula = cedula;
    }
    public double getCuotaBase() {
        return cuotaBase;
    }
    public void setCuotaBase(double cuotaBase) {
        this.cuotaBase = cuotaBase;
    }
    public double cuotaLiquida(int anio){
        if(anio == 1 || anio == 2)
            return(cuotaBase * 0.75);
        else
        return (cuotaBase);
    }
    public void escribirArchivo(String cedula,String nombre,String apellido){
        String cadenaDatos=" ";
        cadenaDatos=cedula+" , "+nombre+" , "+apellido;
       
        FileWriter fichero;
        PrintWriter pw;
        try{
            fichero = new FileWriter ("Datos.txt",true);
            pw = new PrintWriter (fichero);
            pw.println(cadenaDatos);
            pw.close();
            fichero.close();
            
            JOptionPane.showConfirmDialog(null, "Datos ingresados al archivo correspondiente","Informacion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, "No se pudo guardar", "ERROR",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            
        }
             
    }
    public void verAlumnos(){
        
        Vector columnas = new Vector();
        columnas.add("Cedula");
        columnas.add("Nombre");
        columnas.add("Apellidos");
        
        Vector filas = new Vector();
        Vector fila = new Vector();
        
        File archivo=null;
        FileReader fr=null;
        BufferedReader br=null;
        
        Vector clon = new Vector();
        
        try{
            archivo = new File ("Datos.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            String filaLeidaArchivo;
            String [] cadenaSeparada;
            
            while ((filaLeidaArchivo = br.readLine()) !=null){
                cadenaSeparada = filaLeidaArchivo.split(" , ");
                cedula=cadenaSeparada[0];
                nombres=cadenaSeparada[1];
                apellidos=cadenaSeparada[2];
                
                fila.removeAllElements();
                fila.add(cedula);
                fila.add(nombres);
                fila.add(apellidos);
                
                clon=(Vector) fila.clone();
                filas.add(clon);
            }
            JTable tabla = new JTable(filas, columnas);
            JScrollPane scroll = new JScrollPane(tabla);
            ventana2.getContentPane().add(scroll);
            ventana2.setLocationRelativeTo(null);
            ventana2.pack();
            ventana2.setVisible(true);
            br.close();
            fr.close();
        }
        catch(Exception e){
            JOptionPane.showConfirmDialog(null, "El archivo no existe","Informacion",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
