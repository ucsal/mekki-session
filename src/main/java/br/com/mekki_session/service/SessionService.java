package br.com.mekki_session.service;

import br.com.mekki_session.entity.Session;
import br.com.mekki_session.to.SessionTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SessionService {
    void save(SessionTO sessionTO);

    Session updateSession(Session session);

    Session findSessionById(Integer id);

    List<Session> sessionListByUser();

    List<Session> sessionListAll();
}



