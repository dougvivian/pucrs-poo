import java.util.ArrayList;

public class Condominio {
    private ArrayList<Casa> casas;

    public Condominio(){
        casas = new ArrayList<Casa>();
    }

    //CREATE
    public void cadastrarCasa(Casa c){
        casas.add(c);
    }

    
    //READ PELO ENDEREÇO
    public Casa consultarCasaEndereco(String endereco){
        for (int i=0;i<casas.size();i++){
            Casa aux = casas.get(i);
            if (aux.getEndereco().equals(endereco)){
                return aux;
            }      
        }
        return null;
    }
    //READ LISTAR CASAS
    public void listarCasas(){
        for (int i=0;i<casas.size();i++){
            System.out.println("M²: "+ casas.get(i).getTamanho());
            System.out.println("Valor: "+ casas.get(i).getValor());
            System.out.println("Endereço: "+ casas.get(i).getEndereco());
        }
    }
    //READ LISTA MAIS CARA
    public Casa consultarCasaMaisCara(){
        Casa maisCara = casas.get(0);
        for (int i=0;i<casas.size();i++){
            Casa atual = casas.get(i);
            if (atual.getValor()> maisCara.getValor()){
                maisCara = atual;
            }    
        }
        return maisCara;
    }

    //DELETE 
    public boolean removerCasa(String endereco) {
    Casa casaEncontrada = consultarCasaEndereco(endereco);
    if (casaEncontrada != null) {
        casas.remove(casaEncontrada);
        return true; // Removido com sucesso
    }
    return false; // Não achou para remover
}

}


