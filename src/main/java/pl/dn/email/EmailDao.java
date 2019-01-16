package pl.dn.email;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.email.customBodies.EmailShort;

@Repository
public interface EmailDao extends CrudRepository<Email, Long> {
    EmailShort findById(Long id);

    @Query(value = "select * " +
            "from email " +
            "where email.id = :emailId", nativeQuery = true)
    EmailShort findByIdWithShortSenderInfo(@Param("emailId") long emailId);

    @Query(value = "SELECT e.id as id, e.content as content, e.creation_time as creationTime, " +
            "e.topic as topic, u.first_name as firstName, u.last_name as lastName, uci.email as email FROM email e" +
            " LEFT JOIN user u ON u.id = e.sender_id " +
            " LEFT JOIN user_contact_info uci ON u.contact_info_id = uci.id " +
            " WHERE e.id = :emailId"
            , nativeQuery =  true)
    Object findFullEmail(@Param("emailId") Long emailId);

    @Query(value = "SELECT content FROM email" +
            " WHERE id = :emailId"
            , nativeQuery =  true)
    String getContentOnly(@Param("emailId") Long emailId);
}
