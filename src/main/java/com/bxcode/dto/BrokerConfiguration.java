package com.bxcode.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;

/**
 * BrokerConfiguration
 * <p>
 * BrokerConfiguration class.
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BrokerConfiguration implements Serializable {
    private static final long serialVersionUID = -5454798761785012662L;
    private String queue;
    private String command;
    private String routingKey;
    private String routingDomain;
    private String routingKeyOrigin;
    private String routingKeyDestiny;
}


