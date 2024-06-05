package com.bxcode.components.helpers;

import com.bxcode.components.enums.EventType;
import com.bxcode.components.exceptions.BrokerConfigurationException;
import com.bxcode.dto.BrokerConfiguration;
import com.bxcode.dto.RoutingKey;
import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.util.Objects;

/**
 * RoutingKeyHelper
 * <p>
 * RoutingKeyHelper class.
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
@UtilityClass
public class RoutingKeyHelper {

    public static RoutingKey createRoutingKey(final EventType eventType, final BrokerConfiguration brokerConfiguration) {
        if (Objects.isNull(brokerConfiguration)) {
            throw new BrokerConfigurationException("error in brokerConfiguration, the current configuration is null");
        }
        final RoutingKey routingKey = RoutingKey.builder()
                .eventType(eventType)
                .origin(brokerConfiguration.getRoutingKeyOrigin())
                .destiny(brokerConfiguration.getRoutingKeyDestiny())
                .domain(brokerConfiguration.getRoutingDomain())
                .command(brokerConfiguration.getCommand())
                .build();
        log.debug("the routingKey configuration is {}", routingKey.toString());
        return routingKey;
    }
}


