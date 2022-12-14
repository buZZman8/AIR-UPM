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
public class ListaPasajeros {

    private int capacidad;
    private int ocupacion;
    private Pasajero pasajeros[];

    /**
     * Constructor of the class
     *
     * @param capacidad
     */
    public ListaPasajeros(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public boolean estaLlena() {
        boolean estaLlena = false;
        if (getOcupacion() <= capacidad) {
            estaLlena = false;
        } else if (ocupacion > capacidad) {
            estaLlena = true;
        }
        return estaLlena;
    }

    public Pasajero getPasajero(int i) {
        return pasajeros[i];
    }

    public boolean insertarPasajero(Pasajero pasajero) {
        if (estaLlena() == false) {
            pasajeros[ocupacion] = pasajero;
            ocupacion++;

            return true;
        } else return false;
    }

    public Pasajero buscarPasajeroDNI(String dni) {
        Pasajero aux = null;
        for (int i = 0; i <= capacidad; i++) {
            if (dni == pasajeros[i].getDNI()) {
                aux = pasajeros[i];
            }
        }
        return aux;
    }

    public Pasajero buscarPasajeroEmail(String email) {
        Pasajero aux = null;
        for (int i = 0; i <= capacidad; i++) {
            if (email == pasajeros[i].getEmail()) {
                aux = pasajeros[i];
            }
        }
        return aux;

    }

    // Permite seleccionar un pasajero existente a partir de su DNI, usando el mensaje pasado como argumento para la solicitud
    // y siguiendo el orden y los textos mostrados en el enunciado
    // La función solicita repetidamente hasta que se introduzca un DNI correcto
    public Pasajero seleccionarPasajero(Scanner teclado, String mensaje) {
        Pasajero aux = null;
        do {
            System.out.println(mensaje);
            aux = buscarPasajeroDNI(teclado.nextLine());
            if (aux != null) {
                if (aux.getDNI() == null) {
                    aux = null;
                }
            }

        } while (aux == null);
        return aux;
    }

    // Genera un fichero CSV con la lista de pasajeros, sobreescribiendolo
    public boolean escribirPasajerosCsv(String fichero) {
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(fichero);

            for (int i = 0; i <= capacidad; i++) {
                String listapasajeros = (pasajeros[i].getNombre() + ";" + pasajeros[i].getApellidos() + ";"
                        + pasajeros[i].getNumeroDNI() + "," + pasajeros[i].getLetraDNI() + ";" + pasajeros[i].getEmail() + ";");
                salida.print(listapasajeros);
            }
            salida.close();
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
    }


    //Métodos estáticos
    // Genera una lista de pasajeros a partir del fichero CSV, usando los límites especificados como argumentos para la capacidad
    // de la lista y el número de billetes máximo por pasajero
    public static ListaPasajeros leerPasajerosCsv(String fichero, int capacidad, int maxBilletesPasajero) {
        Scanner entrada = null;
        ListaPasajeros lista = new ListaPasajeros(capacidad);
        try {
            entrada = new Scanner(new FileReader(fichero));
            for (int i = 0; i < capacidad; i++) {
                String pasajeros[] = entrada.nextLine().split(";");
                System.out.printf(entrada.nextLine());
                String nombre = pasajeros[0];
                String apellidos = pasajeros[1];
                long numeroDni = Long.parseLong(pasajeros[2]);
                char letraDNI = pasajeros[3].charAt(0);
                String email = pasajeros[4];
                int maxBilletes = Integer.parseInt(pasajeros[5]);

                lista.insertarPasajero(new Pasajero(nombre, apellidos, numeroDni, letraDNI, email, maxBilletes));


            }


            System.out.print("Se ha leído con éxito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error de lectura del fichero Aeropuertos");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error de lectura del fichero Aeropuertos");

        } finally {
            if (entrada != null) {
                entrada.close();
            }
        }
        return lista;
    }
}