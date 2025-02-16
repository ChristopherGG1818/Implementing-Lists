import java.util.Arrays;
public class GenericAList<T> {
    private T[] elements;
    private int size;
    private static final int maxCapacity = 5;
    public GenericAList() {
        this.elements = (T[]) new Object[maxCapacity];
        this.size = 0;
    }
    public void adding(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size] = element;
        size++;
    }
    public void remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid" + pos);
        }
        for (int i = pos; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        elements[size] = null;
    }

    private void resize() {
        elements = Arrays.copyOf(elements, elements.length * 2);
    }
    public String toString() {
        if (size == 0) {
            return "Empty";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        GenericAList<Song> songsList = new GenericAList<>();
        songsList.adding(new Song("El Rey", "Vicente Fernandez", 2.34));
        songsList.adding(new Song("Usted ", "Luis Miguel", 3.43));
        songsList.adding(new Song("Callaita", "Bad Bunny", 4.11));
        songsList.adding(new Song("El Perdedor", "Maluma", 3.27));

        System.out.println("music");
        System.out.println(songsList);

        songsList.remove(1);

        System.out.println("After removing songs\n" +"");
        System.out.println(songsList);
    }
}