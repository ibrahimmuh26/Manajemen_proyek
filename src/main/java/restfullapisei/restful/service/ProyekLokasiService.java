package restfullapisei.restful.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfullapisei.restful.entity.Lokasi;
import restfullapisei.restful.entity.Proyek;
import restfullapisei.restful.entity.proyek_lokasi;
import restfullapisei.restful.model.CreateProyekRequest;
import restfullapisei.restful.model.DeleteProyekLokasiRequest;
import restfullapisei.restful.model.UpdateProyekRequest;
import restfullapisei.restful.repository.LokasiRepository;
import restfullapisei.restful.repository.ProyekLokasiRepository;
import restfullapisei.restful.repository.ProyekRepository;

import java.util.Optional;
import java.util.Set;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class ProyekLokasiService {

    @Autowired
    private ProyekLokasiRepository proyekLokasiRepository;

    @Autowired
    private Validator validator;
    @Autowired
    private ProyekRepository proyekRepository;
    @Autowired
    private LokasiRepository lokasiRepository;

    public Iterable<proyek_lokasi> getAll(){
        return proyekLokasiRepository.findAll();
    }


    public void  update(UpdateProyekRequest request){

        Set<ConstraintViolation< UpdateProyekRequest >> constraintViolationS=  validator.validate(request);
        if(constraintViolationS.size() != 0 ){
            throw  new ConstraintViolationException(constraintViolationS);
        }
        Optional<proyek_lokasi> proyekLokasi = proyekLokasiRepository.findById(Integer.toString(request.getId()));
        Optional<Proyek> proyek = proyekRepository.findById(Integer.toString(proyekLokasi.get().getProyek().getId()));
        Optional<Lokasi> lokasi =  lokasiRepository.findById(Integer.toString(proyekLokasi.get().getLokasi().getId()));


        if (proyekLokasi.isPresent()) {
            Proyek proyek_entity =proyek.get();

            proyek_entity.setNama_proyek(request.getNama_proyek());
            proyek_entity.setClient(request.getClient());
            proyek_entity.setTgl_mulai(request.getTgl_mulai());
            proyek_entity.setTgl_selesai(request.getTgl_selesai());
            proyek_entity.setPimpinan_proyek(request.getPimpinan_proyek());
            proyek_entity.setKeterangan(request.getKeterangan());

            proyekRepository.save(proyek_entity);
            Lokasi lokasi_entity = lokasi.get();
            lokasi_entity.setNama_lokasi(request.getNama_lokasi());
            lokasi_entity.setNegara(request.getNegara());
            lokasi_entity.setKota(request.getKota());
            lokasi_entity.setProvinsi(request.getProvinsi());
            lokasiRepository.save(lokasi_entity);



        } else {
            throw new EntityNotFoundException("Entity not found");
        }









    }

    public  void delete(DeleteProyekLokasiRequest request){
        Set<ConstraintViolation< DeleteProyekLokasiRequest >> constraintViolationS=  validator.validate(request);
        if(constraintViolationS.size() != 0 ){
            throw  new ConstraintViolationException(constraintViolationS);
        }
        Optional<proyek_lokasi> proyekLokasi = proyekLokasiRepository.findById(Integer.toString(request.getId()));
        Optional<Proyek> proyek = proyekRepository.findById(Integer.toString(proyekLokasi.get().getProyek().getId()));
        Optional<Lokasi> lokasi =  lokasiRepository.findById(Integer.toString(proyekLokasi.get().getLokasi().getId()));

        Proyek proyek_entity= proyek.get();
        proyekRepository.delete(proyek_entity);
        Lokasi lokasi_entity=lokasi.get();
        lokasiRepository.delete(lokasi_entity);
        proyekLokasiRepository.deleteById(Integer.toString(request.getId()));
    }



}
