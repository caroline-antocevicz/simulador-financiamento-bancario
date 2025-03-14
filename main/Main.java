package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Terreno;
import modelo.Casa;
import util.InterfaceUsuario;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Variáveis
        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        // Armazena os dados do financiamento
        ArrayList<Financiamento> listaFinanciamentos = new ArrayList<>();

        // Dados do financiamento personalizado
        System.out.println("Cadastro do Financiamento Personalizado");
        double valorImovelUsuario = interfaceUsuario.pedirValorImovel();
        double taxaJurosUsuario = interfaceUsuario.pedirTaxaJuros();
        int prazoFinanciamentoUsuario = interfaceUsuario.pedirPrazoFinanciamento();
        Casa casaUsuario = new Casa(valorImovelUsuario, prazoFinanciamentoUsuario, taxaJurosUsuario, 150, 300);
        listaFinanciamentos.add(casaUsuario);

        // Dados financiamentos

        // Casas
        Casa casa1 = new Casa(300000, 20, 5, 200, 400);
        Casa casa2 = new Casa(500000, 25, 4.5, 250, 500);
        listaFinanciamentos.add(casa1);
        listaFinanciamentos.add(casa2);

        // Apartamentos
        Apartamento apto1 = new Apartamento(400000, 30, 4.7, 2, 10);
        Apartamento apto2 = new Apartamento(350000, 15, 5.2, 1, 5);
        listaFinanciamentos.add(apto1);
        listaFinanciamentos.add(apto2);

        // Terreno
        Terreno terreno = new Terreno(250000, 10, 6, "Residencial");
        listaFinanciamentos.add(terreno);

        // Mostrar informações e calcular valores
        for (Financiamento financiamento : listaFinanciamentos) {
            double valorImovel = financiamento.getValorImovel();
            double totalFinanciamento = financiamento.calcularTotalPagamento();
            financiamento.mostrarDadosFinanciamento();
            totalValorImoveis += valorImovel;
            totalValorFinanciamentos += totalFinanciamento;

            if (financiamento instanceof Casa) {
                ((Casa) financiamento).mostrarDadosCasa();
            } else if (financiamento instanceof Apartamento) {
                ((Apartamento) financiamento).mostrarDadosApartamento();
            } else if (financiamento instanceof Terreno) {
                ((Terreno) financiamento).mostrarDadosTerreno();
            }
        }

        // Total de todos os imóveis
        System.out.println("Total de todos os imóveis: R$" + totalValorImoveis);
        System.out.println("Total de todos os financiamentos: R$" + totalValorFinanciamentos);

        // Salvar dados dos financiamentos em arquivo de texto
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("financiamentos.txt"));

            for (Financiamento financiamento : listaFinanciamentos) {
                // Gravar os dados comuns do financiamento
                writer.write("Valor Imóvel: R$" + financiamento.getValorImovel());
                writer.write(", Valor Total do Financiamento: R$" + financiamento.calcularTotalPagamento());
                writer.write(", Taxa de Juros: " + financiamento.getTaxaJurosAnual() + "%");
                writer.write(", Prazo: " + financiamento.getPrazoFinanciamento() + " anos");

                // Gravar os dados específicos de cada classe
                if (financiamento instanceof Casa) {
                    Casa casa = (Casa) financiamento;
                    writer.write(", Área Construída: " + casa.getAreaConstruida());
                    writer.write(", Tamanho do Terreno: " + casa.getTamanhoTerreno());
                } else if (financiamento instanceof Apartamento) {
                    Apartamento apto = (Apartamento) financiamento;
                    writer.write(", Vagas Garagem: " + apto.getVagasGaragem());
                    writer.write(", Número do Andar: " + apto.getNumeroAndar());
                } else if (financiamento instanceof Terreno) {
                    Terreno terrenoObj = (Terreno) financiamento;
                    writer.write(", Tipo de Zona: " + terrenoObj.getTipoZona());
                }

                writer.newLine();  // Nova linha para o próximo financiamento
            }

            writer.close();
            System.out.println("Dados dos financiamentos salvos com sucesso em 'financiamentos.txt'.");

        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados dos financiamentos: " + e.getMessage());
        }

        // Leitura dos dados salvos em arquivo de texto
        try {
            BufferedReader reader = new BufferedReader(new FileReader("financiamentos.txt"));
            String linha;

            System.out.println("Dados lidos do arquivo 'financiamentos.txt':");
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);  // Exibe cada linha lida do arquivo
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Erro ao ler os dados dos financiamentos: " + e.getMessage());
        }

        // Serializar o ArrayList de financiamentos
        try {
            FileOutputStream fileOut = new FileOutputStream("financiamentos.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(listaFinanciamentos);
            out.close();
            fileOut.close();
            System.out.println("ArrayList de financiamentos serializado salvo em 'financiamentos.ser'.");

        } catch (IOException e) {
            System.out.println("Erro ao serializar os financiamentos: " + e.getMessage());
        }

        // Desserializar o ArrayList de financiamentos
        try {
            FileInputStream fileIn = new FileInputStream("financiamentos.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<Financiamento> listaFinanciamentosLida = (ArrayList<Financiamento>) in.readObject();
            in.close();
            fileIn.close();

            System.out.println("Dados dos financiamentos lidos do arquivo serializado:");
            for (Financiamento financiamento : listaFinanciamentosLida) {
                financiamento.mostrarDadosFinanciamento();

                // Mostrar os dados específicos da classe especializada
                if (financiamento instanceof Casa) {
                    ((Casa) financiamento).mostrarDadosCasa();
                } else if (financiamento instanceof Apartamento) {
                    ((Apartamento) financiamento).mostrarDadosApartamento();
                } else if (financiamento instanceof Terreno) {
                    ((Terreno) financiamento).mostrarDadosTerreno();
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o arquivo serializado: " + e.getMessage());
        }
    }
}
