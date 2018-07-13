package com.zwh.store.mapper;

import org.apache.ibatis.annotations.Param;

import com.zwh.store.entity.Manager;

public interface ManagerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    
    Manager getManagerByAccountAndPassword(@Param("account")String account,@Param("password")String password);
}