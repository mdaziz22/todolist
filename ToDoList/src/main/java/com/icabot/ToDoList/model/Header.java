package com.icabot.ToDoList.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Header {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long headerId;
    private String header;
    private Date date;

    @OneToMany(mappedBy = "header", cascade = CascadeType.REMOVE)
    private List<Task> tasks;


}
