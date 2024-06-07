package com.lenoox.jobboard.model;

import com.lenoox.jobboard.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

public interface AnalysisDto {
   String getCity();
   Long getJobOfferCount();
}
