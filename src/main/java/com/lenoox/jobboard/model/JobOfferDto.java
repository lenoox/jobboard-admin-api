package com.lenoox.jobboard.model;

import com.lenoox.jobboard.entities.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;
@Builder
@Data
public class JobOfferDto {
    private UUID id;
    private Integer version;
    @NotNull
    @NotBlank
    private String title;
    @NotNull
    @NotBlank
    private String description;
    private User customer;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}
