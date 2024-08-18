package restfullapisei.restful.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateProyekRequest {

    private int id;

    private  String nama_proyek;

    private  String client;

    private LocalDate tgl_mulai;

    private  LocalDate tgl_selesai;

    private  String pimpinan_proyek;


    private  String keterangan;

    private String nama_lokasi;

    private String negara;

    private String provinsi;

    private String kota;
}
