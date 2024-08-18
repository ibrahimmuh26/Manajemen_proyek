package restfullapisei.restful.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Getter

@Setter

@AllArgsConstructor
@NoArgsConstructor
@Entity

@Table(name="proyek")

public class Proyek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    private  String nama_proyek;

    private  String client;

    private LocalDate tgl_mulai;

    private  LocalDate tgl_selesai;

    private  String pimpinan_proyek;

    private String keterangan;


}
