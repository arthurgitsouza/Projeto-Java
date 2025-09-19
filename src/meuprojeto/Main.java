package meuprojeto;

// Importa as classes necessárias de outras bibliotecas do Java
import java.util.Locale; // Para garantir a leitura de decimais com ponto
import java.util.Scanner; // Para ler a entrada do usuário

public class Main {
    public static void main(String[] args) {

        // Configura o Locale para US para que o Scanner entenda números decimais com ponto (ex: 100.50).
        // Isso é uma boa prática para evitar problemas de formatação entre diferentes sistemas.
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("--- CALCULADORA DE IMPOSTO DE IMPORTAÇÃO (EUA) ---");

        // PASSO 1: Coletar as entradas do usuário
        System.out.print("Informe qual é o produto: ");
        String descricao = scanner.nextLine(); // nextLine() lê a linha inteira (incluindo espaços)

        System.out.println("\n--- Informe o país de Origem ---");
        System.out.println("1-China, 2-União Europeia, 3-Japão, 4-Coreia do Sul, 5-Vietnã, 6-Tailândia, 7-Canadá, 8-México, 9-Outros");
        System.out.print("Digite o número da origem: ");
        int origem = scanner.nextInt(); // nextInt() lê um número inteiro

        System.out.println("\n--- Informe a Categoria do Produto ---");
        System.out.println("1-Geral, 2-Fármacos, 3-Semicondutores, 4-Cobre, 5-Madeira, 6-Energia/Minerais, 7-Bullion");
        System.out.print("Digite o número da categoria: ");
        int categoria = scanner.nextInt();

        System.out.print("\nInforme o Valor da Mercadoria (USD): ");
        double valorMercadoria = scanner.nextDouble(); // nextDouble() lê um número decimal

        System.out.print("Informe o Valor do Frete (USD): ");
        double valorFrete = scanner.nextDouble();

        // O USMCA só é perguntado se a origem for Canadá (7) ou México (8) - KISS (Keep It Simple, Stupid)
        // Evita perguntas desnecessárias.
        boolean usmca = false; // Inicializa como false por padrão
        if (origem == 7 || origem == 8) {
            System.out.print("A mercadoria se enquadra nas regras do USMCA? (true/false): ");
            usmca = scanner.nextBoolean(); // nextBoolean() lê 'true' ou 'false'
        }

        // PASSO 2: Criar o objeto ItemImportado com os dados coletados
        // Estamos instanciando (criando) um novo objeto ItemImportado.
        ItemImportado item = new ItemImportado(descricao, origem, categoria,
                valorMercadoria, valorFrete, usmca);

        // PASSO 3: Calcular o imposto
        // Chamamos o método estático 'calcular' da classe CalculadoraImposto,
        // passando o objeto 'item' que acabamos de criar.
        double valorImposto = CalculadoraImposto.calcular(item);

        // PASSO 4: Exibir o relatório formatado
        // Chamamos o método estático 'exibirRelatorio' da classe FormatadorRelatorio,
        // passando o objeto 'item' e o 'valorImposto' calculado.
        FormatadorRelatorio.exibirRelatorio(item, valorImposto);

        // Boa prática: Fechar o Scanner para liberar recursos do sistema.
        scanner.close();
    }
}