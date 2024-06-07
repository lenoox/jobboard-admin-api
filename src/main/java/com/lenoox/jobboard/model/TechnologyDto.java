package com.lenoox.jobboard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Builder
@Data
public class TechnologyDto {
    private UUID id;
    @NotNull
    @NotBlank
    private String technology;
}
