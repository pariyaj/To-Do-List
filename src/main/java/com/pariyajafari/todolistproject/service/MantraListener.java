package com.pariyajafari.todolistproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MantraListener {

    @Autowired
    private MantraService mantraService;

    public MantraListener(MantraService mantraService){
        this.mantraService = mantraService;
    }

    @KafkaListener(topics = "taskCreated", groupId = "mantraGroup")
    public void handleTaskCreated(Long taskId){
        mantraService.fetchAndSaveMantra();
    }
}
