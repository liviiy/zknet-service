package com.zknet.gateway.biz;

import com.zknet.gateway.jsonrpc.dto.ZkNetL2TokenDTO;

public interface L2TokenBiz {
    ZkNetL2TokenDTO getTokenById(Long id);
}
