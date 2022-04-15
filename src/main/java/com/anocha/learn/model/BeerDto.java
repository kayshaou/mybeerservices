package com.anocha.learn.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Getter
@Setter
public class BeerDto implements Serializable {
    @NotNull
    private UUID id;
    @NotNull
    private Integer version;
    @NotNull
    private OffsetDateTime createdDatetime;
    @NotNull
    private OffsetDateTime lastModified;

    @NotBlank
    private String beerName;
    @NotNull
    private BeerStyleEnum beerStyle;

    @Positive
    @NotNull
    private Long upc;
    @Positive
    @NotNull
    private BigDecimal price;
    @Positive
    @NotNull
    private Integer quantityOnHand;


}
