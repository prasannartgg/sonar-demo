package au.com.tgg.apps.foundation.util;

import au.com.tgg.apps.foundation.dto.ResponseDTO;
import au.com.tgg.apps.foundation.model.json.StockInfo;
import au.com.tgg.apps.foundation.service.FoundationService;
import org.apache.qpid.jms.message.JmsBytesMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.jms.JMSException;
import java.io.UnsupportedEncodingException;

@Component
public class TopicReceiveController {

    private static final String TOPIC_NAME = "tstfoundationsbt01";

    private static final String SUBSCRIPTION_NAME = "tstfoundationsbs01";

    private final Logger logger = LoggerFactory.getLogger(TopicReceiveController.class);

    @Autowired
    FoundationService foundationService;

    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
            subscription = SUBSCRIPTION_NAME)
    public void receiveSBMessage(JmsBytesMessage user) throws JMSException, UnsupportedEncodingException {
        int length = 0;
        length = new Long(user.getBodyLength()).intValue();
        byte[] b = new byte[length];
        user.readBytes(b, length);
        String jsonMsg = new String(b, "UTF-8");
        logger.info("SbMsg: {}", jsonMsg);
        foundationService.serviceBusProcessor(jsonMsg);
    }

//    @JmsListener(destination = TOPIC_NAME, containerFactory = "topicJmsListenerContainerFactory",
//            subscription = SUBSCRIPTION_NAME)
//    public void receiveFailedSBMessage(JmsBytesMessage user) throws JMSException, UnsupportedEncodingException {
//        int length = 0;
//        length = new Long(user.getBodyLength()).intValue();
//        byte[] b = new byte[length];
//        user.readBytes(b, length);
//        String text = new String(b, "UTF-8");
//        logger.info("SbMsg: {}", text);
//    }
}
