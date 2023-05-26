package co.edu.unicauca.openmarket.presentation.commands;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.CategoryService;

/**
 * Comando para editar un category en el sistema.
 */
public class OMEditCategoryCommand extends OMCommand {

    private long categoryId;
    private CategoryService categoryService;
    private Category oldCategory;
    private Category newCategory;
    private boolean result;

    public OMEditCategoryCommand(long categoryId, CategoryService categoryService, String newName) {
        this.categoryId = categoryId;
        this.categoryService = categoryService;
        this.newCategory = new Category(categoryId, newName);
    }

    @Override
    public void make() {
        oldCategory = categoryService.findCategoryById(categoryId);
        if (oldCategory != null) {
            result = categoryService.editCategory(categoryId, newCategory);
        }
    }

    @Override
    public void unmake() {
        // Restaurar el categoryo original
        if (oldCategory != null) {
            result = categoryService.editCategory(categoryId, oldCategory);
        }
    }

    @Override
    public void remake() {
        if (newCategory != null) {
            result = categoryService.editCategory(categoryId, newCategory);
        }
    }

    public boolean result() {
        return result;
    }

    public void setOldCategory(Category oldCategory) {
        this.oldCategory = oldCategory;
    }

    public void setNewCategory(Category newCategory) {
        this.newCategory = newCategory;
    }
}
