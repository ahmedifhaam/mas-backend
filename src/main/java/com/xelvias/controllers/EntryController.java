package com.xelvias.controllers;

import com.xelvias.models.Entry;
import com.xelvias.services.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(name = "/")
public class EntryController {
    @Autowired
    EntryService entryService;

    @RequestMapping(value = {"/entry"},method = RequestMethod.POST)
    @ResponseBody
    boolean saveEntry(@Valid @RequestBody Entry entry){
        entryService.saveEntry(entry);
        return true;
    }

//    @RequestMapping(value = {"/entries"},method = RequestMethod.GET)
//    @ResponseBody
//    List<Entry> getEntries(){
//        return entryService.getAll();
//    }

    @RequestMapping(value = {"/entries"},method = RequestMethod.GET)
    @ResponseBody
    List<Entry> getEntries(@RequestParam String fabric,@RequestParam String component,@RequestParam String size){
        System.out.println("Ifhaam "+fabric+component+size);
        return entryService.getEntries(fabric,component,size,100);
    }



    @RequestMapping(value = {"/test"})
    @ResponseBody
    String gettest(){
        return "tester";
    }

    @RequestMapping(value = "/entrysample")
    @ResponseBody
    Entry getSample(){
        return entryService.getSample();
    }
}
