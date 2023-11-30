package max;

import java.util.List;
import java.util.concurrent.Callable;

public class MaxCalc<T extends Comparable<T>> implements Callable<T> {
    private final List<T> list;

    public MaxCalc (List<T> list){
        this.list = list;
    }

    @Override
    public T call() throws Exception {
        if(list == null || list.isEmpty())
            return null;

        T ret = null;
        for(T el : list){
            if(ret == null || (el != null && el.compareTo(ret) > 0))
                ret = el;
        }

        return ret;
    }
}
