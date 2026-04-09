public class App {

    public static void main(String[] args) {
        ListArrayOfInteger lista = new ListArrayOfInteger();

        lista.add(6);
        lista.add(8);
        lista.add(10);
        lista.add(12);
        lista.removeIndex(2, 10);

        System.out.println(lista);
    }
}
