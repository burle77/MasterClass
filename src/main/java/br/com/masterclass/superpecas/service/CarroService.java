package br.com.masterclass.superpecas.service;

import br.com.masterclass.superpecas.model.Carro;
import br.com.masterclass.superpecas.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    // Mais métodos conforme necessário...
}
