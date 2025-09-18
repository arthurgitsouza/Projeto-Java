//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        double aliquota = 0.0;

        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o nome do Produto: ");
        String nomeProduto = leitor.nextLine();
        System.out.println("Digite o Número que representa a Origem: ");
        int origem = leitor.nextInt();
        System.out.println("Digite a Categoria: ");
        int categoria = leitor.nextInt();
        System.out.println("Digite o Valor da Mercadoria: ");
        double valorMercadoria = leitor.nextDouble();
        System.out.println("Digite o Valor do Frete: ");
        double valorFrete = leitor.nextDouble();
        boolean usmca = false;



        if (origem == 7  || origem == 8) {
            usmca = true;
            aliquota = 0;
        }
        if (usmca == false){
            if (categoria == 6){
                aliquota = 10;
            }
            else if (categoria )
        }
    }
}