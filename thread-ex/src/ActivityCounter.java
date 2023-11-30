public class ActivityCounter {
    private int activityCounter;

    public ActivityCounter(int start){
        activityCounter = start;
    }

    public synchronized void  increaseCounter(){
        activityCounter++;
    }

    public int getCounter(){
        return activityCounter;
    }
}
