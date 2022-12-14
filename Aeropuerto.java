package es_upm_fp;

/**
 * Description of the class
 *
 * @author Oscar Ivan Ospina Acosta
 * @author Andres Murillo Gonzales
 * @version     1.0
 */
public class Aeropuerto {

    private String nombre;
    private String codigo;
    private double latitud;
    private double longitud;
    private int terminales;

    /**
     * Constructor of the class
     *
     * @param nombre
     * @param codigo
     * @param latitud
     * @param longitud
     * @param terminales
     */
    public Aeropuerto(String nombre, String codigo, double latitud, double longitud, int terminales){
        this.nombre = nombre;
        this.codigo = codigo;
        this.latitud = latitud;
        this.longitud = longitud;
        this.terminales = terminales;
    }

    public Aeropuerto(String codigo){
        this.codigo = codigo;
    }
    public String getNombre(){
        return nombre;
    }
    public String getCodigo(){
        return codigo;
    }
    public double getLatitud(){
        return latitud;
    }
    public double getLongitud(){
        return longitud;
    }
    public int getTerminales(){
        return terminales;
    }


    /**Calcula la distancia entre aerpuerto de salida y aerpouerto de destino
     * @param destino
     * @return distancia
     */

    public double distancia(Aeropuerto destino){

        final int RT = 6378;

        double latitudA = Math.toRadians(this.latitud);
        double latitudB = Math.toRadians(destino.latitud);
        double longitudA =  Math.toRadians(this.latitud);
        double longitudB =  Math.toRadians(destino.longitud);

        double distancia = Math.acos(Math.sin(latitudA)*Math.sin(latitudB) + Math.cos(latitudB)*Math.cos(latitudB)*Math.cos(longitudA-longitudB)) * RT;
        distancia = (int) distancia;

        return distancia;
    }


    /** Devuleve los datos de un aeropuerto (nombre, coordenadas, y terminales)
     * @return DatosAeropuerto
     */
    public String toString(){
        String DatosAeropuerto;
        DatosAeropuerto = nombre + " - " + codigo + ", en (" + latitud + " -" + longitud + "), con " + terminales + "terminales";

        return DatosAeropuerto;
    }


    /**devuelve el nombre y codigo de un aeropuerto
     * @return aeropuerto
     */
    public String toStringSimple(){
        String aeropuerto;
        aeropuerto = nombre + " - " + codigo;

        return aeropuerto;
    }
}
