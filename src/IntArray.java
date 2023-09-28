import java.util.Arrays;

public class IntArray {
    private int[] arr;
    private int capacity;
    private int size;
    public IntArray() {
        arr = new int[10];
        this.capacity = 10;
        this.size = 10;
        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }
    }

    public IntArray(int capacity) {
        arr = new int[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    public void add(int x) {
        if(this.size>this.capacity) {
            this.capacity *= 2;
            int[] arrTmp = new int[this.capacity];

            for (int i = 0; i < this.size; i++) {
                arrTmp[i] = arr[i];
            }
            arrTmp[this.size++] = x;
            arr = arrTmp;
        }else{
            arr[this.size++] = x;
        }
    }

    public void add(int index, int x) {
        // If index is larger than the capacity or the array is full
        while(this.capacity<=index || this.size+1>this.capacity){
            this.capacity *= 2;
            int []arrTmp = new int[this.capacity];
            for(int i=0;i<arr.length;i++){
                arrTmp[i] = arr[i];
            }
            arr = arrTmp;
        }
        for (int i = this.size+1; i > index; i--) {
            arr[i] = arr[i-1];
        }
        arr[index] = x;
        this.size = index+1;
    }

    public void set(int index, int x){
        try {
            assert index < size;
        }catch (AssertionError ae){
            return;
        }
        arr[index]=x;
    }

    public void delete(int index){
        try {
            assert index < size;
        }catch (AssertionError ae){
            return;
        }
        for (int i = index; i < this.capacity-1; i++) {
            arr[i] = arr[i+1];
        }
    }

    @Override
    public String toString() {
        return "IntArray{" +
                "arr=" + Arrays.toString(arr) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntArray intArray = (IntArray) o;
        return Arrays.equals(arr, intArray.arr);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(arr);
    }

    public static void main(String[] args) {
        IntArray arr = new IntArray();

        arr.add(15,15);
        arr.set(16,16);
        arr.set(10,10);
        arr.delete(6);
        System.out.println(arr);
    }

}
