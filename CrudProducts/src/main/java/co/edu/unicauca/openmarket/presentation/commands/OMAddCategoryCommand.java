/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.presentation.commands;

import java.util.List;

import co.edu.unicauca.openmarket.domain.Category;
import co.edu.unicauca.openmarket.domain.service.CategoryService;

/**
 *
 * @author ahurtado
 */
public class OMAddCategoryCommand extends OMCommand {

    private Category cP;
    private Category cR;
    private CategoryService cS;
    boolean result=false;
    public OMAddCategoryCommand(Category cP, CategoryService cS){
        this.cP = cP;
        this.cS = cS;
    }
    
    
    @Override
    public void make() {
        result = cS.saveCategory(cP.getName());
    }

    @Override
    public void unmake() {
        if (category != null) {
        List<Category> categories = cS.findAllCategories();
        for(Category each: categories){
            if(each.getName().equals(cP.getName())){
                result = cS.deleteCategory(each.getCategoryId());
            }
        }
    }

    @Override
    public void remake() {
    if (cR != null) {
        result = cS.saveCategory(cR.getName());
    }
    }
    
    public boolean result(){
        return result;
    }
    
    }
