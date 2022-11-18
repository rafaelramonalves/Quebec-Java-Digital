package bootcamp.java.estacionamentonuvem.controller;

import bootcamp.java.estacionamentonuvem.controller.dto.ParkingCreateDTO;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ParkingControllerIT {

    @LocalServerPort
    private int randomPort;

    @BeforeEach
    public void setUpTest(){
        System.out.println(randomPort);
        //RestAssured.port = randomPort;
    }

    @Test
    void findAll() {
        /*
        RestAssured.given()
                .when()
                .get("/parking")
                .then()
                .statusCode(200)
                .body("license[0]", Matchers.equalTo("DMS-1111"));

         */
    }

    @Test
    void create() {
        var createDTO = new ParkingCreateDTO();
        createDTO.setColor("AMARELO");
        createDTO.setLicense("353532");
        createDTO.setModel("Corsa");
        createDTO.setState("BA");

        /*
        RestAssured.given()
                .when()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(createDTO)
                .post("/parking")
                .then()
                .statusCode(HttpStatus.CREATED.value())
                .body("license[", Matchers.equalTo("353532"));

         */
    }
}