package club.mikusun.iadmin.account.feign;

import club.mikusun.iadmin.webutils.result.account.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
@RequestMapping("/account")
@FeignClient(value = "AccountProvideApplication" , contextId = "AccountFeignClient")
public interface AccountFeignClient {
    @PostMapping("/one/id/{id}")
    Result one(@PathVariable("id") Integer id);

    @PostMapping("/one/accountstr/{account}")
    Result one(@PathVariable("account") String account);
}
