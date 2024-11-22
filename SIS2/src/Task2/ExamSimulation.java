package Task2;
import Task2.ExamChecking;

public class ExamSimulation {
    public static void main(String[] args) {
        ExamChecking checker1 = new ExamChecking(6);
        ExamChecking checker2 = new ExamChecking(4);

        checker1.setName("Alibek");
        checker2.setName("Dana");

        checker1.setPriority(Thread.MAX_PRIORITY);
        checker2.setPriority(Thread.NORM_PRIORITY);

        checker1.start();
        checker2.start();
    }
}