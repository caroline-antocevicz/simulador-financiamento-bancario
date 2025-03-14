package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        System.out.print("Digite o valor do imóvel: R$");
        return scanner.nextDouble();
    }

    public double pedirTaxaJuros() {
        System.out.print("Digite a taxa de juros anual: ");
        return scanner.nextDouble();
    }

    public int pedirPrazoFinanciamento() {
        System.out.print("Digite o prazo de financiamento em anos: ");
        return scanner.nextInt();
    }
}
