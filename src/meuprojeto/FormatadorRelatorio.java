package meuprojeto;

import java.util.Locale;
public class FormatadorRelatorio {

    public static void exibirRelatorio(ItemImportado item, double valorImposto) {

        Locale.setDefault(Locale.US);

        System.out.println("\n\n--- RELATÓRIO FINAL DE IMPORTAÇÃO ---");
        System.out.printf("Produto: %s\n", item.getDescricao());
        System.out.printf("País de Origem: %s\n", CalculadoraImposto.getOrigemTexto(item.getOrigem()));
        System.out.printf("Categoria: %s\n", CalculadoraImposto.getCategoriaTexto(item.getCategoria()));
        System.out.printf("Valor CIF: US$ %.2f\n", item.calcularCif());

        double aliquota = CalculadoraImposto.calcular(item) / item.calcularCif();
        System.out.printf("Alíquota Aplicada: %.0f%%\n", aliquota * 100);
        System.out.printf("Valor do Imposto: US$ %.2f\n", valorImposto);
        System.out.println("-------------------------------------");
    }
}