package br.com.mekki_session.repository;

import br.com.mekki_session.entity.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session,Integer> {

    List<Session> findByuserId(Integer userId);

    List<Session> findByroomIdAndDate(Integer roomId, Date date);
}

