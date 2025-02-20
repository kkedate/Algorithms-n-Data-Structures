package lab2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class keyboard {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write("Введите количество клавиш: ");
        writer.flush();
        int n = Integer.parseInt(reader.readLine());

        int[] maxPresses = new int[n];
        writer.write("Введите количество нажатий на клавишу: ");
        writer.flush();
        String[] maxPressesInput = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            maxPresses[i] = Integer.parseInt(maxPressesInput[i]);
        }
        writer.write("Введите общее количество нажатий на клавиши: ");
        writer.flush();
        int k = Integer.parseInt(reader.readLine());

        int[] currentPresses = new int[n];
        writer.write("Введите последовательность нажатий клавиш: ");
        writer.flush();
        String[] pressesInput = reader.readLine().split(" ");
        for (int i = 0; i < k; i++) {
            int index = Integer.parseInt(pressesInput[i]) - 1;
            currentPresses[index]++;
        }
        for (int i = 0; i < n; i++) {
            if (currentPresses[i] > maxPresses[i]) {
                writer.write("YES\n");
            } else {
                writer.write("NO\n");
            }
        }
        writer.flush();
        reader.close();
        writer.close();
    }
}
