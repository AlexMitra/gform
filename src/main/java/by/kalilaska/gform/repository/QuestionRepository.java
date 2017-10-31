package by.kalilaska.gform.repository;

import org.springframework.data.repository.CrudRepository;

import by.kalilaska.gform.entity.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {

}
