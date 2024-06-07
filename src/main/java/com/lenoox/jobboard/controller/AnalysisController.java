package com.lenoox.jobboard.controller;

import com.lenoox.jobboard.model.JobOfferDto;
import com.lenoox.jobboard.service.JobBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
public class AnalysisController {
    public static final String JOB_OFFER_PATH = "/api/v1/analysis/location";
    public  final JobBoardService jobBoardService;

    @GetMapping(value = JOB_OFFER_PATH)
    public ResponseEntity countJobOfferByLocation(){
        return ResponseEntity.ok(this.jobBoardService.countJobOfferByLocation());
    }
}
