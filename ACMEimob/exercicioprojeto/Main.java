import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<ProdutoPerecivel> listaPereciveis;
    public List<ProdutoNaoPerecivel> listaNaoPereciveis;
    public List<Servico> listaServicos;

    public Main() {
        listaPereciveis = new ArrayList<>();
        listaNaoPereciveis = new ArrayList<>();
        listaServicos = new ArrayList<>();
    }

    /**
     * Executa a aplicacao
     */
    public void executar() {
        cadastraItens();
        mostraItens();
    }

    /**
     * Cadastra itens no catalogo
     */
    private void cadastraItens() {
        ProdutoPerecivel pp = new ProdutoPerecivel(111,"Cafe", Pais.BRASIL,30);
        addProdutoPerecivel(pp);

        ProdutoNaoPerecivel pnp;
        pnp = new ProdutoNaoPerecivel(222,"Navio",Pais.DINAMARCA,"Madeira");
        addProdutoNaoPerecivel(pnp);

        Servico s = new Servico(333,100.00);
        addServico(s);
    }

    /**
     * Mostra itens cadastrados no catalogo
     */
    private void mostraItens() {
        List<ProdutoPerecivel> listaProdutoPerecivel;
        listaProdutoPerecivel = getProdutosPereciveis();
        for(ProdutoPerecivel p : listaProdutoPerecivel) {
            System.out.println(p.getDescricao());
        }

        List<ProdutoNaoPerecivel> listaProdutoNaoPerecivel;
        listaProdutoNaoPerecivel = getProdutosNaoPereciveis();
        for(ProdutoNaoPerecivel p : listaProdutoNaoPerecivel) {
            System.out.println(p.getDescricao());
        }

        List<Servico> listaServico;
        listaServico = getServicos();
        for(Servico p : listaServico) {
            System.out.println(p.getDescricao());
        }
    }

    public boolean addProdutoPerecivel(ProdutoPerecivel p) {
        return listaPereciveis.add(p);
    }

    public boolean addProdutoNaoPerecivel(ProdutoNaoPerecivel p) {
        return listaNaoPereciveis.add(p);
    }

    public boolean addServico(Servico s) {
        return listaServicos.add(s);
    }

    public List<ProdutoPerecivel> getProdutosPereciveis() {
        List<ProdutoPerecivel> copia = new ArrayList<>();
        for(ProdutoPerecivel p : listaPereciveis) {
            copia.add(p);
        }
        return copia;
    }

    public List<ProdutoNaoPerecivel> getProdutosNaoPereciveis() {
        List<ProdutoNaoPerecivel> copia = new ArrayList<>();
        for(ProdutoNaoPerecivel p : listaNaoPereciveis) {
            copia.add(p);
        }
        return copia;
    }

    public List<Servico> getServicos() {
        List<Servico> copia = new ArrayList<>();
        for(Servico s : listaServicos) {
            copia.add(s);
        }
        return copia;
    }

    public ProdutoPerecivel getProdutoPerecivel(int codigo) {
        for(ProdutoPerecivel p : listaPereciveis) {
            if(p.getCodigo() == codigo)
                return p;
        }
        return null;
    }

    public ProdutoNaoPerecivel getProdutoNaoPerecivel(int codigo) {
        for(ProdutoNaoPerecivel p : listaNaoPereciveis) {
            if(p.getCodigo() == codigo)
                return p;
        }
        return null;
    }

    public Servico getServico(int codigo) {
        for(Servico s : listaServicos) {
            if(s.getCodigo() == codigo)
                return s;
        }
        return null;
    }

    public static void main(String[] args) {
        new Main().executar();
        }
}
