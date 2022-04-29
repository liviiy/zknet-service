package com.zknet.gateway.mapper;

import com.zknet.gateway.entity.ZkNetL2Token;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ZkNetL2TokenMapper {
    ZkNetL2Token getById(Long id);
    Long addL2Token(ZkNetL2Token token);
    int updateL2Token(ZkNetL2Token token);
    List<ZkNetL2Token> getByConditionIf(ZkNetL2Token tokenParam);
}
