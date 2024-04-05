package br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Telephone;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Vehicle;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ParkingLotDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String cnpj;
    private Integer spaceForMotorcycles;
    private Integer spaceForCars;

    private AddressDTO addressDTO;


    public ParkingLotDTO() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public Integer getSpaceForMotorcycles() {
        return spaceForMotorcycles;
    }

    public void setSpaceForMotorcycles(Integer spaceForMotorcycles) {
        this.spaceForMotorcycles = spaceForMotorcycles;
    }

    public Integer getSpaceForCars() {
        return spaceForCars;
    }

    public void setSpaceForCars(Integer spaceForCars) {
        this.spaceForCars = spaceForCars;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLotDTO that = (ParkingLotDTO) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
