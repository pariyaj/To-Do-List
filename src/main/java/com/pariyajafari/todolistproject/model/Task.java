package com.pariyajafari.todolistproject.model;

import com.pariyajafari.todolistproject.model.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private String deadline;

    @Column
    private Status status;

    public Task(long id, Status status) {
        this.id = id;
        this.status = status;
    }
}
