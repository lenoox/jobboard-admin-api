package com.lenoox.jobboard.controller;

import com.lenoox.jobboard.model.JobOfferDto;
import com.lenoox.jobboard.service.JobBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin(
        origins = "http://localhost:4200",
        allowedHeaders = "*",
        methods = { RequestMethod.GET }
)
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
public class JobOfferController {
    public static final String JOB_OFFER_PATH = "/api/v1/job-offer";
    public static final String JOB_OFFER_PATH_ID = JOB_OFFER_PATH + "/{jobOfferId}";
    public  final JobBoardService jobBoardService;

    @GetMapping(value = JOB_OFFER_PATH)
    public ResponseEntity listJobOffer(){
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping(JOB_OFFER_PATH)
    public ResponseEntity handlePost(@Validated @RequestBody JobOfferDto jobOfferDto){
        this.jobBoardService.saveJobOffer(jobOfferDto);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
