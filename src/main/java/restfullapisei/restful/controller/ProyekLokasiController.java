package restfullapisei.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import restfullapisei.restful.entity.proyek_lokasi;
import restfullapisei.restful.service.ProyekLokasiService;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class ProyekLokasiController {

        @Autowired
        private ProyekLokasiService proyekLokasiService;

        @GetMapping(
                path="/proyek",
                produces = MediaType.APPLICATION_JSON_VALUE
        )
        public ResponseEntity<List<proyek_lokasi>> getAll() {
            List<proyek_lokasi> proyekLokasiList = (List<proyek_lokasi>) proyekLokasiService.getAll();

            // Periksa apakah data ditemukan
            if (proyekLokasiList.isEmpty()) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.ok(proyekLokasiList);
            }
        }
//        public  Iterable<proyek_lokasi> getAll() {
//            return proyekLokasiService.getAll();
//        }

}
