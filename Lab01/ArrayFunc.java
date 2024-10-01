import java.util.Arrays;
import java.util.Scanner;

public class ArrayFunc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        double[] array = new double[size];
        System.out.println("Enter the elements:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextDouble();
        }

        Arrays.sort(array);
        System.out.print("Dang Phuong Nam 20225892\nSorted Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();

        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        System.out.println("Sum of Array Elements: " + sum);

        double average = sum / size;
        System.out.println("Average of Array Elements: " + average);
    }
}