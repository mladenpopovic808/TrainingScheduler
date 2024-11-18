package rs.ognjen_uros.spring_zakazivanje_treninga.amqListener;

import lombok.AllArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import rs.ognjen_uros.spring_zakazivanje_treninga.dto.IncrementNumberOfSessionsDto;
import rs.ognjen_uros.spring_zakazivanje_treninga.helper.MessageHelper;
import rs.ognjen_uros.spring_zakazivanje_treninga.service.UserService;

import javax.jms.JMSException;
import javax.jms.Message;

@AllArgsConstructor
@Component
public class IncrementNumberOfSessionsListener {

    private final MessageHelper messageHelper;
    private final UserService userService;



    @JmsListener(destination = "${destination.incrementNumberOfSessions}", concurrency = "5-10")
    public void incrementReservationCount(Message message) throws JMSException {
        IncrementNumberOfSessionsDto incrementNumberOfSessionsDto = messageHelper.getMessage(message, IncrementNumberOfSessionsDto.class);
        System.out.println(incrementNumberOfSessionsDto);
        userService.updateUserNumberOfSessions(incrementNumberOfSessionsDto.getUserId());
    }
    

}
