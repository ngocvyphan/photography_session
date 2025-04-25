package info.hccis.photography.session.repositories;

import java.util.List;

import info.hccis.photography.session.jpa.entity.CodeValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeValueRepository extends CrudRepository<CodeValue, Integer> {
        List<CodeValue> findByCodeTypeId(Integer codeTypeId);
}