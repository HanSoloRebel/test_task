public class Counter{
    long counter;
    Counter (){
        setCounter(0);
    }
    public void incCounter() throws Exception{
        counter += 1;
        if (counter - 1 == Long.MAX_VALUE) throw new Exception("Достигнуто максимальное значение счетчика.");
    }
    public long getCounter(){
        return counter;
    }
    public void setCounter(long counter) {
        this.counter = counter;
    }
}