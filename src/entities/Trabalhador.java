package entities;

import entities.enums.Nivel_Trabalhador;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Trabalhador {
    private String nome;
    private Nivel_Trabalhador nivel;
    private Double salarioBase;

    private Departamento departamento;
    private List<HoraContrato> contratos = new ArrayList<>( );

    public Trabalhador(){

    }

    public Trabalhador(String nome, Nivel_Trabalhador nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nivel_Trabalhador getNivel() {
        return nivel;
    }

    public void setNivel(Nivel_Trabalhador nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<HoraContrato> getContratos() {
        return contratos;
    }

     public void addContrato(HoraContrato contrato){
         contratos.add(contrato);
     }

    public void removerContrato(HoraContrato contrato){ // Metodo para remover um contrato a lista.
        contratos.remove(contrato);
    }

    public double renda(int ano, int mes){
        double soma = salarioBase;
        Calendar cal = Calendar.getInstance();
        for(HoraContrato c : contratos){
            cal.setTime(c.getData());
            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);
            if(ano == c_ano && mes == c_mes) {
                soma += c.valorTotal();
            }
        }
        return  soma;
    }

}
