package tk.leooresende.stateful.infra.util.factory;

import javax.validation.Validation;
import javax.validation.Validator;

public class ValidatorFactory {
	
	public static Validator getValidator() {
		javax.validation.ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		return factory.getValidator();
	}
}
