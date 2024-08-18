package restfullapisei.restful.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLokasiRequest {
    @NotBlank
    private String nama_lokasi;

    @NotBlank
    private String negara;

    @NotBlank
    private String provinsi;

    @NotBlank
    private String kota;
}
