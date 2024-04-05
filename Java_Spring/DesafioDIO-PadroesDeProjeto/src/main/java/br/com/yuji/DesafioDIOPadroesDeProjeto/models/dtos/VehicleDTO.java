package br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.enums.VehicleType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class VehicleDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String brand;
    private String model;
    private String color;
    private String licensePlate;
    private VehicleType type;

    @JsonIgnore
    private ParkingLotDTO parkingLotDTO;


    public VehicleDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
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
        VehicleDTO vehicleDTO = (VehicleDTO) o;
        return Objects.equals(id, vehicleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
