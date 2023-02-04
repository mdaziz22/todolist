package com.icabot.ToDoList.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long taskId;

    @ManyToOne(cascade = {CascadeType.DETACH
            , CascadeType.MERGE
            , CascadeType.PERSIST
            , CascadeType.REFRESH})
    @JoinColumn(name = "header_id", nullable = false)
    @JsonIgnore
    private Header header;

    private String task;

    private Boolean completedTask;


}
