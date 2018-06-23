package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface SeckillDao {
    /**
     * reduce inventory
     * @param seckillId
     * @param killTime
     * @return 如果影响行数>1，表示更新的记录行数
     */
    int reduceNumber(@Param("seckillId") long seckillId, @Param("killTime") Date killTime);

    /** query items by id
     * @param seckillId
     * @return
     */
    Seckill queryById(long seckillId);

    /**
     * query items by offset
     * @param offset 偏移量
     * @param limit 取最多多少条
     * @return
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
