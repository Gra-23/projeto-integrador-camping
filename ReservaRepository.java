
package com.senac.projeto.camping.repository;

import com.senac.projeto.camping.model.Reservas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservaRepository extends JpaRepository<Reservas, Integer>{
    
    List<Reservas> findByHospedeId(Integer IdHospede);
    
}
