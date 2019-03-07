/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  Universidad de los Andes (Bogotá - Colombia)
  Departamento de Ingeniería de Sistemas y Computación
  Licenciado bajo el esquema Academic Free License version 2.1

  Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
  Ejercicio: n3_avion
  Autor: Equipo Cupi2 2017
  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.mundo;

/**
 * Pasajero del avión.
 */
public class Pasajero {

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Cédula del pasajero.
     */
    private String cedula;

    /**
     * Nombre del pasajero.
     */
    private String nombre;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un pasajero con su cédula y nombre. <br>
     * <b>post: </b> El pasajero tiene sus datos básicos cédula y nombre asignados.
     *
     * @param pCedula Cédula del pasajero. pCedula > 0.
     * @param pNombre Nombre del pasajero. pNombre != null && pNombre != "".
     */
    public Pasajero(String pCedula, String pNombre) {
        cedula = pCedula;
        nombre = pNombre;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la cédula del pasajero.
     *
     * @return La cédula del pasajero.
     */
    public String darCedula() {
        return cedula;
    }

    /**
     * Retorna el nombre del pasajero.
     *
     * @return El nombre del pasajero.
     */
    public String darNombre() {
        return nombre;
    }

    /**
     * Indica si el pasajero es igual a otro.
     *
     * @param pOtroPasajero Pasajero a comparar. pOtroPasajero != null.
     * @return Retorna true si es el mismo pasajero, false en caso contrario.
     */
    public boolean igualA(Pasajero pOtroPasajero) {
        boolean esIgual = false;
        if (cedula.equals(pOtroPasajero.darCedula())) {
            esIgual = true;
        }

        return esIgual;
    }

    /**
     * Evalúa el último caracter numérico de la cédula de un pasajero (si existe) y retorna <tt>true</tt> en caso de que sea impar, o <tt>false</tt>
     * de lo contrario (es par, o no existen caracteres numéricos en la cédula).
     */
    public boolean esCedulaImpar() {
        char[] caracteresCedula = cedula.toCharArray();
        // Se declara un valor numérico inicializado en -1, ya que 1 solo caracter en la cédula no puede tomar un valor negativo
        int ultimoDigito = -1;

        // Este ciclo busca el último valor numérico en la cadena - una vez lo encuentra, su valor cambia y termina el ciclo
        for (int i = caracteresCedula.length - 1; i >= 0 && ultimoDigito == -1; i--) {
            // como requisito de Integer.parseInt se debe pasar un String, por eso se convierte y se asigna en caracterStr
            String caracterStr = String.valueOf(caracteresCedula[i]);

            // try/catch es una forma de manejo de errores que veremos en nivel 4
            // https://universidad-de-los-andes.gitbooks.io/fundamentos-de-programacion/content/Nivel4/5_ManejoDeLasExcepciones.html
            try {
                ultimoDigito = Integer.parseInt(caracterStr);
            } catch (NumberFormatException e) {
                // No se hace nada, si no es un caracter numérico, símplemente se ignora
            }
        }

        // Si en la cadena se encontró un caracter numérico
        if (ultimoDigito != -1) {
            return ultimoDigito % 2 == 1;
        }
        // si no se encontraron dígitos en la cadena, se devuelve false
        return false;
    }
}