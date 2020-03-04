package club.mikusun.iadmin.account.feign;

import club.mikusun.iadmin.domain.account.Account_Token;
import club.mikusun.iadmin.webutils.result.account.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@FeignClient(value = "AccountProvideApplication" , contextId = "TokenFeginClient")
@RequestMapping("/token")
public interface TokenFeginClient {
    @PostMapping("/one/id/{id}")
    Result one(@PathVariable("id") Integer id);

    @PostMapping("/one/token/{token}")
    Result one(@PathVariable("token") String token);

    @PostMapping("/save/one")
    Result save(@RequestBody Account_Token data);

    @PostMapping("/save/list")
    Result save(@RequestBody Iterable<Account_Token> data);

    @PostMapping("/update/one")
    Result update(@RequestBody Account_Token data);
}
