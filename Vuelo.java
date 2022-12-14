package es_upm_fp;

import java.util.Random;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class Vuelo {
    private boolean[][] asientos;
    private String id;
    private Avion avion;
    private Aeropuerto origen;
    private int terminalOrigen;
    private Fecha salida;
    private Aeropuerto destino;
    private int terminalDestino;
    private Fecha llegada;
    private double precio;

    /**
     * Constructor of the class
     *
     * @param id
     * @param avion
     * @param origen
     * @param terminalOrigen
     * @param salida
     * @param destino
     * @param terminalDestino
     * @param llegada
     * @param precio
     */
    public Vuelo(String id, Avion avion, Aeropuerto origen, int terminalOrigen, Fecha salida, Aeropuerto destino, int terminalDestino, Fecha llegada, double precio) {
        this.id=id;
        this.avion=avion;
        this.origen=origen;
        this.terminalOrigen=terminalOrigen;
        this.salida=salida;
        this.destino=destino;
        this.terminalDestino=terminalDestino;
        this.llegada=llegada;
        this.precio=precio;

    }


    public String getId() {
        return id;
    }

    public Avion getAvion() {
        return avion;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public int getTerminalOrigen() {
        return terminalOrigen;
    }

    public Fecha getSalida() {
        return salida;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public int getTerminalDestino() {
        return terminalDestino;
    }

    public Fecha getLlegada() {
        return llegada;
    }

    public double getPrecio() {
        return precio;
    }
    public double getPrecioPreferente;{

    }
    public double getGetPrecioPrimera;{

    }

    public int numAsientosLibres(){
        int  asientostotal= avion.getFilas()*avion.getColumnas();
        int asientoslibres=asientostotal;
        for (int i=0;i<= avion.getFilas();i++)
            for(int j=0;j<= avion.getColumnas();j++){
                if(asientoOcupado(i,j));
                asientoslibres--;
            }
        return asientoslibres;
    }

    public boolean vueloLleno() {
        return false;
    }

    public boolean asientoOcupado(int fila, int columna){
        if ((buscarBillete().getFila()==fila&&(buscarBillete().getColumna()==columna))){
            return true;
        }else
            return false;

    }


    public Billete buscarBillete(String localizador){

    }

    //Devuelve el obejeto billete que corresponde con una fila o columna,
    //Devolverá null si está libre o se excede en el límite de fila y columna
    public Billete buscarBillete(int fila, int columna){

    }


    //Si está desocupado el asiento que indica el billete, lo pone ocupado y devuelve true, si no devuelve false
    public boolean ocuparAsiento(Billete billete){

    }


    //A traves del loalizador de billete, se desocupará el asiento
    public boolean desocuparAsiento(String localizador){

    }



    // Añade los billetes al final de un fichero CSV, sin sobreescribirlo
    public boolean aniadirBilletesCsv(String fichero){

    }


    // Devuelve una cadena con información completa del vuelo
    //Ejemplo: Vuelo PM0066 de Josep Tarradellas Barcelona-El Prat(BCN) T2 (01/01/2023 08:15:00) a Gran Canaria(LPA) T1 (01/01/2023 11:00:05) en Boeing 747(EC-LKD) por 182,52€, asientos libres: 409
    public String toString(){
        String vuelo;
        vuelo=("Vuelo "+id+" de " + origen.toStringSimple()+" T"+terminalOrigen+" ("+salida+") a "+destino.toStringSimple()+" T"+terminalDestino+" ("+llegada+") en "+ avion.toStringSimple()+ " por "+ precio+", asientos libres: ");


        return vuelo;
    }
    // Devuelve una cadena con información abreviada del vuelo
    //Ejemplo: Vuelo PM0066 de Josep Tarradellas Barcelona-El Prat(BCN) T2 (01/01/2023 08:15:00) a Gran Canaria(LPA) T1 (01/01/2023 11:00:05)
    public String toStringSimple(){
        String vuelo;
        vuelo=("Vuelo "+id+" de " + origen.toStringSimple()+" T"+terminalOrigen+" ("+salida+") a "+destino.toStringSimple()+" T"+terminalDestino+" ("+llegada+")");
        return vuelo;
    }

    //Devuelve true si el código origen, destino y fecha son los mismos que el vuelo
    public boolean coincide(String codigoOrigen, String codigoDestino, Fecha fecha) {
        if (codigoOrigen==getOrigen().getCodigo()&&codigoDestino==getDestino().getCodigo()&&fecha==salida){
            return true;
        }else return false;
    }



    // Muestra la matriz  de asientos del vuelo, ejemplo:
    //   A  B  C  D  E  F
    // 1( )(X)( )( )( )( )
    // 2{X}{X}{ }{ }{ }{ }
    // 3{ }{ }{ }{X}{X}{X}
    // 4{ }{ }{ }{ }{ }{ }
    // 5{ }{ }{X}{ }{ }{ }
    // 6[ ][ ][ ][ ][ ][ ]
    // 7[X][X][X][ ][ ][ ]
    // 8[ ][ ][ ][ ][ ][ ]
    // 9[ ][X][ ][ ][ ][X]
    //10[ ][ ][ ][ ][ ][ ]
    public void imprimirMatrizAsientos(){

    }



    //Devuelve true si ha podido escribir en un fichero la lista de pasajeros del vuelo, siguiendo las indicaciones del enunciado
    public boolean generarListaPasajeros(String fichero){

    }




    //Métodos estáticos

    //Genera un ID de vuelo. Este consistirá en una cadena de 6 caracteres, de los cuales los dos
    //primeros serán PM y los 4 siguientes serán números aleatorios. Ejemplo: PM0123
    //NOTA: Usar el objeto rand pasado como argumento para la parte aleatoria.
    public static String generarID(Random rand) {
        String id;
        id=("PM"+rand);
        return id;
    }

    //Crea y devuelve un objeto Vuelo de los datos que selecciona el usuario de aeropuertos y aviones y la restricción de que
    //no puede estar repetido el identificador, siguiendo las indicaciones del enunciado
    //La función solicita repetidamente los parametros hasta que sean correctos
    public static Vuelo altaVuelo(Scanner teclado, Random rand, ListaAeropuertos aeropuertos, ListaAviones aviones, ListaVuelos vuelos){
        Vuelo aux = null;
        Aeropuerto aeropuertoOrigen = aeropuertos.seleccionarAeropuerto(teclado,"Ingrese código de Aeropuerto Origen:");
        int terminalOrigen = Utilidades.leerNumero(teclado,"Ingrese Terminal Origen (1 - "+aeropuertoOrigen.getTerminales()+"):",1,aeropuertoOrigen.getTerminales());
        Aeropuerto aeropuertoDestino = aeropuertos.seleccionarAeropuerto(teclado,"Ingrese código de Aeropuerto Destino:");
        int terminalDestino = Utilidades.leerNumero(teclado,"Ingrese Terminal Destino (1 - "+aeropuertoDestino.getTerminales()+"):",1,aeropuertoDestino.getTerminales());
        Avion avion = aviones.seleccionarAvion(teclado,"Ingrese matrícula de Avión:",aeropuertoOrigen.distancia(aeropuertoDestino));
        Fecha fechaSalida;
        Fecha fechaLlegada;
        do {
            fechaSalida = Utilidades.leerFechaHora(teclado, "Fecha de Salida:");
            fechaLlegada = Utilidades.leerFechaHora(teclado, "Fecha de LLegada:");
        } while (!fechaSalida.anterior(fechaLlegada));
        double precio = Utilidades.leerNumero(teclado,"Ingrese precio de pasaje:",1,200);
        String id = generarID(rand);
        aux = new Vuelo(id,avion,aeropuertoOrigen,terminalOrigen,fechaSalida,aeropuertoDestino,terminalDestino,fechaLlegada,precio);
        vuelos.insertarVuelo(aux);
        return aux;

    }
}