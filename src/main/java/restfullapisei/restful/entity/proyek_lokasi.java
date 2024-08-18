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

@Table(name="proyek_lokasi")

public class proyek_lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;



    @OneToOne
    @JoinColumn(name="proyek_id", referencedColumnName = "id")
    private Proyek proyek;

    @OneToOne
    @JoinColumn(name="lokasi_id",referencedColumnName = "id")
    private Lokasi lokasi;

}



