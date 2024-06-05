package com.bxcode.events.outbounds.implementations;

import com.bxcode.components.annotations.BrokerDeclareExchange;
import com.bxcode.components.annotations.BrokerPublisher;
import com.bxcode.components.configurations.MicroserviceMessageConfiguration;
import com.bxcode.components.enums.EventType;
import com.bxcode.components.exceptions.BrokerConfigurationException;
import com.bxcode.components.helpers.RoutingKeyHelper;
import com.bxcode.dto.Event;
import com.bxcode.dto.TransactionMessage;
import com.bxcode.dto.TransactionRequest;
import com.bxcode.events.outbounds.contracts.IBrokerProducerTransaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import static com.bxcode.components.constants.BrokerProcessConstants.BROKER_DECLARE_EXCHANGE;
import static com.bxcode.components.constants.BrokerProcessConstants.BROKER_DECLARE_EXCHANGE_TYPE;

/**
 * BrokerProducerTransaction
 * <p>
 * BrokerProducerTransaction class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 4/06/2024
 */

@Log4j2
@Component
@BrokerDeclareExchange(exchanges = {BROKER_DECLARE_EXCHANGE}, typeName = BROKER_DECLARE_EXCHANGE_TYPE)
public class BrokerProducerTransaction implements IBrokerProducerTransaction {

    private final MicroserviceMessageConfiguration messageConfiguration;

    public BrokerProducerTransaction(final MicroserviceMessageConfiguration messageConfiguration) {
        this.messageConfiguration = messageConfiguration;
    }


    @Override
    @BrokerPublisher(exchange = BROKER_DECLARE_EXCHANGE)
    public Event<TransactionMessage<TransactionRequest>> doOnProcessTransaction(TransactionMessage<TransactionRequest> transactionMessage) {
        try {
            final Event<TransactionMessage<TransactionRequest>> request = Event.<TransactionMessage<TransactionRequest>>builder()
                    .data(transactionMessage)
                    .routingKey(RoutingKeyHelper.createRoutingKey(EventType.SERVICE, messageConfiguration.getBrokerRequestProducer()))
                    .build();
            log.debug("transaction producer {} ", transactionMessage);
            return request;
        } catch (Exception e) {
            log.error("error in process doOnProcessTransaction producer{}", e.getMessage());
            throw new BrokerConfigurationException(e.getMessage());
        }
    }
}


