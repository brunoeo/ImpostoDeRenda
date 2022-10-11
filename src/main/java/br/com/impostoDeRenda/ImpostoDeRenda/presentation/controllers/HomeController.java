package br.com.impostoDeRenda.ImpostoDeRenda.presentation.controllers;

import br.com.impostoDeRenda.ImpostoDeRenda.presentation.dto.RequisicaoFormulario;
import br.com.impostoDeRenda.ImpostoDeRenda.domain.services.ImpostoRendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    ImpostoRendService impostoRendService;

    @GetMapping("formulario")
    public String formulario(RequisicaoFormulario requisicaoFormulario){
        return "home/formulario";
    }

    @PostMapping("calcular")
    public String calcular(@Valid RequisicaoFormulario requisicaoFormulario, BindingResult result, Model model){
        if(result.hasErrors()){
            return "home/formulario";
        }

        return impostoRendService.calculaImpostoRenda(requisicaoFormulario, model);
    }

}
