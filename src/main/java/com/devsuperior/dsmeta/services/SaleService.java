package com.devsuperior.dsmeta.services;

import com.devsuperior.dsmeta.dto.SaleDTO;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;

	private LocalDate endDateOrDefault (String date) {
		return !date.isEmpty()
				? LocalDate.parse(date)
				: LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	}

	private LocalDate startDateOrDefault (String date, LocalDate endDate) {
		return !date.isEmpty()
				? LocalDate.parse(date)
				: endDate.minusYears(1L);
	}
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();

		return new SaleMinDTO(entity);
	}

	public Page<SaleDTO> getSaleReport (String minDate, String maxDate, String name, Pageable pageable) {
		LocalDate endDate = this.endDateOrDefault(maxDate);
		LocalDate startDate = this.startDateOrDefault(minDate, endDate);

		return this.repository.getSaleReport(startDate, endDate, name, pageable);
	}

	public List<SaleSummaryDTO> getSaleSummary (String minDate, String maxDate) {
		LocalDate endDate = this.endDateOrDefault(maxDate);
		LocalDate startDate = this.startDateOrDefault(minDate, endDate);

		return this.repository.getSaleSummary(startDate, endDate);
	}
}
