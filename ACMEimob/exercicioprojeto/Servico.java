public class Servico {
    public int cod;
    public double preco;

    public Servico(int cod, double preco) {
        this.cod = cod;
        this.preco = preco;
    }

    public int getCodigo() {
		return cod;
	}

	public double calculaPrecoFinal() {
		return preco * 1.5;
	}

	public String getDescricao() {
        return  "cod=" + cod +
                ", preco=" + preco +
                ", preco final=" + calculaPrecoFinal();
    }
}
