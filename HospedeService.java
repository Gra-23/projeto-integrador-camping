
package com.senac.projeto.camping.service;

import com.senac.projeto.camping.model.Hospedes;
import com.senac.projeto.camping.repository.HospedeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HospedeService {
    
    @Autowired
    HospedeRepository hospedeRepository;
    
    public List<Hospedes> listarTodos(){
        return hospedeRepository.findAll();
    }
    
    public Hospedes buscarPorId (Integer id){
        return hospedeRepository.findById(id).orElseThrow();
    }
    
    public void excluir(Integer id){
        Hospedes hospedeEncontrado = buscarPorId(id);
        hospedeRepository.deleteById(hospedeEncontrado.getId());
    }
    
    public Hospedes criar(Hospedes hospede){
        hospede.setId(0);
        hospedeRepository.save(hospede);
        return hospede;
    }
    
    public Hospedes atualizar(Integer id, Hospedes hospedeEnviado){
        Hospedes hospedeEncontrado = buscarPorId(id);
        hospedeEncontrado.setNome(hospedeEnviado.getNome());
        hospedeEncontrado.setCPF(hospedeEnviado.getCPF());
        hospedeEncontrado.setTelefone(hospedeEnviado.getTelefone());
        hospedeEncontrado.setCidade(hospedeEnviado.getCidade());
        hospedeEncontrado.setPais(hospedeEnviado.getPais());
        hospedeRepository.save(hospedeEnviado);
        return hospedeEnviado;
    }
}
