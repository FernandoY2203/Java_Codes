package br.com.yuji.bootcampPadroesProjetoExemplo.services.impl;

import br.com.yuji.bootcampPadroesProjetoExemplo.models.Address;
import br.com.yuji.bootcampPadroesProjetoExemplo.models.Client;
import br.com.yuji.bootcampPadroesProjetoExemplo.repositories.AddressRepository;
import br.com.yuji.bootcampPadroesProjetoExemplo.repositories.ClientRepository;
import br.com.yuji.bootcampPadroesProjetoExemplo.services.ClientService;
import br.com.yuji.bootcampPadroesProjetoExemplo.services.ViaCepService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    ViaCepService viaCepService;

    @Override
    public Iterable<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);

        return obj.orElseThrow(RuntimeException::new);
    }

    @Override
    public void insert(Client client) {
        String cep = client.getAddress().getCep();

        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.consultarCep(cep);

            return addressRepository.save(newAddress);
        });

        client.setAddress(address);

        clientRepository.save(client);
    }

    @Override
    public void update(Long id, Client client) {
        try {
            Client entity = clientRepository.getReferenceById(id);
            String cep = client.getAddress().getCep();

            Address address = addressRepository.findById(cep).orElseGet(() -> {
                Address newAddress = viaCepService.consultarCep(cep);

                return addressRepository.save(newAddress);
            });

            client.setAddress(address);

            updateData(entity, client);

            clientRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(Long id) {
        try {
            Optional<Client> u = clientRepository.findById(id);

            clientRepository.delete(u.get());
        } catch (NoSuchElementException e) {
            throw new RuntimeException();
        }
    }


    private void updateData(Client entity, Client client) {
        entity.setName(client.getName());
        entity.setAddress(client.getAddress());
    }
}
