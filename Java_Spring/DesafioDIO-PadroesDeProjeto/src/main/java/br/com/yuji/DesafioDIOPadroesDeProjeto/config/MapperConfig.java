package br.com.yuji.DesafioDIOPadroesDeProjeto.config;

import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Address;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.ParkingLot;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Telephone;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.Vehicle;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.AddressDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.ParkingLotDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.TelephoneDTO;
import br.com.yuji.DesafioDIOPadroesDeProjeto.models.dtos.VehicleDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapperConfig {

    // ParkingLot Mapper
    @Mapping(source = "parkingLot.address", target = "addressDTO")
    ParkingLotDTO toParkingLotDTO(ParkingLot parkingLot);
    @InheritInverseConfiguration
    ParkingLot toParkingLot(ParkingLotDTO parkingLotDTO);

    @Mapping(source = "parkingLotList.address", target = "addressDTO")
    List<ParkingLotDTO> toListParkingLotDTOs(List<ParkingLot> parkingLotList);
    @InheritInverseConfiguration
    List<ParkingLot> toListParkingLots(List<ParkingLotDTO> parkingLotDTOList);


    // Address Mapper
    AddressDTO toAddressDTO(Address address);
    Address toAddress(AddressDTO addressDTO);

    List<AddressDTO> toListAddressDTOs(List<Address> addressList);
    List<Address> toListAddress(List<AddressDTO> addressDTOList);


    // Telephone Mapper
    @Mapping(source = "telephone.parkingLot", target = "parkingLotDTO")
    TelephoneDTO toTelephoneDTO(Telephone telephone);
    @InheritInverseConfiguration
    Telephone toTelephone(TelephoneDTO telephoneDTO);

    @Mapping(source = "telephoneList.parkingLot", target = "parkingLotDTO")
    List<TelephoneDTO> toListTelephoneDTOs(List<Telephone> telephoneList);
    @InheritInverseConfiguration
    List<Telephone> toListTelephones(List<TelephoneDTO> telephoneDTOList);


    // Vehicle Mapper
    @Mapping(source = "vehicle.parkingLot", target = "parkingLotDTO")
    VehicleDTO toVehicleDTO(Vehicle vehicle);
    @InheritInverseConfiguration
    Vehicle toVehicle(VehicleDTO vehicleDTO);

    @Mapping(source = "vehicleList.parkingLot", target = "parkingLotDTO")
    List<VehicleDTO> toListVehicleDTOs(List<Vehicle> vehicleList);
    @InheritInverseConfiguration
    List<Vehicle> toListVehicles(List<VehicleDTO> vehicleDTOList);
}
