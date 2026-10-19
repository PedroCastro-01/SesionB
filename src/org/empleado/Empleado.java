
package org.empleado;

public class Empleado {

    public enum TipoEmpleado {
        VENDEDOR, ENCARGADO
    }

    public static float calculoNominaBruta(
            TipoEmpleado tipo, float ventasMes, float horasExtra) {

        // Comprobación de datos no válidos
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de empleado no puede ser nulo");
        }

        if (ventasMes < 0) {
            throw new IllegalArgumentException("Las ventas no pueden ser negativas");
        }

        if (horasExtra < 0) {
            throw new IllegalArgumentException("Las horas extra no pueden ser negativas");
        }

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

        // Comprobación de nómina negativa
        if (nominaBruta < 0) {
            throw new IllegalArgumentException("La nómina bruta no puede ser negativa");
        }

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