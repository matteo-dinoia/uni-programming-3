package max;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Main {
    private static final int NUM_THREADS = 10;
    private static final int COL = 30;
    private static final int ROW = 30;

    public static Integer max(List<List<Integer>> matrix){
        if(matrix == null || matrix.isEmpty())
            return null;

        Integer ret = null, el;

        try(ExecutorService ex = Executors.newFixedThreadPool(NUM_THREADS)){
            List<FutureTask<Integer>> futureTasks = new ArrayList<>();
            for (List<Integer> integers : matrix){
                FutureTask<Integer> tmp = new FutureTask<>(new MaxCalc<>(integers));
                futureTasks.add(tmp);
                ex.execute(tmp);
            }

            for(FutureTask<Integer> ft : futureTasks){
                el = ft.get();
                if(ret == null || (el != null && el.compareTo(ret) > 0))
                        ret = el;
            }
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ret;
    }

    public static void main(String[] args) {


        List<List<Integer>> m = new ArrayList<>();
        for(int i = 0; i < ROW; i++)
            m.add(createRandom());
        System.out.println(max(m));
    }

    private static List<Integer> createRandom(){
        List<Integer> li = new ArrayList<>();
        for(int i = 0; i < COL; i++){
            Integer ins = (int)(Math.random() * 100000);
            System.out.print(ins + " ");
            li.add(ins);
        }
        System.out.println();

        return li;
    }
}