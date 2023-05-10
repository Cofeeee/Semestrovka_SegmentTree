import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
      int[] arr = NumGen.generateNumber();
      Random random = new Random();

      long startTime = System.nanoTime();
      ModificationSegmentTree segmentTree = new ModificationSegmentTree(arr);
      long endTime = System.nanoTime();

      System.out.println("Время создание структуры: " + (((double)(endTime - startTime)) / 1000) + " милисек");
      System.out.println("Время добавление одного элемента(среднее): " + ((double)(endTime - startTime) / (1000 * 10000)) + " милисек");
      System.out.println("Количество итераций на добавление одного элемента(среднее): " + ((double)segmentTree.iteration / 10000) + "\n");
      segmentTree.timelist.clear();
      segmentTree.iterationlist.clear();
      segmentTree.iteration = 0;

      startTime = System.nanoTime();
      int start = random.nextInt(9900);
      segmentTree.sumRange(start,start+100);
      endTime = System.nanoTime();

      int sumIterate = 0;
      for(int a : segmentTree.iterationlist){
       sumIterate+= a;
      }


      System.out.println("Среднее время поиска: " + (((double)(endTime - startTime)) / 1000) + "милисек");
      System.out.println("Средняя количество итераций: " + ((double)sumIterate / 10000));
      System.out.println("Количество итераций для поиска элемента: " + segmentTree.iterationlist.toString());
      System.out.println("Время поиска: " + segmentTree.timelist.toString() + "\n");
      segmentTree.timelist.clear();
      segmentTree.iterationlist.clear();
      segmentTree.iteration = 0;

      startTime = System.nanoTime();
      for (int i = 0; i < 100 ; i++) {
       segmentTree.update(random.nextInt(1000),0);
      }
      endTime = System.nanoTime();

      sumIterate = 0;
      for(int a : segmentTree.iterationlist){
       sumIterate+= a;
      }


      System.out.println("Среднее время удаления: " + (((double)(endTime - startTime)) / 1000) + "милисек");
      System.out.println("Средняя количество итераций: " + ((double)sumIterate / 10000));
      System.out.println("Количество итераций для поиска элемента: " + segmentTree.iterationlist.toString());
      System.out.println("Время поиска: " + segmentTree.timelist.toString());

    }
}
