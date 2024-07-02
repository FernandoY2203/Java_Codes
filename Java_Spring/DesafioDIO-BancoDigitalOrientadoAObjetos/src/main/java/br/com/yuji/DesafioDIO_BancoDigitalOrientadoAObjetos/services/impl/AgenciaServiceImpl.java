package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.impl;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Agencia;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.AgenciaRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.AgenciaService;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.exceptions.DatabaseException;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class AgenciaServiceImpl implements AgenciaService {

    private final Logger logger = Logger.getLogger(AgenciaServiceImpl.class.getName());


    @Autowired
    private AgenciaRepository repository;


    @Override
    public Iterable<Agencia> findAll() {
        logger.info("Buscando todas as agencias...");

        return repository.findAll();
    }

    @Override
    public Agencia findById(Long id) {
        logger.info("Buscando uma agencia...");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Agencia insert(Agencia agencia) {
        logger.info("Criando agencia...");

        return repository.save(agencia);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deletando agencia...");

        try {
            Optional<Agencia> a = repository.findById(id);

            repository.delete(a.get());
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }
}
