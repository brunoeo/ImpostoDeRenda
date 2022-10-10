package br.com.impostoDeRenda.ImpostoDeRenda.controllers;

import br.com.impostoDeRenda.ImpostoDeRenda.dto.RequisicaoFormulario;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("home")
public class HomeController {

    @GetMapping("formulario")
    public String formulario(RequisicaoFormulario requisicaoFormulario){
        return "home/formulario";
    }

    @PostMapping("calcular")
    public String calcular(@Valid RequisicaoFormulario requisicaoFormulario, BindingResult result){
        if(result.hasErrors()){
            return "home/formulario";
        }
        return "";
    }

}
