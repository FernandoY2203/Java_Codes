package br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.impl;

import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Cliente;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.models.Endereco;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.ClienteRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.repositories.EnderecoRepository;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.ClienteService;
import br.com.yuji.DesafioDIO_BancoDigitalOrientadoAObjetos.services.ViaCepService;
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
public class ClienteServiceImpl implements ClienteService {

    private final Logger logger = Logger.getLogger(ClienteServiceImpl.class.getName());

    @Autowired
    private ClienteRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;


    @Override
    public Iterable<Cliente> findAll() {
        logger.info("Buscando todos os clientes...");

        return repository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        logger.info("Buscando cliente...");

        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    public Cliente insert(Cliente cliente) {
        logger.info("Criando cliente...");

        cliente.setEndereco(createEndereco(cliente));

        return repository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        logger.info("Atualizando cliente...");

        try {
            Cliente obj = repository.getReferenceById(cliente.getId());

            updateData(obj, cliente);

            return repository.save(obj);
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(cliente.getId());
        }
    }

    @Override
    public void delete(Long id) {
        logger.info("Deletando cliente...");

        try {
            Optional<Cliente> c = repository.findById(id);

            enderecoRepository.delete(c.get().getEndereco());
            repository.delete(c.get());
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    private Endereco createEndereco(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco newEndereco = viaCepService.consultarCep(cep);

        newEndereco.setLogradouro(cliente.getEndereco().getLogradouro());
        newEndereco.setBairro(cliente.getEndereco().getBairro());
        newEndereco.setComplemento(cliente.getEndereco().getComplemento());

        return enderecoRepository.save(newEndereco);
    }

    private void updateData(Cliente obj, Cliente aux) {
        obj.setNome(aux.getNome());
        obj.setSobrenome(aux.getSobrenome());
        obj.setDataNascimento(aux.getDataNascimento());
        obj.setEndereco(createEndereco(aux));
    }
}
