package com.example.batispro.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Equipment {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;


    private Integer serialNumber;

    private String name;

    @ManyToOne
    private Category category;

    private Integer quantity;

    private Double rentalCost;

    private String details;

}
