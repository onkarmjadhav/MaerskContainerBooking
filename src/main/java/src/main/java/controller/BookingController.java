package src.main.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.model.BookingRequest;
import src.main.java.model.BookingResponse;
import src.main.java.model.Bookings;
import src.main.java.model.ContainerAvailableResponse;
import src.main.java.model.CustomerRequest;
import src.main.java.service.ContainerService;
import src.main.java.utils.ValidateUtils;

@RestController
@RequestMapping(path = "/api/bookings")
public class BookingController {
	
	@Autowired
	private ContainerService containerService;
	
	@ResponseBody
	@PostMapping(path= "/isContainerAvailable", consumes = "application/json", produces = "application/json")
    public ContainerAvailableResponse checkAvailable(@RequestBody CustomerRequest request) {
		
		ValidateUtils.validateInputs(request);
		
		boolean isAvailable = containerService.checkAvailable(request);
		
		ContainerAvailableResponse response = new ContainerAvailableResponse();
		response.setAvailable(isAvailable);
		
		return response;
		
	}
	
	@ResponseBody
	@PostMapping(path= "/isContainerAvailable", consumes = "application/json", produces = "application/json")
    public BookingResponse bookContainer(@RequestBody BookingRequest request) {
		
		ValidateUtils.validateInputs(request);
		
		Bookings bookingRef = containerService.bookContainer(request);
		
		BookingResponse response = new BookingResponse();
		response.setBookingRef(bookingRef.getId().toString());
		
		return response;
		
	}

}
