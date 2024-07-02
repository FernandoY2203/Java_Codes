package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.impl;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.ContaCorrente;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Contas;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.ContaCorrenteRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.ContasRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.ContaCorrenteService;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.exceptions.DatabaseException;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    private final Logger logger = Logger.getLogger(ContaCorrenteServiceImpl.class.getName());

    @Autowired
    private ContaCorrenteRepository repository;
    @Autowired
    private ContasRepository contasRepository;


    @Override
    public Iterable<ContaCorrente> findAll() {
        logger.info("Buscando todas as contas correntes...");

        return repository.findAll();
    }

    @Override
    public ContaCorrente findById(Long id) {
        logger.info("Buscando conta corrente...");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public ContaCorrente insert(ContaCorrente contaCorrente) {
        logger.info("Criando conta corrente...");

        return repository.save(contaCorrente);
    }

    @Override
    public ContaCorrente update(ContaCorrente contaCorrente) {
        logger.info("Atualizando conta corrente...");

        try {
            ContaCorrente obj = repository.getReferenceById(contaCorrente.getId());

            updateData(obj, contaCorrente);

            return repository.save(obj);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(contaCorrente.getId());
        }
    }

    @Override
    public void delete(Long id) {
        logger.info("Deletando conta corrente...");

        try {
            Optional<ContaCorrente> cC = repository.findById(id);

            repository.delete(cC.get());
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    @Override
    public void sacar(Double valor, ContaCorrente contaCorrente) {
        logger.info("Sacando da conta corrente...");

        contaCorrente.sacar(valor);

        repository.save(contaCorrente);
    }

    @Override
    public void depositar(Double valor, ContaCorrente contaCorrente) {
        logger.info("Depositando na conta corrente...");

        contaCorrente.depositar(valor);

        repository.save(contaCorrente);
    }

    @Override
    public void transferir(Double valor, ContaCorrente contaCorrente, Contas contaATransferir) {
        logger.info("Transferindo da conta corrente...");

        contaCorrente.transferir(valor, contaATransferir);

        repository.save(contaCorrente);
        contasRepository.save(contaATransferir);
    }

    @Override
    public void usarCredito(Double valor, ContaCorrente contaCorrente) {
        logger.info("Usando credito da conta corrente...");

        contaCorrente.usarCredito(valor);

        repository.save(contaCorrente);
    }


    private void updateData(ContaCorrente obj, ContaCorrente aux) {
        obj.setCredito(aux.getCredito());
        obj.setChequeEspecial(aux.getChequeEspecial());
    }
}
