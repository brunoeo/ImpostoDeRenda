package br.com.impostoDeRenda.ImpostoDeRenda.domain.services;

import br.com.impostoDeRenda.ImpostoDeRenda.presentation.dto.ImpostoDTO;
import br.com.impostoDeRenda.ImpostoDeRenda.presentation.dto.RequisicaoFormulario;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ImpostoRendService {
    public String calculaImpostoRenda(RequisicaoFormulario requisicaoFormulario, Model model) {

        ImpostoDTO impostoDTO = new ImpostoDTO();

        impostoDTO.setValorDependente(189.59 );

        double salario = Double.parseDouble(requisicaoFormulario.getSalario());
        int qtdDependentes = Integer.parseInt(requisicaoFormulario.getNumDependentes());

        if(salario > 4664.68){
            impostoDTO.setAliquota(0.275);
            impostoDTO.setIrpf(869.36);
        } else if (salario > 3751.06) {
            impostoDTO.setAliquota(0.225);
            impostoDTO.setIrpf(636.13);
        } else if (salario > 2826.66) {
            impostoDTO.setAliquota(0.15);
            impostoDTO.setIrpf(354.80);
        }else if(salario > 1903.99){
            impostoDTO.setAliquota(0.075);
            impostoDTO.setIrpf(142.80);
        }else{
            impostoDTO.setAliquota(0d);
            impostoDTO.setIrpf(0d);
        }


        impostoDTO.setValorMensal((salario * impostoDTO.getAliquota()) -
                (impostoDTO.getIrpf() + (impostoDTO.getValorDependente() * qtdDependentes)));

        if (impostoDTO.getValorMensal() <= 0){
            impostoDTO.setValorMensal(0d);
            impostoDTO.setValorAnual(0d);
        }else {
            impostoDTO.setValorAnual(impostoDTO.getValorMensal() * 12);
        }

        model.addAttribute("impostoRenda", impostoDTO);

        return "home/impostoCalculado";
    }
}
