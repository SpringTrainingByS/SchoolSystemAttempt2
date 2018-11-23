package pl.dn.email;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.emailShorter.EmailShorter;

import java.util.List;

@Repository
public interface EmailDao extends CrudRepository<Email, Long> {

//    @Query(value = "SELECT id, topic, creation_time FROM email WHERE id = :id", nativeQuery = true)
//    EmailBasic findById(Long id);

    Email findById(Long id);

    @Query(value = "SELECT * FROM email WHERE id = :id", nativeQuery = true)
    Email findFullById(@Param("id") Long id);

    @Query(value = "select email.id as emailId, email.content as content, email.creation_time as creationTime, email.topic as topic, " +
            "user.id as userId, user.first_name as firstName, user.last_name as lastName, user_contact_info.email as emailAddress " +
            "from email " +
            "left JOIN user ON email.sender_id = user.id " +
            "left JOIN user_contact_info ON user.contact_info_id = user_contact_info.id " +
            "where email.id = :emailId", nativeQuery = true)
    Object findByIdWithShortSenderInfo(@Param("emailId") long emailId);
}
