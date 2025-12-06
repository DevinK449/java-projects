//Devin King
import java.util.*;

class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }
//Adds an item and maintains heap order
    public void add(T item) {
        heap.add(item);
        int i = heap.size() - 1;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i).compareTo(heap.get(parent)) < 0) {
                Collections.swap(heap, i, parent);
                i = parent;
            } else break;
        }
    }

    public T remove() {
        if (heap.size() == 0) return null;
        T result = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (heap.size() == 0) return result;
        heap.set(0, last);
        int i = 0;
        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;
            if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) smallest = left;
            if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) smallest = right;
            if (smallest == i) break;
            Collections.swap(heap, i, smallest);
            i = smallest;
        }
        return result;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
