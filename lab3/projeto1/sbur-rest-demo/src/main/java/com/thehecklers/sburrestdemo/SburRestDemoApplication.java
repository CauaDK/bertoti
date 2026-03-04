package com.thehecklers.sburrestdemo;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SburRestDemoApplication {

    public static void main(String[] args) {
        Database.initialize();
        SpringApplication.run(SburRestDemoApplication.class, args);
    }

}

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/petshops")
class RestApiDemoController {

    public RestApiDemoController() {
    }

    @GetMapping
    Iterable<Petshop> getPetshops() {
        List<Petshop> petshops = new ArrayList<>();
        try (Connection conn = Database.get();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT id, nome FROM petshop")) {
            while (rs.next()) {
                petshops.add(new Petshop(rs.getLong("id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petshops;
    }

    @GetMapping("/{id}")
    Optional<Petshop> getPetshopById(@PathVariable Long id) {
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("SELECT id, nome FROM petshop WHERE id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Petshop(rs.getLong("id"), rs.getString("nome")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @PostMapping
    Petshop postPetshop(@RequestBody Petshop petshop) {
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO petshop (nome) VALUES (?)",
                     Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, petshop.getName());
            ps.executeUpdate();
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    petshop.setId(rs.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return petshop;
    }

    @PutMapping("/{id}")
    ResponseEntity<Petshop> putPetshop(@PathVariable Long id,
                                       @RequestBody Petshop petshop) {
        boolean exists = false;
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("UPDATE petshop SET nome = ? WHERE id = ?")) {
            ps.setString(1, petshop.getName());
            ps.setLong(2, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                exists = true;
                petshop.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (exists) {
            return new ResponseEntity<>(petshop, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(postPetshop(petshop), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/{id}")
    void deletePetshop(@PathVariable Long id) {
        try (Connection conn = Database.get();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM petshop WHERE id = ?")) {
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Petshop {
    private Long id;
    private String name;

    @JsonCreator
    public Petshop(@JsonProperty("id") Long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public Petshop(String name) {
        this(null, name);
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
}