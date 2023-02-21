package com.icabot.ToDoList.controller;

import com.icabot.ToDoList.dto.HeaderDto;
import com.icabot.ToDoList.dto.ValidateDto;
import com.icabot.ToDoList.services.HeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
public class HeaderController {

    @Autowired
    private HeaderService headerService;

    /*
     * Get all header
     */
    @GetMapping("/getAllHeader")
    public ResponseEntity<List<HeaderDto>> getAllHeader() {
        try {
            return new ResponseEntity<>(headerService.getAllHeader(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Get all header
     */
    @GetMapping("/getAllHeaderByUserId/{userId}")
    public ResponseEntity<List<HeaderDto>> getAllHeaderByUserId(@PathVariable long userId) {
        try {
            return new ResponseEntity<>(headerService.getAllHeaderByUserId(userId), HttpStatus.OK);
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /*
     * Creates the header provided by user
     */
    @PostMapping("/createHeader")
    public ResponseEntity<ValidateDto> createHeader(@RequestBody HeaderDto header) {
        try {
            headerService.saveHeader(header);
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("HeaderController: Successfully created Header: " + header)
                    .isSuccess(true)
                    .build(), HttpStatus.OK);

        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("HeaderController: Failed to create header: " + header)
                    .isSuccess(false)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

    /*
     *  Deletes header and corresponding tasks associated with it
     *  using the headerID provided by the user
     */
    @DeleteMapping("/deleteHeader/{headerId}")
    public ResponseEntity<ValidateDto> deleteHeader(@PathVariable long headerId) {
        try {
            headerService.deleteHeader(headerId);
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("HeaderController: Successfully deleted Header with headerId: " + headerId)
                    .isSuccess(true)
                    .build(), HttpStatus.OK);
        } catch (Exception ex) {
            ex.getStackTrace();
            return new ResponseEntity<>(ValidateDto.builder()
                    .errorMessage("HeaderController: Failed to delete header with headerId: " + headerId)
                    .isSuccess(false)
                    .build(), HttpStatus.BAD_REQUEST);
        }
    }

}
