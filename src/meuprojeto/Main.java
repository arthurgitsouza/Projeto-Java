package meuprojeto;

import java.util.Locale; // Para garantir a leitura de decimais com ponto
import java.util.Scanner; // Para ler a entrada do usuário

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("--- CALCULADORA DE IMPOSTO DE IMPORTAÇÃO (EUA) ---");

        // PASSO 1: Coletar as entradas do usuário
        System.out.print("Informe qual é o produto: ");
        String descricao = scanner.nextLine();

        System.out.println("\n--- Informe o país de Origem ---");
        System.out.println("1-China, 2-União Europeia, 3-Japão, 4-Coreia do Sul, 5-Vietnã, 6-Tailândia, 7-Canadá, 8-México, 9-Outros");
        System.out.print("Digite o número da origem: ");
        int origem = scanner.nextInt();

        System.out.println("\n--- Informe a Categoria do Produto ---");
        System.out.println("1-Geral, 2-Fármacos, 3-Semicondutores, 4-Cobre, 5-Madeira, 6-Energia/Minerais, 7-Bullion");
        System.out.print("Digite o número da categoria: ");
        int categoria = scanner.nextInt();

        System.out.print("\nInforme o Valor da Mercadoria (USD): ");
        double valorMercadoria = scanner.nextDouble();

        System.out.print("Informe o Valor do Frete (USD): ");
        double valorFrete = scanner.nextDouble();

        boolean usmca = false; // Inicializa como false por padrão
        if (origem == 7 || origem == 8) {
            System.out.print("A mercadoria se enquadra nas regras do USMCA? (true/false): ");
            usmca = scanner.nextBoolean(); // nextBoolean() lê 'true' ou 'false'
        }

        // PASSO 2: Criar o objeto ItemImportado com os dados coletados
        ItemImportado item = new ItemImportado(descricao, origem, categoria,
                valorMercadoria, valorFrete, usmca);

        // PASSO 3: Calcular o imposto
        double valorImposto = CalculadoraImposto.calcular(item);

        // PASSO 4: Exibir o relatório formatado
        FormatadorRelatorio.exibirRelatorio(item, valorImposto);

        scanner.close();
    }
}