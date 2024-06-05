package com.bxcode.events.inbounds.contracts;

import com.bxcode.dto.Event;
import com.bxcode.dto.TransactionMessage;
import com.bxcode.dto.TransactionRequest;

/**
 * IBrokerConsumerTransaction
 * <p>
 * IBrokerConsumerTransaction interface.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 4/06/2024
 */
public interface IBrokerConsumerTransaction {

    void transactionConsumer(final Event<TransactionMessage<TransactionRequest>>  eventTransactionMessage);
}


