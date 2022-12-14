package es_upm_fp;

import java.io.*;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author Andres Murillo GOnzales
 * @author  Oscar Ivan Ospina Acosta
 * @version     1.0
 */
public class ListaAviones {

    /**
     * Constructor of the class
     *
     * @param capacidad
     * @param ocupacion
     */

    private int capacidad;
    private int ocupacion;

    private Avion aviones[];

    public ListaAviones(int capacidad) {
        this.capacidad = capacidad;
        this.ocupacion = 0;
        aviones = new Avion[capacidad];

    }


    public int getOcupacion() {
        return ocupacion;
    }

    public boolean estaLlena() {
        if (getOcupacion() < capacidad)
            return false;
        else return true;
    }

    public Avion getAvion(int posicion) {
        return aviones[posicion];

    }

    public boolean insertarAvion(Avion avion) {
        if (ocupacion < capacidad) {
            aviones[ocupacion] = avion;
            ocupacion++;
            return true;
        } else return false;
    }

    public Avion buscarAvion(String matricula) {
        int i = 0;
        while (i < capacidad) {
            if (aviones[i].getMatricula() == matricula) {
                return aviones[i];
            }
            i++;
        }
        return null;
    }


    // Permite seleccionar un avión existente a partir de su matrícula, y comprueba si dispone de un alcance mayor o igual que el pasado como argumento,
    // usando el mensaje pasado como argumento para la solicitud y siguiendo el orden y los textos mostrados en el enunciado
    // La función solicita repetidamente la matrícula del avión hasta que se introduzca uno con alcance suficiente
    public Avion seleccionarAvion(Scanner teclado, String mensaje, double alcance) {
        Avion aux = null;
        do {
            System.out.println(mensaje);
            aux = buscarAvion(teclado.nextLine());

            if (aux != null) {
                if (aux.getAlcance() < alcance) {
                    aux = null;
                }
            }
        } while (aux == null);
        return aux;
    }


    // Genera un fichero CSV con la lista de aviones, sobreescribiendolo
    public boolean escribirAvionesCsv(String nombre) {
        PrintWriter salida = null;
        try {
            salida = new PrintWriter(nombre);

            for (int i = 0; i <= capacidad; i++) {
                String avion = (aviones[i].getMarca() + ";" + aviones[i].getModelo() + ";" + aviones[i].getMatricula() + ";"
                        + aviones[i].getColumnas() + ";" + aviones[i].getFilas() + ";" + aviones[i].getAlcance());
                salida.print(avion);
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
        // Genera una lista de aviones a partir del fichero CSV, usando el argumento como
        // capacidad máxima de la lista
        public static ListaAviones leerAvionesCsv(String fichero,int capacidad){
            Scanner entrada = null;
            ListaAviones lista = new ListaAviones(capacidad);
            try {
                entrada = new Scanner(new FileReader(fichero));
                for (int i = 0; i < capacidad; i++) {
                    String[] avion = entrada.nextLine().split(";");
                    String marca = avion[0];
                    String modelo = avion[1];
                    String matricula = avion[2];
                    int columnas = Integer.parseInt(avion[3]);
                    int filas = Integer.parseInt(avion[4]);
                    double alcance = Double.parseDouble(avion[5]);

                    lista.insertarAvion(new Avion(marca, modelo, matricula, columnas, filas, alcance));


                }
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (entrada != null) {
                    entrada.close();
                }
            }
            return null;
    }

}
