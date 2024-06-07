package com.lenoox.jobboard.service;

import com.lenoox.jobboard.entities.JobOffer;
import com.lenoox.jobboard.mapper.JobOfferMapper;
import com.lenoox.jobboard.model.AnalysisContainerDto;
import com.lenoox.jobboard.model.AnalysisDto;
import com.lenoox.jobboard.model.JobOfferDto;
import com.lenoox.jobboard.repository.JobOfferRepository;
import jdk.swing.interop.SwingInterOpUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class JobBoardServiceImpl implements JobBoardService  {
    private final JobOfferRepository jobOfferRepository;
    @Override
    public String saveJobOffer(JobOfferDto jobOfferDto) {
        JobOfferMapper jobOfferMapper= new JobOfferMapper();
        jobOfferRepository.save(jobOfferMapper.jobOfferDtoToJobOffer(jobOfferDto));
        return "OK";
    }
    public AnalysisContainerDto countJobOfferByLocation(){
        List<AnalysisDto> analysisDto= jobOfferRepository.countJobOffersByLocation();
        AnalysisDto analysisDtoMax = Collections.max(analysisDto, Comparator.comparing(c -> c.getJobOfferCount()));
        AnalysisContainerDto analysisContainerDto =  AnalysisContainerDto.builder()
                .data(analysisDto)
                .max(analysisDtoMax.getJobOfferCount())
                .build();
        return analysisContainerDto;
    }
}
