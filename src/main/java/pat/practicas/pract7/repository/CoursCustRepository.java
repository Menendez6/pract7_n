package pat.practicas.pract7.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pat.practicas.pract7.model.CoursCustTable;

@Repository
public interface CoursCustRepository extends CrudRepository<CoursCustTable,Long> {
}
