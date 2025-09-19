package meuprojeto;

public class CalculadoraImposto {

    public static double calcular(ItemImportado item) {
        double aliquota = 0.0;

        int origem = item.getOrigem();
        int categoria = item.getCategoria();
        boolean usmca = item.isUsmca();


        // Regra 1: Canadá (7) ou México (8)
        if (origem == 7 || origem == 8) {
            if (usmca) {
                aliquota = 0.0;
            } else {
                if (categoria == 6) {
                    aliquota = 0.10;
                } else {
                    aliquota = 0.25;
                }
            }
        }
        // Regra 2: Outros países (não Canadá nem México)
        else {
            if (categoria >= 2 && categoria <= 7) {
                aliquota = 0.10;
            }

            else if (categoria == 1) {

                switch (origem) {
                    case 1: // China
                        aliquota = 0.34; // 34%
                        break;
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
        }

        return item.calcularCif() * aliquota;
    }

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