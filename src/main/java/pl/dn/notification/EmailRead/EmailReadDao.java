package pl.dn.notification.EmailRead;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailReadDao extends CrudRepository<EmailRead, Long> {
    public EmailReadBool findByUserId(long userId);
}
