package club.mikusun.iadmin.account.service;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService<T ,ID> extends JpaRepository<T ,ID> {
}
