package fsabadini.exemplo.produtor;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/v1/messages")
public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${queue.messages}")
    private String queue;

    @GetMapping
    public ResponseEntity send() {
        this.rabbitTemplate.convertAndSend(queue, UUID.randomUUID().toString());
        return ResponseEntity.ok("Mensagem enviada com sucesso !" + Instant.now());
    }
}
