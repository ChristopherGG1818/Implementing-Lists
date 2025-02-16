public class GenericSLList<T> {
    private SLNode<T> head;
    private int size;
    public GenericSLList() {
        head = null;
        size = 0;
    }
    public void adding(T element) {
        SLNode<T> newNode = new SLNode<>(element);
        if (head == null) {
            head = newNode;
        } else {
            SLNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public void remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid" + pos);
        }
        if (pos == 0) {
            head = head.next;
        } else {
            SLNode<T> current = head;
            for (int i = 0; i < pos - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    public String toString() {
        if (size == 0) {
            return "Empty";
        }
        StringBuilder sb = new StringBuilder();
        SLNode<T> current = head;
        while (current != null) {
            sb.append(current.data).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        GenericSLList<Song> songsList = new GenericSLList<>();
        songsList.adding(new Song("TURiSTA", "Bad Bunny", 3.10));
        songsList.adding(new Song("Bulls In The Bronx", "Pierce The Veil", 4.27));
        songsList.adding(new Song("Cuando Me Enamoro", "Enrique Iglesias", 3.20));
        songsList.adding(new Song("Drown", "Weston Estate", 3.01));

        System.out.println("Adding songs:");
        System.out.println(songsList);

        songsList.remove(1);

        System.out.println("After removing songs\n");
        System.out.println(songsList);
    }
}