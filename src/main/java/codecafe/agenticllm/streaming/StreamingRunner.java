/**
 * StreamingRunner.java
 * <p>
 * This is a simple implementation of command line streaming.
 * It contains some reusable code to help you stream responses. Streaming
 * makes the process of development easier, but is non-trivial to implement and
 * should not be the focus of the assignment.
 *
 */
package codecafe.agenticllm.streaming;

import codecafe.agenticllm.services.StreamingAssistant;
import dev.langchain4j.service.TokenStream;

import java.util.concurrent.CountDownLatch;

public final class StreamingRunner {

    public static void run(StreamingAssistant assistant, String prompt) throws InterruptedException {
        // Construct the stream
        TokenStream stream = assistant.chat(1, prompt);

        // Will keep the application alive later
        CountDownLatch done = new CountDownLatch(1);

        // Configure the stream for the command line
        stream.onPartialResponse(System.out::print)
                .onCompleteResponse(_ -> {
                    System.out.println("\n\n--- completed ---");
                    done.countDown();
                })
                .onError(error -> {
                    error.printStackTrace();
                    done.countDown();
                })
                .start();

        // Keep the program alive so we can receive responses. LangChain4j will not 
        // occupy our main program, since that would completely freeze the GUI if we had one!
        done.await();
    }
}
