
package com.senac.projeto.camping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Reservas")
public class Reservas {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "id_hospede")
    private Hospedes hospede;
    private String checkin;
    private String checkout;
    private double valorDiaria;
    private int adulto;
    private int crianca;
    private boolean pet;
    private String equip;
    private String obs;

}
