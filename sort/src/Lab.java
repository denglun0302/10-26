
import java.util.Arrays;
import java.util.Random;

interface SortMethod {
    String getName();
    void sort(int[] a);
}
interface Build{
    String getName();
    int[]  build(int n);
}
class buildRandom implements Build{
    @Override
    public String getName(){
        return "随机";
    }
    @Override
    public int[] build(int n){
       return  Lab.buildRandom(n);
    }
}
class buildSorted implements Build{
    @Override
    public String getName(){
        return "顺序";
    }
    @Override
    public int[] build(int n){
      return  Lab.buildSorted(n);
    }
}
class buildReverse implements Build{
    @Override
    public String getName(){
        return "逆序";
    }
    @Override
    public int[] build(int n){
       return Lab.buildReversed(n);
    }
}
class buildEqual implements Build{
    @Override
    public String getName(){
        return "相等";
    }
    @Override
    public int[] build(int n){
       return Lab.buildEquals(n);
    }
}

class InsertSortMethod implements SortMethod {
    @Override
    public String getName() {
        return "插入排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.insertSort0(a);
    }
}
class shellSortMethod implements SortMethod {
    @Override
    public String getName() {
        return "希尔排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.shellSort(a);
    }
}
class selectSortMethod implements SortMethod {
    @Override
    public String getName() {
        return "选择排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.select(a);
    }
}
class heapSortMethod implements SortMethod {
    @Override
    public String getName() {
        return "堆排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.heapSort(a);
    }
}
class bubbleSortMethod implements SortMethod {
    @Override
    public String getName() {
        return "冒泡排序";
    }

    @Override
    public void sort(int[] a) {
        Sort.bubbleSort(a);
    }
}

public class Lab {


    public static int[] buildRandom(int n) {
        Random random = new Random(20190924);
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = random.nextInt(n);
        }
        return r;
    }

    public static int[] buildSorted(int n) {
        Random random = new Random(20190924);
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = random.nextInt(n);
        }
        Arrays.sort(r);
        return r;
    }

    private static void shellSortR(int[] array) {
        int gap = array.length;
        while (true) {
            gap = (gap / 3) + 1;
            //gap = gap / 2;
            insertSortWithGapR(array, gap);
            if (gap == 1) {
                break;
            }
        }
    }
    private static void insertSortWithGapR(int[] array, int gap) {
        for (int i = gap; i < array.length; i++) {
            int key = array[i];
            int j;
            for (j = i - gap; j >= 0 && array[j] < key; j -= gap) {
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    public static int[] buildReversed(int n) {
        Random random = new Random(20190924);
        int[] r = new int[n];
        for (int i = 0; i < n; i++) {
            r[i] = random.nextInt(n);
        }
        shellSortR(r);
        return r;
    }

    public static int[] buildEquals(int n) {
        return new int[n];
    }

    public static void main(String[] args) {
        SortMethod[] methods = {
                new InsertSortMethod(), new shellSortMethod(), new selectSortMethod(), new heapSortMethod(), new bubbleSortMethod()
        };
        Build[] b = {new buildRandom(), new buildSorted(), new buildReverse(), new buildEqual()};

        for (int i = 1; i <= 4; i++) {
            int n = 50000 * i;
            for (Build b2 : b) {
                int[] a = b2.build(n);
                for (SortMethod method : methods) {
                    int[] a2 = a.clone();
                    long begin = System.nanoTime();
                    method.sort(a2);
                    long end = System.nanoTime();
                    double ms = (end - begin) * 1.0 / 1000000;
                    System.out.printf("%s: %s: %d: 耗时 %.5f 毫秒%n",b2.getName(), method.getName(), n, ms);
                }

            }
        }
    }
}
