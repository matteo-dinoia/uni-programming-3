import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Azione implements Runnable{
    private static ActivityCounter activity = new ActivityCounter(0);
    public Semaphore sem = null;
    public ConditionManager condMan = null;

    private int secToWait;
    private int index;
    private List<Integer> cond;

    public Azione(int index, int secToWait, int[] cond, ConditionManager condMan, Semaphore sem){
        this.index = index;
        this.secToWait = secToWait;
        this.condMan = condMan;
        this.sem = sem;

        this.cond = new ArrayList<>();
        for(int i = 0; i < cond.length; i++)
            this.cond.add(cond[i]);
    }
    public Azione(int index, int secToWait, int[] cond, ConditionManager condMan){
        this(index, secToWait, cond, condMan, null);
    }

    @Override
    public void run() {
        if(sem != null){
            try {
                sem.acquire();
                work();
            } catch (InterruptedException e) {
            } finally { sem.release(); }
        }else work();
    }


    private void work(){
        condMan.waitConditions(cond);
        action();
        activity.increaseCounter();
        condMan.setCondition(index);
    }

    private void action(){
        System.out.println("Inizio azione " + index + "(" + activity.getCounter() + ") waiting " + secToWait + " sec");
        try {
            Thread.sleep(secToWait * 333L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Fine azione " + index);
    }

}
