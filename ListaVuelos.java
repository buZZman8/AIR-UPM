package es_upm_fp;
import java.io.*;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @oscar ivan ospina acosta
 * @andres murillo gonzales
 * @version     1.0
 */
public class ListaVuelos {
    /**
     * Constructor of the class
     * @param capacidad
     */

    private int capacidad;
    private int ocupacion;
    private Vuelo vuelos[];




    public ListaVuelos(int capacidad){
        this.capacidad = capacidad;
        this.ocupacion = 0;
        vuelos = new Vuelo[capacidad];
    }

    public ListaVuelos(int capacidad, ListaAeropuertos aeropuertos, ListaAviones aviones){
    }


    public int getOcupacion(){ return ocupacion;}


    public boolean estaLlena(){
        if(getOcupacion() < capacidad)
            return false;
        else return true;
    }

    //Devuelve el objeto vuelo que está en la posición i del array
    public Vuelo getVuelo(int i){
        return vuelos[i];
    }

    //Devuelve true si puede insertar el vuelo
    public boolean insertarVuelo (Vuelo vuelo){
        if(ocupacion < capacidad){
            vuelos[ocupacion] = vuelo;
            ocupacion++;
            return true;
        }else return false;
    }


    //Devuelve el objeto vuelo que tenga el identificador igual al parámetro id
    //Si no lo encuentra, devolverá null
    public Vuelo buscarVuelo (String id){
        int i = 0;
        while (i<capacidad){
            if(vuelos[i].getID() == id)
                return vuelos[i];
            i++;

        }
        return null;
    }


    //Devuelve un nuevo objeto ListaVuelos conteniendo los vuelos que vayan de un aeropuerto a otro en una determinada fecha
    public ListaVuelos buscarVuelos(String codigoOrigen, String codigoDestino, Fecha fecha){
        int i=0;
        ListaVuelos aux = new ListaVuelos(capacidad);
        while(i<=capacidad){
            if((vuelos[i].getOrigen().getCodigo()==codigoOrigen)&&(vuelos[i].getDestino().getCodigo()==codigoDestino)&&(vuelos[i].getSalida()==fecha))
                aux.insertarVuelo(vuelos[i]);
            i++;
        } return aux;
    }

    //Muestra por pantalla los vuelos siguiendo el formato de los ejemplos del enunciado
    public void listarVuelos(){
        for(int i=0; i<capacidad;i++){
            String vuelo = (vuelos[i].getID() + "," + vuelos[i].getAvion() + "," + vuelos[i].getOrigen() + vuelos[i].getTerminalOrigen() + ","
                    + vuelos[i].getDestino() + vuelos[i].getTerminalDestino() +  "," + vuelos[i].getSalida() + ","
                    + vuelos[i].getLlegada() + "," + vuelos[i].getPrecio());
            System.out.println(vuelo);
        }

    }


    //Permite seleccionar un vuelo existente a partir de su ID, usando el mensaje pasado como argumento para la solicitud
    //y siguiendo el orden y los textos mostrados en el enunciado, y usando la cadena cancelar para salir devolviendo null
    //La función solicita repetidamente hasta que se introduzca un ID correcto
    public Vuelo seleccionarVuelo(Scanner teclado, String mensaje, String cancelar){
        Vuelo aux = null;
        do {
            System.out.println(mensaje);
            aux= buscarVuelo(teclado.nextLine());

        } while ( aux == null);
        return  aux;
    }




    //Ha de escribir la lista de vuelos en la ruta y nombre del fichero pasado como parámetro.
    //Si existe el fichero, se sobreescribe, si no existe se crea.
    public boolean escribirVuelosCsv(String fichero) {
        File archivo = new File(fichero);
        File archivo2  = new File(fichero);
        boolean existe = archivo.exists();
        String vuelo;

        if (existe = true) {
            PrintWriter salida = null;
            try {
                salida = new PrintWriter(fichero);

                for (int i = 0; i <= capacidad; i++) {
                    vuelo = (vuelos[i].getID() + "," + vuelos[i].getAvion() + "," + vuelos[i].getOrigen() + vuelos[i].getTerminalOrigen() + ","
                            + vuelos[i].getDestino() + vuelos[i].getTerminalDestino() +  "," + vuelos[i].getSalida() + ","
                            + vuelos[i].getLlegada() + "," + vuelos[i].getPrecio());
                    salida.print(vuelo);
                }

                    return true;


            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                return false;
            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            } finally {
                if (salida != null) {
                    salida.close();
                }
            }
        } else {
            try {
                archivo2.createNewFile();
                for (int i = 0; i <= capacidad; i++) {
                    vuelo = (vuelos[i].getID() + ";" + vuelos[i].getAvion() + ";" + vuelos[i].getOrigen() + vuelos[i].getTerminalOrigen() + ";"
                            + vuelos[i].getSalida() + vuelos[i].getDestino() + ";" + vuelos[i].getTerminalDestino() + ";" + vuelos[i].getLlegada() + ","
                            + vuelos[i].getPrecio() );

                    FileWriter lista = new FileWriter(archivo2);
                    lista.write(vuelo);
                }
                    return true;

            } catch (IOException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
    }



    //Métodos estáticos
    //Genera una lista de vuelos a partir del fichero CSV, usando los límites especificados como argumentos para la capacidad
    //de la lista
    public static ListaVuelos leerVuelosCsv(String fichero, int capacidad, ListaAeropuertos aeropuertos, ListaAviones aviones){
        Scanner in = null;
        ListaVuelos lista = new ListaVuelos(capacidad,aeropuertos,aviones);
        try{
            in = new Scanner ( new FileReader(fichero));
            for(int i = 0; i < capacidad; i++){
                String[] vuelo = in.nextLine().split(",");
                String Id = vuelo[0];
                Avion avion = aviones.buscarAvion(vuelo[1]);
                Aeropuerto origen = aeropuertos.buscarAeropuerto(vuelo[2]);
                int terminalOrigen = Integer.parseInt(vuelo[3]);
                Aeropuerto destino = aeropuertos.buscarAeropuerto(vuelo[5]);
                int terminalDestino= Integer.parseInt(vuelo[6]);
                double precio = Double.parseDouble(vuelo[8]);
                Fecha salida= Fecha.fromString(vuelo[4]);
                Fecha llegada = Fecha.fromString(vuelo[7]);

                lista.insertarVuelo(new Vuelo(Id,avion,origen,terminalOrigen,salida, destino,terminalDestino,llegada,precio));
            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(in != null){
                in.close();
            }
        }
        return null;
    }

}
