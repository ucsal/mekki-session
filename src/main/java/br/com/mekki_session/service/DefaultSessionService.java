package br.com.mekki_session.service;

import br.com.mekki_session.client.RoomClient;
import br.com.mekki_session.entity.Session;
import br.com.mekki_session.repository.SessionRepository;
import br.com.mekki_session.to.SessionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Component
public class DefaultSessionService implements SessionService {

    @Autowired
    private SessionRepository repository;

    @Autowired
    private RoomClient roomClient;


    @Override
    public void save(SessionTO sessionTO) {
        validateInsert(sessionTO);
        repository.save(convertToSession(sessionTO));
    }

    @Override
    public Session updateSession(Session session) {
        return repository.save(session);
    }

    @Override
    public Session findSessionById(Integer id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Session> sessionListByUser() {
        //por enquanto so para testar
        return repository.findByuserId(1);
    }

    @Override
    public List<Session> sessionListAll() {
        return repository.findAll();
    }

    public boolean checkRoomAvailability(Integer roomId, Date date, LocalTime start, LocalTime end) {
        List<Session> sessions = repository.findByroomIdAndDate(roomId, date);

        for (Session s : sessions) {
            if (start.isBefore(s.getEndTime()) && end.isAfter(s.getStartTime())) {
                throw new RuntimeException("horario ja reservado");
            }
        }

        return true;
    }

    private boolean validateInsert(SessionTO sessionTO) {
        if (!roomClient.isAvailable(sessionTO.getRoomId())) {
            throw new RuntimeException("sala impedida de Reserva");
        }

        checkRoomAvailability(sessionTO.getRoomId(), sessionTO.getDate(),
                sessionTO.getStartTime(), sessionTO.getEndTime());

        return true;
    }


    private Session convertToSession(SessionTO sessionTO) {
        Session session = new Session();
        session.setDate(sessionTO.getDate());
        session.setRoomId(sessionTO.getRoomId());
        session.setUserId(sessionTO.getUserId());
        session.setDate(sessionTO.getDate());

        session.setStartTime(sessionTO.getStartTime());
        session.setEndTime(sessionTO.getEndTime());

        return session;

    }
}
