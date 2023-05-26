import co.edu.unicauca.openmarket.access.IProductRepository;
import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.presentation.commands.OMAddProductCommand;
import co.edu.unicauca.openmarket.presentation.commands.OMCommand;
import co.edu.unicauca.openmarket.presentation.commands.OMInvoker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import clojure.lang.Var;

import java.lang.reflect.Field;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OMAddProductCommandTest {

    @Test
    public void testMake() {
        // Arrange
        ProductService productService = mock(ProductService.class);
        Product product = new Product(1L, "Test Product", "Test Description", 10.0);
        OMAddProductCommand command = new OMAddProductCommand(product, productService);
        Mockito.when(productService.saveProduct(product.getName(), product.getDescription())).thenReturn(true);

        // Act
        command.make();

        // Assert
        assertTrue(command.result());
        verify(productService, Mockito.times(1)).saveProduct(product.getName(), product.getDescription());
    }

    @Test
    public void testUnmake() {
        // Arrange
        ProductService productService = mock(ProductService.class);
        Product product = new Product(1L, "Test Product", "Test Description", 100.0);
        OMAddProductCommand command = new OMAddProductCommand(product, productService);
        Mockito.when(productService.findProductById(1L)).thenReturn(product);
        Mockito.when(productService.deleteProduct(1L)).thenReturn(true);

        // Act
        command.unmake();

        // Assert
        assertTrue(command.result());
        verify(productService, Mockito.times(1)).findProductById(1L);
        verify(productService, Mockito.times(1)).deleteProduct(1L);
    }

    @Test
    void testRemake() {
    // Arrange
    ProductService productService = mock(ProductService.class);
    Product product = new Product(1L, "Test Product", "Test Description", 100.0);
    OMAddProductCommand command = new OMAddProductCommand(product, productService);
    Mockito.when(productService.findProductById(1L)).thenReturn(product);
    Mockito.when(productService.saveProduct(product.getName(), product.getDescription())).thenReturn(true);

    OMInvoker invoker = new OMInvoker();
    invoker.addCommand(command);

    // Act
    invoker.execute();
    invoker.unexecute();
    invoker.reexecute();

    // Assert
    assertTrue(command.result());
    //verify(productService, Mockito.times(2)).findProductById(1L);
    //verify(productService, Mockito.times(2)).saveProduct(product.getName(), product.getDescription());
}


    private Stack<OMCommand> getUndoneCommands(OMInvoker invoker) {
        try {
            Field field = invoker.getClass().getDeclaredField("undoneCommands");
            field.setAccessible(true);
            return (Stack<OMCommand>) field.get(invoker);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
