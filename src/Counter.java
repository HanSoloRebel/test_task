public class Counter{
    private long counter; //No type requirements in the task. Memory saving: long type, not a BigDecimal
    Counter (){
        this(0);
    }
    Counter (long counter){
        this.counter = counter;
    }
    public long incCounter() throws Exception{
        counter += 1;
        if (counter - 1 == Long.MAX_VALUE) throw new Exception("Превышено максимальное значение счетчика.");//check for Max Value reaching
        else return counter;
    }
    public long getCounter(){
        return counter;
    }
    public void setCounter(long counter) {
        this.counter = counter;
    }
}