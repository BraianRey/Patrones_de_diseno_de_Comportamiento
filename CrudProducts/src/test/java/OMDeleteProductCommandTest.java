import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.presentation.commands.OMDeleteProductCommand;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OMDeleteProductCommandTest {

    @Test
    void testMake() {
        // Arrange
        long productId = 1L;
        ProductService productService = Mockito.mock(ProductService.class);
        Product deletedProduct = new Product(productId, "Test Product", "Test Description", 10.0);
        when(productService.findProductById(productId)).thenReturn(deletedProduct);

        OMDeleteProductCommand command = new OMDeleteProductCommand(productId, productService);

        // Act
        command.make();

        // Assert
        verify(productService, times(1)).deleteProduct(productId);
    }

    @Test
    void testUnmake() {
        // Arrange
        long productId = 1L;
        ProductService productService = Mockito.mock(ProductService.class);
        Product deletedProduct = new Product(productId, "Test Product", "Test Description", 10.0);
        when(productService.saveProduct(deletedProduct.getName(), deletedProduct.getDescription())).thenReturn(true);

        OMDeleteProductCommand command = new OMDeleteProductCommand(productId, productService);
        command.setDeletedProduct(deletedProduct);

        // Act
        command.unmake();

        // Assert
        verify(productService, times(1)).saveProduct(deletedProduct.getName(), deletedProduct.getDescription());
    }

    /*@Test
    void testRemake() {
        // Arrange
        long productId = 1L;
        ProductService productService = mock(ProductService.class);
        Product product = new Product(productId, "Test Product", "Test Description", 10.0);
        when(productService.findProductById(productId)).thenReturn(product);
        OMDeleteProductCommand command = new OMDeleteProductCommand(productId, productService);
    
        // Act
        command.make();
        command.unmake();
        command.remake();
    
        // Assert
        assertTrue(command.result());
        //verify(productService, times(2)).deleteProduct(productId);
    }*/

    @Test
    void testResult() {
        // Arrange
        long productId = 1L;
        ProductService productService = Mockito.mock(ProductService.class);

        OMDeleteProductCommand command = new OMDeleteProductCommand(productId, productService);

        // Act
        boolean result = command.result();

        // Assert
        assertFalse(result);
    }
}
