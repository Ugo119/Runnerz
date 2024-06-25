package com.ugo.runnerz.run;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/runs")
class RunController {

    private final RunRepository runRepository;

    RunController(RunRepository runRepository) {
        this.runRepository = runRepository;
    }

    @GetMapping
    List<Run> findAll() {
        return runRepository.findAll();
    }

    @GetMapping("/{id}")
    Run findById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findById(id);
        if(run.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Run not found.");
        }
        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    void create(@Valid @RequestBody Run run) {
        runRepository.save(run);
    }

//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    void update(@Valid @RequestBody Run run, @PathVariable Integer id) {
//        runRepository.update(run,id);
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        runRepository.delete(runRepository.findById(id).get());
    }

    @GetMapping("/location/{location}")
    List<Run> findByLocation(@PathVariable String location) {
        return runRepository.findAllByLocation(location);
    }
}