package br.com.yuji.bootcampRESTNuvemExemplo.services;

import br.com.yuji.bootcampRESTNuvemExemplo.models.User;

public interface UserService {

    User findById(Long id);

    User create(User user);
}
