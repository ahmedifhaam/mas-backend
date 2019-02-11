package com.xelvias.dao;

import com.xelvias.models.Entry;

import java.util.List;

public interface EntryDAO {
    void save(Entry entry);
    List<Entry> findAllEntries();
}
