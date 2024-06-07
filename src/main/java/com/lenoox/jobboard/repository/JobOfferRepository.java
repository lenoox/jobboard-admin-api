package com.lenoox.jobboard.repository;
import com.lenoox.jobboard.entities.JobOffer;
import com.lenoox.jobboard.model.AnalysisDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;
public interface JobOfferRepository extends JpaRepository<JobOffer, UUID> {
    @Query(value="SELECT LOCATION.CITY as city, COUNT(JOB_OFFER.ID) as jobOfferCount FROM JOB_OFFER JOIN JOB_OFFER_LOCATION ON (JOB_OFFER.ID = JOB_OFFER_LOCATION.JOB_OFFER_ID)  JOIN LOCATION ON (LOCATION.ID = JOB_OFFER_LOCATION.LOCATION_ID ) GROUP BY LOCATION.CITY", nativeQuery = true
    )
    List<AnalysisDto> countJobOffersByLocation();
}