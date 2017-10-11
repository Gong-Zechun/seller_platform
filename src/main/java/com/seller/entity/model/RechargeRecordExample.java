package com.seller.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RechargeRecordExample implements Serializable {
    /**
     * RECHARGE_RECORD
     */
    protected String orderByClause;

    /**
     * RECHARGE_RECORD
     */
    protected boolean distinct;

    /**
     * RECHARGE_RECORD
     */
    protected List<Criteria> oredCriteria;

    /**
     * RECHARGE_RECORD
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbg.generated
     */
    public RechargeRecordExample() {
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
     * RECHARGE_RECORD null
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

        public Criteria andReceiptAccountNameIsNull() {
            addCriterion("RECEIPT_ACCOUNT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameIsNotNull() {
            addCriterion("RECEIPT_ACCOUNT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameEqualTo(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME =", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameNotEqualTo(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME <>", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameGreaterThan(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME >", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME >=", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameLessThan(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME <", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameLessThanOrEqualTo(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME <=", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameLike(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME like", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameNotLike(String value) {
            addCriterion("RECEIPT_ACCOUNT_NAME not like", value, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameIn(List<String> values) {
            addCriterion("RECEIPT_ACCOUNT_NAME in", values, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameNotIn(List<String> values) {
            addCriterion("RECEIPT_ACCOUNT_NAME not in", values, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameBetween(String value1, String value2) {
            addCriterion("RECEIPT_ACCOUNT_NAME between", value1, value2, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andReceiptAccountNameNotBetween(String value1, String value2) {
            addCriterion("RECEIPT_ACCOUNT_NAME not between", value1, value2, "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneIsNull() {
            addCriterion("TRANSFER_PERSON_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneIsNotNull() {
            addCriterion("TRANSFER_PERSON_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneEqualTo(String value) {
            addCriterion("TRANSFER_PERSON_PHONE =", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneNotEqualTo(String value) {
            addCriterion("TRANSFER_PERSON_PHONE <>", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneGreaterThan(String value) {
            addCriterion("TRANSFER_PERSON_PHONE >", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSFER_PERSON_PHONE >=", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneLessThan(String value) {
            addCriterion("TRANSFER_PERSON_PHONE <", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneLessThanOrEqualTo(String value) {
            addCriterion("TRANSFER_PERSON_PHONE <=", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneLike(String value) {
            addCriterion("TRANSFER_PERSON_PHONE like", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneNotLike(String value) {
            addCriterion("TRANSFER_PERSON_PHONE not like", value, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneIn(List<String> values) {
            addCriterion("TRANSFER_PERSON_PHONE in", values, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneNotIn(List<String> values) {
            addCriterion("TRANSFER_PERSON_PHONE not in", values, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneBetween(String value1, String value2) {
            addCriterion("TRANSFER_PERSON_PHONE between", value1, value2, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneNotBetween(String value1, String value2) {
            addCriterion("TRANSFER_PERSON_PHONE not between", value1, value2, "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIsNull() {
            addCriterion("TRANSFER_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIsNotNull() {
            addCriterion("TRANSFER_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTransferAmountEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMOUNT =", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMOUNT <>", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountGreaterThan(BigDecimal value) {
            addCriterion("TRANSFER_AMOUNT >", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMOUNT >=", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountLessThan(BigDecimal value) {
            addCriterion("TRANSFER_AMOUNT <", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRANSFER_AMOUNT <=", value, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountIn(List<BigDecimal> values) {
            addCriterion("TRANSFER_AMOUNT in", values, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotIn(List<BigDecimal> values) {
            addCriterion("TRANSFER_AMOUNT not in", values, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRANSFER_AMOUNT between", value1, value2, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRANSFER_AMOUNT not between", value1, value2, "transferAmount");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlIsNull() {
            addCriterion("TRANSFER_IMG_URL is null");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlIsNotNull() {
            addCriterion("TRANSFER_IMG_URL is not null");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlEqualTo(String value) {
            addCriterion("TRANSFER_IMG_URL =", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlNotEqualTo(String value) {
            addCriterion("TRANSFER_IMG_URL <>", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlGreaterThan(String value) {
            addCriterion("TRANSFER_IMG_URL >", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("TRANSFER_IMG_URL >=", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlLessThan(String value) {
            addCriterion("TRANSFER_IMG_URL <", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlLessThanOrEqualTo(String value) {
            addCriterion("TRANSFER_IMG_URL <=", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlLike(String value) {
            addCriterion("TRANSFER_IMG_URL like", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlNotLike(String value) {
            addCriterion("TRANSFER_IMG_URL not like", value, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlIn(List<String> values) {
            addCriterion("TRANSFER_IMG_URL in", values, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlNotIn(List<String> values) {
            addCriterion("TRANSFER_IMG_URL not in", values, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlBetween(String value1, String value2) {
            addCriterion("TRANSFER_IMG_URL between", value1, value2, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlNotBetween(String value1, String value2) {
            addCriterion("TRANSFER_IMG_URL not between", value1, value2, "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andFinishFlagIsNull() {
            addCriterion("FINISH_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andFinishFlagIsNotNull() {
            addCriterion("FINISH_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andFinishFlagEqualTo(String value) {
            addCriterion("FINISH_FLAG =", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagNotEqualTo(String value) {
            addCriterion("FINISH_FLAG <>", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagGreaterThan(String value) {
            addCriterion("FINISH_FLAG >", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagGreaterThanOrEqualTo(String value) {
            addCriterion("FINISH_FLAG >=", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagLessThan(String value) {
            addCriterion("FINISH_FLAG <", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagLessThanOrEqualTo(String value) {
            addCriterion("FINISH_FLAG <=", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagLike(String value) {
            addCriterion("FINISH_FLAG like", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagNotLike(String value) {
            addCriterion("FINISH_FLAG not like", value, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagIn(List<String> values) {
            addCriterion("FINISH_FLAG in", values, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagNotIn(List<String> values) {
            addCriterion("FINISH_FLAG not in", values, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagBetween(String value1, String value2) {
            addCriterion("FINISH_FLAG between", value1, value2, "finishFlag");
            return (Criteria) this;
        }

        public Criteria andFinishFlagNotBetween(String value1, String value2) {
            addCriterion("FINISH_FLAG not between", value1, value2, "finishFlag");
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

        public Criteria andReceiptAccountNameLikeInsensitive(String value) {
            addCriterion("upper(RECEIPT_ACCOUNT_NAME) like", value.toUpperCase(), "receiptAccountName");
            return (Criteria) this;
        }

        public Criteria andTransferPersonPhoneLikeInsensitive(String value) {
            addCriterion("upper(TRANSFER_PERSON_PHONE) like", value.toUpperCase(), "transferPersonPhone");
            return (Criteria) this;
        }

        public Criteria andTransferImgUrlLikeInsensitive(String value) {
            addCriterion("upper(TRANSFER_IMG_URL) like", value.toUpperCase(), "transferImgUrl");
            return (Criteria) this;
        }

        public Criteria andFinishFlagLikeInsensitive(String value) {
            addCriterion("upper(FINISH_FLAG) like", value.toUpperCase(), "finishFlag");
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
     * RECHARGE_RECORD
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {
        private static final long serialVersionUID = 1L;

        protected Criteria() {
            super();
        }
    }

    /**
     * RECHARGE_RECORD null
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