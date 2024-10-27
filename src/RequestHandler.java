import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RequestHandler implements Callable<String> {

    String dbcall() {
        return null;
    }

    String restcall() {
        return null;
    }

    @Override
    public String call() throws Exception {
        try (ExecutorService ex = Executors.newVirtualThreadPerTaskExecutor()) {
            String output = CompletableFuture.supplyAsync(this::dbcall, ex).thenCombine(
                    CompletableFuture.supplyAsync(this::restcall, ex), (a, b) -> {
                        return a + "" + b;
                    }).join();


            return output;
        }
    }
}