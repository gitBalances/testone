package com.tansuo365.test1.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Transient;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TablesEntity {

    private String tableName;
    @Transient
    private String tableBrief;

}
