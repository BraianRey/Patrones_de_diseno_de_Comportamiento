package co.edu.unicauca.openmarket.presentation.commands;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.CategoryService;

public class OMDeleteCategoryCommand extends OMCommand {

    private long productId;
    private CategoryService productService;
    private Category deletedCategory;
    private Category returnCategory;
    private boolean result;

    private long originalCategoryId; // Identificador original del producto eliminado

    public OMDeleteCategoryCommand(long productId, CategoryService productService) {
        this.productId = productId;
        this.originalCategoryId = productId; // Almacenamos el identificador original
        this.productService = productService;
    }

    @Override
    public void make() {
        deletedCategory = productService.findCategoryById(productId);
        result = productService.deleteCategory(productId);
    }

    @Override
    public void unmake() {
        result = productService.saveCategory(deletedCategory.getName());
    }

    @Override
    public void remake() {
        if (deletedCategory != null) {
            result = productService.deleteCategory(originalCategoryId); // Indica que la operación fue exitosa
        }
    }

    public boolean result() {
        return result;
    }

    public void setDeletedCategory(Category deletedCategory) {
        this.deletedCategory = deletedCategory;
    }
}
