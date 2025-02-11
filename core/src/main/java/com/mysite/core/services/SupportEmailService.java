package com.adobe.aem.support.core.services;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.mailer.MailService;
import com.day.cq.mailer.MailingException;
import com.day.cq.mailer.MessageGateway;

@ServiceRanking(9999)
@Component(
    service = {MailService.class,MessageGateway.class},
	immediate = true,
	enabled = true)
public class SupportEmailService implements MailService, MessageGateway<Email> {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean handles(Class<? extends Email> arg0) {
       logger.info("SupportEmailService handles has been called");
       return true;
    }

    @Override
    public void send(Email arg0) throws MailingException {
        logger.info("Calling send method in SupportEmailService");
    }

    @Override
    public void sendEmail(Email arg0) throws EmailException {
        logger.info("Calling sendEmail method in SupportEmailService");
    }
    
}
