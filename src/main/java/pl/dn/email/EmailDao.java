package pl.dn.email;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.email.customBodies.EmailCustom;
import pl.dn.email.customBodies.EmailFull;
import pl.dn.email.customBodies.EmailShort;

@Repository
public interface EmailDao extends CrudRepository<Email, Long> {

    <T extends EmailCustom> T findById(Long id, Class<? extends EmailCustom> projection);


    @Query(value = "select * " +
            "from email " +
            "where email.id = :emailId", nativeQuery = true)
    EmailShort findByIdWithShortSenderInfo(@Param("emailId") long emailId);
}
