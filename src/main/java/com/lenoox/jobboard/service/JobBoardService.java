package com.lenoox.jobboard.service;

import com.lenoox.jobboard.model.AnalysisContainerDto;
import com.lenoox.jobboard.model.AnalysisDto;
import com.lenoox.jobboard.model.JobOfferDto;

import java.util.List;

public interface JobBoardService {

    public String saveJobOffer(JobOfferDto jobOfferDto);
    public AnalysisContainerDto countJobOfferByLocation();
}
