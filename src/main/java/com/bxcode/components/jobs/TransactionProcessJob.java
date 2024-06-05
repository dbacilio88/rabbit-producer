package com.bxcode.components.jobs;

import com.bxcode.components.configurations.MicroserviceJobConfiguration;
import com.bxcode.services.implementations.TransactionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * TransactionProcessJob
 * <p>
 * TransactionProcessJob class.
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
@EnableScheduling
public class TransactionProcessJob implements ApplicationListener<ApplicationReadyEvent> {

    private final MicroserviceJobConfiguration microserviceJobConfiguration;
    private final TransactionService transactionService;

    public TransactionProcessJob(final MicroserviceJobConfiguration microserviceJobConfiguration,
                                 final TransactionService transactionService) {
        this.microserviceJobConfiguration = microserviceJobConfiguration;
        this.transactionService = transactionService;
    }

    @Scheduled(cron = "${event-transaction.cron}")
    public synchronized void sendEventTransaction() {
        if (Boolean.TRUE.equals(microserviceJobConfiguration.isEnable())) {
            log.info("send evento to consumer {}", LocalDateTime.now());
            transactionService.transactionProcess();
        }
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        if (Objects.isNull(microserviceJobConfiguration)) {
            log.error("error in process onApplicationEvent, configuration is null");
        }
        if (Boolean.TRUE.equals(microserviceJobConfiguration.isEnable())) {
            sendEventTransaction();
        }

    }
}


