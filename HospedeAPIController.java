
package com.senac.projeto.camping.controller;

import com.senac.projeto.camping.model.Hospedes;
import com.senac.projeto.camping.service.HospedeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/hospede")
public class HospedeAPIController {
    
    @Autowired
    HospedeService hospedeService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> listar(){
        List<Hospedes> listagem = hospedeService.listarTodos();        
        return new ResponseEntity<>(listagem, HttpStatus.OK);
    }
    
    @PostMapping ("/cadastrar")
    public ResponseEntity<Hospedes> addHospede(@RequestBody Hospedes hospede){
        var novoHospede = hospedeService.criar(hospede);
        return new ResponseEntity<>(novoHospede, HttpStatus.CREATED);
    }
    
    @GetMapping ("/buscar/{id}")
    public ResponseEntity<Hospedes> buscar(@PathVariable Integer id){
        Hospedes hospedeEncontrado = hospedeService.buscarPorId(id);        
        return new ResponseEntity<>(hospedeEncontrado, HttpStatus.OK);
    }
    
    @DeleteMapping ("/excluir/{id}")
    public ResponseEntity<Hospedes> excluir(@PathVariable Integer id){
        hospedeService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping ("/atualizar/{id}")
    public ResponseEntity<Hospedes> atualizar(@RequestBody Hospedes hospede, @PathVariable Integer id){
        var hospedeEditado = hospedeService.atualizar(id, hospede);
        return new ResponseEntity<>(hospedeEditado, HttpStatus.OK);
    }
    
    
}
