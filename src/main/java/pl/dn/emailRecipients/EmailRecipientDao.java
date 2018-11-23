package pl.dn.emailRecipients;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.dn.schoolClassOrganization.details.classType.ClassType;

import java.util.List;

public interface EmailRecipientDao extends CrudRepository<EmailRecipients, Long> {

    List<EmailRecipients> findByRecipientId(long userId, boolean isRead);

    @Query(value = "SELECT * FROM email_recipients WHERE recipient_id = :userId  LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
    public List<EmailRecipients> findByUserIdUsePagination
            (@Param("limitValue") int limit, @Param("offsetValue") int offset, @Param("userId") long userId);

    int countByRecipientIdAndIsRead(long userId, boolean isRead);
}
