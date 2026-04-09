import java.util.ArrayList;

public class Cliente {
    String nome;
    private ArrayList<Casa> compradas;

    public Cliente(String nome) {
        this.nome = nome;
        compradas = new ArrayList<Casa>();
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void comprarCasa(Casa casa) {
        compradas.add(casa);
    }

    public void consultarCasasCompradas() {
        for (int i = 0; i < compradas.size(); i++) {
            System.out.println("M²: " + compradas.get(i).getTamanho());
            System.out.println("Valor: " + compradas.get(i).getValor());
            System.out.println("Endereço: " + compradas.get(i).getEndereco());
        }

    }

    // Este método apenas "entrega" a lista para quem pedir
    public ArrayList<Casa> getCompradas() {
        return this.compradas;
    }

}