package src.main.java.utils;

import org.springframework.util.StringUtils;

import src.main.java.model.CustomerRequest;

public class ValidateUtils {
	
	public static void validateInputs(CustomerRequest request) {
		
		if(StringUtils.isEmpty(request.getOrigin())) {
			throw new RuntimeException("Origin can not be empty");
		}
		
		if(StringUtils.isEmpty(request.getDestination())) {
			throw new RuntimeException("Destination can not be empty");
		}
		
		if(request.getContainerType().getType() == null) {
			throw new RuntimeException("Container Type can not be empty");
		}
		
		if(request.getContainerType().getType() == null) {
			throw new RuntimeException("Container Type can not be empty");
		}
		
		if(request.getContainerSize() != 20 || request.getContainerSize() != 40) {
			throw new RuntimeException("Container size should be either 20 or 40");
		}
		
		if(request.getQuantity() < 0 || request.getQuantity() > 100) {
			throw new RuntimeException("Quantity should be between 1 & 100");
		}
		
	}

}
