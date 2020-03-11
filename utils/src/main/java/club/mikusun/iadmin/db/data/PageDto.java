package club.mikusun.iadmin.db.data;

import club.mikusun.iadmin.webutils.result.account.HttpResult;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class PageDto implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private Direction direction;
    private String[] fields;

    public Pageable toPageable() throws Exception{
        if(null==pageSize || pageSize<=0){
            pageSize = 20;
        } else if(pageSize>50){
            throw new BadRequestException("pageSize is too large");
        }
        if(pageNum <0){
            pageNum = 0;
        }
        if(direction==null){
            direction = Direction.DESC;
        }
        return PageRequest.of(
                this.getPageNum(),
                this.getPageSize(),
                Sort.by(Sort.Direction.valueOf(this.getDirection().getName()), fields)
        );
    }
}
