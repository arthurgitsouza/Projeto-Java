package meuprojeto;

public class CalculadoraImposto { // Declaração da classe

    // Método principal para calcular o imposto de um item importado.
    // public: Pode ser chamado de qualquer lugar.
    // double: O método retorna um valor decimal (o imposto calculado).
    // (ItemImportado item): Recebe um objeto do tipo ItemImportado como parâmetro.
    // static: Permite chamar o método diretamente pela classe (ex: CalculadoraImposto.calcular(meuItem))
    //         sem precisar criar um objeto CalculadoraImposto.
    public static double calcular(ItemImportado item) {
        double aliquota = 0.0; // Variável para armazenar a alíquota percentual (0.10 para 10%)

        // Acesso aos dados do item através dos getters
        int origem = item.getOrigem();
        int categoria = item.getCategoria();
        boolean usmca = item.isUsmca();

        // Lógica para definir a alíquota com base nas regras do trabalho
        // A ordem dos 'if-else if' é importante: do mais específico para o mais geral.

        // Regra 1: Canadá (7) ou México (8)
        if (origem == 7 || origem == 8) {
            if (usmca) { // Sub-regra 1.1: Com USMCA = true
                aliquota = 0.0; // 0%
            } else { // Sub-regra 1.2: Com USMCA = false
                if (categoria == 6) { // Categoria Energia/Minerais
                    aliquota = 0.10; // 10%
                } else { // Demais categorias
                    aliquota = 0.25; // 25%
                }
            }
        }
        // Regra 2: Outros países (não Canadá nem México)
        else {
            // Sub-regra 2.1: Categorias especiais (Fármacos a Bullion, de 2 a 7)
            if (categoria >= 2 && categoria <= 7) {
                aliquota = 0.10; // 10%
            }
            // Sub-regra 2.2: Categoria Geral (1)
            else if (categoria == 1) {
                // 'switch' é uma estrutura de controle eficiente para múltiplos 'if's
                // que checam o mesmo valor (neste caso, a origem).
                switch (origem) {
                    case 1: // China
                        aliquota = 0.34; // 34%
                        break; // 'break' sai do switch após encontrar uma correspondência
                    case 2: // União Europeia
                        aliquota = 0.20; // 20%
                        break;
                    case 3: // Japão
                        aliquota = 0.24; // 24%
                        break;
                    case 4: // Coreia do Sul
                        aliquota = 0.26; // 26%
                        break;
                    case 5: // Vietnã
                        aliquota = 0.46; // 46%
                        break;
                    case 6: // Tailândia
                        aliquota = 0.37; // 37%
                        break;
                    case 9: // Outros
                    default: // Qualquer outro caso não listado (DRY: evita repetir 10% para Brasil, etc.)
                        aliquota = 0.10; // 10%
                        break;
                }
            }
            // Se houver uma categoria inválida (fora de 1-7), a alíquota permanece 0.0
            // ou você poderia adicionar um tratamento de erro.
        }

        // Calcula o valor final do imposto: CIF * Alíquota
        return item.calcularCif() * aliquota;
    }

    // --- Métodos Auxiliares para traduzir códigos para texto (DRY: evita repetição de lógica) ---
    // static: Podem ser chamados diretamente pela classe.
    // public String: Retornam um texto.
    // (int codigo): Recebem um código numérico.

    public static String getOrigemTexto(int codigo) {
        switch (codigo) {
            case 1: return "China";
            case 2: return "União Europeia";
            case 3: return "Japão";
            case 4: return "Coreia do Sul";
            case 5: return "Vietnã";
            case 6: return "Tailândia";
            case 7: return "Canadá";
            case 8: return "México";
            case 9: return "Outros";
            default: return "Desconhecida"; // Caso um código inválido seja inserido
        }
    }

    public static String getCategoriaTexto(int codigo) {
        switch (codigo) {
            case 1: return "Geral";
            case 2: return "Fármacos";
            case 3: return "Semicondutores";
            case 4: return "Cobre";
            case 5: return "Madeira";
            case 6: return "Energia/Minerais";
            case 7: return "Bullion";
            default: return "Desconhecida"; // Caso um código inválido seja inserido
        }
    }
}