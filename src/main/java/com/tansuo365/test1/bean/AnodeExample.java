package com.tansuo365.test1.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AnodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AnodeExample() {
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andE_densityIsNull() {
            addCriterion("e_density is null");
            return (Criteria) this;
        }

        public Criteria andE_densityIsNotNull() {
            addCriterion("e_density is not null");
            return (Criteria) this;
        }

        public Criteria andE_densityEqualTo(Double value) {
            addCriterion("e_density =", value, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityNotEqualTo(Double value) {
            addCriterion("e_density <>", value, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityGreaterThan(Double value) {
            addCriterion("e_density >", value, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityGreaterThanOrEqualTo(Double value) {
            addCriterion("e_density >=", value, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityLessThan(Double value) {
            addCriterion("e_density <", value, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityLessThanOrEqualTo(Double value) {
            addCriterion("e_density <=", value, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityIn(List<Double> values) {
            addCriterion("e_density in", values, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityNotIn(List<Double> values) {
            addCriterion("e_density not in", values, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityBetween(Double value1, Double value2) {
            addCriterion("e_density between", value1, value2, "e_density");
            return (Criteria) this;
        }

        public Criteria andE_densityNotBetween(Double value1, Double value2) {
            addCriterion("e_density not between", value1, value2, "e_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityIsNull() {
            addCriterion("true_density is null");
            return (Criteria) this;
        }

        public Criteria andTrue_densityIsNotNull() {
            addCriterion("true_density is not null");
            return (Criteria) this;
        }

        public Criteria andTrue_densityEqualTo(Double value) {
            addCriterion("true_density =", value, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityNotEqualTo(Double value) {
            addCriterion("true_density <>", value, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityGreaterThan(Double value) {
            addCriterion("true_density >", value, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityGreaterThanOrEqualTo(Double value) {
            addCriterion("true_density >=", value, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityLessThan(Double value) {
            addCriterion("true_density <", value, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityLessThanOrEqualTo(Double value) {
            addCriterion("true_density <=", value, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityIn(List<Double> values) {
            addCriterion("true_density in", values, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityNotIn(List<Double> values) {
            addCriterion("true_density not in", values, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityBetween(Double value1, Double value2) {
            addCriterion("true_density between", value1, value2, "true_density");
            return (Criteria) this;
        }

        public Criteria andTrue_densityNotBetween(Double value1, Double value2) {
            addCriterion("true_density not between", value1, value2, "true_density");
            return (Criteria) this;
        }

        public Criteria andCompressiveIsNull() {
            addCriterion("compressive is null");
            return (Criteria) this;
        }

        public Criteria andCompressiveIsNotNull() {
            addCriterion("compressive is not null");
            return (Criteria) this;
        }

        public Criteria andCompressiveEqualTo(Double value) {
            addCriterion("compressive =", value, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveNotEqualTo(Double value) {
            addCriterion("compressive <>", value, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveGreaterThan(Double value) {
            addCriterion("compressive >", value, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveGreaterThanOrEqualTo(Double value) {
            addCriterion("compressive >=", value, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveLessThan(Double value) {
            addCriterion("compressive <", value, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveLessThanOrEqualTo(Double value) {
            addCriterion("compressive <=", value, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveIn(List<Double> values) {
            addCriterion("compressive in", values, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveNotIn(List<Double> values) {
            addCriterion("compressive not in", values, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveBetween(Double value1, Double value2) {
            addCriterion("compressive between", value1, value2, "compressive");
            return (Criteria) this;
        }

        public Criteria andCompressiveNotBetween(Double value1, Double value2) {
            addCriterion("compressive not between", value1, value2, "compressive");
            return (Criteria) this;
        }

        public Criteria andCarbonIsNull() {
            addCriterion("carbon is null");
            return (Criteria) this;
        }

        public Criteria andCarbonIsNotNull() {
            addCriterion("carbon is not null");
            return (Criteria) this;
        }

        public Criteria andCarbonEqualTo(Double value) {
            addCriterion("carbon =", value, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonNotEqualTo(Double value) {
            addCriterion("carbon <>", value, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonGreaterThan(Double value) {
            addCriterion("carbon >", value, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonGreaterThanOrEqualTo(Double value) {
            addCriterion("carbon >=", value, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonLessThan(Double value) {
            addCriterion("carbon <", value, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonLessThanOrEqualTo(Double value) {
            addCriterion("carbon <=", value, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonIn(List<Double> values) {
            addCriterion("carbon in", values, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonNotIn(List<Double> values) {
            addCriterion("carbon not in", values, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonBetween(Double value1, Double value2) {
            addCriterion("carbon between", value1, value2, "carbon");
            return (Criteria) this;
        }

        public Criteria andCarbonNotBetween(Double value1, Double value2) {
            addCriterion("carbon not between", value1, value2, "carbon");
            return (Criteria) this;
        }

        public Criteria andFlexuralIsNull() {
            addCriterion("flexural is null");
            return (Criteria) this;
        }

        public Criteria andFlexuralIsNotNull() {
            addCriterion("flexural is not null");
            return (Criteria) this;
        }

        public Criteria andFlexuralEqualTo(Double value) {
            addCriterion("flexural =", value, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralNotEqualTo(Double value) {
            addCriterion("flexural <>", value, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralGreaterThan(Double value) {
            addCriterion("flexural >", value, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralGreaterThanOrEqualTo(Double value) {
            addCriterion("flexural >=", value, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralLessThan(Double value) {
            addCriterion("flexural <", value, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralLessThanOrEqualTo(Double value) {
            addCriterion("flexural <=", value, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralIn(List<Double> values) {
            addCriterion("flexural in", values, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralNotIn(List<Double> values) {
            addCriterion("flexural not in", values, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralBetween(Double value1, Double value2) {
            addCriterion("flexural between", value1, value2, "flexural");
            return (Criteria) this;
        }

        public Criteria andFlexuralNotBetween(Double value1, Double value2) {
            addCriterion("flexural not between", value1, value2, "flexural");
            return (Criteria) this;
        }

        public Criteria andRoomIsNull() {
            addCriterion("room is null");
            return (Criteria) this;
        }

        public Criteria andRoomIsNotNull() {
            addCriterion("room is not null");
            return (Criteria) this;
        }

        public Criteria andRoomEqualTo(Double value) {
            addCriterion("room =", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotEqualTo(Double value) {
            addCriterion("room <>", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThan(Double value) {
            addCriterion("room >", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomGreaterThanOrEqualTo(Double value) {
            addCriterion("room >=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThan(Double value) {
            addCriterion("room <", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomLessThanOrEqualTo(Double value) {
            addCriterion("room <=", value, "room");
            return (Criteria) this;
        }

        public Criteria andRoomIn(List<Double> values) {
            addCriterion("room in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotIn(List<Double> values) {
            addCriterion("room not in", values, "room");
            return (Criteria) this;
        }

        public Criteria andRoomBetween(Double value1, Double value2) {
            addCriterion("room between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andRoomNotBetween(Double value1, Double value2) {
            addCriterion("room not between", value1, value2, "room");
            return (Criteria) this;
        }

        public Criteria andThermalIsNull() {
            addCriterion("thermal is null");
            return (Criteria) this;
        }

        public Criteria andThermalIsNotNull() {
            addCriterion("thermal is not null");
            return (Criteria) this;
        }

        public Criteria andThermalEqualTo(Double value) {
            addCriterion("thermal =", value, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalNotEqualTo(Double value) {
            addCriterion("thermal <>", value, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalGreaterThan(Double value) {
            addCriterion("thermal >", value, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalGreaterThanOrEqualTo(Double value) {
            addCriterion("thermal >=", value, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalLessThan(Double value) {
            addCriterion("thermal <", value, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalLessThanOrEqualTo(Double value) {
            addCriterion("thermal <=", value, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalIn(List<Double> values) {
            addCriterion("thermal in", values, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalNotIn(List<Double> values) {
            addCriterion("thermal not in", values, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalBetween(Double value1, Double value2) {
            addCriterion("thermal between", value1, value2, "thermal");
            return (Criteria) this;
        }

        public Criteria andThermalNotBetween(Double value1, Double value2) {
            addCriterion("thermal not between", value1, value2, "thermal");
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

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andBowlIsNull() {
            addCriterion("bowl is null");
            return (Criteria) this;
        }

        public Criteria andBowlIsNotNull() {
            addCriterion("bowl is not null");
            return (Criteria) this;
        }

        public Criteria andBowlEqualTo(String value) {
            addCriterion("bowl =", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlNotEqualTo(String value) {
            addCriterion("bowl <>", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlGreaterThan(String value) {
            addCriterion("bowl >", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlGreaterThanOrEqualTo(String value) {
            addCriterion("bowl >=", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlLessThan(String value) {
            addCriterion("bowl <", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlLessThanOrEqualTo(String value) {
            addCriterion("bowl <=", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlLike(String value) {
            addCriterion("bowl like", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlNotLike(String value) {
            addCriterion("bowl not like", value, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlIn(List<String> values) {
            addCriterion("bowl in", values, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlNotIn(List<String> values) {
            addCriterion("bowl not in", values, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlBetween(String value1, String value2) {
            addCriterion("bowl between", value1, value2, "bowl");
            return (Criteria) this;
        }

        public Criteria andBowlNotBetween(String value1, String value2) {
            addCriterion("bowl not between", value1, value2, "bowl");
            return (Criteria) this;
        }

        public Criteria andIn_diameterIsNull() {
            addCriterion("in_diameter is null");
            return (Criteria) this;
        }

        public Criteria andIn_diameterIsNotNull() {
            addCriterion("in_diameter is not null");
            return (Criteria) this;
        }

        public Criteria andIn_diameterEqualTo(Double value) {
            addCriterion("in_diameter =", value, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterNotEqualTo(Double value) {
            addCriterion("in_diameter <>", value, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterGreaterThan(Double value) {
            addCriterion("in_diameter >", value, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterGreaterThanOrEqualTo(Double value) {
            addCriterion("in_diameter >=", value, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterLessThan(Double value) {
            addCriterion("in_diameter <", value, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterLessThanOrEqualTo(Double value) {
            addCriterion("in_diameter <=", value, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterIn(List<Double> values) {
            addCriterion("in_diameter in", values, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterNotIn(List<Double> values) {
            addCriterion("in_diameter not in", values, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterBetween(Double value1, Double value2) {
            addCriterion("in_diameter between", value1, value2, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andIn_diameterNotBetween(Double value1, Double value2) {
            addCriterion("in_diameter not between", value1, value2, "in_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterIsNull() {
            addCriterion("out_diameter is null");
            return (Criteria) this;
        }

        public Criteria andOut_diameterIsNotNull() {
            addCriterion("out_diameter is not null");
            return (Criteria) this;
        }

        public Criteria andOut_diameterEqualTo(Double value) {
            addCriterion("out_diameter =", value, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterNotEqualTo(Double value) {
            addCriterion("out_diameter <>", value, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterGreaterThan(Double value) {
            addCriterion("out_diameter >", value, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterGreaterThanOrEqualTo(Double value) {
            addCriterion("out_diameter >=", value, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterLessThan(Double value) {
            addCriterion("out_diameter <", value, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterLessThanOrEqualTo(Double value) {
            addCriterion("out_diameter <=", value, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterIn(List<Double> values) {
            addCriterion("out_diameter in", values, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterNotIn(List<Double> values) {
            addCriterion("out_diameter not in", values, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterBetween(Double value1, Double value2) {
            addCriterion("out_diameter between", value1, value2, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andOut_diameterNotBetween(Double value1, Double value2) {
            addCriterion("out_diameter not between", value1, value2, "out_diameter");
            return (Criteria) this;
        }

        public Criteria andSlotIsNull() {
            addCriterion("slot is null");
            return (Criteria) this;
        }

        public Criteria andSlotIsNotNull() {
            addCriterion("slot is not null");
            return (Criteria) this;
        }

        public Criteria andSlotEqualTo(String value) {
            addCriterion("slot =", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotEqualTo(String value) {
            addCriterion("slot <>", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotGreaterThan(String value) {
            addCriterion("slot >", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotGreaterThanOrEqualTo(String value) {
            addCriterion("slot >=", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotLessThan(String value) {
            addCriterion("slot <", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotLessThanOrEqualTo(String value) {
            addCriterion("slot <=", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotLike(String value) {
            addCriterion("slot like", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotLike(String value) {
            addCriterion("slot not like", value, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotIn(List<String> values) {
            addCriterion("slot in", values, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotIn(List<String> values) {
            addCriterion("slot not in", values, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotBetween(String value1, String value2) {
            addCriterion("slot between", value1, value2, "slot");
            return (Criteria) this;
        }

        public Criteria andSlotNotBetween(String value1, String value2) {
            addCriterion("slot not between", value1, value2, "slot");
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