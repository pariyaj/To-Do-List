package com.pariyajafari.todolistproject.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name:"tasks")    
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String name;

    @Column
    private String description;

    @Column
    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate deadline;

    @Column
    @NotNull
    private Status status;

    public Task(long id, Status status) {
        this.id = id;
        this.status = status;
    }
}
