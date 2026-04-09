/**
 * Classe que implementa uma lista linear usando arranjo.
 * 
 */

public class ListArrayOfInteger {

    // Atributos
    private static final int INITIAL_SIZE = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListArrayOfInteger() {
        this(INITIAL_SIZE);
    }

    /**
     * Construtor da lista.
     * 
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListArrayOfInteger(int tam) {
        if (tam <= 0) {
            tam = INITIAL_SIZE;
        }
        data = new Integer[tam];
        count = 0;
    }

    /**
     * Esvazia a lista.
     */
    public void clear() { // O(1)
        data = new Integer[INITIAL_SIZE];
        count = 0;
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * 
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() { // O(1)
        return (count == 0);
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * 
     * @return o numero de elementos da lista
     */
    public int size() { // O(1)
        return count;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * 
     * @param element elemento a ser adicionado ao final da lista
     */

    public boolean remove(Integer element) {
        for (int i = 0; i < count; i++) {
            if (data[i].equals(element)) {

                // desloca os elementos
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j + 1];
                }

                data[count - 1] = null; // limpa última posição
                count--;

                System.out.println("Elemento " + element + " removido com sucesso.");
                return true;
            }
        }

        System.out.println("Elemento " + element + " não encontrado");
        return false;
    }

    public boolean removeIndex(int index, Integer element) {

        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        for (int i = index; i < count; i++) {
            if (data[i].equals(element)) {

                // desloca os elementos
                for (int j = i; j < count - 1; j++) {
                    data[j] = data[j + 1];
                }

                data[count - 1] = null; // limpa última posição
                count--;

                System.out.println("Elemento " + element + " removido com sucesso.");
                return true;
            }
        }

        System.out.println("Elemento " + element + " não encontrado");
        return false;
    }

    // public int containsIndex(Integer element) {
    // for (int i = 0; i < count; i++) {
    // if (data[i].equals(element)) {
    // System.out.println("indice encontrado " + i);
    // return i;
    // }
    // }
    // return -1;
    // }

    public void add(int index, Integer element) {
        // 1. Validação de segurança
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        // 2. Se estiver cheio, dobra o tamanho
        if (count == data.length) {
            setCapacity(data.length * 2);
        }

        // 3. O SHIFT (de trás para frente)
        // Começamos do 'count' (espaço vazio) e trazemos o anterior para ele
        for (int j = count; j > index; j--) {
            data[j] = data[j - 1];
        }

        // 4. Agora o buraco no 'index' está livre e seguro!
        data[index] = element;
        count++;
    }

    public void add(Integer element) { // O(n)
        if (count == data.length) {
            setCapacity(data.length * 2);
        }
        data[count] = element;
        count++;
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * 
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     * @throws IndexOutOfBoundsException se (index < 0 || index >= size())
     */
    public int get(int index) { // O(1)
        if ((index < 0) || (index >= count)) {
            throw new IndexOutOfBoundsException("Index = " + index);
        }
        return data[index];
    }

    @Override
    public String toString() { // O(n)
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < count; i++) {
            s.append(data[i]);
            if (i != (count - 1)) {
                s.append(",");
            }
        }
        s.append("\n");
        return s.toString();
    }

    private void setCapacity(int newCapacity) {
        if (newCapacity != data.length) {
            int min = 0;
            Integer[] newData = new Integer[newCapacity];
            if (data.length < newCapacity) {
                min = data.length;
            } else {
                min = newCapacity;
            }
            for (int i = 0; i < min; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }

}
