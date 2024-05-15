package br.com.masterclass.superpecas.repository;

import br.com.masterclass.superpecas.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CarroRepository extends JpaRepository<Carro, Long> {

    List<Carro> findByMarca(String marca);

    List<Carro> findByModelo(String modelo);

    List<Carro> findByAno(int ano);

    List<Carro> findByMarcaAndModelo(String marca, String modelo);

    List<Carro> findByAnoBetween(int anoInicio, int anoFim);
}
