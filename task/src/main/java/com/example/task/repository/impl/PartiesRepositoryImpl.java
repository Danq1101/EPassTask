package com.example.task.repository.impl;

import com.example.task.config.HibernateSessionFactory;
import com.example.task.domain.Parties;
import com.example.task.domain.TradeItems;
import com.example.task.repository.PartiesRepository;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PartiesRepositoryImpl implements PartiesRepository{



//    public void getData() {
//        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        session.beginTransaction();
//        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//        factory.setServiceClass(Parties.class);
//        factory.setAddress("http://www.epass.by/BEPTGlobalService?wsdl");
//        Parties parties = (Parties) factory.create();
//        List<TradeItems> data = parties.getTradeItems();
//        for (TradeItems partiesByGln : data) {
//            session.save(partiesByGln);
//        }
//        session.getTransaction().commit();
//        sessionFactory.close();
//    }

//    @Override
//    public void save(Parties parties) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tr = session.beginTransaction();
//        session.save(parties);
//        tr.commit();
//        session.close();
//    }
//
//    @Override
//    public void update(Parties parties) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tr = session.beginTransaction();
//        session.update(parties);
//        tr.commit();
//        session.close();
//    }
//
//    @Override
//    public void delete(Parties parties) {
//        Session session = HibernateSessionFactory.getSessionFactory().openSession();
//        Transaction tr = session.beginTransaction();
//        session.delete(parties);
//        tr.commit();
//        session.close();
//    }


    @Override
    public List<Parties> findAll(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Parties> parties = session.createQuery("FROM Parties", Parties.class).getResultList();
        session.close();
        return parties;
    }

    @Override
    public List<Parties> searchPartiesByModifiedTimes
            (String fromDate, String toDate, Integer startRecord, Integer recordCount) {
//        if (fromDate.length() != 10 || toDate.length() != 10) throw new Exception(exception.status(INVALID_DATE));
//        if (startRecord < 1 || recordCount < 1 || recordCount > 1000) throw new Exception(exception.status(INVALID_RECORD));
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<Parties> parties = session.createQuery("SELECT p FROM Parties p WHERE p.fromDate >=: fromDate or " +
                "p.toDate <=: toDate")
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
//        if (parties == null) throw new Exception(exception.status(NO_RESULT));
        session.close();
        return parties;
    }
    @Override
    public Parties getFullPartyByGLN(Long checkGln) {
//        if (String.valueOf(checkGln).length() != 13) throw new Exception(exception.status(INVALID_GLN));
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Parties parties = (Parties) session.createQuery("from Parties p where p.gln =: checkGln")
                .setParameter("checkGln", checkGln)
                .uniqueResult();
//        if (parties == null) throw new Exception(exception.status(GLN_DONT_EXIST));
        session.close();
        return parties;
    }

}

