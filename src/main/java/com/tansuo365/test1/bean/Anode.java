package com.tansuo365.test1.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 阳极
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Anode {

    private Integer id;

    private String province;

    private String company;

    private String s_company;

    private Double e_density;

    private Double true_density;

    private Double compressive;

    private Double carbon;

    private Double flexural;

    private Double room;

    private Double thermal;

    private Double ash;

    private String size;

    private String bowl;

    private Double in_diameter;

    private Double out_diameter;

    private String slot;

    private Double today_price;

    private String remarks;

    private Date create_time;

    private Date update_time;

    private Boolean expand_1;

    private Boolean expand_2;

    private Boolean expand_3;

    private String reporter;

}