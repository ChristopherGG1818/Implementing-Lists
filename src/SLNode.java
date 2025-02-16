class SLNode<T> {
    public T data;
    public SLNode<T> next;
    public SLNode(T data) {
        this.data = data;
        this.next = null;
    }
}