package com.devsuperior.dsmeta.repositories;

import com.devsuperior.dsmeta.dto.SaleDTO;
import com.devsuperior.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;

public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT new com.devsuperior.dsmeta.dto.SaleDTO(s.id, s.date, s.amount, se.name) " +
            "FROM Sale s " +
            "JOIN s.seller se " +
            "WHERE s.date BETWEEN :startDate AND :endDate " +
            "AND UPPER(s.seller.name) LIKE  UPPER(CONCAT('%',:sellerName,'%'))")
    public Page<SaleDTO> getSaleReport(LocalDate startDate, LocalDate endDate, String sellerName, Pageable pageable);
}
