package pl.dn.email;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface EmailDao extends CrudRepository<Email, Long> {

    EmailShort findById(Long id);

    @Query(value = "SELECT * FROM email WHERE id = :id", nativeQuery = true)
    Email findFullById(@Param("id") Long id);

    @Query(value = "select * " +
            "from email " +
            "where email.id = :emailId", nativeQuery = true)
    EmailShort findByIdWithShortSenderInfo(@Param("emailId") long emailId);
}
