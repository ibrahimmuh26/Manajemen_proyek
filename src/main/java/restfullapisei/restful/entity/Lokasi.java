package restfullapisei.restful.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter

@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity

@Table(name="lokasi")

public class Lokasi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private  String nama_lokasi;

    private String negara;

    private  String provinsi;

    private  String kota;


}
