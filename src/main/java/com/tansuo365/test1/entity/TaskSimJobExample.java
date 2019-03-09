package com.tansuo365.test1.entity;

import java.util.ArrayList;
import java.util.List;

public class TaskSimJobExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskSimJobExample() {
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

        public Criteria andEnabledIsNull() {
            addCriterion("enabled is null");
            return (Criteria) this;
        }

        public Criteria andEnabledIsNotNull() {
            addCriterion("enabled is not null");
            return (Criteria) this;
        }

        public Criteria andEnabledEqualTo(Integer value) {
            addCriterion("enabled =", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotEqualTo(Integer value) {
            addCriterion("enabled <>", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThan(Integer value) {
            addCriterion("enabled >", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("enabled >=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThan(Integer value) {
            addCriterion("enabled <", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("enabled <=", value, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledIn(List<Integer> values) {
            addCriterion("enabled in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotIn(List<Integer> values) {
            addCriterion("enabled not in", values, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledBetween(Integer value1, Integer value2) {
            addCriterion("enabled between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("enabled not between", value1, value2, "enabled");
            return (Criteria) this;
        }

        public Criteria andInterval_timeIsNull() {
            addCriterion("interval_time is null");
            return (Criteria) this;
        }

        public Criteria andInterval_timeIsNotNull() {
            addCriterion("interval_time is not null");
            return (Criteria) this;
        }

        public Criteria andInterval_timeEqualTo(Integer value) {
            addCriterion("interval_time =", value, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeNotEqualTo(Integer value) {
            addCriterion("interval_time <>", value, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeGreaterThan(Integer value) {
            addCriterion("interval_time >", value, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeGreaterThanOrEqualTo(Integer value) {
            addCriterion("interval_time >=", value, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeLessThan(Integer value) {
            addCriterion("interval_time <", value, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeLessThanOrEqualTo(Integer value) {
            addCriterion("interval_time <=", value, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeIn(List<Integer> values) {
            addCriterion("interval_time in", values, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeNotIn(List<Integer> values) {
            addCriterion("interval_time not in", values, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeBetween(Integer value1, Integer value2) {
            addCriterion("interval_time between", value1, value2, "interval_time");
            return (Criteria) this;
        }

        public Criteria andInterval_timeNotBetween(Integer value1, Integer value2) {
            addCriterion("interval_time not between", value1, value2, "interval_time");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameIsNull() {
            addCriterion("job_class_name is null");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameIsNotNull() {
            addCriterion("job_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameEqualTo(String value) {
            addCriterion("job_class_name =", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameNotEqualTo(String value) {
            addCriterion("job_class_name <>", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameGreaterThan(String value) {
            addCriterion("job_class_name >", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameGreaterThanOrEqualTo(String value) {
            addCriterion("job_class_name >=", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameLessThan(String value) {
            addCriterion("job_class_name <", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameLessThanOrEqualTo(String value) {
            addCriterion("job_class_name <=", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameLike(String value) {
            addCriterion("job_class_name like", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameNotLike(String value) {
            addCriterion("job_class_name not like", value, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameIn(List<String> values) {
            addCriterion("job_class_name in", values, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameNotIn(List<String> values) {
            addCriterion("job_class_name not in", values, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameBetween(String value1, String value2) {
            addCriterion("job_class_name between", value1, value2, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_class_nameNotBetween(String value1, String value2) {
            addCriterion("job_class_name not between", value1, value2, "job_class_name");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionIsNull() {
            addCriterion("job_description is null");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionIsNotNull() {
            addCriterion("job_description is not null");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionEqualTo(String value) {
            addCriterion("job_description =", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionNotEqualTo(String value) {
            addCriterion("job_description <>", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionGreaterThan(String value) {
            addCriterion("job_description >", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionGreaterThanOrEqualTo(String value) {
            addCriterion("job_description >=", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionLessThan(String value) {
            addCriterion("job_description <", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionLessThanOrEqualTo(String value) {
            addCriterion("job_description <=", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionLike(String value) {
            addCriterion("job_description like", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionNotLike(String value) {
            addCriterion("job_description not like", value, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionIn(List<String> values) {
            addCriterion("job_description in", values, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionNotIn(List<String> values) {
            addCriterion("job_description not in", values, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionBetween(String value1, String value2) {
            addCriterion("job_description between", value1, value2, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_descriptionNotBetween(String value1, String value2) {
            addCriterion("job_description not between", value1, value2, "job_description");
            return (Criteria) this;
        }

        public Criteria andJob_nameIsNull() {
            addCriterion("job_name is null");
            return (Criteria) this;
        }

        public Criteria andJob_nameIsNotNull() {
            addCriterion("job_name is not null");
            return (Criteria) this;
        }

        public Criteria andJob_nameEqualTo(String value) {
            addCriterion("job_name =", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameNotEqualTo(String value) {
            addCriterion("job_name <>", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameGreaterThan(String value) {
            addCriterion("job_name >", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameGreaterThanOrEqualTo(String value) {
            addCriterion("job_name >=", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameLessThan(String value) {
            addCriterion("job_name <", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameLessThanOrEqualTo(String value) {
            addCriterion("job_name <=", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameLike(String value) {
            addCriterion("job_name like", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameNotLike(String value) {
            addCriterion("job_name not like", value, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameIn(List<String> values) {
            addCriterion("job_name in", values, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameNotIn(List<String> values) {
            addCriterion("job_name not in", values, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameBetween(String value1, String value2) {
            addCriterion("job_name between", value1, value2, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_nameNotBetween(String value1, String value2) {
            addCriterion("job_name not between", value1, value2, "job_name");
            return (Criteria) this;
        }

        public Criteria andJob_numberIsNull() {
            addCriterion("job_number is null");
            return (Criteria) this;
        }

        public Criteria andJob_numberIsNotNull() {
            addCriterion("job_number is not null");
            return (Criteria) this;
        }

        public Criteria andJob_numberEqualTo(String value) {
            addCriterion("job_number =", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberNotEqualTo(String value) {
            addCriterion("job_number <>", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberGreaterThan(String value) {
            addCriterion("job_number >", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberGreaterThanOrEqualTo(String value) {
            addCriterion("job_number >=", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberLessThan(String value) {
            addCriterion("job_number <", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberLessThanOrEqualTo(String value) {
            addCriterion("job_number <=", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberLike(String value) {
            addCriterion("job_number like", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberNotLike(String value) {
            addCriterion("job_number not like", value, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberIn(List<String> values) {
            addCriterion("job_number in", values, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberNotIn(List<String> values) {
            addCriterion("job_number not in", values, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberBetween(String value1, String value2) {
            addCriterion("job_number between", value1, value2, "job_number");
            return (Criteria) this;
        }

        public Criteria andJob_numberNotBetween(String value1, String value2) {
            addCriterion("job_number not between", value1, value2, "job_number");
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