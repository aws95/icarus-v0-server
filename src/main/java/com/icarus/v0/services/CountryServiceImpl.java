package com.icarus.v0.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.icarus.v0.entities.Country;
import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.CountryRepo;

@Service
public class CountryServiceImpl implements CountryService{
	private final CountryRepo countryRepo;

	@Autowired
	public CountryServiceImpl(CountryRepo countryRepo) {
		this.countryRepo = countryRepo;
	}

	@Override
	public List<Country> listCountries() {
		return (List<Country>) countryRepo.findAll();
	}

	@Override
	public Country listCountry(Long id) {
		return countryRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Country ID " + id + " not found"));
	}

	@Override
	public List<DataPoint> listCountryDataPoints(Long id) {
		return countryRepo.findDataPointsByCountry(id);
	}

	@Override
	public Country createCountry(Country country) {
		return countryRepo.save(country);
	}

	@Override
	public Country updateCountry(Long id, Country country) {
		return countryRepo.findById(id).map(c -> {
			
		      
			c.setCountryId(country.getCountryId()) ;
				
			c.setIso(country.getIso());
				
			c.setName(country.getName() );
				
			c.setNicename(country.getNicename()) ;
				
			c.setIso3(country.getIso3());
				
			c.setNumcode(country.getNumcode()) ;
				
			c.setPhonecode(country.getPhonecode());

			return countryRepo.save(country);
		}).orElseThrow(() -> new ResourceNotFoundException("Country ID " + id + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteCountry(Long id) {
		return countryRepo.findById(id).map(contry -> {
			countryRepo.delete(contry);
			return ResponseEntity.ok().body("Country with ID "+ id + " was deleted");
		}).orElseThrow(() -> new ResourceNotFoundException("Country ID " + id + " not found"));
	}
}
