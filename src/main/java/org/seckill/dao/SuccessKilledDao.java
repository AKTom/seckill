package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author Jeanva He
 * @Date $ $
 */
@Mapper
public interface SuccessKilledDao {
    /**
     * insert kill details, can filter duplicate
     * @param seckillId
     * @param userPhone
     * @return 插入的结果及数量
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * query SuccessKilled by id and with Seckill
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
