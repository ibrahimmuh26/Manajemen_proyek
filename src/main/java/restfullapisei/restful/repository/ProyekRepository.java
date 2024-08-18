package restfullapisei.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restfullapisei.restful.entity.Proyek;

import java.util.List;

public interface ProyekRepository extends JpaRepository<Proyek,String> {

}
