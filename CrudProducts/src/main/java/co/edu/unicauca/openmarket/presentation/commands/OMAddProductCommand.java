/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.presentation.commands;

import co.edu.unicauca.openmarket.domain.Product;
import co.edu.unicauca.openmarket.domain.service.ProductService;

/**
 *
 * @author ahurtado
 */
public class OMAddProductCommand extends OMCommand {

    private Product pP;
    private Product pR;
    private ProductService pS;
    boolean result=false;
    public OMAddProductCommand(Product pP, ProductService pS){
        this.pP = pP;
        this.pS = pS;
    }
    
    
    @Override
    public void make() {
        result = pS.saveProduct(pP.getName(), pP.getDescription());
    }

    @Override
    public void unmake() {
    if (pP != null) {
        Product product = pS.findProductById(pP.getProductId());
        if (product != null) {
            this.pR = new Product(product.getProductId(), product.getName(), product.getDescription(), product.getPrice());
            result = pS.deleteProduct(product.getProductId());
        }
        }
    }

    @Override
    public void remake() {
    if (pR != null) {
        result = pS.saveProduct(pR.getName(), pR.getDescription());
    }
    }
    
    public boolean result(){
        return result;
    }
    
    }
