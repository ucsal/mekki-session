package br.com.mekki_session.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RoomClient", url = "http://localhost:8085/room")
public interface RoomClient {

    @GetMapping("/{id}")
    Boolean isAvailable(@PathVariable("id") Integer id);
}
