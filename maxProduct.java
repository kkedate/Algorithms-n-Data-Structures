package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class maxProduct {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        writer.write("Введите количество элементов массива: ");
        writer.flush();
        int n = Integer.parseInt(reader.readLine());

        if (n < 3) {
            writer.write("Массив должен содержать минимум 3 элемента.\n");
            writer.flush();
            return;
        }

        int[] array = new int[n];
        writer.write("Введите элементы массива:\n");
        writer.flush();
        String[] input = reader.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(array);
        int maxProduct1 = array[n - 1] * array[n - 2] * array[n - 3];
        int maxProduct2 = array[0] * array[1] * array[n - 1];
        int maxProduct = Math.max(maxProduct1, maxProduct2);

        int num1, num2, num3;

        if (maxProduct == maxProduct1) {
            num1 = array[n - 1];
            num2 = array[n - 2];
            num3 = array[n - 3];
        } else {
            num1 = array[0];
            num2 = array[1];
            num3 = array[n - 1];
        }

        writer.write("Наибольшее произведение 3 чисел: " + num1 + num2 + num3);
        writer.flush();

        reader.close();
        writer.close();
    }
}
