CREATE TABLE IF NOT EXISTS  permission(
    id INT PRIMARY KEY AUTO_INCREMENT ,
    permission VARCHAR(40) NOT NULL
);

INSERT INTO permission VALUES
                            (001 , 'UPVOTE'   ), # 点赞
                            (100 , 'REPLY'    ), # 回复
                            (200 , 'RELEASE'  ), # 发帖
                            (300 , 'DELETE'   ); # 删除操作

# //////////////////////////////////////////////////////////////
CREATE TABLE IF NOT EXISTS  role(
    id INT PRIMARY KEY AUTO_INCREMENT,
    pid INT,
    name VARCHAR(40) NOT NULL
);

INSERT INTO role VALUES
                        (1 , NULL , "GENERAL"), # 普通用户
                        (2 , NULL , "MODERATOR"),# 版主
                        (3 , NULL , "OFFICIAL");# 官方

# /////////////////////////////////////////////////////////////////
CREATE TABLE IF NOT EXISTS  role_permission(
    role_id INT NOT NULL,
    permission_id INT NOT NULL,
    UNIQUE A (role_id , permission_id)  USING BTREE
)

INSERT INTO role_permission VALUES
                                (   1  ,   001  ),
                                (   1  ,   100  ),
                                (   1  ,   200  ),
                                (   2  ,   001  ),
                                (   2  ,   100  ),
                                (   2  ,   200  ),
                                (   2  ,   300  ),
                                (   3  ,   001  ),
                                (   3  ,   100  ),
                                (   3  ,   200  ),
                                (   3  ,   300  );

# //////////////////////////////////////////////////////

CREATE TABLE IF NOT EXISTS access(
    id INT PRIMARY KEY AUTO_INCREMENT,
    resour_url VARCHAR(128) NOT NULL,
    opened TINYINT(1) NOT NULL
);

INSERT INTO access VALUES
                    (1, "/**",TRUE),
                    (2, "/account/**",FALSE);

# /////////////////////////////////
CREATE TABLE account_role(
    uid INT NOT NULL,
    rid INT NOT NULL,
    UNIQUE ACCOUNT_ROLE_MAPPING (uid , rid) USING BTREE
);

INSERT INTO account_role VALUES
                            ( 1 , 1 ),
                            ( 1 , 2 ),
                            ( 1 , 3 ),
                            ( 2 , 1 ),
                            ( 3 , 1 ),
                            ( 4 , 1 ),
                            ( 4 , 2 );
