package bootcamp.java.estacionamentonuvem.service;

import bootcamp.java.estacionamentonuvem.exception.ParkingNotFoundException;
import bootcamp.java.estacionamentonuvem.model.Parking;
import bootcamp.java.estacionamentonuvem.repository.ParkingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ParkingService {

    private final ParkingRepository parkingRepository;

    static {
        var id = getUUID();
        var id1 = getUUID();

        Parking parking = new Parking(id,"12345","DF","GOL", "PRETO");
        Parking parking1 = new Parking(id1,"4581","DF","CELTA", "BRANCO");



    }

    public ParkingService(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Parking> findAll(){
        return parkingRepository.findAll();

    }

    private static String getUUID() {
        return UUID.randomUUID().toString().replace("-","");
    }
    @Transactional
    public Parking findById(String id) {
       return  parkingRepository.findById(id).orElseThrow(()
                -> new ParkingNotFoundException(id)
    );

    }

    @Transactional
    public Parking create(Parking parkingCreate){
        String uuid = getUUID();
        parkingCreate.setId(uuid);
        parkingCreate.setEntryDate(LocalDateTime.now());
        parkingRepository.save(parkingCreate);
        return parkingCreate;
    }

    @Transactional
    public void delete(String id) {
       findById(id);
       parkingRepository.deleteById(id);
    }

    @Transactional
    public Parking update(String id, Parking parkinCreate) {
        Parking parking = findById(id);
        parking.setColor(parkinCreate.getColor());
        parking.setColor(parkinCreate.getState());
        parking.setColor(parkinCreate.getModel());
        parking.setColor(parkinCreate.getLicense());
        parkingRepository.save(parking);
        return  parking;
    }

    @Transactional
    public Parking checkOut(String id) {
       Parking parking = findById(id);
       parking.setExitDate(LocalDateTime.now());
       parking.setBill(ParkingCheckOut.getBill(parking));
       parkingRepository.save(parking);
        return parking;
    }
}
