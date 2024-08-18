package restfullapisei.restful.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateProyekRequest {

    @NotBlank
    private  String nama_proyek;

    @NotBlank
    private  String client;

    private LocalDate tgl_mulai;

    private  LocalDate tgl_selesai;

    @NotBlank
    private  String pimpinan_proyek;


    private  String keterangan;

    @NotBlank
    private String nama_lokasi;

    @NotBlank
    private String negara;

    @NotBlank
    private String provinsi;

    @NotBlank
    private String kota;
}
