package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public double getValorImovel() {
        return valorImovel;
    }

    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    public abstract double calcularPagamentoMensal();

    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }

    public void mostrarDadosFinanciamento() {
        System.out.println("Valor do Imóvel: R$" + this.valorImovel);
        System.out.println("Valor Total do Financiamento: R$" + this.calcularTotalPagamento());
    }
}
