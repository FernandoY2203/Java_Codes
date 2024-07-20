package br.com.yuji.bootcampRESTNuvemExemplo.services.impl;

import br.com.yuji.bootcampRESTNuvemExemplo.models.User;
import br.com.yuji.bootcampRESTNuvemExemplo.repositories.UserRepositoriy;
import br.com.yuji.bootcampRESTNuvemExemplo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoriy repositoriy;

    @Autowired
    public UserServiceImpl(UserRepositoriy repositoriy) {
        this.repositoriy = repositoriy;
    }


    @Override
    public User findById(Long id) {
        return repositoriy.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if(user.getId() != null && repositoriy.existsById(user.getId())) {
            throw new IllegalArgumentException("This user already exists...");
        }
        else if (repositoriy.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This number account already exists...");
        }
        return repositoriy.save(user);
    }
}
