package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.model.Carro;
import br.com.masterclass.superpecas.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> listarTodosOsCarros() {
        return carroRepository.findAll();
    }

    public Carro salvarCarro(Carro carro) {
        return carroRepository.save(carro);
    }

    public List<Carro> buscarCarrosPorMarca(String marca) {
        return carroRepository.findByMarca(marca);
    }

    public List<Carro> buscarCarrosPorModelo(String modelo) {
        return carroRepository.findByModelo(modelo);
    }

    public List<Carro> buscarCarrosPorAno(int ano) {
        return carroRepository.findByAno(ano);
    }

    public List<Carro> buscarCarrosPorMarcaEModelo(String marca, String modelo) {
        return carroRepository.findByMarcaAndModelo(marca, modelo);
    }

    public List<Carro> buscarCarrosPorIntervaloDeAno(int anoInicio, int anoFim) {
        return carroRepository.findByAnoBetween(anoInicio, anoFim);
    }

    public void deletarCarro(Long id) {
        carroRepository.deleteById(id);
    }

    public Optional<Carro> buscarCarroPorId(Long id) {
        return carroRepository.findById(id);
    }
}
