package com.lenoox.jobboard.model;

import lombok.*;

import java.util.UUID;

@Builder
@Data
public class LocationDto {
    private UUID id;
    private String city;
}
