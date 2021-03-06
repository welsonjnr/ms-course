package com.msstudy.hrwoker.resources;

import com.msstudy.hrwoker.entities.Worker;
import com.msstudy.hrwoker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private static Logger Logger = LoggerFactory.getLogger(WorkerResource.class);

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @Value("${test.config}")
    private String testConfig;

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs(){
        Logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        List<Worker> list = repository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        Logger.info("PORT = " + env.getProperty("local.server.port"));

        Optional<Worker> worker = repository.findById(id);
        return worker.isPresent() ? ResponseEntity.ok(worker.get()) : ResponseEntity.notFound().build();
    }
}
