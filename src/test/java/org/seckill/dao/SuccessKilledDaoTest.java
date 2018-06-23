package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.seckill.entity.SuccessKilled;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @Author Jeanva He
 * @Date
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() {
        long id = 1000L;
        long phone = 13922114971L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount "+insertCount);
    }

    @Test
    public void queryByIdWithSeckill() {
        long id = 1000L;
        long phone = 13922114970L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println("successKilld: "+successKilled);
        System.out.println(successKilled.getSeckill());
    }
}
