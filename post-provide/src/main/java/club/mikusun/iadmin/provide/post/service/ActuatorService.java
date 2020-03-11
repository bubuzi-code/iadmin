package club.mikusun.iadmin.provide.post.service;

import club.mikusun.iadmin.db.depencies.jpa.service.BaseService;
import club.mikusun.iadmin.domain.post.Actuator;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.provide.post.dao.ActuatorDao;
import org.springframework.stereotype.Repository;

@Repository
public interface ActuatorService  extends BaseService<Actuator, Integer> {
}
