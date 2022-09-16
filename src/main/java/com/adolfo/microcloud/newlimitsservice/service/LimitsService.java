package com.adolfo.microcloud.newlimitsservice.service;

import com.adolfo.microcloud.newlimitsservice.entity.Limits;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class LimitsService {

    public List<Limits> getAll() {
        return new ArrayList<Limits>();
    }
}
