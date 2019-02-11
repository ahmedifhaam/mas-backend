package com.xelvias.services;

import com.xelvias.models.Entry;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


public interface EntryService {
    void saveEntry(Entry entry);
    List<Entry> getAll();
    Entry getSample();
}
