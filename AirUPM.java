package es_upm_fp;

import java.util.Scanner;

import java.util.Random;
/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class AirUPM {
    /**
     * Constructor of the class
     *
     * @param maxAeropuertos
     * @param maxAviones
     * @param maxVuelos
     * @param maxPasajeros
     * @param maxBilletesPasajero
     */

    private int maxAeropuertos;
    private int maxAviones;
    private int maxVuelos;
    private int maxPasajeros;
    private int maxBilletesPasajero;
    private int ocupacion;
    private ListaPasajeros pasajeros;
    private ListaVuelos vuelos;
    private ListaAviones aviones;
    private ListaAeropuertos aeropuertos;
    private Vuelo[] vuelosA;
    private Pasajero[] pasajerosA;
    private int capacidad;


    public AirUPM(int maxAeropuertos, int maxAviones, int maxVuelos, int maxPasajeros, int maxBilletesPasajero, String AEROPUERTOS, String AVIONES, String VUELOS, String PASAJEROS, String
            BILLETES) {
        this.maxAeropuertos = maxAeropuertos;
        this.maxAviones = maxAviones;
        this.maxVuelos = maxVuelos;
        this.maxPasajeros = maxPasajeros;
        this.maxBilletesPasajero = maxBilletesPasajero;
        this.ocupacion = 0;
        vuelos = new Vuelo[capacidad];
    }

    public int getOcupacion() {
        return ocupacion;
    }


    // Lee los datos de los ficheros especificados y los agrega a AirUPM
    public void cargarDatos(String ficheroAeropuertos, String ficheroAviones, String ficheroVuelos, String ficheroPasajeros, String ficheroBilletes) {
        aeropuertos = ListaAeropuertos.leerAeropuertosCsv(ficheroAeropuertos, maxAeropuertos);
        aviones = ListaAviones.leerAvionesCsv(ficheroAviones, maxAviones);
        vuelos = ListaVuelos.leerVuelosCsv(ficheroVuelos, maxVuelos, aeropuertos, aviones);
        pasajeros = ListaPasajeros.leerPasajerosCsv(ficheroPasajeros, maxPasajeros, maxBilletesPasajero);

    }


    // Almacena los datos de AirUPM en los ficheros CSV especificados
    public boolean guardarDatos(String ficheroAeropuertos, String ficheroAviones, String ficheroVuelos, String ficheroPasajeros, String ficheroBilletes) {

    }


    public boolean maxVuelosAlcanzado() {
        if (insertarVuelo() == false)
            return true;
        else return false;
    }

    public boolean insertarVuelo(Vuelo vuelo) {
        if (ocupacion < maxVuelos) {
            vuelosA[ocupacion] = vuelo;
            ocupacion++;
            return true;
        } else return false;
    }

    public boolean maxPasajerosAlcanzado() {
        if (maxPasajeros > insertarPasajero())
            return true;
        else return false;
    }

    public boolean insertarPasajero(Pasajero pasajero) {
        if (ocupacion < maxPasajeros) {
            pasajerosA[ocupacion] = pasajero;
            ocupacion++;
            return true;
        } else return false;
    }


    // Funcionalidad buscarVuelo especificada en el enunciado del proyecto, que devuelve una lista de vuelos entre dos aeropuertos y
    // con una fecha de salida solicitados por teclado al usuario en el orden y con los textos indicados en los ejemplos de
    // ejecución del enunciado
    public ListaVuelos buscarVuelo(Scanner teclado) {
        teclado = new Scanner(System.in);
        System.out.println("intrduce origen: ");
        String origen = teclado.nextLine();
        System.out.println("introduce destino: ");
        String destino = teclado.nextLine();
        String fechaSalida = teclado.nextLine();


    }


    // Funcionalidad comprarBillete especificada en el enunciado del proyecto, que compra un billete para un vuelo especificado,
    // pidiendo por teclado los datos necesarios al usuario en el orden y con los textos indicados en los ejemplos de ejecución del
    // enunciado. Si la lista de pasajeros está vacía, creará un nuevo pasajero, si está llena seleccionará un pasajero, en cualquier
    // otro caso, deberá preguntar al usuario si crear o seleccionar
    public void comprarBillete(Scanner teclado, Random rand, Vuelo vuelo) {
        System.out.println("1. adquirir billete para Pasajero ya registrado \n2. Adquirir billete para un nuevo pasajero");
        int opcion = teclado.nextInt();


        switch (opcion) {
            case 2:
                Pasajero.altaPasajero();
        }


    }

    //Métodos estáticos

    // Muestra el menú y solicita una opción por teclado
    public static int menu(Scanner teclado) {
        System.out.println("1. Alta Vuelo \n2. Alta Pasajero \n3. Buscar Vuelo \n4. Mostar Billetes de Pasajero \n5. Generar lista de Pasajeros \n 0. salir");
        int opcion;
        do {
            System.out.print("seleccione opcion: ");
            opcion = teclado.nextInt();
        } while (opcion > 6);
        return opcion;
    }


    // Carga los datos de los ficheros CSV pasados por argumento (consola) en AirUPM, llama iterativamente al menú y realiza la
    //  opción especificada hasta que se indique la opción Salir, y finalmente guarda los datos de AirUPM en los mismos ficheros CSV
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        System.out.println(menu(in));



            switch (menu(in)) {
                case 0:
                    break;
                case 1:
                    altaVuelo();
                    break;
                case 2:
                    altaPasajero();
                    break;
                case 3:
                    buscarVuelo();
                    break;
                case 4:
                    mostrarBilletesDePasajero();
                    break;
                case 5:
                    generarListaDePasajeros();
            }


    }
}