package br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.enums.TelephoneType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;

public class TelephoneDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String number;
    private TelephoneType type;

    @JsonIgnore
    private ParkingLotDTO parkingLotDTO;


    public TelephoneDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public TelephoneType getType() {
        return type;
    }

    public void setType(TelephoneType type) {
        this.type = type;
    }

    public ParkingLotDTO getParkingLotDTO() {
        return parkingLotDTO;
    }

    public void setParkingLotDTO(ParkingLotDTO parkingLotDTO) {
        this.parkingLotDTO = parkingLotDTO;
    }

    public String getParkingLotName() {
        return parkingLotDTO != null ? parkingLotDTO.getName() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TelephoneDTO telephoneDTO = (TelephoneDTO) o;
        return Objects.equals(id, telephoneDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
