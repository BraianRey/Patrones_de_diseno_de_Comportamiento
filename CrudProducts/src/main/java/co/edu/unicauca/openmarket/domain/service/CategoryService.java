package co.edu.unicauca.openmarket.domain.service;

import co.edu.unicauca.openmarket.access.ICategoryRepository;
import co.edu.unicauca.openmarket.domain.Category;
import java.util.ArrayList;
import java.util.List;
import reloj.frameworkobsobs.Observado;
/**
 *
 * @author BRey
 */
public class CategoryService extends Observado{

    // Ahora hay una dependencia de una abstracción, no es algo concreto,
    // no sabe cómo está implementado.
    private static ICategoryRepository repository;

    /**
     * Inyección de dependencias en el constructor. Ya no conviene que el mismo
     * servicio cree un repositorio concreto
     *
     * @param repository una clase hija de ICategoryRepository
     */
    public CategoryService(ICategoryRepository repository) {
        this.repository = repository;
    }


    public boolean saveCategory(String name) {
        
        Category newCategory = new Category();
        newCategory.setName(name);
        
        //Validate Category
        if (newCategory.getName().isBlank() ) {
            return false;
        }

        return repository.save(newCategory);

    }

    public List<Category> findAllCategories() {
        List<Category> categories = new ArrayList<>();
        categories = repository.findAll();

        return categories;
    }
    
    public static Category findCategoryById(Long id){
        return repository.findById(id);
    }
    
    public Category findCategoryByName(String name){
        return repository.findByName(name);
    }
    
    public boolean deleteCategory(Long id){
        return repository.delete(id);
    }

    public boolean editCategory(Long categoryId, Category cat) {
        
        //Validate Category
        if (cat == null || cat.getName().isBlank() ) {
            return false;
        }
        return repository.edit(categoryId, cat);
    }

}
