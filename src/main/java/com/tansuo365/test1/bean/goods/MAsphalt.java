package com.tansuo365.test1.bean.goods;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tansuo365.test1.entity.Goods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 改质沥青
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MAsphalt implements Serializable,Goods {

    private Long id;

    private String province;

    private String company;

    private String s_company;

    private Double softening_point;

    private Double toluene;

    private Double quinoline;

    private Double beta_resin;

    private Double coking_value;

    private Double ash;

    private Double today_price;

    private String remarks;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date create_time;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date update_time;

    private Boolean expand_1;

    private Boolean expand_2;

    private Boolean expand_3;

    private String reporter;

    @Override
    public Double getSulfur() {
        return null;
    }

    @Override
    public void setGrade(String grade) {
    }
}