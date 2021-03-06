package com.example.micreoserversimpleprovideruser.dao;

import com.example.micreoserversimpleprovideruser.bean.HygOrder;
import com.example.micreoserversimpleprovideruser.bean.HygOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HygOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    long countByExample(HygOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int deleteByExample(HygOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int insert(HygOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int insertSelective(HygOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    List<HygOrder> selectByExampleWithBLOBs(HygOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    List<HygOrder> selectByExample(HygOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    HygOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int updateByExampleSelective(@Param("record") HygOrder record, @Param("example") HygOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int updateByExampleWithBLOBs(@Param("record") HygOrder record, @Param("example") HygOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int updateByExample(@Param("record") HygOrder record, @Param("example") HygOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int updateByPrimaryKeySelective(HygOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int updateByPrimaryKeyWithBLOBs(HygOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hyg_order
     *
     * @mbg.generated Sun Jan 06 21:43:00 GMT+08:00 2019
     */
    int updateByPrimaryKey(HygOrder record);
}