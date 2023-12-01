package com.example.secondday;
import com.example.secondday.EntryDTO.CardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Component
public class Controller {
    @Autowired
    service service;
    @PostMapping("/addname/{name}")
    public ResponseEntity<String> addEmploy(@PathVariable("name") String name){
       return  new ResponseEntity<>(service.addEmploy(name), HttpStatus.ACCEPTED);
    }
    @PostMapping("/addteam/{evenOrOdd}/{nameOfteam}")
    public ResponseEntity<String> addteam(@PathVariable("evenOrOdd") int evenOROdd,@PathVariable("nameOfteam") String name){
        return  new ResponseEntity<>(service.addteam(evenOROdd,name), HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List> getAll(){
        return new ResponseEntity<>(service.getAllTeam(),HttpStatus.ACCEPTED);
    }
    @PostMapping("/add/Card")
    public ResponseEntity<String> addCard(@RequestBody CardDTO cardDTO){
        return new ResponseEntity<>(service.addCard(cardDTO),HttpStatus.ACCEPTED);
    }
}
