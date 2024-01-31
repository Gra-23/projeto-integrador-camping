
package com.senac.projeto.camping.controller;

import com.senac.projeto.camping.model.Hospedes;
import com.senac.projeto.camping.model.Reservas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HospedeController {
    @Autowired 
    HospedeService hospedeService;
    
    @Autowired 
    ReservaService reservaService;
    
    
    @GetMapping("/inicio")
    public String iniciar(){
        return "index";
    }
    
    @GetMapping("/cadastrar-hospede")
    public String cadastrarHosp(Model model){
        model.addAttribute("hospede", new Hospedes());
        return "cadastroHospedes";
    }
    
    @PostMapping("/gravar-hospede")
    public String gravarHospede(@ModelAttribute Hospedes hospede, Model model){
        hospedeService.criar(hospede);
        return "redirect:/listagem-hos";
    }
    
    @GetMapping("/listagem-hos")
    public String listarHosp(Model model){
        model.addAttribute("lista", hospedeService.listarTodos());
        return "lista";
    }
    
    
    @GetMapping("/cadastrar-reserva")
    public String cadastrarReserva(Model model){
        model.addAttribute("reserva", new Reservas());
        return "cadastroReservas";
    }
    
    @PostMapping("/gravar-reserva")
    public String gravarReserva (@ModelAttribute Reservas reserva, Model model){
        reservaService.criar(reserva);
        return "redirect:listagem-res";
    }  
    
    @GetMapping("/listagem-res")
    public String listarRes(Model model){
        model.addAttribute("listagem", reservaService.listarTodos());
        return "listaReservas";
    }
    
    @GetMapping("/exibir")
    public String exibirReserva(Model model, @RequestParam String id){
        Integer idHospede = Integer.parseInt(id);
        
        Hospedes hospedeEncontrado = new Hospedes();
        hospedeEncontrado = hospedeService.buscarPorId(idHospede);
        
        List<Reservas> reservaEncontrada = new ArrayList<>();
        reservaEncontrada = reservaService.listar(idHospede);
        
        
        model.addAttribute("hospede", hospedeEncontrado);
        model.addAttribute("reservas", new Reservas());
        model.addAttribute("reserva", reservaEncontrada);
        return "cadastroReservas";
    } 
    
    @GetMapping("/atualizar-hospede/{id}")
    public String atualizarHospede(@PathVariable(value = "id") Integer id, Model model) { 
        Hospedes hosp = hospedeService.buscarPorId(id);
        model.addAttribute("hospede", hosp); 
        return "atualizarHos";
    }
    
    @GetMapping("/deletar-hospede/{id}")
    public String deletarHospede(@PathVariable(value = "id") Integer id) { 
        hospedeService.excluir(id); 
        return "redirect:/listagem-hos"; 
    }
    
    @GetMapping("/atualizar-reserva/{id}")
    public String atualizarReserva(@PathVariable(value = "id") Integer id, Model model) { 
        Reservas res = reservaService.buscarPorId(id);
        model.addAttribute("reserva", res); 
        return "atualizarRes";
    }
    
    @GetMapping("/deletar-reserva/{id}")
    public String deletarReserva(@PathVariable(value = "id") Integer id) { 
        reservaService.excluir(id); 
        return "redirect:/listagem-res"; 
    }
}
