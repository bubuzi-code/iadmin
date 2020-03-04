package club.mikusun.iadmin.provide.account.controller;

import club.mikusun.iadmin.db.data.Direction;
import club.mikusun.iadmin.top.account.service.TopAccessService;
import club.mikusun.iadmin.webutils.result.account.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class AccessController {

    @Autowired
    private TopAccessService topAccessService;

    @PostMapping("/all")
    public Object all(
            @RequestParam("direction") Direction direction,
            @RequestParam("fields") String[] fields
    ){

        return Result.success(topAccessService.findAll(
                Sort.by(Sort.Direction.valueOf(direction.getName()) , fields)
        ));
    }

}
