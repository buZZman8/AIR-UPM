package es_upm_fp;

/**
 * Description of the class
 *
 * @author
 * @author
 * @version     1.0
 */
public class Pasajero {
    /**
     *
     */
    private String nombre;
    private String apellidos;
    private long numeroDNI;
    private char letraDNI;
    private String email;

    /**
     * Constructor of the class
     *
     * @param nombre
     * @param apellidos
     * @param numeroDNI
     * @param letraDNI
     * @param email
     */
    public Pasajero(String nombre, String apellidos, long numeroDNI, char letraDNI, String email, int maxBilletes) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numeroDNI = numeroDNI;
        this.letraDNI = letraDNI;
        this.email = email;

    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public long getNumeroDNI() {
        return numeroDNI;
    }

    public char getLetraDNI() {
        return letraDNI;
    }

    // Ejemplo: 00123456S
    public String getDNI() {

        return Long.toString(numeroDNI) + letraDNI;
    }

    public String getEmail() {
        return email;
    }

    // Texto que debe generar: Víctor Rodríguez Fernández, 00123456S, victor.rfernandez@upm.es
    public String toString() {
        String pasajero;
        pasajero = nombre + " " + apellidos + " , " + getDNI() + ", " + email;
        return pasajero;
    }

    //public int numBilletesComprado();
    //public boolean maxBilletesAlcanzado();
    //public Billete getBillete(int i);
    //public boolean aniadirBillete(Billete billete);
    //public Billete buscarBillete(String localizador);
    // Elimina el billete de la lista de billetes del pasajero
    //public boolean cancelarBillete(String localizador);
    //public void listarBilletes();
    // Encapsula la funcionalidad seleccionarBillete de ListaBilletes
    //public Billete seleccionarBillete(Scanner teclado, String mensaje);
    //Métodos estáticos
    //
    // Crea un nuevo pasajero no repetido, pidiendo por teclado los datos necesarios al usuario en el orden
    // y con los textos indicados en los ejemplos de ejecución del enunciado
    // La función solicita repetidamente los parametros hasta que sean correctos
    //public static Pasajero altaPasajero(Scanner teclado, ListaPasajeros pasajeros, int maxBilletes){}
    // Correcto: 00123456 S, incorrectos: 123456789 A, 12345678 0, 12345678 A
    public static boolean correctoDNI(long numero, char letra) {
        char[] letras = {'T', 'R', 'W', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        //for(int i=1;i<=23;i++){
        //if(numero%23==i)
        int indicador = (int) numero % 23;
        String digitos = Long.toString(numero);
        if (digitos.length() <= 8) {
            if (letras[indicador] == letra) {
                return true;
            } else return false;
        } else return false;
    }

    // Correcto: cristian.ramirez@upm.es, incorrecto: cristian.ramirez@gmail.com, cristian-23@upm.es, cristian.@upm.es
    public static boolean correctoEmail(String email) {
        boolean correcto=false;
        boolean correctofinal = false;
        boolean correctocaracteres= false;
        boolean correctopunto=false;
        String dominio1 = "@upm.es";
        String dominio2 = "@alumnos.upm.es";
        String caracteresEspeciales = "~`!@#$%^&*()-_=+\\|[{]};:'\",<->/?";
        if(email.contains(caracteresEspeciales)){
            correctocaracteres= false;
        }
        else correctocaracteres=true;
        if(email.endsWith(dominio1)||email.endsWith(dominio2)){
            correctofinal= true;
        } else correctofinal=false;
        if((email.indexOf('.')<(email.indexOf('@')-1))&&('.'<Integer.valueOf(email.substring(0,1)))
                &&(email.indexOf('.')!=0)){
            correctopunto=true;

        }else correctopunto=true;

        if(correctofinal==true&&correctocaracteres==true&&correctopunto==true){
            correcto= true;
        }
        return correcto;
    }
}