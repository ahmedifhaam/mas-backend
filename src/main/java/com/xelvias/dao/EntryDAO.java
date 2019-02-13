package com.xelvias.dao;

import com.xelvias.models.Entry;

import java.util.List;

public interface EntryDAO {
    void save(Entry entry);
    List<Entry> findAllEntries();
    List<Entry> findEntries(String fabric,String component,String size,int maxsize);
}
