package com.example.LocalizationRestApi.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
@ToString
@Entity
public class Geolocation {

    @Id
    private long id;
    @Size(min = 1, max = 6)
    private int deviceId;
    @Size(min = 1, max = 6)
    private int latitiude;
    @Size(min = 1, max = 6)
    private int longitude;

    public Geolocation() {
    }

    public Geolocation(@NotEmpty(message = "field deviceId is empty!") @Size(min = 1, max = 6) Integer deviceId, @NotEmpty(message = "latitiude age is empty!") @Size(min = 1, max = 6) Integer latitiude, @NotEmpty(message = "field longitude is empty!") @Size(min = 1, max = 6) Integer longitude) {
        this.deviceId = deviceId;
        this.latitiude = latitiude;
        this.longitude = longitude;
    }
}
