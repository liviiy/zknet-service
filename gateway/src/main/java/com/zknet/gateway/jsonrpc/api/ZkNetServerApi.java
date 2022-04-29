package com.zknet.gateway.jsonrpc.api;

import com.googlecode.jsonrpc4j.JsonRpcService;
import com.zknet.gateway.jsonrpc.dto.ZkNetL2TokenDTO;

@JsonRpcService("zknet")
public interface ZkNetServerApi {
    ZkNetL2TokenDTO getTokenById(Long id);
}
