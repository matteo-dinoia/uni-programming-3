import java.util.ArrayList;
import java.util.List;

public class ConditionManager {
    private ArrayList<Boolean> statusList = new ArrayList<>();

    public synchronized void waitConditions(List<Integer> cond){
       while(!checkConditions(cond)){
           try {
               wait();
           } catch (InterruptedException e) {}
       }

    }

    private boolean checkConditions(List<Integer> cond){
        for(int i = 0; i < cond.size(); i++){
            if(cond.get(i) < 0 || cond.get(i) >= statusList.size()  || !statusList.get(cond.get(i)))
                return false;
        }
        return true;

    }

    public synchronized void setCondition(int cond){
        if(cond < 0) return;

        int toAdd = cond - (statusList.size() - 1);
        for(int i = 0; i < toAdd; i++)
            statusList.add(false);

        statusList.set(cond, true);
        notifyAll();
    }
}
