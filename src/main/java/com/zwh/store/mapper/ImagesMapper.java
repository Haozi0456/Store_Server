package com.zwh.store.mapper;

import com.zwh.store.entity.Images;

public interface ImagesMapper {
    int deleteByPrimaryKey(Integer imgid);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(Integer imgid);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);
}