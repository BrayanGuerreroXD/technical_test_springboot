package com.nelumbo.test.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

import java.sql.Date;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle {

    @Id
    @SequenceGenerator(name="inscription_id_seq", allocationSize=1)
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="inscription_id_seq")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "id_parking")
    private Parking parking;

    @Column(name = "badge")
    private String badge;

    @Column(name = "date_entry")
    private Date dateEntry;

    @Column(name = "date_exit")
    private Date dateExit;
}
