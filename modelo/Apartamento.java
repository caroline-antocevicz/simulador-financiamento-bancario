package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public int getNumeroAndar() {
        return numeroAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.getValorImovel() / (super.getPrazoFinanciamento() * 12) + 100;
    }

    public void mostrarDadosApartamento() {
        System.out.println("Vagas de Garagem: " + this.vagasGaragem);
        System.out.println("Número do Andar: " + this.numeroAndar);
    }
}
