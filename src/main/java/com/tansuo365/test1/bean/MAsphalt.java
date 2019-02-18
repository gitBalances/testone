package com.tansuo365.test1.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 改质沥青
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MAsphalt {

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

    private Date create_time;

    private Date update_time;

    private Boolean expand_1;

    private Boolean expand_2;

    private Boolean expand_3;

    private String reporter;

}