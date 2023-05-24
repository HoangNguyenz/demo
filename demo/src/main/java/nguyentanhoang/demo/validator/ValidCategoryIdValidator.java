package nguyentanhoang.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nguyentanhoang.demo.entity.Category;
import nguyentanhoang.demo.validator.annotation.ValidCategoryId;
public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId,Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext context){
        return category!= null && category.getId() !=null;
    }
}
