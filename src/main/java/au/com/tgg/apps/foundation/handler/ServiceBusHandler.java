/* TopicReceiveController. Superseded by TopicReceiveController.java
package au.com.tgg.apps.foundation.handler;
import com.azure.messaging.servicebus.*;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Component
public class ServiceBusHandler {

    static void receiveMessages() throws InterruptedException
    {
        CountDownLatch countdownLatch = new CountDownLatch(1);

        // Create an instance of the processor through the ServiceBusClientBuilder
        ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
                .connectionString(System.getenv("AzureWebJobsAzureSBConnection"))
                .processor()
                .topicName(System.getenv("serviceBusTopic"))
                .subscriptionName("tstfoundationsbs01")
                .processMessage(ServiceBusHandler::processMessage)
                .processError(context -> processError(context, countdownLatch))
                .buildProcessorClient();

//        ServiceBusReceiverAsyncClient receiver = new ServiceBusClientBuilder()
//                .connectionString(System.getenv("AzureWebJobsAzureSBConnection"))
//                .receiver()
//                .topicName(System.getenv("serviceBusTopic"))
//                .subscriptionName("tgg-appcore-npd")
//                .buildAsyncClient();

        System.out.println("Starting the processor");
        processorClient.start();

        TimeUnit.SECONDS.sleep(10);
        System.out.println("Stopping and closing the processor");
        processorClient.close();
    }

    private static void processMessage(ServiceBusReceivedMessageContext context) {
        ServiceBusReceivedMessage message = context.getMessage();
        System.out.printf("Processing message. Session: %s, Sequence #: %s. Contents: %s%n", message.getMessageId(),
                message.getSequenceNumber(), message.getBody());
    }

    private static void processError(ServiceBusErrorContext context, CountDownLatch countdownLatch) {
        System.out.printf("Error when receiving messages from namespace: '%s'. Entity: '%s'%n",
                context.getFullyQualifiedNamespace(), context.getEntityPath());

        if (!(context.getException() instanceof ServiceBusException)) {
            System.out.printf("Non-ServiceBusException occurred: %s%n", context.getException());
            return;
        }

        ServiceBusException exception = (ServiceBusException) context.getException();
        ServiceBusFailureReason reason = exception.getReason();

        if (reason == ServiceBusFailureReason.MESSAGING_ENTITY_DISABLED
                || reason == ServiceBusFailureReason.MESSAGING_ENTITY_NOT_FOUND
                || reason == ServiceBusFailureReason.UNAUTHORIZED) {
            System.out.printf("An unrecoverable error occurred. Stopping processing with reason %s: %s%n",
                    reason, exception.getMessage());

            countdownLatch.countDown();
        } else if (reason == ServiceBusFailureReason.MESSAGE_LOCK_LOST) {
            System.out.printf("Message lock lost for message: %s%n", context.getException());
        } else if (reason == ServiceBusFailureReason.SERVICE_BUSY) {
            try {
                // Choosing an arbitrary amount of time to wait until trying again.
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println("Unable to sleep for period of time");
            }
        } else {
            System.out.printf("Error source %s, reason %s, message: %s%n", context.getErrorSource(),
                    reason, context.getException());
        }
    }

//    void receiveMessages(String connectionString, String queueName) throws InterruptedException
//    {
//        CountDownLatch countdownLatch = new CountDownLatch(1);
//
//        // Create an instance of the processor through the ServiceBusClientBuilder
//        ServiceBusProcessorClient processorClient = new ServiceBusClientBuilder()
//                .connectionString(connectionString)
//                .processor()
//                .queueName(queueName)
//                .processMessage(FoundationService::serviceBusProcessor)
//                .processError(context -> processError(context, countdownLatch))
//                .buildProcessorClient();
//
//        System.out.println("Starting the processor");
//        processorClient.start();
//
//        TimeUnit.SECONDS.sleep(10);
//        System.out.println("Stopping and closing the processor");
//        processorClient.close();
//    }

//    private final Logger logger = LoggerFactory.getLogger(ServiceBusHandler.class);
//    private static final String TOPIC_NAME = "tstfoundationsbt01";
//
//    private static final String SUBSCRIPTION_NAME = "tstfoundationsbs01";
//
//    @JmsListener(destination =  "tstfoundationsbt01", containerFactory = "jmsListenerContainerFactory", subscription = "tstfoundationsbs01")
//    public void receiveMessage(String json) {
//        System.out.println("Received message: {}" + json);
//    }

}

*/
