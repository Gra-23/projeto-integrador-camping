
package com.senac.projeto.camping.controller;

import com.senac.projeto.camping.model.Reservas;
import com.senac.projeto.camping.service.ReservaService;
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
@RequestMapping ("/reserva")
public class ReservaAPIController {
    
    @Autowired
    ReservaService reservaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List> listar(){
        List<Reservas> listagemRes = reservaService.listarTodos();        
        return new ResponseEntity<>(listagemRes, HttpStatus.OK);
    }
    
    @PostMapping ("/cadastrar")
    public ResponseEntity<Reservas> addAnalise(@RequestBody Reservas res){
        var novaReserva = reservaService.criar(res);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }
    
    @GetMapping ("/buscar/{idReserva}")
    public ResponseEntity<List> buscar(@PathVariable Integer idReserva){
        List <Reservas> reservaEncontrada = reservaService.listar(idReserva);        
        return new ResponseEntity<>(reservaEncontrada, HttpStatus.OK);
    }
    
    @DeleteMapping ("/excluir/{id}")
    public ResponseEntity<Reservas> excluir(@PathVariable Integer id){
        reservaService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    @PutMapping ("/atualizar/{id}")
    public ResponseEntity<Reservas> atualizar(@RequestBody Reservas reserva, @PathVariable Integer id){
        var reservaEditada = reservaService.atualizar(id, reserva);
        return new ResponseEntity<>(reservaEditada, HttpStatus.OK);
    }
}
