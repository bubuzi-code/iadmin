package club.mikusun.iadmin.db.data;

import lombok.Getter;

public enum  Direction {

    DESC("DESC") , ASC("ASC");
    @Getter
    private String name;
    Direction(String name){
        this.name = name;
    }

}
