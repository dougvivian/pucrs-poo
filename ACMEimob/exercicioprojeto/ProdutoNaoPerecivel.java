public class ProdutoNaoPerecivel {
    public int codigo;
    public String nome;
    public Pais pais;
    public String material;

    public ProdutoNaoPerecivel(int codigo, String nome, Pais pais, String material) {
        this.codigo = codigo;
        this.nome = nome;
        this.pais = pais;
        this.material = material;
    }

    public int getCodigo() {
        return codigo;
    }

    public double calculaPrecoFinal() {
        return 30.00;
    }

    public String getDescricao() {
        return "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", pais=" + pais.getExtenso() +
                ", material=" + material +
                ", preco final=" + calculaPrecoFinal();
    }
}
