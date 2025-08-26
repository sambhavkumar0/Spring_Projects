package com.validate;

import com.model.Admission;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CustomValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Admission.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Admission admission = (Admission) target;

        if (!errors.hasFieldErrors("childName")) {
            if (!admission.getChildName().matches("^[a-zA-Z\\s]{2,}$")) {
                errors.rejectValue("childName", "childName.custom", "Name should contain only alphabets and spaces with a minimum of 2 characters");
            }
        }

        if (!errors.hasFieldErrors("contactNumber")) {
            if (!admission.getContactNumber().matches("^[6-9]\\d{9}$")) {
                errors.rejectValue("contactNumber", "contactNumber.custom", "Contact Number should be of 10 digits and start with a number between 6 and 9");
            }
}
}
}