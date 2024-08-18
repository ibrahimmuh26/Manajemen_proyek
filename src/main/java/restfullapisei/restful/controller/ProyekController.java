package restfullapisei.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import restfullapisei.restful.entity.Proyek;
import restfullapisei.restful.model.CreateProyekRequest;
import restfullapisei.restful.model.UpdateProyekRequest;
import restfullapisei.restful.model.WebResponse;
import restfullapisei.restful.service.ProyekLokasiService;
import restfullapisei.restful.service.ProyekService;

import java.util.List;

@RestController
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @Autowired
    private ProyekLokasiService proyekLokasiService;

    @PostMapping(
            path="/proyek",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> create(@RequestBody CreateProyekRequest request){
        proyekService.create(request);
        return WebResponse.<String>builder().data("Data Berhasil Disimpan").build();
    }

    @PutMapping(
            path = "/proyek",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public  WebResponse<String> update(@RequestBody UpdateProyekRequest request){
        proyekLokasiService.update(request);
        return WebResponse.<String>builder().data("data berhasil diupdate").build();
    }



}
