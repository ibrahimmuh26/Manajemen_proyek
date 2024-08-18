package restfullapisei.restful.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfullapisei.restful.entity.Lokasi;
import restfullapisei.restful.entity.proyek_lokasi;
import restfullapisei.restful.model.CreateLokasiRequest;
import restfullapisei.restful.model.CreateProyekRequest;
import restfullapisei.restful.model.DeleteLokasiRequest;
import restfullapisei.restful.model.UpdateLokasiRequest;
import restfullapisei.restful.repository.LokasiRepository;

import java.util.Optional;
import java.util.Set;

@Service
public class LokasiService {
    @Autowired
    private LokasiRepository lokasiRepository;

    @Autowired
    private Validator validator;
    public Iterable<Lokasi> getAll(){
        return lokasiRepository.findAll();
    }


    public void update(UpdateLokasiRequest request){
        Set<ConstraintViolation<UpdateLokasiRequest>> constraintViolationS=  validator.validate(request);
        if(constraintViolationS.size() != 0 ){
            throw  new ConstraintViolationException(constraintViolationS);
        }
        Optional<Lokasi> proyekLokasi = lokasiRepository.findById(Integer.toString(request.getId()));

        if(proyekLokasi.isPresent()){
            Lokasi lokasi =proyekLokasi.get();
            lokasi.setNama_lokasi(request.getNama_lokasi());
            lokasi.setNegara(request.getNegara());
            lokasi.setProvinsi(request.getProvinsi());
            lokasi.setKota(request.getKota());
            lokasiRepository.save(lokasi);

        }

    }

    public void create(CreateLokasiRequest request){
        Set<ConstraintViolation<CreateLokasiRequest>> constraintViolationS=  validator.validate(request);
        if(constraintViolationS.size() != 0 ){
            throw  new ConstraintViolationException(constraintViolationS);
        }

        Lokasi lokasi = new Lokasi();
        lokasi.setNama_lokasi(request.getNama_lokasi());
        lokasi.setNegara(request.getNegara());
        lokasi.setProvinsi(request.getProvinsi());
        lokasi.setKota(request.getKota());
        lokasiRepository.save(lokasi);

    }
    public void delete(DeleteLokasiRequest request){
        Set<ConstraintViolation<DeleteLokasiRequest>> constraintViolationS=  validator.validate(request);
        if(constraintViolationS.size() != 0 ){
            throw  new ConstraintViolationException(constraintViolationS);
        }

        lokasiRepository.deleteById(Integer.toString(request.getId()));

    }


}
