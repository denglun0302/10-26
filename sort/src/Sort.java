public class Sort {
    public static void insertSort0(int[] array) {
        for(int i=1;i<array.length;i++){
            int key=array[i];
            int j=i-1;
            for(;j>=0&&array[j]>key;j--){
                array[j+1]=array[j];
            }
            array[j+1]=key;
        }
        //最好   O（n）
        //最坏O（n^2)
    }

    public static void shellSort(int[] array) {
        int gap = array.length;
        while (true) {
            gap = (gap / 3) + 1;
            insertWithGap(array, gap);
            if (gap == 1) {
                break;
            }
        }
    }

    private static void insertWithGap(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int key = array[i];
            int j = i - gap;
            for (; j > 0 && array[j] > key; j--) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    public static void select(int[] array) {
       for(int i=0;i<array.length-1;i++){
           int max=0;
           for(int j=1;j<array.length-i;j++){
               if(array[j]>array[max]){
                   max=j;
               }
           }
           swap(array,max,array.length-i-1);
       }
    }

    public static void selectsmall(int[] array) {
        // 无序区间[i,array.length)
       for(int i=0;i<array.length-1;i++){
           int min=i;
           for(int j=i+1;j<array.length;j++){
               if(array[j]<array[min]){
                   min=j;
               }
           }
           swap(array,min,i);
       }
    }

    public static void heapSort(int[] array) {
        createHeapBig(array, array.length);
        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - i - 1);
            shiftDownBig(array, 0, array.length - 1 - i);
        }
    }

    public static void createHeapBig(int[] a, int s) {
        for (int i = (s - 2) / 2; i >= 0; i--) {
            shiftDownBig(a, i, s);
        }
    }

    private static void shiftDownBig(int[] array, int index, int size) {
        while (2 * index + 1 < size) {
            int max = 2 * index + 1;
            if (max + 1 < size && array[max + 1] > array[max]) {
                max = max + 1;
            }
            if (array[index] >= array[max]) {
                return;
            }
            swap(array, index, max);
            index = max;
        }
    }

    private static void swap(int[] array, int max, int i) {
        int t = array[max];
        array[max] = array[i];
        array[i] = t;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSort = true;
            int j = 0;
            for (j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSort = false;
                }
                if (isSort) {
                    return;
                }
            }
        }
    }

}
