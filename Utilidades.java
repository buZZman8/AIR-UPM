package es_upm_fp;
import java.util.Scanner;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class Utilidades {
    // Solicita un número repetidamente hasta que se introduzca uno correcto (dentro de los límites)
    public static int leerNumero(Scanner teclado, String mensaje, int minimo, int maximo){
        int numero;
        do{
            System.out.println(mensaje);
            numero = teclado.nextInt();
        } while (numero>maximo||numero<minimo);
        return numero;
    }
    public static long leerNumero(Scanner teclado, String mensaje, long minimo, long maximo){
        long numero;
        do{
            System.out.println(mensaje);
            numero = teclado.nextLong();
        } while (numero>maximo||numero<minimo);
        return numero;
    }
    public static double leerNumero(Scanner teclado, String mensaje, double minimo, double maximo){
        double numero;
        do{
            System.out.println(mensaje);
            numero = teclado.nextDouble();
        } while (numero>maximo||numero<minimo);
        return numero;
    }
    public static char leerLetra(Scanner teclado, String mensaje, char minimo, char maximo){
        char letra;
        do{
            System.out.println(mensaje);
            letra = teclado.next().charAt(0);
        } while (letra>maximo||letra<minimo);
        return letra;
    }
    // Solicita una fecha repetidamente hasta que se introduzca una correcta
    public static Fecha leerFecha(Scanner teclado, String mensaje){
        int dia;
        int mes;
        int anio;
        do{
            System.out.println(mensaje);
            dia = leerNumero(teclado, "Ingrese día:",1,31);
            mes = leerNumero(teclado,"Ingrese mes:",1,12);
            anio = leerNumero(teclado, "Ingrese año:",Fecha.PRIMER_ANIO,Fecha.ULTIMO_ANIO);

        }while(!Fecha.comprobarFecha(dia, mes, anio));
        Fecha fecha = new Fecha(dia,mes,anio);
        return fecha;
    }
    // Solicita una fecha y hora repetidamente hasta que se introduzcan unas correctas
    public static Fecha leerFechaHora(Scanner teclado, String mensaje){
        int dia;
        int mes;
        int anio;
        int hora;
        int minuto;
        int segundo;
        do{
            System.out.println(mensaje);
            dia = leerNumero(teclado, "Ingrese día:",1,31);
            mes = leerNumero(teclado,"Ingrese mes:",1,12);
            anio = leerNumero(teclado, "Ingrese año:",Fecha.PRIMER_ANIO,Fecha.ULTIMO_ANIO);
            hora = leerNumero(teclado, "Ingrese hora:",0,23);
            minuto = leerNumero(teclado, "Ingrese minuto:",0,59);
            segundo = leerNumero(teclado, "Ingrese segundo:",0,59);

            if(!(Fecha.comprobarFecha(dia, mes, anio)) || !(Fecha.comprobarHora(hora, minuto, segundo)))
                System.out.println("Fecha u hora introducida incorrecta.");

        }while(!(Fecha.comprobarFecha(dia, mes, anio)) || !(Fecha.comprobarHora(hora, minuto, segundo)));
        Fecha fecha = new Fecha(dia,mes,anio,hora,minuto,segundo);
        return fecha;
    }
}
