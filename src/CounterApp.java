import java.util.Scanner;
public class CounterApp {
    public static void main(String[] args) {
        FileProcessing file = new FileProcessing();
        Counter counter = new Counter();
        counter.setCounter(file.readFromFile());
        System.out.printf("Счетчик загружен, значение '%d'.\n", counter.getCounter());
        Scanner input = new Scanner(System.in);
        while (true){
            String ctrl = input.next();
            if (ctrl.equals("/inc")){
                try {
                    counter.incCounter();
                    String counterValue = String.valueOf(counter.getCounter());
                    file.writeToFile(counterValue);
                    System.out.printf("Счетчик увеличен на '1'.\n'%d'\n", counter.getCounter());
                } catch (Exception ex) {
                    counter.setCounter(0);
                    file.writeToFile(String.valueOf(0));
                    System.out.println(ex.getMessage() + " Счетчик обнулился.");
                }
            } else if (ctrl.equals("/stop")) {
                String counterValue = String.valueOf(counter.getCounter());
                file.writeToFile(counterValue);
                System.out.printf("'%d'\nЗавершаю работу.", counter.getCounter());
                break;
            } else if (ctrl.equals("/reset")) {
                counter.setCounter(0);
                file.writeToFile(String.valueOf(0));
                System.out.println("Счетчик обнулился.");
            }
        }
    }
}