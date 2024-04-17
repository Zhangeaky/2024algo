package aleetcode.algo.sort;

public class InsertSorting implements Sorting{


    @Override
    public int[] sorting(int[] input) {

        if (input == null) {
            return null;
        }

        for (int i=1; i<input.length; i++) {
            for (int j=i-1 ; j>=0; j--) {
                swap(input, i, j);
            }
        }


        return new int[0];
    }

    private void swap(int[] arr, int i, int j) {

        if (arr[j] < arr[i]) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}
