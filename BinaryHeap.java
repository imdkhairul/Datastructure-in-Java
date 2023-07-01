class BinaryHeap{
    public void buildBinaryHeap(int arr[], int size) {
        int i = size/2;
        for(; i>=0 ; i--){
            heapify(arr, i, size);
        }
    }

    public void heapify(int arr[],int index, int size) {
        int left = 2 * index + 1;
        int right = left + 1;

        int max = index;

        if (left <= size && arr[left] > arr[max]){
            max = left;
        }
        
        if (right <= size && arr[right] > arr[max]){
            max = right;
        }

        if (max != index){
            int temp = arr[max];
            arr[max] = arr[index];
            arr[index] = temp;
            heapify(arr, max, size);
        }
        
    }

    public void deleteMax(int arr[], int size) {
        int temp = arr[size];
        arr[size] = arr[0];
        arr[0] = temp;
        size = size - 1;
        heapify(arr,0, size);
    }

    public void print(int arr[], int size) {
        for (int i = 0; i < size; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap();
        int arr[] = {10,20,30,40,50,60,70};
        System.out.println("The Array Elements are:");
        heap.print(arr, arr.length);
        System.out.println("Constructiing Heap...");
        heap.buildBinaryHeap(arr, arr.length - 1);
        System.out.println("The array Elements are...");
        heap.print(arr, arr.length);
        System.out.println("Delete Max Element in Heap...");
        heap.deleteMax(arr, arr.length - 1);
        heap.print(arr, arr.length - 1);
    }
}