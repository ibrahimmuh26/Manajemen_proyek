package restfullapisei.restful.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restfullapisei.restful.entity.Lokasi;
import restfullapisei.restful.entity.Proyek;
import restfullapisei.restful.entity.proyek_lokasi;
import restfullapisei.restful.model.CreateProyekRequest;
import restfullapisei.restful.repository.LokasiRepository;
import restfullapisei.restful.repository.ProyekLokasiRepository;
import restfullapisei.restful.repository.ProyekRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private Validator validator;

    public void  create(CreateProyekRequest request){

      Set<ConstraintViolation< CreateProyekRequest >> constraintViolationS=  validator.validate(request);
        if(constraintViolationS.size() != 0 ){
            throw  new ConstraintViolationException(constraintViolationS);
        }



        Proyek proyek= new Proyek();
        proyek.setNama_proyek(request.getNama_proyek());
        proyek.setClient(request.getClient());
        proyek.setTgl_mulai(request.getTgl_mulai());
        proyek.setTgl_selesai(request.getTgl_selesai());
        proyek.setPimpinan_proyek(request.getPimpinan_proyek());
        proyek.setKeterangan(request.getKeterangan());

        proyekRepository.save(proyek);

        Lokasi lokasi = new Lokasi();

        lokasi.setNama_lokasi(request.getNama_lokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());

        lokasiRepository.save(lokasi);

        proyek_lokasi proyekLokasi = new proyek_lokasi();
        proyekLokasi.setProyek(proyek);
        proyekLokasi.setLokasi(lokasi);
        proyekLokasiRepository.save(proyekLokasi);











    }

    public Iterable<Proyek> getAll(){
        return proyekRepository.findAll();
    }




}
