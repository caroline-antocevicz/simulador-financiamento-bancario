package modelo;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.getValorImovel() / (super.getPrazoFinanciamento() * 12) + 80;
    }

    public void mostrarDadosCasa() {
        System.out.println("Área Construída: " + this.areaConstruida + " m²");
        System.out.println("Tamanho do Terreno: " + this.tamanhoTerreno + " m²");
    }
}
