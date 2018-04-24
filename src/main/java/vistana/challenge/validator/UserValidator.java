package vistana.challenge.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import vistana.challenge.domain.SystemUser;

@Component
public class UserValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return SystemUser.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {

      ValidationUtils.rejectIfEmpty(err, "username", "username.empty");
      ValidationUtils.rejectIfEmpty(err, "dateOfBirth", "user.dob.empty");
      
      SystemUser user = (SystemUser) obj;
      Pattern pattern = Pattern.compile("[^a-zA-Z0-9]",
            Pattern.CASE_INSENSITIVE);
      if (!(pattern.matcher(user.getUsername()).matches())) {
         err.rejectValue("username", "username.invalid");
      }
      
      if (user.getUsername().length() < 5 || user.getUsername().length() > 12) {
          err.rejectValue("username", "username.invalid.length");
       }
      
      if (user.getDateOfBirth() == null) {
          err.rejectValue("dateOfBirth", "user.dob.empty");
       }

   }

}