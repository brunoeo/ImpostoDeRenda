package br.com.impostoDeRenda.ImpostoDeRenda.presentation.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class RequisicaoFormulario {

    @Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "Formato inválido")
    private String salario;
    @Pattern(regexp = "^\\d+(\\.\\d{0})?$", message = "Formato inválido")
    private String numDependentes;
    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getNumDependentes() {
        return numDependentes;
    }

    public void setNumDependentes(String numDependentes) {
        this.numDependentes = numDependentes;
    }

}
