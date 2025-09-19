package meuprojeto;

public class ItemImportado {

    private String descricao;
    private int origem;
    private int categoria;
    private double valorMercadoria;
    private double valorFrete;
    private boolean usmca;

    public ItemImportado(String descricao, int origem, int categoria,
                         double valorMercadoria, double valorFrete, boolean usmca) {
        this.descricao = descricao;
        this.origem = origem;
        this.categoria = categoria;
        this.valorMercadoria = valorMercadoria;
        this.valorFrete = valorFrete;
        this.usmca = usmca;
    }

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

    public boolean isUsmca() {
        return usmca;
    }

    public double calcularCif() {
        return valorMercadoria + valorFrete;
    }
}