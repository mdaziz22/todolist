package com.icabot.ToDoList.services;

import com.icabot.ToDoList.dto.HeaderDto;
import com.icabot.ToDoList.model.Header;
import com.icabot.ToDoList.model.User;
import com.icabot.ToDoList.repository.HeaderRepository;
import com.icabot.ToDoList.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class HeaderService {

    @Autowired
    private HeaderRepository headerRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveHeader(HeaderDto header) {
        User userFromDb = userRepository.findById(header.getUserId()).orElseThrow();
        headerRepository.save(Header.builder()
                .headerId(header.getHeaderId())
                .header(header.getHeader())
                .date(Date.valueOf(LocalDate.now()))
                .user(userFromDb)
                .build());
    }


    public List<HeaderDto> getAllHeader() {
        List<Header> headerDb = headerRepository.findAll();
        List<HeaderDto> headerDto = new ArrayList<>();
        headerDb.stream().forEach(a -> headerDto.add(HeaderDto.builder()
                .headerId(a.getHeaderId())
                .header(a.getHeader())
                .date(a.getDate()).build()));

        return headerDto;

    }

    public void deleteHeader(long headerId) {
        Optional<Header> header = headerRepository.findById(headerId);
        if (!header.isEmpty()) headerRepository.delete(header.get());
        log.info("HeaderService: Deleted header with value: {}", header);
    }
}
