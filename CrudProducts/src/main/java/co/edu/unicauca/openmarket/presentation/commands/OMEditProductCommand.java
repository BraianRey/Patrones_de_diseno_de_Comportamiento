package co.edu.unicauca.openmarket.presentation.commands;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.CategoryService;
import co.edu.unicauca.openmarket.domain.service.ProductService;

/**
 *
 * @author BRey
 */
public class OMEditProductCommand extends OMCommand {

    private long productId;
    private ProductService productService;
    private CategoryService categoryService;
    private Product oldProduct;
    private Product newProduct;
    private boolean result;

    public OMEditProductCommand(long productId, ProductService productService, String newName, String newDescription, double newPrice) {
        this.productId = productId;
        this.productService = productService;
        this.newProduct = new Product(productId, newName, newDescription, newPrice);
    }

    public OMEditProductCommand(long productId, ProductService productService, CategoryService categoryService , String newName, String newDescription, double newPrice, Category category) {
        this.productId = productId;
        this.productService = productService;
        this.categoryService = categoryService;
        this.newProduct = new Product(productId, newName, newDescription, newPrice);
        this.newProduct.setCategory(category);
    }

    @Override
    public void make() {
        oldProduct = productService.findProductById(productId);
        if (oldProduct != null) {
            if (newProduct.getCategory() != null) {
                Category category = categoryService.findCategoryByName(newProduct.getCategory().getName());
                newProduct.setCategory(category);
                // Copia la categoría del nuevo producto al producto existente
                result = productService.editProduct(productId, newProduct);          
            } else {
                // Si la categoría es nula, intenta editar el producto sin especificar la categoría
                result = productService.editProduct(productId, newProduct);
            }
        }
    }

    @Override
    public void unmake() {
        // Restaurar el producto original
        if (oldProduct != null) {
            Category category = oldProduct.getCategory();
            if (category != null) {
                result = productService.editProduct(productId, oldProduct, oldProduct.getCategory());
            } else {
                result = productService.editProduct(productId, oldProduct);
            }
        }
    }

    @Override
    public void remake() {
        if (oldProduct != null) {
            if (newProduct.getCategory() != null) {
                result = productService.editProduct(productId, newProduct, newProduct.getCategory());
            } else {
                result = productService.editProduct(productId, newProduct);
            }
        }
    }

    public boolean result() {
        return result;
    }

    public void setOldProduct(Product oldProduct) {
        this.oldProduct = oldProduct;
    }

    public void setNewProduct(Product newProduct) {
        this.newProduct = newProduct;
    }
}
