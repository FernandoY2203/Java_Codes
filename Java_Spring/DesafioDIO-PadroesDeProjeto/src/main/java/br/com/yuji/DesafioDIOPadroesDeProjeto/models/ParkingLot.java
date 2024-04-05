package br.com.yuji.DesafioDIOPadroesDeProjeto.models;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.enums.VehicleType;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.exceptions.LackOfSpaceException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ParkingLot implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String cnpj;
    @Column(nullable = false)
    private Integer spaceForMotorcycles;
    @Column(nullable = false)
    private Integer spaceForCars;

    @ManyToOne
    private Address address;
    @OneToMany(mappedBy = "parkingLot")
    private List<Telephone> telephones = new ArrayList<>();
    @OneToMany(mappedBy = "parkingLot")
    private List<Vehicle> vehicles = new ArrayList<>();


    public ParkingLot() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Telephone> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones) {
        this.telephones = telephones;
    }
    public void addTelephone(Telephone telephone) {
        telephones.add(telephone);
    }

    public void removeTelephone(Telephone telephone) {
        telephones.remove(telephone);
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

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void addVehicles(Vehicle vehicle) {
        if(vehicle.getType() == VehicleType.CAR) {
            if(spaceForCars == 0) {
                throw new LackOfSpaceException("There is no more Space for Cars...");
            }

            this.spaceForCars -= 1;
            vehicles.add(vehicle);
        }
        else {
            if(spaceForMotorcycles == 0) {
                throw new LackOfSpaceException("There is no more Space for Motorcycles...");
            }

            this.spaceForMotorcycles -= 1;
            vehicles.add(vehicle);
        }
    }

    public void removeVehicle(Vehicle vehicle) {
        if(vehicle.getType() == VehicleType.CAR) {
            this.spaceForCars += 1;
            vehicles.remove(vehicle);
        }
        else {
            this.spaceForMotorcycles += 1;
            vehicles.remove(vehicle);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingLot that = (ParkingLot) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
