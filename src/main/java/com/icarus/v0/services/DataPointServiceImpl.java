package com.icarus.v0.services;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.icarus.v0.entities.City;
import com.icarus.v0.entities.Country;
import com.icarus.v0.entities.DataPoint;
import com.icarus.v0.entities.OpenWeatherResponse;
import com.icarus.v0.entities.State;
import com.icarus.v0.exception.ResourceNotFoundException;
import com.icarus.v0.repository.CityRepo;
import com.icarus.v0.repository.CountryRepo;
import com.icarus.v0.repository.DataPointRepo;
import com.icarus.v0.repository.StateRepo;

@Service
public class DataPointServiceImpl implements DataPointService {

	private final DataPointRepo dataPointRepo;
	private final CityRepo cityRepo;
	private final CountryRepo countryRepo;
	private final StateRepo stateRepo;
	private RestTemplate restTemplate;
	private EmailServiceImpl emailService;
	private ClickSendServiceImpl smsService;
	@Value("${radiatin.api.endpoint}")
	private String endpoint;
	@Value("${radiatin.api.apiKey}")
	private String apiKey;

	@Autowired
	public DataPointServiceImpl(DataPointRepo dataPointRepo, CityRepo cityRepo, CountryRepo countryRepo,
			StateRepo stateRepo, EmailServiceImpl emailService, RestTemplateBuilder restTemplateBuilder,
			ClickSendServiceImpl smsService) {
		this.dataPointRepo = dataPointRepo;
		this.cityRepo = cityRepo;
		this.countryRepo = countryRepo;
		this.stateRepo = stateRepo;
		this.emailService = emailService;
		this.smsService = smsService;
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public List<DataPoint> getAllDataPoints() {
		return (List<DataPoint>) dataPointRepo.findAll();
	}

	@Override
	public Optional<DataPoint> getDataPoint(Long id) {
		return (dataPointRepo.findById(id));
	}

	@Override
	public DataPoint createDataPoint(Long countryId, Long stateId, Long cityId, DataPoint dataPoint) {
		if (!countryRepo.existsById(countryId)) {
			throw new ResourceNotFoundException("Country ID " + countryId + "not found");
		}
		if (!stateRepo.existsById(stateId)) {
			throw new ResourceNotFoundException("State ID " + stateId + "not found");
		}
		if (!cityRepo.existsById(cityId)) {
			throw new ResourceNotFoundException("City ID " + cityId + "not found");
		}

		final Country country = countryRepo.findById(countryId).get();
		dataPoint.setCountry(country);
		final State state = stateRepo.findById(stateId).get();
		dataPoint.setState(state);
		final City city = cityRepo.findById(cityId).get();
		dataPoint.setCity(city);

		final String URL = endpoint;
		Map<String, Object> uriVariables = new HashMap<>();
		uriVariables.put("lat", dataPoint.getCity().getLat());
		uriVariables.put("lon", dataPoint.getCity().getLon());
		uriVariables.put("API key", apiKey);
		ResponseEntity<OpenWeatherResponse> response = restTemplate.getForEntity(URL, OpenWeatherResponse.class,
				uriVariables);
		System.out.println(response.getBody().getList().get(0).getRadiation().getGhi());
		Double a = (int) (dataPoint.getArea() / 1.63548) * 1.63548;
		dataPoint.setEnergy(
				a * 0.75 * 0.175 * ((response.getBody().getList().get(0).getRadiation().getGhi()) / 1000) * 24);

		LocalDate currentdate = LocalDate.now();
		LocalDate summerStart = LocalDate.of(currentdate.getYear(), Month.MAY, 1);
		LocalDate summerFinish = LocalDate.of(currentdate.getYear(), Month.SEPTEMBER, 30);
        Double consumption = dataPoint.getBillAmount() / 365;
        
		 if(currentdate.isAfter(summerStart) && currentdate.isBefore(summerFinish) ) 
		 {
			 consumption = consumption * 1.5;
		 }

		if (dataPoint.getEmail() != null) {
			emailService.sendEmail(dataPoint.getEmail(),
					String.valueOf(new DecimalFormat("##.##").format(consumption / 0.21)),
					String.valueOf(new DecimalFormat("##.##").format(consumption)),
					String.valueOf(new DecimalFormat("##.##").format(dataPoint.getEnergy() * 0.21)));
		}
		if (dataPoint.getPhone() != null) {
			smsService.sendSms(dataPoint.getEmail(),
					String.valueOf(new DecimalFormat("##.##").format(consumption / 0.21)),
					String.valueOf(new DecimalFormat("##.##").format(consumption)),
					String.valueOf(new DecimalFormat("##.##").format(dataPoint.getEnergy() * 0.21)),
					dataPoint.getPhone());
		}
		dataPointRepo.save(dataPoint);

		return dataPoint;
	}

	@Override
	public DataPoint updateDataPoint(Long id, Long countryId, Long stateId, Long cityId, DataPoint dataPoint) {
		if (!countryRepo.existsById(countryId)) {
			throw new ResourceNotFoundException("Country ID " + countryId + " not found");
		}
		if (!stateRepo.existsById(stateId)) {
			throw new ResourceNotFoundException("State ID " + stateId + " not found");
		}
		if (!cityRepo.existsById(cityId)) {
			throw new ResourceNotFoundException("City ID " + cityId + " not found");
		}
		return dataPointRepo.findById(id).map(dp -> {

			dp.setBillAmount(dataPoint.getBillAmount());

			dp.setPeriod(dataPoint.getPeriod());

			dp.setPhone(dataPoint.getPhone());

			dp.setEmail(dataPoint.getEmail());

			dp.setArea(dataPoint.getArea());

			return dataPointRepo.save(dataPoint);
		}).orElseThrow(() -> new ResourceNotFoundException("Data Point ID " + id + " not found"));
	}

	@Override
	public ResponseEntity<?> deleteDataPoint(Long id) {
		return dataPointRepo.findById(id).map(dataPoint -> {
			dataPointRepo.delete(dataPoint);
			return ResponseEntity.ok().body("Data Point with ID " + id + " deleted");
		}).orElseThrow(() -> new ResourceNotFoundException("Data Point ID " + id + " was not found"));
	}

}
