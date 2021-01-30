import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TimeTask {
        //每秒
        public static final int SECOND=1;
        //每天
        public static final int DAY=60*60*24;
        //每周
        public static final int WEEK=60*60*24*7;
        //每月
        public static final int MONTH=60*60*24*30;

        public static void task(String content,int frequency) {
            Runnable runnable = new Runnable() {
                public void run() {
                    FileUtil.write(content);
                }
            };
            ScheduledExecutorService service = Executors
                    .newSingleThreadScheduledExecutor();
            // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
            service.scheduleAtFixedRate(runnable, 0, frequency, TimeUnit.SECONDS);
        }

    public static void main(String[] args) {
        task("hahaha",3);
    }
}
