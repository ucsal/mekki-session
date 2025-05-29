package br.com.mekki_session.controller;

import br.com.mekki_session.entity.Session;
import br.com.mekki_session.service.SessionService;
import br.com.mekki_session.to.SessionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController {


    @Autowired
    private SessionService service;


    @PostMapping("/save")
    public ResponseEntity saveSession(@RequestBody SessionTO sessionTO){
        service.save(sessionTO);
        return ResponseEntity.ok("funcionou");
    }

    @PostMapping("/update")
    public Session updateSession(@RequestBody Session session){
        return service.updateSession(session);
    }
    @GetMapping("/{id}")
    public Session findSession(@PathVariable Integer id){
        return service.findSessionById(id);
    }

    @GetMapping("/list")
    public List<Session> sessionListByUser(){
        return service.sessionListByUser();
    }

    @GetMapping("/listall")
    public List<Session> sessionListAll(){
        return service.sessionListAll();
    }

}
