
package com.senac.projeto.camping.repository;

import com.senac.projeto.camping.model.Hospedes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HospedeRepository extends JpaRepository<Hospedes, Integer>{
    
}
