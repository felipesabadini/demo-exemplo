package fsabadini.exemplo.consumidor;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = "${queue.messages}")
    public void receive(String message) {
        System.out.println("Mensagem recebida -> " + message);
    }
}
