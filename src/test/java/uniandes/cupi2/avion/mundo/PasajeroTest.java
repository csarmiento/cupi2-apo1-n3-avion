package uniandes.cupi2.avion.mundo;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class PasajeroTest {
    @Test
    public void esCedulaImpar_retornaTrue_paraCedulaConUltimoDigitoImpar() {
        Pasajero pasajero = new Pasajero("CC1000000021", "Pasajero de Prueba");

        assertTrue(pasajero.esCedulaImpar());
    }

    @Test
    public void esCedulaImpar_retornaFalse_paraCedulaConUltimoDigitoPar() {
        Pasajero pasajero = new Pasajero("CC1000000012", "Pasajero de Prueba");

        assertFalse(pasajero.esCedulaImpar());
    }

    @Test
    public void esCedulaImpar_retornaFalse_paraCedulaSinDigitos() {
        Pasajero pasajero = new Pasajero("PAS-XXX-YYY-ZZZ", "Pasajero de Prueba");

        assertFalse(pasajero.esCedulaImpar());
    }

}