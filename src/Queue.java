public class Queue<T> {

    private Node<T> first;
    private Node<T> last;

    /** פעולה בונה המתחילה תור ריק */
    public Queue() {
        this.first = null;
        this.last = null;
    }

    /** פעולה המכנסת את הערך x לסוף התור הנוכחי */
    public void insert(T x) {
        Node<T> temp = new Node<>(x);
        if (first == null)
            first = temp;
        else
            last.setNext(temp);
        last = temp;
    }

    /** פעולה מוציאה ומחזירה את הערך הנמצא בראש התור הנוכחי */
    public T remove() {
        T x = first.getValue();
        first = first.getNext();
        if (first == null)
            last = null;
        return x;
    }

    /** פעולה מחזירה את הערך הנמצא בראש התור הנוכחי */
    public T head() {
        return first.getValue();
    }

    /** פעולה מחזירה אמת אם התור הנוכחי ריק */
    public boolean isEmpty() {
        return first == null;
    }

    /** פעולה מחזירה מחרוזת המייצגת את התור הנוכחי */
//    public String toString() {
//        if (this.isEmpty()) return "[]";
//        this.insert(null);
//        String s = "[";
//        T temp = this.remove();
//        while (temp != null) {
//            s = s + temp + ", ";
//            this.insert(temp);
//            temp = this.remove();
//        }
//        s = s.substring(0, s.length() - 1) + "]";
//        return s;
//    }


    @Override
    public String toString() {
        return this.first.toString();
    }
}