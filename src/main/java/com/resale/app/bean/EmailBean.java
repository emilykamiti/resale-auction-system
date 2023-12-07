package com.resale.app.bean;



import javax.enterprise.event.Observes;
import javax.inject.Singleton;

import com.resale.app.model.entity.AuditLog;

import java.io.Serializable;

@Singleton
public class EmailBean implements Serializable {

    public void email(@Observes AuditLog log){
        System.out.println("Emailing: " + log.getLogDetails());
    }
}
