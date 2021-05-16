package com.icarus.v0.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.icarus.v0.entities.Country;
import com.icarus.v0.entities.DataPoint;

public interface CountryService {

	public abstract List<Country> listCountries() ;


	public abstract Country listCountry(Long id) ;
	

	public abstract List<DataPoint> listCountryDataPoints(Long id) ;


	public abstract Country createCountry(Country country) ;


	public abstract Country updateCountry(Long id,Country country) ;


	public abstract ResponseEntity<?> deleteCountry(Long id);
}
