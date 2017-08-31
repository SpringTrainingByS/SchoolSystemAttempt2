package pl.dn.service.userType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.dao.userType.ModeratorDao;
import pl.dn.model.userType.Moderator;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.beans.Transient;

/**
 * Created by User on 31.08.2017.
 */
@Service
public class ModeratorService  {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public Moderator save(Moderator moderator) {

        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(moderator);

        return moderator;
    }

}
