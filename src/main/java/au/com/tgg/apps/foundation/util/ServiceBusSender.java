package au.com.tgg.apps.foundation.util;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderAsyncClient;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.util.retry.Retry;

import java.time.Duration;
import java.time.OffsetDateTime;

public final class ServiceBusSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceBusSender.class);

    public static void sendScheduledMessage(String topicName, String message) {
        sendScheduledMessage(topicName, message, (long) 300);
    }

    public static void sendScheduledMessage(String topicName, String message, Long delayInSeconds) {
        ServiceBusMessage serviceBusMessage = new ServiceBusMessage(message);
        ServiceBusSenderAsyncClient senderAsyncClient =  new ServiceBusClientBuilder()
                .connectionString(System.getenv("AzureWebJobsAzureSBConnection"))
                .sender()
                .topicName(topicName).buildAsyncClient();
        senderAsyncClient.scheduleMessage(serviceBusMessage, OffsetDateTime.now().plusSeconds(delayInSeconds))
                /*.flatMap(respBody -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromValue(respBody)))*/
                .timeout(Duration.ofSeconds(120))
                .retry(5)
                .doOnSubscribe( res -> {LOGGER.info("TRY SEND MSG TO SB: " + message);})
                .retryWhen(Retry.backoff(5, Duration.ofSeconds(10))
                        .jitter(0d)
                        .doAfterRetry(retrySignal -> {
                            LOGGER.info("Retry Sending - attempt: " + retrySignal.totalRetries() + " for : " + message);
                        })
                        .onRetryExhaustedThrow((retryBackoffSpec, retrySignal)
                                -> {LOGGER.error("Msg Reattempt Exhausted: "  + " msg: "+ message);
                            return new HttpServerErrorException(HttpStatus.REQUEST_TIMEOUT, "No response from Server"); }))
                .doOnSuccess(res ->
                        LOGGER.info("MSG SENT TO SB: " + message)
                )
                .doOnError(res -> {LOGGER.error("MSG SEND FAIL: " + res.getCause().toString() + " msg: "+ message);
                    res.printStackTrace();})
                .subscribe()
        ;
    }

    public static void sendMessage(String topicName, String message) {
        ServiceBusMessage serviceBusMessage = new ServiceBusMessage(message);
        ServiceBusSenderAsyncClient senderAsyncClient =  new ServiceBusClientBuilder()
                .connectionString(System.getenv("AzureWebJobsAzureSBConnection"))
                .sender()
                .topicName(topicName).buildAsyncClient();
        senderAsyncClient.sendMessage(serviceBusMessage).timeout(Duration.ofSeconds(120))
                .retry(5)
                .doOnSubscribe( res -> {LOGGER.info("TRY SEND MSG TO SB: " + message);})
                .retryWhen(Retry.backoff(5, Duration.ofSeconds(10))
                        .jitter(0d)
                        .doAfterRetry(retrySignal -> {
                            LOGGER.info("Retry Sending - attempt: " + retrySignal.totalRetries() + " for : " + message);
                        })
                        .onRetryExhaustedThrow((retryBackoffSpec, retrySignal)
                                -> {LOGGER.error("Msg Reattempt Exhausted: "  + " msg: "+ message);
                            return new HttpServerErrorException(HttpStatus.REQUEST_TIMEOUT, "No response from Server"); }))
                .doOnSuccess(res -> LOGGER.info("MSG SENT TO SB: " + message))
                .doOnError(res -> {LOGGER.error("MSG SEND FAIL: " + res.getCause().toString() + " msg: "+ message);
                    res.printStackTrace();})
                .subscribe();
    }
}
