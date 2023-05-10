import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
Генерация 10000 чисел
От 0 до 10000
 */
public class NumGen {
    public static int[] generateNumber() throws IOException {
        int[] arr = new int[10000];
        Random random = new Random();
        FileWriter fileWriter = new FileWriter(new File("num"));

        for (int i = 0; i < 10000; i++) {
            arr[i] = random.nextInt(10000);
        }

        fileWriter.write(Arrays.toString(arr));

        return arr;
    }
}
