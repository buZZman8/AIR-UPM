package es_upm_fp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class ListaAeropuertos {

    /**
     * Constructor of the class
     *
     * @param capacidad
     * @param estaLlena
     * @param eropuerto
     * @param insertar aeropuerto
     */

    String codigo[] = {"MAD", "BCN","LPA","VLC" };

    Scanner teclado = new Scanner(System.in);
    private int capacidad;
    private int ocupacion;
    private Aeropuerto aeropuertos[];

    public ListaAeropuertos(int capacidad) {
        this.capacidad = capacidad;
        this.ocupacion = 0;
        aeropuertos = new Aeropuerto[capacidad];
    }


    public int getOcupacion()  {return ocupacion;}
    public boolean estaLlena(){
        if (getOcupacion() < capacidad)
            return false;
        else return true;
    }
    public Aeropuerto getAeropuerto(int i){ return aeropuertos[i];}

    public boolean insertarAeropuerto(Aeropuerto aeropuerto){
        if (ocupacion < capacidad) {
            aeropuertos[ocupacion] = aeropuerto;
            ocupacion++;
            return true;
        } else return false;
    }

    public Aeropuerto buscarAeropuerto(String codigo){
        int i = 0;
        while (i<capacidad){
            if(aeropuertos[i].getCodigo() == codigo){
                return aeropuertos[i];
            }
            i++;
        }
        return null;
    }



    // Permite seleccionar un aeropuerto existente a partir de su código, usando el mensaje pasado como argumento para la solicitud
    // y siguiendo el orden y los textos mostrados en el enunciado
    // La función solicita repetidamente el código hasta que se introduzca uno correcto
    public Aeropuerto seleccionarAeropuerto(Scanner teclado, String mensaje) {
        Aeropuerto aux = null;
        do {
            System.out.println(mensaje);
            aux = buscarAeropuerto(teclado.nextLine());

        } while (aux == null);
        return aux;

    }








    // Genera un fichero CSV con la lista de aeropuertos, sobreescribiendolo
    public boolean escribirAeropuertosCsv(String nombre){
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(nombre);
            for (int i = 0; i < capacidad; i++) {
                String aeropuerto = (aeropuertos[i].getCodigo() + "," + aeropuertos[i].getNombre() + "," + aeropuertos[i].getLatitud() + ","
                        + aeropuertos[i].getLongitud() + "," + aeropuertos[i].getTerminales() );
                salida.print(aeropuerto);
            }
            salida.close();
            return true;
        }catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            if (salida != null)
                salida.close();
        }
    }





    //Métodos estáticos
    //Genera una lista de aeropuertos a partir del fichero CSV, usando el argumento como   
    //capacidad máxima de la lista
    public static ListaAeropuertos leerAeropuertosCsv(String fichero, int capacidad){
        Scanner in = null;
        ListaAeropuertos lista =new ListaAeropuertos(capacidad);
        try {
            in = new Scanner ( new FileReader(fichero));
            for (int i = 0; i < capacidad; i++) {
                String[] aeropuerto = in.nextLine().split(",");
                String codigo = aeropuerto[0];
                String nombre = aeropuerto[1];
                double latitud = Double.parseDouble(aeropuerto[2]);
                double longitud = Double.parseDouble(aeropuerto[3]);
                int terminales = Integer.parseInt(aeropuerto[4]);

                lista.insertarAeropuerto(new Aeropuerto(codigo,nombre,latitud,longitud,terminales));

            }
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }finally {
            if(in != null) {
                in.close();
            }
        }
        return null;

    }
}
