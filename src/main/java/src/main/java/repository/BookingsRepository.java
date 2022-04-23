package src.main.java.repository;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import src.main.java.model.Bookings;

@org.springframework.stereotype.Repository
public interface BookingsRepository extends CassandraRepository<Bookings, UUID> {
	
	

}
