package com.icabot.ToDoList.services;

import com.icabot.ToDoList.dto.HeaderDto;
import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.Task;
import com.icabot.ToDoList.repository.HeaderRepository;
import com.icabot.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeaderService {

    @Autowired
    private HeaderRepository headerRepository;

    @Autowired
    private TaskRepository taskRepository;

    public void createHeader(Header header) {
        headerRepository.save(header);
    }

    public void addTask(long id, Task task) {
        var header = headerRepository.findById(id);
        if(!header.isEmpty()){
            taskRepository.save(task);
        }
    }

    public void saveHeader(Header header) {

        headerRepository.save(header);
    }


    public List<HeaderDto> getAllHeader() {
        List<Header> headerDb = headerRepository.findAll();
        List<HeaderDto> headerDto = new ArrayList<>();
        headerDb.stream().forEach(a->headerDto.add(HeaderDto.builder()
                .headerId(a.getHeaderId())
                .header(a.getHeader())
                .date(a.getDate()).build()));
       return headerDto;

    }
}
