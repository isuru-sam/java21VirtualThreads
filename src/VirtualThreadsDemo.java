import java.util.concurrent.ThreadFactory;

public class VirtualThreadsDemo {
    public static void main(String[] args) throws Exception{


        System.out.println("Hello world!");
    }

    public static void handleUserRequests() {

        System.out.println("Enter threead");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Exit thread");

    }
    private static void virtualThreadBuilder() throws InterruptedException {
       //not thread safe
        Thread.Builder.OfVirtual vBuilder =Thread.ofVirtual().name("UsertThread",0);
        Thread v1 =vBuilder.start(VirtualThreadsDemo::handleUserRequests);
        Thread v2 =vBuilder.start(VirtualThreadsDemo::handleUserRequests);
        v1.join();
        v2.join();
    }
    //thread safe
    private static void VirtualThreadactory() throws InterruptedException{
        ThreadFactory tf=Thread.ofVirtual().name("FactoryThreasds",0).factory();
    Thread t1 = tf.newThread(VirtualThreadsDemo::handleUserRequests);
    t1.start();
    Thread t2 = tf.newThread(VirtualThreadsDemo::handleUserRequests);
    t2.start();

    t1.join();
    t2.join();
    }
    }