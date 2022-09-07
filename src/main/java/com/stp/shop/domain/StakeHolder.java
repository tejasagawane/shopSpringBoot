package com.stp.shop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "stake_holder")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StakeHolder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stake_holder_id")
    private long id;
    private String name;
    private LocalDate billDate;
    private LocalDate paidDate;
    private long billAmount;
    private long paidAmount;
}
