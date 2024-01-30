
package com.senac.projeto.camping.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "Hospedes")
public class Hospedes {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;
    private String nome;
    private String CPF;
    private String telefone;
    private String cidade;
    private String pais;
    
}
