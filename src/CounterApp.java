import java.util.Scanner;
public class CounterApp {
    public static void main(String[] args) {
        String ctrl;//control variable
        long counterValue;//variable for counter value
        try {
            FileRW file = new FileRW();
            Counter counter = new Counter();
            counter.setCounter(file.readFromFile());//writing counter value with value from file
            System.out.printf("Счетчик загружен, значение '%d'.\n", counter.getCounter());
            Scanner input = new Scanner(System.in);
            while (true) {
                ctrl = input.next();
                try {
                    if (ctrl.equals("/inc")) {//increment counter value
                        try {
                            counterValue = counter.incCounter();
                            file.writeToFile(counterValue);
                            System.out.printf("Счетчик увеличен на '1'.\n'%d'\n", counter.getCounter());
                        } catch (Exception ex) {
                            counter.setCounter(0);
                            file.writeToFile(0);
                            System.out.println(ex.getMessage() + " Счетчик обнулился.");
                        }
                    } else if (ctrl.equals("/stop")) {
                        counterValue = counter.getCounter();
                        file.writeToFile(counterValue);
                        System.out.printf("'%d'\nЗавершаю работу.", counter.getCounter());
                        break;
                    } else if (ctrl.equals("/reset")) {
                        counter.setCounter(0);
                        file.writeToFile(0);
                        System.out.println("Счетчик обнулился.");
                    }
                } catch (Exception ex) {
                    System.out.println("Ошибка записи в файл");
                    throw ex;
                }
            }
        } catch (Exception ex) {
            System.out.println("Завершаю работу.");
        }
    }
}