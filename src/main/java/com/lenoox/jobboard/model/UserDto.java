package com.lenoox.jobboard.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
public class UserDto {
    private UUID id;
    private String name;
    private String email;
    private Integer version;
    private LocalDateTime createdDate;
    private LocalDateTime updateDate;
}