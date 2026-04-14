package org.example;

import java.util.HashMap;
import java.util.Map;

public class inventario
{

    // Atributos.
    private Map<String, Integer> productos; // Nombre del producto -> cantidad en stock.

    // Constructor.
    public inventario()
    {
        // Corrección: Usar HashMap en lugar de Map.
        this.productos = new HashMap<>();
    }

    // Agrega un producto con una cantidad inicial (lanza excepción si el nombre es vacío o la cantidad es negativa)

    /**
     * Agrega un producto con una cantidad inicial.
     *
     * @param nombre   Nombre del producto.
     * @param cantidad Cantidad inicial del producto.
     * @throws IllegalArgumentException Lanza una excepción si el nombre es vació o la cantidad es negativa.
     */
    public void agregarProducto(String nombre, int cantidad) throws IllegalArgumentException
    {
        if (nombre == null || nombre.trim().isEmpty())
        {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (cantidad < 0)
        {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        int stockActual = productos.getOrDefault(nombre, 0);
        productos.put(nombre, stockActual + cantidad);
    }

    /**
     * Elimina una cantidad de un producto.
     * @param nombre Nombre del producto.
     * @param cantidad Cantidad del producto.
     * @throws IllegalArgumentException Se lanza una excepción cuando el producto no existe o la cantidad es mayor a la cantidad en stock.
     */
    public void eliminarProducto(String nombre, int cantidad) throws IllegalArgumentException
    {
        if (!productos.containsKey(nombre))
        {
            throw new IllegalArgumentException("El producto no existe");
        }
        int stockActual = productos.get(nombre);
        if (cantidad > stockActual)
        {
            throw new IllegalArgumentException("Cantidad a eliminar excede el stock");
        }
        productos.put(nombre, stockActual - cantidad);
    }

    /**
     * Consulta el stock de un producto.
     * @param nombre Nombre del producto a consultar.
     * @return devuelve -1 si no existe
     */
    public int consultarStock(String nombre) {
        return productos.getOrDefault(nombre, -1);
    }
}