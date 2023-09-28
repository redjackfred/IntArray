public class IntArrayJiaoming {
    private int[] array;

    private int size;



    public IntArrayJiaoming() {
        this.array = new int[10];
        this.size = 0;
    }

    public IntArrayJiaoming(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }
    public void add(int x){
        // double capacity if the array is full.
        if(this.size == array.length) {
            int capacity = 2 * array.length;
            int[] tempArray = new int[capacity];
            for (int i = 0; i < array.length; i++) {
                tempArray[i] = array[i];
            }
            array = tempArray;
        }
        //add value x into the last index of the array.
        array[size] = x;
        size++;
    }
    public void add(int index, int x){
        int capacity = array.length;
        while( index >= capacity){
            capacity = 2 * capacity;
        }
        int[] tempArray = new int[capacity];
        for(int i = 0; i< array.length; i++){
            if(i < index ){
                tempArray[i] = array[i];
            }else{
                tempArray[i] = array[i-1];
            }
        }
        tempArray[index] = x;
        array = tempArray;
        size++;
    }
    public void set(int index, int x){
        if(index < array.length) array[index] = x;
    }
    public void delete(int index){
        if(index < array.length){
            for(int i = index; i < array.length-1; i++){
                array[i] = array[i+1];
            }
            array[array.length-1] = 0;
        }
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < array.length-1; i++){
            str.append(array[i]).append(",");
        }
        str.append(array[array.length-1]);
        return str.toString();
    }
    public boolean equals(IntArrayJiaoming intArray){
        if(intArray.size!= this.size){
            return false;
        }
        for(int i = 0; i < intArray.size; i++){
            if(intArray.array[i] != array[i]){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IntArrayJiaoming array = new IntArrayJiaoming();
        IntArrayJiaoming intarray = new IntArrayJiaoming();
        array.add(9);
        intarray.add(9);
        System.out.println(array);
        array.add(12, 8);
        intarray.add(2,8);
        System.out.println(array);
        array.set(5,5);
        System.out.println(array);
        array.set(15,5);
        System.out.println(array);
        array.set(9,5);
        System.out.println(array);
        array.add(2,5);
        System.out.println(array);
        array.set(10,110);
        System.out.println(array);
        array.set(39,15);
        System.out.println(array);
        array.set(8,15);
        System.out.println(array);
        array.delete(9);
        System.out.println(array);
        System.out.println(array.equals(intarray));

    }
}
