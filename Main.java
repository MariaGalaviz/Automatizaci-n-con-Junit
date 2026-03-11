package org.example;

public class Main {

    public double calcularTotalCompra (double precio, int cantidad){
        return precio * cantidad;
    }

    public double aplicarDescuento (double total, double porcentaje){
        if (porcentaje < 0) {
            throw new IllegalArgumentException("El descuento no puede ser negativo");
        }
        return total - (total * porcentaje / 100) ;
    }
}