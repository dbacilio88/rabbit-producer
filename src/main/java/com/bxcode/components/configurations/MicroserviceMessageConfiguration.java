package com.bxcode.components.configurations;

import com.bxcode.dto.BrokerCommonConfiguration;
import com.bxcode.dto.BrokerConfiguration;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * MicroserviceMessageConfiguration
 * <p>
 * MicroserviceMessageConfiguration class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 4/06/2024
 */

@Data
@Configuration
@ConfigurationProperties(prefix = "broker-configuration")
public class MicroserviceMessageConfiguration {

    @Value("${microservices.entityUuid}")
    private String componentId;
    private BrokerCommonConfiguration commonConfiguration;
    private BrokerConfiguration brokerRequestProducer;
    private BrokerConfiguration brokerResponseConsumer;
}


