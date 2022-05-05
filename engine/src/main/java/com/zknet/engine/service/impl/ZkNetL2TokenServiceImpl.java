package com.zknet.engine.service.impl;

import com.zknet.engine.entity.ZkNetL2Token;
import com.zknet.engine.mapper.ZkNetL2TokenMapper;
import com.zknet.engine.service.ZkNetL2TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Slf4j
public class ZkNetL2TokenServiceImpl implements ZkNetL2TokenService {

    @Resource
    private ZkNetL2TokenMapper zkNetL2TokenMapper;

    @Override
    public ZkNetL2Token getById(Long id) {
        return zkNetL2TokenMapper.getById(id);
    }
}
