package by.kalilaska.gform.repository;

import org.springframework.data.repository.CrudRepository;

import by.kalilaska.gform.entity.AnswerType;

public interface AnswerTypeRepository extends CrudRepository<AnswerType, Short> {
	AnswerType findByTypeName(String typeName);
}
