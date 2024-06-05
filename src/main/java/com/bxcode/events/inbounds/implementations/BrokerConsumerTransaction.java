package com.bxcode.events.inbounds.implementations;

import com.bxcode.components.annotations.BrokerDeclareBinding;
import com.bxcode.components.annotations.BrokerDeclareExchange;
import com.bxcode.components.annotations.BrokerDeclareQueue;
import com.bxcode.dto.Event;
import com.bxcode.dto.TransactionMessage;
import com.bxcode.dto.TransactionRequest;
import com.bxcode.events.inbounds.contracts.IBrokerConsumerTransaction;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import static com.bxcode.components.constants.BrokerProcessConstants.*;

/**
 * BrokerConsumerTransaction
 * <p>
 * BrokerConsumerTransaction class.
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
@Service
@BrokerDeclareExchange(exchanges = {BROKER_DECLARE_EXCHANGE}, typeName = BROKER_DECLARE_EXCHANGE_TYPE)
@BrokerDeclareBinding(exchange = BROKER_DECLARE_EXCHANGE, routingKey = BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_CONSUMER_ROUTING_KEY, queue = BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_QUEUE)
public class BrokerConsumerTransaction implements IBrokerConsumerTransaction {


    @com.bxcode.components.annotations.BrokerConsumer(queues = BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_QUEUE,
            bindings = {@BrokerDeclareBinding(exchange = BROKER_DECLARE_EXCHANGE, routingKey = BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_CONSUMER_ROUTING_KEY, queue = BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_QUEUE)},
            declareQueues = {@BrokerDeclareQueue(queues = {BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_QUEUE})}
    )
    @Override
    public void transactionConsumer(Event<TransactionMessage<TransactionRequest>> eventTransactionMessage) {
        log.info("input to consumer {}", eventTransactionMessage.getData().getData().getRequest());
    }
}


