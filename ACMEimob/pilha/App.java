
public class App {
    public static void main(String[] args) {
        Pilha p = new Pilha();
        p.push(1);
        p.push(2);
        p.push(3);
        p.push(4);

        Integer[] vet = { 10, 20, 30, 40, 50 };
        inverte(vet);
        /*
         * int tam = p.size();
         * for(int i=0; i<tam; i++) {
         * System.out.println(p.pop());
         * }
         */
        while (!p.isEmpty()) {
            System.out.println(p.pop());
        }

    }

    public static void inverte(Integer[] vet) {
        Pilha p = new Pilha();
        for (int i = 0; i < vet.length; i++) {
            p.push(vet[i]);
        }

        for (int i = 0; i < vet.length; i++) {
            vet[i] = p.pop();
        }
        
        for (int i = 0; i < vet.length; i++) {
        System.out.print(vet[i] + " ");
        }
    }

    public static Pilha getClone(Pilha p) {
        return null;
    }

    public static void addAll(Pilha p, LinkedListOfInteger l) {

    }
}
