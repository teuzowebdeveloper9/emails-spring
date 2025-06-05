package email.project.email.consummers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class emailCosummer {

    @RabbitListener(queues = "email-queue")
    public  void  ListenEmailQueue(@Payload String message){

        System.out.println(message);

    }


}
