package com.pariyajafari.todolistproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    private long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate deadline;

    @Column
    private Status status;
}
