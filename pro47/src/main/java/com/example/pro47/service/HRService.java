package com.example.pro47.service;

import com.example.pro47.entity.HR;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class HRService {
    private final ArrayList<HR> hr_list = new ArrayList<>();

    public void create(HR hr) {
        hr_list.add(hr);
        log.info("HR was created");
    }

    public List<HR> getAll() {
        log.info("Getting the list of HR");
        return hr_list;
    }

    public HR getById(int id) {
        for (HR hr : hr_list)
            if (hr.getId() == id) {
                log.info("HR with id number {} was retrieved", hr.getId());
                return hr;
            }
        return null;
    }

    public void update(int id, HR hr_worker) {
        for (HR hr : hr_list)
            if (hr.getId() == id) {
                hr.setCompanyName(hr_worker.getCompanyName());
                hr.setLocatedCity(hr_worker.getLocatedCity());
                log.info("HR was updated");
            }
    }

    public void delete(int id) {
        for (HR hr : hr_list)
            if (hr.getId() == id) {
                hr_list.remove(hr);
                break;
            }
        log.info("HR was deleted");
    }


}
