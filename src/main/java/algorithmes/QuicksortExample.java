package algorithmes;

public class QuicksortExample {

    public static void main(String[] args) {
        // Get a random generated array
        int[] a = getArray();
        // prints the given array
        printArray(a);
        // sort the array
        sort(a);
        System.out.println("");
        //prints the sorted array
        printArray(a);
    }

    // This method sorts an array and internally calls quickSort
    public static void sort(int[] a){
        int left = 0;
        int right = a.length-1;

        quickSort(a, left, right);
    }

    // This method is used to sort the array using quicksort algorithm.
    // It takes the left and the right end of the array as the two cursors.
    private static void quickSort(int[] a, int left,int right){
        // If both cursor scanned the complete array quicksort exits
        if(left >= right)
        return;

        // For the simplicity, we took the right most item of the array as a pivot

        int pivot = a[right];
        int partition = partition(a, left, right, pivot);

        // Recursively, calls the quicksort with the different left and right parameters of the sub-array
        quickSort(a,0, partition-1);
        quickSort(a,partition+1, right);
    }

    // This method is used to partition the given array and returns the integer which points to the sorted pivot index
    private static int partition(int[] a, int left,int right,int pivot){
        int leftCursor = left-1;
        int rightCursor = right;

        while(leftCursor < rightCursor){

            while(a[++leftCursor] < pivot);

            while(rightCursor > 0 && a[--rightCursor] > pivot);

            if(leftCursor >= rightCursor){
                break;
            }else{
                swap(a, leftCursor, rightCursor);
            }

        }

        swap(a, leftCursor, right);
        return leftCursor;
    }

    // This method is used to swap the values between the two given index
    public static void swap(int[] a, int left,int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }

    public static void printArray(int[] a){
        for(int i : a){
            System.out.print(i+" ");
        }
    }

    public static int[] getArray(){
        int size=10;
        int []array = new int[size];
        int item = 0;

        for(int i=0;i<size;i++){
            item = (int)(Math.random()*100);
            array[i] = item;
        }
        return array;
    }
}
