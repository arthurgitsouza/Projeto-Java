package meuprojeto; // Define o pacote ao qual a classe pertence

public class ItemImportado { // Declaração da classe

    // Atributos (campos) da classe - private para encapsulamento (Princípio S de SOLID)
    // Isso significa que apenas métodos dentro desta classe podem acessar/modificar diretamente.
    // Outras classes usarão os métodos "get" (getters).
    private String descricao;
    private int origem;
    private int categoria;
    private double valorMercadoria;
    private double valorFrete;
    private boolean usmca; // Relevante apenas para origens específicas

    // Construtor: Usado para criar (instanciar) um novo objeto ItemImportado.
    // Ele recebe todos os valores necessários para inicializar os atributos do objeto.
    public ItemImportado(String descricao, int origem, int categoria,
                         double valorMercadoria, double valorFrete, boolean usmca) {
        this.descricao = descricao; // 'this' refere-se ao atributo da própria classe
        this.origem = origem;
        this.categoria = categoria;
        this.valorMercadoria = valorMercadoria;
        this.valorFrete = valorFrete;
        this.usmca = usmca;
    }

    // Métodos Getters: Fornecem acesso de leitura aos atributos privados.
    // public: Permite que outras classes chamem esses métodos.
    // String/int/double/boolean: Tipo de valor que o método retorna.
    public String getDescricao() {
        return descricao;
    }

    public int getOrigem() {
        return origem;
    }

    public int getCategoria() {
        return categoria;
    }

    public double getValorMercadoria() {
        return valorMercadoria;
    }

    public double getValorFrete() {
        return valorFrete;
    }

    // Para booleanos, a convenção em Java é usar 'is' no lugar de 'get' para o getter.
    public boolean isUsmca() {
        return usmca;
    }

    // Método auxiliar para calcular o CIF (Custo, Seguro e Frete)
    // Este cálculo é intrínseco ao item, então faz sentido aqui.
    public double calcularCif() {
        return valorMercadoria + valorFrete;
    }
}