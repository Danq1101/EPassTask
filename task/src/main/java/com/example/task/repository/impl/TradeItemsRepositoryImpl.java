package com.example.task.repository.impl;

import com.example.task.config.HibernateSessionFactory;
import com.example.task.domain.TradeItems;
import com.example.task.repository.TradeItemsRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TradeItemsRepositoryImpl implements TradeItemsRepository {
//    @Override
//    public void save(Parties user) {
//
//    }
//
//    @Override
//    public void update(Parties user) {
//
//    }
//
//    @Override
//    public void delete(Parties user) {
//
//    }

    @Override
    public List<TradeItems> findAll(){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<TradeItems> tradeItems = session.createQuery("FROM TradeItems", TradeItems.class).getResultList();
        session.close();
        return tradeItems;
    }

    @Override
    public List<TradeItems> searchSimpleTradeItemsByModifiedTime3
            (String fromDate, String toDate, Integer recordCount, Integer startCount) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List<TradeItems> tradeItems = session.createQuery("SELECT t FROM TradeItems t WHERE t.fromDate >=: fromDate and t.toDate <=: toDate")
                .setParameter("fromDate", fromDate)
                .setParameter("toDate", toDate)
                .getResultList();
//        Query query = session.createQuery("SELECT t FROM TradeItems t WHERE t.fromDate >=: fromDate and t.toDate <=: toDate");
//        query.setParameter("fromDate", fromDate);
//        query.setParameter("toDate", toDate);
//        List<TradeItems> tradeItems = query.getResultList();
        session.close();
        return tradeItems;
    }
}
