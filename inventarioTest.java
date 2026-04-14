package org.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

public class inventarioTest {
    private inventario inventario;

    @BeforeEach
    void setUp() {
        inventario = new inventario();
    }

    @Test
    @DisplayName("1. Agregar un producto nuevo y consultar su stock")
    void testAgregarProductoNuevo() {
        inventario.agregarProducto("Melón", 10);
        assertEquals(10, inventario.consultarStock("Melón"));
    }

    @Test
    @DisplayName("2. Incrementar stock de un producto existente")
    void testIncrementarStockExistente() {
        inventario.agregarProducto("Pera", 5);
        inventario.agregarProducto("Pera", 15);
        assertEquals(20, inventario.consultarStock("Pera"));
    }

    @Test
    @DisplayName("3. Eliminar una cantidad válida de producto")
    void testEliminarProductoValido() {
        inventario.agregarProducto("Uva", 50);
        inventario.eliminarProducto("Uva", 20);
        assertEquals(30, inventario.consultarStock("Uva"));
    }

    @Test
    @DisplayName("4. Agregar 0 productos (Límite inferior)")
    void testAgregarCeroProductos() {
        inventario.agregarProducto("Naranja", 0);
        assertEquals(0, inventario.consultarStock("Naranja"));
    }

    @Test
    @DisplayName("5. Sensibilidad a mayúsculas/minúsculas en el nombre")
    void testDiferenciaMayusculas() {
        inventario.agregarProducto("mango", 10);
        inventario.agregarProducto("MANGO", 5);
        // JUnit verifica que se traten como productos distintos
        assertNotEquals(inventario.consultarStock("mango"), inventario.consultarStock("MANGO"));
    }

    @Test
    @DisplayName("6. Consultar stock de un producto que no existe")
    void testConsultarProductoInexistente() {
        assertEquals(-1, inventario.consultarStock("Sandía"));
    }

    @Test
    @DisplayName("7. Error al agregar cantidad negativa")
    void testAgregarCantidadNegativa() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventario.agregarProducto("Plátano", -5);
        });
        assertEquals("La cantidad no puede ser negativa", exception.getMessage());
    }

    @Test
    @DisplayName("8. Error al usar nombre vacío o con espacios")
    void testNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventario.agregarProducto("   ", 10);
        });
    }

    @Test
    @DisplayName("9. Error al eliminar producto inexistente")
    void testEliminarInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            inventario.eliminarProducto("Kiwi", 1);
        });
    }

    @Test
    @DisplayName("10. Error al eliminar más de lo que hay en stock")
    void testEliminarExcesoStock() {
        inventario.agregarProducto("Cereza", 10);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inventario.eliminarProducto("Cereza", 11);
        });
        assertEquals("Cantidad a eliminar excede el stock", exception.getMessage());
    }
}