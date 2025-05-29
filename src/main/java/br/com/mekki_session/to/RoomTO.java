package br.com.mekki_session.to;


import lombok.Data;

@Data
public class RoomTO {

    private Integer id;

    private Integer capacity;

    private String name;

    private String code;

    private String description;

    private String maintenanceReason;

    private Boolean isAvailable;
}
