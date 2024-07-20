package br.com.yuji.bootcampRESTNuvemExemplo.repositories;

import br.com.yuji.bootcampRESTNuvemExemplo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoriy extends JpaRepository<User, Long> {

    boolean existsByAccountNumber(String accountNumber);
}
