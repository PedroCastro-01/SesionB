
package org.empleado;

public class Empleado {

    public enum TipoEmpleado {
        VENDEDOR, ENCARGADO
    }

    public static float calculoNominaBruta(
            TipoEmpleado tipo, float ventasMes, float horasExtra) {

        float salarioBase = 0;

        if (tipo == TipoEmpleado.VENDEDOR) {
            salarioBase = 2000;
        } else if (tipo == TipoEmpleado.ENCARGADO) {
            salarioBase = 2500;
        }

        float prima = 0;

        if (ventasMes >= 1500) {
            prima = 200;
        } else if (ventasMes >= 1000) {
            prima = 100;
        }

        float pagoHorasExtra = horasExtra * 30;

        return salarioBase + prima + pagoHorasExtra;
    }

    public static float calculoNominaNeta(float nominaBruta) {

        float retencion = 0;

        if (nominaBruta < 2100) {
            retencion = 0;
        } else if (nominaBruta < 2500) {
            retencion = 0.15f;
        } else {
            retencion = 0.18f;
        }

        return nominaBruta * (1 - retencion);
    }
}
