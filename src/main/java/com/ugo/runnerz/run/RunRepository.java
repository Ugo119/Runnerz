package com.ugo.runnerz.run;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>();

    @PostConstruct
    private void init() {
        runs.add(new Run(
            1,
		    "Sunday morning run",
			LocalDateTime.now(),
			LocalDateTime.now().plus(50, ChronoUnit.MINUTES),
			6,
			Location.OUTDOOR));
        runs.add(new Run(
            2,
		    "Monday morning run",
			LocalDateTime.now(),
			LocalDateTime.now().plus(30, ChronoUnit.MINUTES),
			3,
			Location.OUTDOOR));

        runs.add(new Run(
            3,
            "Wednesday run",
            LocalDateTime.now(),
            LocalDateTime.now().plus(45, ChronoUnit.MINUTES),
            4,
            Location.INDOOR));    
    }

    List<Run> findAll() {
        return runs;
    }

    Optional<Run> findById(Integer id) {
        return runs.stream()
            .filter(run -> run.id() == id)
            .findFirst();
    }

    void create (Run run) {
        runs.add(run);
    }

    void updateRun(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if(existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    void delete(Integer id) {
        runs.removeIf(run-> run.id().equals(id));
    }

}
