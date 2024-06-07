package com.lenoox.jobboard.mapper;

import com.lenoox.jobboard.entities.JobOffer;
import com.lenoox.jobboard.model.JobOfferDto;

public class JobOfferMapper {
    public static JobOffer jobOfferDtoToJobOffer(JobOfferDto jobOfferDto){
        return JobOffer.builder()
                .id(jobOfferDto.getId())
                .version(jobOfferDto.getVersion())
                .title(jobOfferDto.getTitle())
                .description(jobOfferDto.getDescription())
                //.user(jobOfferDto.getCustomer())
                .createdDate(jobOfferDto.getCreatedDate())
                .updateDate(jobOfferDto.getUpdateDate())
                .build();
    }

    public static JobOfferDto jobOfferToJobOfferDto(JobOffer jobOffer){
        return JobOfferDto.builder()
                .id(jobOffer.getId())
                .version(jobOffer.getVersion())
                .title(jobOffer.getTitle())
                .description(jobOffer.getDescription())
                //.customer(jobOffer.getUser())
                .createdDate(jobOffer.getCreatedDate())
                .updateDate(jobOffer.getUpdateDate())
                .build();
    }
}
