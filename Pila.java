public class Pila<T> {
    private Nodo<T> top;

    public Pila() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(T dato) {
        Nodo<T> nuovoNodo = new Nodo<>(dato);
        nuovoNodo.next = top;
        top = nuovoNodo;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vuota");
        }

        T dato = top.dato;
        top = top.next;
        return dato;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vuota");
        }

        return top.dato;
    }

    public int size() {
        int contatore = 0;
        Nodo<T> corrente = top;

        while (corrente != null) {
            contatore++;
            corrente = corrente.next;
        }

        return contatore;
    }

    @Override
    public String toString() {
        String str= "[ "

        Nodo<T> corrente = top;
        while (corrente != null) {
            str += corrente.dato;
            str += " → ";
            corrente = corrente.next;
        }

        str += "]"
        return str;
    }
}