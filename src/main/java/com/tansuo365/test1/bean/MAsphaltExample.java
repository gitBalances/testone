package com.tansuo365.test1.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MAsphaltExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MAsphaltExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andS_companyIsNull() {
            addCriterion("s_company is null");
            return (Criteria) this;
        }

        public Criteria andS_companyIsNotNull() {
            addCriterion("s_company is not null");
            return (Criteria) this;
        }

        public Criteria andS_companyEqualTo(String value) {
            addCriterion("s_company =", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotEqualTo(String value) {
            addCriterion("s_company <>", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyGreaterThan(String value) {
            addCriterion("s_company >", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyGreaterThanOrEqualTo(String value) {
            addCriterion("s_company >=", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyLessThan(String value) {
            addCriterion("s_company <", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyLessThanOrEqualTo(String value) {
            addCriterion("s_company <=", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyLike(String value) {
            addCriterion("s_company like", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotLike(String value) {
            addCriterion("s_company not like", value, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyIn(List<String> values) {
            addCriterion("s_company in", values, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotIn(List<String> values) {
            addCriterion("s_company not in", values, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyBetween(String value1, String value2) {
            addCriterion("s_company between", value1, value2, "s_company");
            return (Criteria) this;
        }

        public Criteria andS_companyNotBetween(String value1, String value2) {
            addCriterion("s_company not between", value1, value2, "s_company");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointIsNull() {
            addCriterion("softening_point is null");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointIsNotNull() {
            addCriterion("softening_point is not null");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointEqualTo(Double value) {
            addCriterion("softening_point =", value, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointNotEqualTo(Double value) {
            addCriterion("softening_point <>", value, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointGreaterThan(Double value) {
            addCriterion("softening_point >", value, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointGreaterThanOrEqualTo(Double value) {
            addCriterion("softening_point >=", value, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointLessThan(Double value) {
            addCriterion("softening_point <", value, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointLessThanOrEqualTo(Double value) {
            addCriterion("softening_point <=", value, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointIn(List<Double> values) {
            addCriterion("softening_point in", values, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointNotIn(List<Double> values) {
            addCriterion("softening_point not in", values, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointBetween(Double value1, Double value2) {
            addCriterion("softening_point between", value1, value2, "softening_point");
            return (Criteria) this;
        }

        public Criteria andSoftening_pointNotBetween(Double value1, Double value2) {
            addCriterion("softening_point not between", value1, value2, "softening_point");
            return (Criteria) this;
        }

        public Criteria andTolueneIsNull() {
            addCriterion("toluene is null");
            return (Criteria) this;
        }

        public Criteria andTolueneIsNotNull() {
            addCriterion("toluene is not null");
            return (Criteria) this;
        }

        public Criteria andTolueneEqualTo(Double value) {
            addCriterion("toluene =", value, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneNotEqualTo(Double value) {
            addCriterion("toluene <>", value, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneGreaterThan(Double value) {
            addCriterion("toluene >", value, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneGreaterThanOrEqualTo(Double value) {
            addCriterion("toluene >=", value, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneLessThan(Double value) {
            addCriterion("toluene <", value, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneLessThanOrEqualTo(Double value) {
            addCriterion("toluene <=", value, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneIn(List<Double> values) {
            addCriterion("toluene in", values, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneNotIn(List<Double> values) {
            addCriterion("toluene not in", values, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneBetween(Double value1, Double value2) {
            addCriterion("toluene between", value1, value2, "toluene");
            return (Criteria) this;
        }

        public Criteria andTolueneNotBetween(Double value1, Double value2) {
            addCriterion("toluene not between", value1, value2, "toluene");
            return (Criteria) this;
        }

        public Criteria andQuinolineIsNull() {
            addCriterion("quinoline is null");
            return (Criteria) this;
        }

        public Criteria andQuinolineIsNotNull() {
            addCriterion("quinoline is not null");
            return (Criteria) this;
        }

        public Criteria andQuinolineEqualTo(Double value) {
            addCriterion("quinoline =", value, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineNotEqualTo(Double value) {
            addCriterion("quinoline <>", value, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineGreaterThan(Double value) {
            addCriterion("quinoline >", value, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineGreaterThanOrEqualTo(Double value) {
            addCriterion("quinoline >=", value, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineLessThan(Double value) {
            addCriterion("quinoline <", value, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineLessThanOrEqualTo(Double value) {
            addCriterion("quinoline <=", value, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineIn(List<Double> values) {
            addCriterion("quinoline in", values, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineNotIn(List<Double> values) {
            addCriterion("quinoline not in", values, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineBetween(Double value1, Double value2) {
            addCriterion("quinoline between", value1, value2, "quinoline");
            return (Criteria) this;
        }

        public Criteria andQuinolineNotBetween(Double value1, Double value2) {
            addCriterion("quinoline not between", value1, value2, "quinoline");
            return (Criteria) this;
        }

        public Criteria andBeta_resinIsNull() {
            addCriterion("beta_resin is null");
            return (Criteria) this;
        }

        public Criteria andBeta_resinIsNotNull() {
            addCriterion("beta_resin is not null");
            return (Criteria) this;
        }

        public Criteria andBeta_resinEqualTo(Double value) {
            addCriterion("beta_resin =", value, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinNotEqualTo(Double value) {
            addCriterion("beta_resin <>", value, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinGreaterThan(Double value) {
            addCriterion("beta_resin >", value, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinGreaterThanOrEqualTo(Double value) {
            addCriterion("beta_resin >=", value, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinLessThan(Double value) {
            addCriterion("beta_resin <", value, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinLessThanOrEqualTo(Double value) {
            addCriterion("beta_resin <=", value, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinIn(List<Double> values) {
            addCriterion("beta_resin in", values, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinNotIn(List<Double> values) {
            addCriterion("beta_resin not in", values, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinBetween(Double value1, Double value2) {
            addCriterion("beta_resin between", value1, value2, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andBeta_resinNotBetween(Double value1, Double value2) {
            addCriterion("beta_resin not between", value1, value2, "beta_resin");
            return (Criteria) this;
        }

        public Criteria andCoking_valueIsNull() {
            addCriterion("coking_value is null");
            return (Criteria) this;
        }

        public Criteria andCoking_valueIsNotNull() {
            addCriterion("coking_value is not null");
            return (Criteria) this;
        }

        public Criteria andCoking_valueEqualTo(Double value) {
            addCriterion("coking_value =", value, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueNotEqualTo(Double value) {
            addCriterion("coking_value <>", value, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueGreaterThan(Double value) {
            addCriterion("coking_value >", value, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueGreaterThanOrEqualTo(Double value) {
            addCriterion("coking_value >=", value, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueLessThan(Double value) {
            addCriterion("coking_value <", value, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueLessThanOrEqualTo(Double value) {
            addCriterion("coking_value <=", value, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueIn(List<Double> values) {
            addCriterion("coking_value in", values, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueNotIn(List<Double> values) {
            addCriterion("coking_value not in", values, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueBetween(Double value1, Double value2) {
            addCriterion("coking_value between", value1, value2, "coking_value");
            return (Criteria) this;
        }

        public Criteria andCoking_valueNotBetween(Double value1, Double value2) {
            addCriterion("coking_value not between", value1, value2, "coking_value");
            return (Criteria) this;
        }

        public Criteria andAshIsNull() {
            addCriterion("ash is null");
            return (Criteria) this;
        }

        public Criteria andAshIsNotNull() {
            addCriterion("ash is not null");
            return (Criteria) this;
        }

        public Criteria andAshEqualTo(Double value) {
            addCriterion("ash =", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotEqualTo(Double value) {
            addCriterion("ash <>", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshGreaterThan(Double value) {
            addCriterion("ash >", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshGreaterThanOrEqualTo(Double value) {
            addCriterion("ash >=", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshLessThan(Double value) {
            addCriterion("ash <", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshLessThanOrEqualTo(Double value) {
            addCriterion("ash <=", value, "ash");
            return (Criteria) this;
        }

        public Criteria andAshIn(List<Double> values) {
            addCriterion("ash in", values, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotIn(List<Double> values) {
            addCriterion("ash not in", values, "ash");
            return (Criteria) this;
        }

        public Criteria andAshBetween(Double value1, Double value2) {
            addCriterion("ash between", value1, value2, "ash");
            return (Criteria) this;
        }

        public Criteria andAshNotBetween(Double value1, Double value2) {
            addCriterion("ash not between", value1, value2, "ash");
            return (Criteria) this;
        }

        public Criteria andToday_priceIsNull() {
            addCriterion("today_price is null");
            return (Criteria) this;
        }

        public Criteria andToday_priceIsNotNull() {
            addCriterion("today_price is not null");
            return (Criteria) this;
        }

        public Criteria andToday_priceEqualTo(Double value) {
            addCriterion("today_price =", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceNotEqualTo(Double value) {
            addCriterion("today_price <>", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceGreaterThan(Double value) {
            addCriterion("today_price >", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceGreaterThanOrEqualTo(Double value) {
            addCriterion("today_price >=", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceLessThan(Double value) {
            addCriterion("today_price <", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceLessThanOrEqualTo(Double value) {
            addCriterion("today_price <=", value, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceIn(List<Double> values) {
            addCriterion("today_price in", values, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceNotIn(List<Double> values) {
            addCriterion("today_price not in", values, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceBetween(Double value1, Double value2) {
            addCriterion("today_price between", value1, value2, "today_price");
            return (Criteria) this;
        }

        public Criteria andToday_priceNotBetween(Double value1, Double value2) {
            addCriterion("today_price not between", value1, value2, "today_price");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("remarks is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("remarks is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("remarks =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("remarks <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("remarks >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("remarks >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("remarks <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("remarks <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("remarks like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("remarks not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("remarks in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("remarks not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("remarks between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("remarks not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreate_timeEqualTo(Date value) {
            addCriterion("create_time =", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThan(Date value) {
            addCriterion("create_time >", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThan(Date value) {
            addCriterion("create_time <", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeIn(List<Date> values) {
            addCriterion("create_time in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andCreate_timeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "create_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeEqualTo(Date value) {
            addCriterion("update_time =", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThan(Date value) {
            addCriterion("update_time >", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThan(Date value) {
            addCriterion("update_time <", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeIn(List<Date> values) {
            addCriterion("update_time in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andUpdate_timeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "update_time");
            return (Criteria) this;
        }

        public Criteria andExpand_1IsNull() {
            addCriterion("expand_1 is null");
            return (Criteria) this;
        }

        public Criteria andExpand_1IsNotNull() {
            addCriterion("expand_1 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand_1EqualTo(Boolean value) {
            addCriterion("expand_1 =", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1NotEqualTo(Boolean value) {
            addCriterion("expand_1 <>", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1GreaterThan(Boolean value) {
            addCriterion("expand_1 >", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1GreaterThanOrEqualTo(Boolean value) {
            addCriterion("expand_1 >=", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1LessThan(Boolean value) {
            addCriterion("expand_1 <", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1LessThanOrEqualTo(Boolean value) {
            addCriterion("expand_1 <=", value, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1In(List<Boolean> values) {
            addCriterion("expand_1 in", values, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1NotIn(List<Boolean> values) {
            addCriterion("expand_1 not in", values, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1Between(Boolean value1, Boolean value2) {
            addCriterion("expand_1 between", value1, value2, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_1NotBetween(Boolean value1, Boolean value2) {
            addCriterion("expand_1 not between", value1, value2, "expand_1");
            return (Criteria) this;
        }

        public Criteria andExpand_2IsNull() {
            addCriterion("expand_2 is null");
            return (Criteria) this;
        }

        public Criteria andExpand_2IsNotNull() {
            addCriterion("expand_2 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand_2EqualTo(Boolean value) {
            addCriterion("expand_2 =", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2NotEqualTo(Boolean value) {
            addCriterion("expand_2 <>", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2GreaterThan(Boolean value) {
            addCriterion("expand_2 >", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2GreaterThanOrEqualTo(Boolean value) {
            addCriterion("expand_2 >=", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2LessThan(Boolean value) {
            addCriterion("expand_2 <", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2LessThanOrEqualTo(Boolean value) {
            addCriterion("expand_2 <=", value, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2In(List<Boolean> values) {
            addCriterion("expand_2 in", values, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2NotIn(List<Boolean> values) {
            addCriterion("expand_2 not in", values, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2Between(Boolean value1, Boolean value2) {
            addCriterion("expand_2 between", value1, value2, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_2NotBetween(Boolean value1, Boolean value2) {
            addCriterion("expand_2 not between", value1, value2, "expand_2");
            return (Criteria) this;
        }

        public Criteria andExpand_3IsNull() {
            addCriterion("expand_3 is null");
            return (Criteria) this;
        }

        public Criteria andExpand_3IsNotNull() {
            addCriterion("expand_3 is not null");
            return (Criteria) this;
        }

        public Criteria andExpand_3EqualTo(Boolean value) {
            addCriterion("expand_3 =", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3NotEqualTo(Boolean value) {
            addCriterion("expand_3 <>", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3GreaterThan(Boolean value) {
            addCriterion("expand_3 >", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3GreaterThanOrEqualTo(Boolean value) {
            addCriterion("expand_3 >=", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3LessThan(Boolean value) {
            addCriterion("expand_3 <", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3LessThanOrEqualTo(Boolean value) {
            addCriterion("expand_3 <=", value, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3In(List<Boolean> values) {
            addCriterion("expand_3 in", values, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3NotIn(List<Boolean> values) {
            addCriterion("expand_3 not in", values, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3Between(Boolean value1, Boolean value2) {
            addCriterion("expand_3 between", value1, value2, "expand_3");
            return (Criteria) this;
        }

        public Criteria andExpand_3NotBetween(Boolean value1, Boolean value2) {
            addCriterion("expand_3 not between", value1, value2, "expand_3");
            return (Criteria) this;
        }

        public Criteria andReporterIsNull() {
            addCriterion("reporter is null");
            return (Criteria) this;
        }

        public Criteria andReporterIsNotNull() {
            addCriterion("reporter is not null");
            return (Criteria) this;
        }

        public Criteria andReporterEqualTo(String value) {
            addCriterion("reporter =", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotEqualTo(String value) {
            addCriterion("reporter <>", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterGreaterThan(String value) {
            addCriterion("reporter >", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterGreaterThanOrEqualTo(String value) {
            addCriterion("reporter >=", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLessThan(String value) {
            addCriterion("reporter <", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLessThanOrEqualTo(String value) {
            addCriterion("reporter <=", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterLike(String value) {
            addCriterion("reporter like", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotLike(String value) {
            addCriterion("reporter not like", value, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterIn(List<String> values) {
            addCriterion("reporter in", values, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotIn(List<String> values) {
            addCriterion("reporter not in", values, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterBetween(String value1, String value2) {
            addCriterion("reporter between", value1, value2, "reporter");
            return (Criteria) this;
        }

        public Criteria andReporterNotBetween(String value1, String value2) {
            addCriterion("reporter not between", value1, value2, "reporter");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}