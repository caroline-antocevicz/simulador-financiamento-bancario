package modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        return super.getValorImovel() / (super.getPrazoFinanciamento() * 12) + 50;
    }

    public void mostrarDadosTerreno() {
        System.out.println("Tipo de Zona: " + this.tipoZona);
    }
}
