public class GenericDLList<T> {
    private DLNode<T> head;
    private int size;
    public GenericDLList() {
        head = null;
        size = 0;
    }
    public void adding(T element) {
        DLNode<T> newNode = new DLNode<>(element);
        if (head == null) {
            head = newNode;
        } else {
            DLNode<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
        size++;
    }
    public void remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid position: " + pos);
        }
        if (pos == 0) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        } else {
            DLNode<T> current = head;
            for (int i = 0; i < pos; i++) {
                current = current.next;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            current.prev.next = current.next;
        }
        size--;
    }
    public String toString() {
        if (size == 0) {
            return "Empty List";
        }
        StringBuilder sb = new StringBuilder();
        DLNode<T> current = head;
        while (current != null) {
            sb.append(current.data).append("\n");
            current = current.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        GenericDLList<Song> songsList = new GenericDLList<>();
        songsList.adding(new Song("Kaikai Kitan", "Eve", 3.39)); //0
        songsList.adding(new Song("7 Summers", "Morgan Wallen", 3.31));//1
        songsList.adding(new Song("Transform", "Daniel Ceasar", 4.40));//2
        songsList.adding(new Song("The Spins", "Mac Miller", 3.16));//3

        System.out.println("Playlisy");
        System.out.println(songsList);

        songsList.remove(1);

        System.out.println("Remove 1\n");
        System.out.println(songsList);
    }
}