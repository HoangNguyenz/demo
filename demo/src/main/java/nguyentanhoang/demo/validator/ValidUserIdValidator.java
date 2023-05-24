package nguyentanhoang.demo.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import nguyentanhoang.demo.entity.User;
import nguyentanhoang.demo.validator.annotation.ValidUserId;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user==null)
            return true;
        return user.getId()!=null;
    }
}
