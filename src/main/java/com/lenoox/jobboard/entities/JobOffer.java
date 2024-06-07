package com.lenoox.jobboard.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_offer")
public class JobOffer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @JdbcTypeCode(SqlTypes.CHAR)
    @Column(length = 36, columnDefinition = "varchar(36)", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @NotNull
    @NotBlank
    @Size(max = 80)
    @Column(length = 80)
    private String title;

    @NotNull
    @NotBlank
    @Size(max = 1400)
    @Column(length = 1400)
    private String description;

    @ManyToOne
   // @JoinColumn(name="user_id", nullable=false)
    @JoinColumn(name="user_id", nullable=true)
    private User user;

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "job_offer_location",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> categories = new HashSet<>();

    @Builder.Default
    @ManyToMany
    @JoinTable(name = "job_offer_technology",
            joinColumns = @JoinColumn(name = "job_offer_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id"))
    private Set<Location> technology = new HashSet<>();

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updateDate;
}
