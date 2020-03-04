package club.mikusun.iadmin.account.feign;

import club.mikusun.iadmin.db.data.Direction;
import club.mikusun.iadmin.webutils.result.account.Result;
  import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(value =a "
// AccountProvideApplication")
@Service
@FeignClient(value = "AccountProvideApplication" , contextId = "AccessFeginClient")
@RequestMapping("/access")
public interface AccessFeginClient{

    @PostMapping("/all")
    Result all(@RequestParam("direction") Direction direction , @RequestParam("fields") String[] fields);
}
