package nguyentanhoang.demo.controller;


import jakarta.validation.Valid;
import nguyentanhoang.demo.entity.Category;

import nguyentanhoang.demo.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String showAllCategories(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);

        return "category/list";
    }

    @GetMapping("/add")
    public String addCategoryForm(Model model){
        model.addAttribute("category", new Category());

        return "category/add";
    }

    @PostMapping("/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category,
                              BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "category/add";
        }
        categoryService.addCategory(category);
        return "redirect:/categories";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    @GetMapping("/edit/{id}")
    public String editCategoryForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        return "category/edit";
    }

    @PostMapping("/edit/{id}")
    public String editCategory(@PathVariable("id") Long id,
                               @Valid @ModelAttribute("category") Category category,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "category/edit";
        }
        category.setId(id);
        categoryService.updateCategory(category);
        return "redirect:/categories";
    }
}

