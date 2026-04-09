public class App {
    public static void main(String[] args) {
        LinkedListOfInteger lista = new LinkedListOfInteger();

        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Lista Vazia? " + lista.isEmpty());

        System.out.println("Adicionando elementos no final da lista...");

        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        System.out.println(lista);
        //System.out.println("--> Elementos adicionados com sucesso!");
        //System.out.println("Elemento na pos 3 é " + lista.get(1));
        
        lista.add(1,30);
        lista.add(0,50);
        System.out.println(lista);
        //System.out.println("Contém o elemento 30? " + lista.contains(30));
        // System.out.println("Contém o elemento 9? " + lista.contains(2));
        //System.out.println("Tamanho da lista: " + lista.size());
        //System.out.println("Lista Vazia? " + lista.isEmpty());

        // System.out.println("Elemento armazenado na "
        // + "segunda posicao da lista: " +lista.get(1));

        // System.out.println("Elemento armazenado na "
        // + "ultima posicao da lista: " +lista.get(lista.size()-1));

    }
}
