import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;
import co.edu.unicauca.openmarket.presentation.commands.OMEditProductCommand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class OMEditProductCommandTest {

    @Test
    void testMake() {
        // Arrange
        long productId = 1L;
        ProductService productService = mock(ProductService.class);
        Product existingProduct = new Product(productId, "Existing Product", "Existing Description", 10.0);
        Product newProduct = new Product(productId, "New Name", "New Description", 20.0);
        when(productService.findProductById(productId)).thenReturn(existingProduct);
        when(productService.editProduct(productId, newProduct)).thenReturn(true);
        OMEditProductCommand command = new OMEditProductCommand(productId, productService, "New Name", "New Description", 20.0);

        // Act
        command.make();

        // Assert
        //assertTrue(command.result());
        verify(productService, times(1)).findProductById(productId);
        //verify(productService, times(1)).editProduct(productId, newProduct);
    }

    @Test
    void testUnmake() {
        // Arrange
        long productId = 1L;
        ProductService productService = mock(ProductService.class);
        Product oldProduct = new Product(productId, "Old Name", "Old Description", 10.0);
        when(productService.editProduct(productId, oldProduct)).thenReturn(true);
        OMEditProductCommand command = new OMEditProductCommand(productId, productService, "New Name", "New Description", 20.0);
        command.setOldProduct(oldProduct);

        // Act
        command.unmake();

        // Assert
        assertTrue(command.result());
        verify(productService, times(1)).editProduct(productId, oldProduct);
    }

    @Test
    void testRemake() {
        // Arrange
        long productId = 1L;
        ProductService productService = mock(ProductService.class);
        Product oldProduct = new Product(productId, "Old Name", "Old Description", 10.0);
        Product newProduct = new Product(productId, "New Name", "New Description", 20.0);
        when(productService.editProduct(productId, newProduct)).thenReturn(true);
        OMEditProductCommand command = new OMEditProductCommand(productId, productService, "New Name", "New Description", 20.0);
        command.setNewProduct(newProduct);

        // Act
        command.remake();

        // Assert
        assertTrue(command.result());
        verify(productService, times(1)).editProduct(productId, newProduct);
    }
}
