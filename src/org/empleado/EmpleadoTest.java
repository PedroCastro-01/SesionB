
package org.empleado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.empleado.Empleado.TipoEmpleado;

class EmpleadoTest {

    // PRUEBAS DE NOMINA BRUTA

    @Test
    void testVendedorSinPrima() {
        assertEquals(2000, Empleado.calculoNominaBruta(
                TipoEmpleado.VENDEDOR, 999, 0), 0.01);
    }

    @Test
    void testVendedorPrima100() {
        assertEquals(2100, Empleado.calculoNominaBruta(
                TipoEmpleado.VENDEDOR, 1000, 0), 0.01);
    }

    @Test
    void testVendedorPrima100Superior() {
        assertEquals(2100, Empleado.calculoNominaBruta(
                TipoEmpleado.VENDEDOR, 1001, 0), 0.01);
    }

    @Test
    void testVendedorPrima200Inferior() {
        assertEquals(2100, Empleado.calculoNominaBruta(
                TipoEmpleado.VENDEDOR, 1499, 0), 0.01);
    }

    @Test
    void testVendedorPrima200() {
        assertEquals(2200, Empleado.calculoNominaBruta(
                TipoEmpleado.VENDEDOR, 1500, 0), 0.01);
    }

    @Test
    void testVendedorPrima200Superior() {
        assertEquals(2200, Empleado.calculoNominaBruta(
                TipoEmpleado.VENDEDOR, 1501, 0), 0.01);
    }

    @Test
    void testEncargado() {
        assertEquals(2500, Empleado.calculoNominaBruta(
                TipoEmpleado.ENCARGADO, 0, 0), 0.01);
    }

    @Test
    void testHorasExtra() {
        assertEquals(2150, Empleado.calculoNominaBruta(
                TipoEmpleado.VENDEDOR, 0, 5), 0.01);
    }


    // PRUEBAS DE CASOS NEGATIVOS DE NOMINA BRUTA

    @Test
    void testTipoEmpleadoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                Empleado.calculoNominaBruta(
                        null, 1000, 0));
    }

    @Test
    void testVentasNegativas() {
        assertThrows(IllegalArgumentException.class, () ->
                Empleado.calculoNominaBruta(
                        TipoEmpleado.VENDEDOR, -1, 0));
    }

    @Test
    void testHorasExtraNegativas() {
        assertThrows(IllegalArgumentException.class, () ->
                Empleado.calculoNominaBruta(
                        TipoEmpleado.VENDEDOR, 1000, -1));
    }


    // PRUEBAS DE NOMINA NETA

    @Test
    void testNominaInferior2100() {
        assertEquals(2099,
                Empleado.calculoNominaNeta(2099),
                0.01);
    }

    @Test
    void testNominaIgual2100() {
        assertEquals(1785,
                Empleado.calculoNominaNeta(2100),
                0.01);
    }

    @Test
    void testNominaSuperior2100() {
        assertEquals(1785.85,
                Empleado.calculoNominaNeta(2101),
                0.01);
    }

    @Test
    void testNominaInferior2500() {
        assertEquals(2124.15,
                Empleado.calculoNominaNeta(2499),
                0.01);
    }

    @Test
    void testNominaIgual2500() {
        assertEquals(2050,
                Empleado.calculoNominaNeta(2500),
                0.01);
    }

    @Test
    void testNominaSuperior2500() {
        assertEquals(2050.82,
                Empleado.calculoNominaNeta(2501),
                0.01);
    }


    // PRUEBA DE CASO NEGATIVO DE NOMINA NETA

    @Test
    void testNominaNetaNegativa() {
        assertThrows(IllegalArgumentException.class, () ->
                Empleado.calculoNominaNeta(-1));
    }
}
