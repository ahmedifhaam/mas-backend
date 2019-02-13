package com.xelvias.dao;

import com.xelvias.models.Entry;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

    public List<Entry> findEntries(String fabric,String component,String size,int maxSize){

        Query from_entry = sessionFactory.getCurrentSession().createQuery("FROM Entry");
        List<Entry> list = from_entry.list();

        List<Entry> output = new ArrayList<>();
        for(Entry entry : list){
            if(entry.getFabric().equals(fabric) && entry.getComponent().equals(component) && entry.getSize().equals(size)){
                output.add(entry);
            }
        }

        return output;
//        return sessionFactory.getCurrentSession().createQuery("FROM Entry WHERE Entry.fabric='"
//                +fabric+"' and Entry.component='"+component+"' and Entry.size='"+size+"'").setMaxResults(maxSize).list();
    }
}
