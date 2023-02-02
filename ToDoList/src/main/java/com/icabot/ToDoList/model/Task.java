package com.icabot.ToDoList.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.REFRESH,
                          })
    @JoinColumn(name = "header_id", nullable = false)
    private Header header;

    private String task;

    private Boolean completedTask;



}
