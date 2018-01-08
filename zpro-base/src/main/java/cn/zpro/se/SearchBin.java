package cn.zpro.se;

public class SearchBin {

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 23, 88, 105};

        System.out.println(searchBin(array, 0));
    }

    public static int searchBin(int[] array, int k) {
        int a = 0;
        int b = array.length;
        while (a < b) {
            int m = (a + b) / 2;
            if (k < array[m]) {
                b = m;
            } else if (k > array[m]) {
                a = m + 1;
            } else {
                return m;
            }
            System.out.println("循环次数+1");
        }
        return -1;
    }
}
