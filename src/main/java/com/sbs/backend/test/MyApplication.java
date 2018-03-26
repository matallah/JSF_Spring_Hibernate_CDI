package com.sbs.backend.test;

import com.sbs.backend.main.entity.Emp;
import com.sbs.backend.main.service.IEmpService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mohamed.attalah on 3/26/2018.
 */
@Component
public class MyApplication {

    final static Logger logger = Logger.getLogger(MyApplication.class);

    @Autowired
    private IEmpService empService;

    public void performDbTasks() {
        Emp empNew = new Emp("Aymans", "studints");

        // Save new employee
        empService.insert(empNew);

        // Get saved employee
        Emp employee = empService.findEmployee(empNew.getEmpno());
        logger.debug("Retrieving saved employee " + employee);

    }

}
