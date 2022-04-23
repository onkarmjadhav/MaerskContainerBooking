package src.main.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.datastax.oss.driver.api.core.uuid.Uuids;

import src.main.java.model.Available;
import src.main.java.model.BookingRequest;
import src.main.java.model.Bookings;
import src.main.java.model.CustomerRequest;
import src.main.java.repository.BookingsRepository;
import src.main.java.utils.BookingUtils;

@Component
public class ContainerService {
	
	@Autowired
	private BookingsRepository repository;
	
	public boolean checkAvailable(CustomerRequest request) {
		
	    RestTemplate restTemplate = new RestTemplate();
	    Available result = restTemplate.getForObject(BookingUtils.CHECK_CONTAINER_AVAILABILITY_URL, Available.class);
	    
	    System.out.print("Available space: "+ result.getAvailableSpace());
	    
	    if(result.getAvailableSpace() == 0) {
	    	return false;
	    }
		
		return true;
	}
	
	public Bookings bookContainer(BookingRequest request) {
		
		try {
		    Bookings booking = repository.save(new Bookings(Uuids.timeBased(), request.getContainerSize(), 
		    		request.getContainerType(), request.getOrigin(), request.getDestination(),
		    		request.getQuantity(), request.getTimeStamp()));
		    return booking;
		  } catch (Exception e) {
		    throw new RuntimeException("Internal Server Error");
		  }
	}

}
