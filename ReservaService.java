
package com.senac.projeto.camping.service;

import com.senac.projeto.camping.model.Reservas;
import com.senac.projeto.camping.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReservaService {
    
    @Autowired
    ReservaRepository reservaRepository;
    
    public List<Reservas> listarTodos(){
        return reservaRepository.findAll();
    }
    
    public Reservas buscarPorId (Integer id){
        return reservaRepository.findById(id).orElseThrow();
    }
    
    public Reservas criar(Reservas reserva){
        reserva.setId(0);
        reservaRepository.save(reserva);
        return reserva;
    }
    
    public List<Reservas> listar(Integer IdHospede){
        return reservaRepository.findByHospedeId(IdHospede);
    }
    
    public void excluir(Integer id){
        Reservas reservaEncontrada = buscarPorId(id);
        reservaRepository.deleteById(reservaEncontrada.getId());
    }
    
    public Reservas atualizar(Integer id, Reservas reservaEnviada){
        Reservas reservaEncontrada = buscarPorId(id);
        reservaEncontrada.setCheckin(reservaEnviada.getCheckin());
        reservaEncontrada.setCheckout(reservaEnviada.getCheckout());
        reservaEncontrada.setValorDiaria(reservaEnviada.getValorDiaria());
        reservaEncontrada.setAdulto(reservaEnviada.getAdulto());
        reservaEncontrada.setCrianca(reservaEnviada.getCrianca());
        reservaEncontrada.setEquip(reservaEnviada.getEquip());
        reservaEncontrada.setObs(reservaEnviada.getObs());
        reservaRepository.save(reservaEnviada);
        return reservaEnviada;
    }
}
