package co.edu.unicauca.openmarket.presentation.commands;

import java.util.List;

import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;

/**
 *
 * @author BRey
 */
public class OMDeleteProductCommand extends OMCommand {

    private ProductService productService;
    private Product deletedProduct;
    private Product product;
    private boolean result;


    public OMDeleteProductCommand(Long productID, ProductService productService) {
        this.productService = productService;
        this.product = productService.findProductById(productID);
    }

    @Override
    public void make() {
        List<Product> products = productService.findAllProducts();
        for(Product each: products){
            if(each.getName().equals(product.getName())){
                //!Configurar para eliminado unico, se uso por alternatica para la simulacion
                //ya que el id aumenta cada vez mas
                deletedProduct = each;
                result = productService.deleteProduct(each.getProductId());
            }
        }
    }

    @Override
    public void unmake() {
        result = productService.saveProduct(deletedProduct.getName(), deletedProduct.getDescription());
    }

    @Override
    public void remake() {
        List<Product> products = productService.findAllProducts();
        for(Product each: products){
            if(each.getName().equals(deletedProduct.getName())){
                //!Configurar para eliminado unico, se uso por alternatica para la simulacion
                //ya que el id aumenta cada vez mas
                result = productService.deleteProduct(each.getProductId());
            }
        }
    }

    public boolean result() {
        return result;
    }

    public void setDeletedProduct(Product deletedProduct) {
        this.deletedProduct = deletedProduct;
    }
}
