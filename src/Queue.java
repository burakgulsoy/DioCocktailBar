public class Queue {
    private Node front;
    private Node rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public boolean isEmpty() {
        return (front == null);
    }

    public void initializeQueue() {
        front = null;
        rear = null;
    }

    public Cocktail getFront() {
        assert (front != null);
        return front.getCocktail();
    }

    public Cocktail getRear() {
        assert (rear != null);
        return rear.getCocktail();
    }

    public void addQueue(Cocktail newCocktail) {
        Node a = new Node(newCocktail);

        if (front == null) {
            front = rear = a;
        } else {
            rear.setLink(a);
            rear = rear.getLink();
        }
    }

    public void deleteQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            front = front.getLink();
            if (front == null) {
                rear = null;
            }
        }
    }

    public void outputQueue() {
        if (!isEmpty()) {
            Node c = new Node();
            c = front;
            while (c != null) {
                System.out.println(c.getCocktail());
                c = c.getLink();
            }
        }
    }

}
