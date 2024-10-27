import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Example1 {

    public static void main(String[] args) throws Exception{
        ThreadFactory factory=Thread.ofVirtual().name("request",0).factory();
    try(ExecutorService ex =Executors.newThreadPerTaskExecutor(factory)){
for(int i=0;i<100;i++){
    ex.submit()
}
    }

    }
}
