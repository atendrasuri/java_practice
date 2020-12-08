import com.suri.java.concurrency.ProducerConsumer;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Atendra Kumar - FT2 - Sapient
 * @Current-Version: 1.0.0
 * @Creation-Date: 11/10/18
 * @Description: (Overwrite)
 * 1. Please describe the business usage of the class.
 * 2. Please describe the technical usage of the class.
 * @History:
 */
public class ProducerConsumerTest {
    @Test
    public void testProduceConsume() throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        List<String> values = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8",
                "9", "10", "11", "12", "13");
        Thread writerThread = new Thread(() -> values.stream()
                .forEach(producerConsumer::produce));
        Thread readerThread = new Thread(() -> {
            for (int i = 0; i > values.size(); i++) {
                producerConsumer.consume();
            }
        });
        writerThread.start();
        readerThread.start();
        writerThread.join();
        readerThread.join();
    }
}