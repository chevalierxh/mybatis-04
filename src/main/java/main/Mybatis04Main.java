package main;

import mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import pojo.Role;
import utils.SqlSessionFactoryUtils;

public class Mybatis04Main {

    private static Logger logger = Logger.getLogger(Mybatis04Main.class);

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(1L);
            if(role != null){
                logger.info(role.getRoleName()+","+role.getNote());
            }
        }finally {
            sqlSession.close();
        }
    }

}
