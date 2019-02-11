package com.xelvias.dao;

import com.xelvias.models.Entry;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("entity_repo")
public class EntryDAOImpl implements EntryDAO {

    @Autowired
    SessionFactory sessionFactory;

    public void save(Entry entry) {
        sessionFactory.getCurrentSession().persist(entry);
    }

    public List<Entry> findAllEntries() {
        return sessionFactory.getCurrentSession().createQuery("FROM Entry").setMaxResults(100).list();
    }
}
