package com.seller.entity.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample implements Serializable {
    /**
     * TASK
     */
    protected String orderByClause;

    /**
     * TASK
     */
    protected boolean distinct;

    /**
     * TASK
     */
    protected List<Criteria> oredCriteria;

    /**
     * TASK
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public TaskExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * TASK null
     */
    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        private static final long serialVersionUID = 1L;

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
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdIsNull() {
            addCriterion("TASK_GROUP_ID is null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdIsNotNull() {
            addCriterion("TASK_GROUP_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdEqualTo(Integer value) {
            addCriterion("TASK_GROUP_ID =", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdNotEqualTo(Integer value) {
            addCriterion("TASK_GROUP_ID <>", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdGreaterThan(Integer value) {
            addCriterion("TASK_GROUP_ID >", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_GROUP_ID >=", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdLessThan(Integer value) {
            addCriterion("TASK_GROUP_ID <", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_GROUP_ID <=", value, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdIn(List<Integer> values) {
            addCriterion("TASK_GROUP_ID in", values, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdNotIn(List<Integer> values) {
            addCriterion("TASK_GROUP_ID not in", values, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("TASK_GROUP_ID between", value1, value2, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andTaskGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_GROUP_ID not between", value1, value2, "taskGroupId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdIsNull() {
            addCriterion("PUBLISH_TIME_ID is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdIsNotNull() {
            addCriterion("PUBLISH_TIME_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdEqualTo(Integer value) {
            addCriterion("PUBLISH_TIME_ID =", value, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdNotEqualTo(Integer value) {
            addCriterion("PUBLISH_TIME_ID <>", value, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdGreaterThan(Integer value) {
            addCriterion("PUBLISH_TIME_ID >", value, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_TIME_ID >=", value, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdLessThan(Integer value) {
            addCriterion("PUBLISH_TIME_ID <", value, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_TIME_ID <=", value, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdIn(List<Integer> values) {
            addCriterion("PUBLISH_TIME_ID in", values, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdNotIn(List<Integer> values) {
            addCriterion("PUBLISH_TIME_ID not in", values, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_TIME_ID between", value1, value2, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_TIME_ID not between", value1, value2, "publishTimeId");
            return (Criteria) this;
        }

        public Criteria andPublishAmountIsNull() {
            addCriterion("PUBLISH_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andPublishAmountIsNotNull() {
            addCriterion("PUBLISH_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPublishAmountEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT =", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountNotEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT <>", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountGreaterThan(Integer value) {
            addCriterion("PUBLISH_AMOUNT >", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT >=", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountLessThan(Integer value) {
            addCriterion("PUBLISH_AMOUNT <", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_AMOUNT <=", value, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountIn(List<Integer> values) {
            addCriterion("PUBLISH_AMOUNT in", values, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountNotIn(List<Integer> values) {
            addCriterion("PUBLISH_AMOUNT not in", values, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_AMOUNT between", value1, value2, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andPublishAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_AMOUNT not between", value1, value2, "publishAmount");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNull() {
            addCriterion("BUYER_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIsNotNull() {
            addCriterion("BUYER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerIdEqualTo(Integer value) {
            addCriterion("BUYER_ID =", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotEqualTo(Integer value) {
            addCriterion("BUYER_ID <>", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThan(Integer value) {
            addCriterion("BUYER_ID >", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BUYER_ID >=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThan(Integer value) {
            addCriterion("BUYER_ID <", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdLessThanOrEqualTo(Integer value) {
            addCriterion("BUYER_ID <=", value, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdIn(List<Integer> values) {
            addCriterion("BUYER_ID in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotIn(List<Integer> values) {
            addCriterion("BUYER_ID not in", values, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdBetween(Integer value1, Integer value2) {
            addCriterion("BUYER_ID between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andBuyerIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BUYER_ID not between", value1, value2, "buyerId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoIsNull() {
            addCriterion("TAOBAO_ORDER_NO is null");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoIsNotNull() {
            addCriterion("TAOBAO_ORDER_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoEqualTo(String value) {
            addCriterion("TAOBAO_ORDER_NO =", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoNotEqualTo(String value) {
            addCriterion("TAOBAO_ORDER_NO <>", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoGreaterThan(String value) {
            addCriterion("TAOBAO_ORDER_NO >", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("TAOBAO_ORDER_NO >=", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoLessThan(String value) {
            addCriterion("TAOBAO_ORDER_NO <", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoLessThanOrEqualTo(String value) {
            addCriterion("TAOBAO_ORDER_NO <=", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoLike(String value) {
            addCriterion("TAOBAO_ORDER_NO like", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoNotLike(String value) {
            addCriterion("TAOBAO_ORDER_NO not like", value, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoIn(List<String> values) {
            addCriterion("TAOBAO_ORDER_NO in", values, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoNotIn(List<String> values) {
            addCriterion("TAOBAO_ORDER_NO not in", values, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoBetween(String value1, String value2) {
            addCriterion("TAOBAO_ORDER_NO between", value1, value2, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoNotBetween(String value1, String value2) {
            addCriterion("TAOBAO_ORDER_NO not between", value1, value2, "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeIsNull() {
            addCriterion("ACCEPT_ORDER_TIME is null");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeIsNotNull() {
            addCriterion("ACCEPT_ORDER_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeEqualTo(Date value) {
            addCriterion("ACCEPT_ORDER_TIME =", value, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeNotEqualTo(Date value) {
            addCriterion("ACCEPT_ORDER_TIME <>", value, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeGreaterThan(Date value) {
            addCriterion("ACCEPT_ORDER_TIME >", value, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_ORDER_TIME >=", value, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeLessThan(Date value) {
            addCriterion("ACCEPT_ORDER_TIME <", value, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("ACCEPT_ORDER_TIME <=", value, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeIn(List<Date> values) {
            addCriterion("ACCEPT_ORDER_TIME in", values, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeNotIn(List<Date> values) {
            addCriterion("ACCEPT_ORDER_TIME not in", values, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_ORDER_TIME between", value1, value2, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andAcceptOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("ACCEPT_ORDER_TIME not between", value1, value2, "acceptOrderTime");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("CREATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("CREATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Integer value) {
            addCriterion("CREATE_BY =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Integer value) {
            addCriterion("CREATE_BY <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Integer value) {
            addCriterion("CREATE_BY >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("CREATE_BY >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Integer value) {
            addCriterion("CREATE_BY <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Integer value) {
            addCriterion("CREATE_BY <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Integer> values) {
            addCriterion("CREATE_BY in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Integer> values) {
            addCriterion("CREATE_BY not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_BY between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Integer value1, Integer value2) {
            addCriterion("CREATE_BY not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("UPDATE_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("UPDATE_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(Integer value) {
            addCriterion("UPDATE_BY =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(Integer value) {
            addCriterion("UPDATE_BY <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(Integer value) {
            addCriterion("UPDATE_BY >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_BY >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(Integer value) {
            addCriterion("UPDATE_BY <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(Integer value) {
            addCriterion("UPDATE_BY <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<Integer> values) {
            addCriterion("UPDATE_BY in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<Integer> values) {
            addCriterion("UPDATE_BY not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_BY between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(Integer value1, Integer value2) {
            addCriterion("UPDATE_BY not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("UPDATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("UPDATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("UPDATE_TIME =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("UPDATE_TIME <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("UPDATE_TIME >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("UPDATE_TIME <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATE_TIME <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("UPDATE_TIME in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("UPDATE_TIME not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATE_TIME not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNull() {
            addCriterion("REMARKS is null");
            return (Criteria) this;
        }

        public Criteria andRemarksIsNotNull() {
            addCriterion("REMARKS is not null");
            return (Criteria) this;
        }

        public Criteria andRemarksEqualTo(String value) {
            addCriterion("REMARKS =", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotEqualTo(String value) {
            addCriterion("REMARKS <>", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThan(String value) {
            addCriterion("REMARKS >", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("REMARKS >=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThan(String value) {
            addCriterion("REMARKS <", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLessThanOrEqualTo(String value) {
            addCriterion("REMARKS <=", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksLike(String value) {
            addCriterion("REMARKS like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotLike(String value) {
            addCriterion("REMARKS not like", value, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksIn(List<String> values) {
            addCriterion("REMARKS in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotIn(List<String> values) {
            addCriterion("REMARKS not in", values, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksBetween(String value1, String value2) {
            addCriterion("REMARKS between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andRemarksNotBetween(String value1, String value2) {
            addCriterion("REMARKS not between", value1, value2, "remarks");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("DEL_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("DEL_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("DEL_FLAG =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("DEL_FLAG <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("DEL_FLAG >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("DEL_FLAG <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("DEL_FLAG <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("DEL_FLAG like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("DEL_FLAG not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("DEL_FLAG in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("DEL_FLAG not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("DEL_FLAG between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("DEL_FLAG not between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(STATUS) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andTaobaoOrderNoLikeInsensitive(String value) {
            addCriterion("upper(TAOBAO_ORDER_NO) like", value.toUpperCase(), "taobaoOrderNo");
            return (Criteria) this;
        }

        public Criteria andRemarksLikeInsensitive(String value) {
            addCriterion("upper(REMARKS) like", value.toUpperCase(), "remarks");
            return (Criteria) this;
        }

        public Criteria andDelFlagLikeInsensitive(String value) {
            addCriterion("upper(DEL_FLAG) like", value.toUpperCase(), "delFlag");
            return (Criteria) this;
        }
    }

    /**
     * TASK
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {
        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    /**
     * TASK null
     */
    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        private static final long serialVersionUID = 1L;

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