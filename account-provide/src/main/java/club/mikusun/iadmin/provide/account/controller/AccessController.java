package club.mikusun.iadmin.provide.account.controller;

import club.mikusun.iadmin.db.data.Direction;
import club.mikusun.iadmin.provide.account.service.AccessService;
import club.mikusun.iadmin.webutils.result.account.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private AccessService accessService;

    @PostMapping("/all")
    public Object all(
            @RequestParam("direction") Direction direction,
            @RequestParam(value = "fields") String[] fields
    ){

        return Result.success(accessService.findAll(
                Sort.by(Sort.Direction.valueOf(direction.getName()) , fields)
        ));
    }

}
