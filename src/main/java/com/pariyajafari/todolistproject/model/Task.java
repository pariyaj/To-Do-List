package com.pariyajafari.todolistproject.model;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Task(long id, Status status) {
        this.id = id;
        this.status = status;
    }
}
