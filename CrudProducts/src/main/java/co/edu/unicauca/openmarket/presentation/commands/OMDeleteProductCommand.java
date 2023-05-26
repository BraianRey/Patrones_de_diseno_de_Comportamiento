package co.edu.unicauca.openmarket.presentation.commands;

import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;

public class OMDeleteProductCommand extends OMCommand {

    private long productId;
    private ProductService productService;
    private Product deletedProduct;
    private Product returnProduct;
    private boolean result;

    private long originalProductId; // Identificador original del producto eliminado

    public OMDeleteProductCommand(long productId, ProductService productService) {
        this.productId = productId;
        this.productService = productService;
    }

    @Override
    public void make() {
        deletedProduct = productService.findProductById(productId);
        result = productService.deleteProduct(productId);
    }

    @Override
    public void unmake() {
        result = productService.saveProduct(deletedProduct.getName(), deletedProduct.getDescription());
        result = true;
    }

    @Override
    public void remake() {
        if (deletedProduct != null) {
            result = productService.deleteProduct(deletedProduct.getProductId()); // Indica que la operación fue exitosa
        }
    }

    public boolean result() {
        return result;
    }

    public void setDeletedProduct(Product deletedProduct) {
        this.deletedProduct = deletedProduct;
    }
}
