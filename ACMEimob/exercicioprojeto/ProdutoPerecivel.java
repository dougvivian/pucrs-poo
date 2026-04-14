public class ProdutoPerecivel {
    public int codigo;
    public String nome;
    public Pais pais;
    public int duracao;

    public ProdutoPerecivel(int codigo, String nome, Pais pais, int duracao) {
        this.codigo = codigo;
        this.nome = nome;
        this.pais = pais;
        this.duracao = duracao;
    }

    public int getCodigo() {
        return codigo;
    }

    public double calculaPrecoFinal() {
        return 20.00;
    }

    public String getDescricao() {
        return "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", pais=" + pais.getExtenso() +
                ", duracao=" + duracao +
                ", preco final=" + calculaPrecoFinal();
    }
}
