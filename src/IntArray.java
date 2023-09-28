import java.util.Arrays;

public class IntArray {
    private int[] arr;
    private int size;

    public IntArray() {
        this.arr = new int[10];
        this.size = 0;
    }

    public IntArray(int capacity) {
        this.arr = new int[capacity];
        this.size = 0;
    }

    public void add(int x) {
        if (this.size == this.arr.length) {
            int[] arrTmp = new int[this.arr.length * 2];

            for (int i = 0; i < this.size; i++) {
                arrTmp[i] = arr[i];
            }
            arr = arrTmp;
        }
        arr[this.size++] = x;
    }

    public void add(int index, int x) {
        // If index is larger than the capacity or the array is full
        while (this.arr.length <= index) {
            int[] arrTmp = new int[this.arr.length*2];
            for (int i = 0; i < this.arr.length; i++) {
                arrTmp[i] = this.arr[i];
            }
            this.arr = arrTmp;
        }
        for (int i = this.arr.length - 1; i > index; i--) {
            this.arr[i] = this.arr[i - 1];
        }
        this.arr[index] = x;
        this.size++;
    }

    public void set(int index, int x) {
        try {
            assert index < this.arr.length;
        } catch (AssertionError ae) {
            return;
        }
        arr[index] = x;
    }

    public void delete(int index) {
        try {
            assert index < this.arr.length;
        } catch (AssertionError ae) {
            return;
        }
        for (int i = index; i < this.arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    @Override
    public String toString() {
        return "\narr=" + Arrays.toString(arr);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray intArray = (IntArray) o;
        return Arrays.equals(arr, intArray.arr);
    }

    public static void main(String[] args) {
        IntArray arr = new IntArray();

        arr.add(0);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);
        System.out.println("After adding 0 to 9 :" + arr);

        arr.add(15, 15);
        System.out.println("After adding 15 into 15th: " + arr);
        arr.set(16, 16);
        System.out.println("After setting 16 into 16th: " + arr);
        arr.set(20, 16);
        System.out.println("After setting 16 into 20th: " + arr);
        arr.set(10, 10);
        System.out.println("After setting 10 into 10th: " + arr);
        arr.delete(6);
        System.out.println("After deleting 6th element: " + arr);
    }

}
