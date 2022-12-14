package es_upm_fp;

/**
 * Description of the class
 *
 * @author OScar Ivan Ospina Acosta
 * @author Andres Murillo Gonzales
 * @version     1.0
 */
public class Avion {

    /**
     * Constructor of the class
     *
     * @param marca
     * @param modelo
     * @param matricula
     * @param columnas
     * @param filas
     * @param alcance
     */

    private String marca;
    private String modelo;
    private String matricula;
    private int columnas;
    private int filas;
    private double alcance;
    public Avion(String marca, String modelo, String matricula, int columnas, int filas, double alcance){}
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public String getMatricula(){
        return matricula;
    }
    public int getColumnas(){
        return columnas;
    }
    public int getFilas(){
        return filas;
    }
    public double getAlcance(){
        return alcance;
    }
    // Crea un String con los datos de un avión con el siguiente formato:
    // Boeing 737(EC-LKE): 180 asientos, hasta 5700.0 km
    public String toString(){

        String avion;
        avion=marca + " "+modelo+"("+matricula+"): "+(columnas*filas)+" asientos, hasta "+alcance+" km";
        return avion;
    }
    // Crea un String con los datos de un avión con el siguiente formato:
    // Boeing 737(EC-LKE)
    public String toStringSimple(){
        String avion;
        avion = marca + modelo+"("+matricula+")";
        return avion;

    }
}
