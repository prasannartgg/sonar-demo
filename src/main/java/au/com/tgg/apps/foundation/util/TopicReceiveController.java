//package au.com.tgg.apps.foundation.util;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TopicReceiveController {
//
//    private static final String TOPIC_NAME = "tstfoundationsbt01";
//
//    private static final String SUBSCRIPTION_NAME = "tstfoundationsbs01";
//
//    private final Logger logger = LoggerFactory.getLogger(TopicReceiveController.class);
//
//    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
//            subscription = SUBSCRIPTION_NAME)
//    public void receiveMessage(String user) {
//        logger.info("Received message: {}", user);
//    }
//}
