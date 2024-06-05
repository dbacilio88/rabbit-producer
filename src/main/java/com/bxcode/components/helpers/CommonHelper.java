package com.bxcode.components.helpers;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j2;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.bxcode.constants.ProcessConstant.SIMPLE_DATE_FORMAT;

/**
 * CommonHelper
 * <p>
 * CommonHelper class.
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
public class CommonHelper {

    public static String createTimestamp(final Date currentDate) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT);
        return simpleDateFormat.format(currentDate);
    }

    public static String messageId(final String transactionId, String timestamp) {
        return transactionId.concat("-").concat(timestamp);
    }

    public static String correlationId(final String messageId, String requestId) {
        return requestId.concat("-").concat(messageId);
    }
}


