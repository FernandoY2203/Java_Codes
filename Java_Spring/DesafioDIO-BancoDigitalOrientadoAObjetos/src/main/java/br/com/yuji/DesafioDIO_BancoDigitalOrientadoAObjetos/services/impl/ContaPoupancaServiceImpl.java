package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.impl;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.ContaPoupanca;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Contas;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.ContaPoupancaRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.ContasRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.ContaPoupancaService;
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
public class ContaPoupancaServiceImpl implements ContaPoupancaService {

    private final Logger logger = Logger.getLogger(ContaPoupancaServiceImpl.class.getName());

    @Autowired
    private ContaPoupancaRepository repository;
    @Autowired
    private ContasRepository contasRepository;


    @Override
    public Iterable<ContaPoupanca> findAll() {
        logger.info("Buscando todas as contas poupancas...");

        return repository.findAll();
    }

    @Override
    public ContaPoupanca findById(Long id) {
        logger.info("Buscando conta poupanca...");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public ContaPoupanca insert(ContaPoupanca contaPoupanca) {
        logger.info("Criando conta poupanca...");

        return repository.save(contaPoupanca);
    }

    @Override
    public ContaPoupanca update(ContaPoupanca contaPoupanca) {
        logger.info("Atualizando conta poupanca...");

        try {
            ContaPoupanca obj = repository.getReferenceById(contaPoupanca.getId());

            updateData(obj, contaPoupanca);

            return repository.save(obj);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(contaPoupanca.getId());
        }
    }

    @Override
    public void delete(Long id) {
        logger.info("Deletando conta poupanca...");

        try {
            Optional<ContaPoupanca> cP = repository.findById(id);

            repository.delete(cP.get());
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    @Override
    public void sacar(Double valor, ContaPoupanca contaPoupanca) {
        logger.info("Sacando da conta poupanca...");

        contaPoupanca.sacar(valor);

        repository.save(contaPoupanca);
    }

    @Override
    public void depositar(Double valor, ContaPoupanca contaPoupanca) {
        logger.info("Depositando na conta poupanca...");

        contaPoupanca.depositar(valor);

        repository.save(contaPoupanca);
    }

    @Override
    public void transferir(Double valor, ContaPoupanca contaPoupanca, Contas contaATransferir) {
        logger.info("Transferindo da conta poupanca...");

        contaPoupanca.transferir(valor, contaATransferir);

        repository.save(contaPoupanca);
        contasRepository.save(contaATransferir);
    }

    @Override
    public void calcularRemuneracaoMensal(ContaPoupanca contaPoupanca) {
        logger.info("Calculando remuneracao mensal...");

        contaPoupanca.calcularRemuneracaoMensal();

        repository.save(contaPoupanca);
    }


    private void updateData(ContaPoupanca obj, ContaPoupanca aux) {
        obj.setLimite(aux.getLimite());
    }
}
