package de.htwberlin.webtech.Healthtracker.Interface;
import de.htwberlin.webtech.Healthtracker.Entitäsklassen.Weight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends CrudRepository<Weight, Long> {

}
