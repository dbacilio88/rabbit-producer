package com.bxcode.services.implementations;

import com.bxcode.components.configurations.MicroserviceMessageConfiguration;
import com.bxcode.components.helpers.CommonHelper;
import com.bxcode.dto.Event;
import com.bxcode.dto.TransactionMessage;
import com.bxcode.dto.TransactionRequest;
import com.bxcode.events.outbounds.contracts.IBrokerProducerTransaction;
import com.bxcode.services.contracts.ITransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * TransactionService
 * <p>
 * TransactionService class.
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
public class TransactionService implements ITransactionService {
    private final IBrokerProducerTransaction producerTransaction;
    private final MicroserviceMessageConfiguration microserviceMessageConfiguration;

    public TransactionService(final IBrokerProducerTransaction producerTransaction,
                              final MicroserviceMessageConfiguration microserviceMessageConfiguration) {
        this.producerTransaction = producerTransaction;
        this.microserviceMessageConfiguration = microserviceMessageConfiguration;
    }

    @Override
    public void transactionProcess() {

        final String switchKey = UUID.randomUUID().toString();
        final String requestId = UUID.randomUUID().toString();
        final String tenantCode = "tenantCode";
        final Date currentDate = new Date();
        final String currentTimeStamp = CommonHelper.createTimestamp(currentDate);
        final String messageId = CommonHelper.messageId(switchKey, currentTimeStamp);
        final String correlationId = CommonHelper.correlationId(messageId, requestId);

        final TransactionMessage<TransactionRequest> transactionMessage = TransactionMessage.<TransactionRequest>builder()
                .requestId(requestId)
                .tenantCode(tenantCode)
                .eventSource(microserviceMessageConfiguration.getComponentId())
                .messageId(messageId)
                .transactionType("TRANSACTION-CODE")
                .correlationId(correlationId)

                .data(TransactionRequest.builder()
                        .transactionCode("TRANSACTION-CODE")
                        .switchKey(UUID.randomUUID().toString())
                        .request("hello world to producer")
                        .build())
                .build();

        Event<TransactionMessage<TransactionRequest>> event = producerTransaction.doOnProcessTransaction(transactionMessage);
        log.debug("process event from producer {}", event);

    }
}


