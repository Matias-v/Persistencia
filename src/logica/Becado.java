package logica;
public class Becado extends Alumno{
    private double descuento;

    public Becado() {
    }

    public Becado(double descuento, String cedula, double cuotaBase) {
        super(cedula, cuotaBase);
        this.descuento = descuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    
    public double cuotaLiquida(int anio){
        return (super.cuotaLiquida(anio) - descuento);
    }
}
