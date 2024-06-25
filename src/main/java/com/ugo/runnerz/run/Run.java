package com.ugo.runnerz.run;
import java.time.LocalDateTime;

import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;

public record Run(
    @Id
    Integer id,
    @NotEmpty
    String title,
    LocalDateTime startedOn,
    LocalDateTime completedOn,
    @Positive
    Integer miles,
    Location location,
    @Version
    Integer version
) {
    public Run {
        if(!completedOn.isAfter(startedOn)) {
            throw new IllegalArgumentException("Completed On must be after Started On");
        }
    }

}
