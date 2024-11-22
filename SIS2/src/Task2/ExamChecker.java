package Task2;

import java.text.SimpleDateFormat;
import java.util.Date;

class ExamChecking extends Thread {
    private static int examSheets = 500;
    private final int limit;
    private static final Object lock = new Object();

    public ExamChecking(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                if (examSheets <= 0) {
                    System.out.println("There is no any exam sheet left! All papers were already checked!!!");
                    break;
                }
                int count = Math.min(limit, examSheets);
                examSheets -= count;


                String currentTime = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").format(new Date());
                System.out.println(getName() + " finished checking, at: " + currentTime +
                        ", exam sheet count is now " + examSheets);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

