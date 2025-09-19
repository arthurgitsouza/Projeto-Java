package meuprojeto;

import java.util.Locale; // Necessário para garantir a formatação de números decimais

public class FormatadorRelatorio { // Declaração da classe

    // Método para exibir o relatório.
    // public: Pode ser chamado de qualquer lugar.
    // static: Pode ser chamado diretamente pela classe (ex: FormatadorRelatorio.exibir(...)).
    // void: Não retorna nenhum valor, apenas realiza uma ação (imprimir na tela).
    // (ItemImportado item, double valorImposto): Recebe o item e o imposto já calculado como parâmetros.
    public static void exibirRelatorio(ItemImportado item, double valorImposto) {
        // Usa Locale.US para garantir que números decimais sejam formatados com ponto (ex: 123.45)
        // Isso é importante para consistência em diferentes sistemas operacionais.
        Locale.setDefault(Locale.US);

        System.out.println("\n\n--- RELATÓRIO FINAL DE IMPORTAÇÃO ---");
        // 'printf' permite formatação de strings, similar ao Python f-strings ou C printf.
        // %s: substitui por uma String.
        // %.2f: substitui por um número decimal (double/float) com 2 casas decimais.
        System.out.printf("Produto: %s\n", item.getDescricao());
        System.out.printf("País de Origem: %s\n", CalculadoraImposto.getOrigemTexto(item.getOrigem()));
        System.out.printf("Categoria: %s\n", CalculadoraImposto.getCategoriaTexto(item.getCategoria()));
        System.out.printf("Valor CIF: US$ %.2f\n", item.calcularCif());
        // A alíquota precisa ser recalculada se quisermos exibi-la.
        // Para simplicidade, vamos calcular ela novamente aqui para exibição.
        // Em um sistema real, o método 'calcular' poderia retornar um objeto com imposto E alíquota.
        double aliquota = CalculadoraImposto.calcular(item) / item.calcularCif();
        System.out.printf("Alíquota Aplicada: %.0f%%\n", aliquota * 100); // %.0f%% para % inteiro
        System.out.printf("Valor do Imposto: US$ %.2f\n", valorImposto);
        System.out.println("-------------------------------------");
    }
}