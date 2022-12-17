package com.nelumbo.test.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name="parking")
@Data
public class Parking {

    @Id
    @SequenceGenerator(name="inscription_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inscription_id_seq")
    private Integer id;

    @OneToMany
    @JoinColumn(name = "id_partner")
    private Partner partner;

    @Column(name = "name")
    private String name;

    @Column(name = "addres")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "parking")
    private List<Vehicle> vehicles;
}
