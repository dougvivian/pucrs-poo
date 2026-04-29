
public class App {
    public static void main(String[] args) {
        DoubleLinkedListOfInteger l = new DoubleLinkedListOfInteger();
        l.add(10);
        l.add(20);
        l.add(30);
        l.add(40);
        l.add(50);
        l.add(60);
        l.add(70);
        l.add(80);

        System.out.println(l.contains(50));
        // l.addInicio(7);
        System.out.println(l);
        System.out.println("size=" + l.size());

        // System.out.println("Get da posicao 2: " + l.get(2));
        // System.out.println("Get da posicao 6: " + l.get(6));

        // System.out.println("Trocou " + l.set(2, 35) + " por 35 na posicao 2.");

        // System.out.println("Removeu 50? " + l.remove(50));
        // System.out.println("Removeu 57? " + l.remove(57));

    }

}
