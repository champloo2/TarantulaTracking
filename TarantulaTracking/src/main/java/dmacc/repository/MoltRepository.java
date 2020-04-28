package dmacc.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import dmacc.beans.Molt;
import dmacc.beans.Tarantula;



public interface MoltRepository extends JpaRepository <Molt, Long> {
	
	List<Molt> findByTarantula(Tarantula t);
}