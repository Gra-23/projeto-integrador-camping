
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
    
    private List<Hospedes> listaHospedes = new ArrayList<>();
    private List<Reservas> listaReservas = new ArrayList<>();
    
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
        hospede.setId(listaHospedes.size()+1);
        listaHospedes.add(hospede);
        return "redirect:/listagem-hos";
    }
    
    @GetMapping("/listagem-hos")
    public String listarHosp(Model model){
        model.addAttribute("lista", listaHospedes);
        return "lista";
    }
    
    
    @GetMapping("/cadastrar-reserva")
    public String cadastrarReserva(Model model){
        model.addAttribute("reserva", new Reservas());
        return "cadastroReservas";
    }
    
    @PostMapping("/gravar-reserva")
    public String gravarReserva(@ModelAttribute Reservas reserva, Model model){
        reserva.setId(listaReservas.size()+1);
        listaReservas.add(reserva);
        return "redirect:listagem-res";
    }  
    
    @GetMapping("/listagem-res")
    public String listarRes(Model model){
        model.addAttribute("listagem", listaReservas);
        return "listaReservas";
    }
    
    @GetMapping("/exibir")
    public String exibirReserva(Model model, @RequestParam String id){
        Integer idHospede = Integer.parseInt(id);
        Hospedes hospedeEncontrado = new Hospedes();
        
        for (Hospedes h : listaHospedes){
            if (h.getId() == idHospede) {
                hospedeEncontrado = h;
                break;
            }
        }
        
        List<Reservas> reservaEncontrada = new ArrayList<>();
        for (Reservas res : listaReservas){
            if (res.getHospede().getId() == idHospede) {
                reservaEncontrada.add(res);
            }
        }
        
        model.addAttribute("hospede", hospedeEncontrado);
        model.addAttribute("reservas", new Reservas());
        model.addAttribute("reserva", reservaEncontrada);
        return "cadastroReservas";
    }
}
