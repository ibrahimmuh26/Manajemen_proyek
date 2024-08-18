package restfullapisei.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import restfullapisei.restful.entity.Lokasi;
import restfullapisei.restful.entity.proyek_lokasi;
import restfullapisei.restful.model.*;
import restfullapisei.restful.service.LokasiService;

import java.util.List;

@RestController

public class LokasiController {
    @Autowired
    private LokasiService lokasiService;

    @GetMapping(
            path="/lokasi",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Lokasi>> getAll() {
        List<Lokasi> LokasiList = (List<Lokasi>) lokasiService.getAll();

        // Periksa apakah data ditemukan
        if (LokasiList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(LokasiList);
        }
    }
    @PutMapping(
            path="/lokasi",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> update(@RequestBody UpdateLokasiRequest request){
        lokasiService.update(request);
        return WebResponse.<String>builder().data("Data Berhasil Diperbaharui").build();
    }

    @PostMapping(
            path="/lokasi",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> create(@RequestBody CreateLokasiRequest request){
        lokasiService.create(request);
        return WebResponse.<String>builder().data("Data Berhasil Disimpan").build();
    }

    @DeleteMapping(
            path="/lokasi",

    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> delete(@RequestBody DeleteLokasiRequest request)
    {
        lokasiService.delete(request);
        return WebResponse.<String>builder().data("Data Berhasil DiHapus").build();

    }



}
