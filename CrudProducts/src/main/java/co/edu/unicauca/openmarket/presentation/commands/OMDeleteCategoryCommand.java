package co.edu.unicauca.openmarket.presentation.commands;

import java.util.List;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.CategoryService;

/**
 *
 * @author BRey
 */
public class OMDeleteCategoryCommand extends OMCommand {

    private CategoryService categoryService;
    private Category deletedCategory;
    private Category category;
    private boolean result;


    public OMDeleteCategoryCommand(Long categoryID, CategoryService categoryService) {
        this.categoryService = categoryService;
        this.category = categoryService.findCategoryById(categoryID);
    }

    @Override
    public void make() {
        List<Category> categories = categoryService.findAllCategories();
        for(Category each: categories){
            if(each.getName().equals(category.getName())){
                //!Configurar para eliminado unico, se uso por alternatica para la simulacion
                //ya que el id aumenta cada vez mas
                deletedCategory = each;
                result = categoryService.deleteCategory(each.getCategoryId());
            }
        }
    }

    @Override
    public void unmake() {
        result = categoryService.saveCategory(deletedCategory.getName());
    }

    @Override
    public void remake() {
        List<Category> categories = categoryService.findAllCategories();
        for(Category each: categories){
            if(each.getName().equals(deletedCategory.getName())){
                //!Configurar para eliminado unico, se uso por alternatica para la simulacion
                //ya que el id aumenta cada vez mas
                result = categoryService.deleteCategory(each.getCategoryId());
            }
        }
    }

    public boolean result() {
        return result;
    }

    public void setDeletedCategory(Category deletedCategory) {
        this.deletedCategory = deletedCategory;
    }
}
