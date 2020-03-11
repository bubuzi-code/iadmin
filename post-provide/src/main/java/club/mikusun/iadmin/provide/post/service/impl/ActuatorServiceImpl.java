package club.mikusun.iadmin.provide.post.service.impl;

import club.mikusun.iadmin.db.depencies.jpa.service.impl.BaseServiceImpl;
import club.mikusun.iadmin.domain.post.Actuator;
import club.mikusun.iadmin.domain.post.Post_access;
import club.mikusun.iadmin.provide.post.dao.ActuatorDao;
import club.mikusun.iadmin.provide.post.dao.PostAccessDao;
import club.mikusun.iadmin.provide.post.service.ActuatorService;
import club.mikusun.iadmin.provide.post.service.PostAccessService;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;

public class ActuatorServiceImpl extends BaseServiceImpl<Actuator, Integer>
        implements ActuatorService {
    @Getter
    private ActuatorDao dao;
    public ActuatorServiceImpl(ActuatorDao dao) {
        super(dao);
        this.dao = dao;
    }
}
