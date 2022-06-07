import com.tcs.edu.domain.Doubling;
import com.tcs.edu.domain.Message;
import com.tcs.edu.domain.MessageOrder;
import com.tcs.edu.domain.Severity;
import com.tcs.edu.service.HashMapMessageRepository;
import com.tcs.edu.service.MessageService;
import com.tcs.edu.service.RepositoryMessageService;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;


class RepositoryMessageServiceTest {

    @Test
    void testLog() {
        HashMapMessageRepository messageRepository = new HashMapMessageRepository();
        MessageService messageService = new RepositoryMessageService(messageRepository);
        messageService.log(MessageOrder.ASC,
                Doubling.DISTINCT,
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 0", Severity.MINOR),
                new Message("Hello world! 1", Severity.MINOR),
                new Message("Hello world! 2", Severity.MINOR),
                new Message("Hello world! 3", Severity.MINOR),
                new Message("Hello world!", Severity.REGULAR),
                new Message("Hello world!", Severity.MAJOR));
        assertThat(messageRepository.findAll().stream().map(Message::getBody).collect(Collectors.toSet())).contains("Hello world! 0");
        assertThat(messageRepository.findAll().stream().map(Message::getBody).collect(Collectors.toSet())).contains("Hello world! 1");
        assertThat(messageRepository.findAll().stream().map(Message::getBody).collect(Collectors.toSet())).contains("Hello world! 2");
        assertThat(messageRepository.findAll().stream().map(Message::getBody).collect(Collectors.toSet())).contains("Hello world! 3");
        assertThat(messageRepository.findAll().stream().map(Message::getBody).collect(Collectors.toSet())).contains("Hello world!");
    }
}