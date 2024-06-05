package com.bxcode.components.constants;

import lombok.experimental.UtilityClass;

/**
 * BrokerProcessConstants
 * <p>
 * BrokerProcessConstants class.
 * <p>
 * THIS COMPONENT WAS BUILT ACCORDING TO THE DEVELOPMENT STANDARDS
 * AND THE BXCODE APPLICATION DEVELOPMENT PROCEDURE AND IS PROTECTED
 * BY THE LAWS OF INTELLECTUAL PROPERTY AND COPYRIGHT...
 *
 * @author Bxcode
 * @author dbacilio88@outlook.es
 * @since 4/06/2024
 */
@UtilityClass
public class BrokerProcessConstants {
    public static final String BROKER_CONFIGURATION_PREFIX = "broker-configuration";
    public static final String BROKER_DECLARE_EXCHANGE = "${broker-configuration.common-configuration.broker-declare-exchange}";
    public static final String BROKER_DECLARE_EXCHANGE_TYPE = "${broker-configuration.common-configuration.broker-declare-exchange-type}";


    public static final String BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_QUEUE = "${broker-configuration.broker-response-consumer.queue}";
    public static final String BROKER_RABBIT_CONSUMER_TRANSACTION_RESPONSE_CONSUMER_ROUTING_KEY = "${broker-configuration.broker-response-consumer.routing-key}";
}


