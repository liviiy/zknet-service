package com.zknet.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZkNetL2Token {
    private Long id;
    private String name;
    private String fullName;
    private String contractAddress;
    private String type;
}
