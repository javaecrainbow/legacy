package com.salk.legacy.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ImportExample {
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table import
	 * 
	 * @mbggenerated
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table import
	 * 
	 * @mbggenerated
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to
	 * the database table import
	 * 
	 * @mbggenerated
	 */
	protected List<Criteria> oredCriteria;
	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	protected Page page;

	public ImportExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table import
	 * 
	 * @mbggenerated
	 */
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

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

		public Criteria andImportNoIsNull() {
			addCriterion("import_no is null");
			return (Criteria) this;
		}

		public Criteria andImportNoIsNotNull() {
			addCriterion("import_no is not null");
			return (Criteria) this;
		}

		public Criteria andImportNoEqualTo(String value) {
			addCriterion("import_no =", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoNotEqualTo(String value) {
			addCriterion("import_no <>", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoGreaterThan(String value) {
			addCriterion("import_no >", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoGreaterThanOrEqualTo(String value) {
			addCriterion("import_no >=", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoLessThan(String value) {
			addCriterion("import_no <", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoLessThanOrEqualTo(String value) {
			addCriterion("import_no <=", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoLike(String value) {
			addCriterion("import_no like", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoNotLike(String value) {
			addCriterion("import_no not like", value, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoIn(List<String> values) {
			addCriterion("import_no in", values, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoNotIn(List<String> values) {
			addCriterion("import_no not in", values, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoBetween(String value1, String value2) {
			addCriterion("import_no between", value1, value2, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportNoNotBetween(String value1, String value2) {
			addCriterion("import_no not between", value1, value2, "importNo");
			return (Criteria) this;
		}

		public Criteria andImportSizeIsNull() {
			addCriterion("import_size is null");
			return (Criteria) this;
		}

		public Criteria andImportSizeIsNotNull() {
			addCriterion("import_size is not null");
			return (Criteria) this;
		}

		public Criteria andImportSizeEqualTo(String value) {
			addCriterion("import_size =", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeNotEqualTo(String value) {
			addCriterion("import_size <>", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeGreaterThan(String value) {
			addCriterion("import_size >", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeGreaterThanOrEqualTo(String value) {
			addCriterion("import_size >=", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeLessThan(String value) {
			addCriterion("import_size <", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeLessThanOrEqualTo(String value) {
			addCriterion("import_size <=", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeLike(String value) {
			addCriterion("import_size like", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeNotLike(String value) {
			addCriterion("import_size not like", value, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeIn(List<String> values) {
			addCriterion("import_size in", values, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeNotIn(List<String> values) {
			addCriterion("import_size not in", values, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeBetween(String value1, String value2) {
			addCriterion("import_size between", value1, value2, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportSizeNotBetween(String value1, String value2) {
			addCriterion("import_size not between", value1, value2, "importSize");
			return (Criteria) this;
		}

		public Criteria andImportDateIsNull() {
			addCriterion("import_date is null");
			return (Criteria) this;
		}

		public Criteria andImportDateIsNotNull() {
			addCriterion("import_date is not null");
			return (Criteria) this;
		}

		public Criteria andImportDateEqualTo(Date value) {
			addCriterionForJDBCDate("import_date =", value, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("import_date <>", value, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateGreaterThan(Date value) {
			addCriterionForJDBCDate("import_date >", value, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("import_date >=", value, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateLessThan(Date value) {
			addCriterionForJDBCDate("import_date <", value, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("import_date <=", value, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateIn(List<Date> values) {
			addCriterionForJDBCDate("import_date in", values, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("import_date not in", values, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("import_date between", value1, value2, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("import_date not between", value1, value2, "importDate");
			return (Criteria) this;
		}

		public Criteria andImportTypeIsNull() {
			addCriterion("import_type is null");
			return (Criteria) this;
		}

		public Criteria andImportTypeIsNotNull() {
			addCriterion("import_type is not null");
			return (Criteria) this;
		}

		public Criteria andImportTypeEqualTo(String value) {
			addCriterion("import_type =", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeNotEqualTo(String value) {
			addCriterion("import_type <>", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeGreaterThan(String value) {
			addCriterion("import_type >", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeGreaterThanOrEqualTo(String value) {
			addCriterion("import_type >=", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeLessThan(String value) {
			addCriterion("import_type <", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeLessThanOrEqualTo(String value) {
			addCriterion("import_type <=", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeLike(String value) {
			addCriterion("import_type like", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeNotLike(String value) {
			addCriterion("import_type not like", value, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeIn(List<String> values) {
			addCriterion("import_type in", values, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeNotIn(List<String> values) {
			addCriterion("import_type not in", values, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeBetween(String value1, String value2) {
			addCriterion("import_type between", value1, value2, "importType");
			return (Criteria) this;
		}

		public Criteria andImportTypeNotBetween(String value1, String value2) {
			addCriterion("import_type not between", value1, value2, "importType");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("remark is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("remark is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("remark =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("remark <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("remark >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("remark >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("remark <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("remark <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("remark like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("remark not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("remark in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("remark not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("remark between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("remark not between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andImportColorIsNull() {
			addCriterion("import_color is null");
			return (Criteria) this;
		}

		public Criteria andImportColorIsNotNull() {
			addCriterion("import_color is not null");
			return (Criteria) this;
		}

		public Criteria andImportColorEqualTo(String value) {
			addCriterion("import_color =", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorNotEqualTo(String value) {
			addCriterion("import_color <>", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorGreaterThan(String value) {
			addCriterion("import_color >", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorGreaterThanOrEqualTo(String value) {
			addCriterion("import_color >=", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorLessThan(String value) {
			addCriterion("import_color <", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorLessThanOrEqualTo(String value) {
			addCriterion("import_color <=", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorLike(String value) {
			addCriterion("import_color like", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorNotLike(String value) {
			addCriterion("import_color not like", value, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorIn(List<String> values) {
			addCriterion("import_color in", values, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorNotIn(List<String> values) {
			addCriterion("import_color not in", values, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorBetween(String value1, String value2) {
			addCriterion("import_color between", value1, value2, "importColor");
			return (Criteria) this;
		}

		public Criteria andImportColorNotBetween(String value1, String value2) {
			addCriterion("import_color not between", value1, value2, "importColor");
			return (Criteria) this;
		}

		public Criteria andAdderNameIsNull() {
			addCriterion("adder_name is null");
			return (Criteria) this;
		}

		public Criteria andAdderNameIsNotNull() {
			addCriterion("adder_name is not null");
			return (Criteria) this;
		}

		public Criteria andAdderNameEqualTo(String value) {
			addCriterion("adder_name =", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameNotEqualTo(String value) {
			addCriterion("adder_name <>", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameGreaterThan(String value) {
			addCriterion("adder_name >", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameGreaterThanOrEqualTo(String value) {
			addCriterion("adder_name >=", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameLessThan(String value) {
			addCriterion("adder_name <", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameLessThanOrEqualTo(String value) {
			addCriterion("adder_name <=", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameLike(String value) {
			addCriterion("adder_name like", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameNotLike(String value) {
			addCriterion("adder_name not like", value, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameIn(List<String> values) {
			addCriterion("adder_name in", values, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameNotIn(List<String> values) {
			addCriterion("adder_name not in", values, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameBetween(String value1, String value2) {
			addCriterion("adder_name between", value1, value2, "adderName");
			return (Criteria) this;
		}

		public Criteria andAdderNameNotBetween(String value1, String value2) {
			addCriterion("adder_name not between", value1, value2, "adderName");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNull() {
			addCriterion("add_time is null");
			return (Criteria) this;
		}

		public Criteria andAddTimeIsNotNull() {
			addCriterion("add_time is not null");
			return (Criteria) this;
		}

		public Criteria andAddTimeEqualTo(Date value) {
			addCriterion("add_time =", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotEqualTo(Date value) {
			addCriterion("add_time <>", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThan(Date value) {
			addCriterion("add_time >", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("add_time >=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThan(Date value) {
			addCriterion("add_time <", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeLessThanOrEqualTo(Date value) {
			addCriterion("add_time <=", value, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeIn(List<Date> values) {
			addCriterion("add_time in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotIn(List<Date> values) {
			addCriterion("add_time not in", values, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeBetween(Date value1, Date value2) {
			addCriterion("add_time between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andAddTimeNotBetween(Date value1, Date value2) {
			addCriterion("add_time not between", value1, value2, "addTime");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameIsNull() {
			addCriterion("updater_name is null");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameIsNotNull() {
			addCriterion("updater_name is not null");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameEqualTo(String value) {
			addCriterion("updater_name =", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameNotEqualTo(String value) {
			addCriterion("updater_name <>", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameGreaterThan(String value) {
			addCriterion("updater_name >", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameGreaterThanOrEqualTo(String value) {
			addCriterion("updater_name >=", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameLessThan(String value) {
			addCriterion("updater_name <", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameLessThanOrEqualTo(String value) {
			addCriterion("updater_name <=", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameLike(String value) {
			addCriterion("updater_name like", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameNotLike(String value) {
			addCriterion("updater_name not like", value, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameIn(List<String> values) {
			addCriterion("updater_name in", values, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameNotIn(List<String> values) {
			addCriterion("updater_name not in", values, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameBetween(String value1, String value2) {
			addCriterion("updater_name between", value1, value2, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdaterNameNotBetween(String value1, String value2) {
			addCriterion("updater_name not between", value1, value2, "updaterName");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNull() {
			addCriterion("update_time is null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIsNotNull() {
			addCriterion("update_time is not null");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeEqualTo(Date value) {
			addCriterion("update_time =", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotEqualTo(Date value) {
			addCriterion("update_time <>", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThan(Date value) {
			addCriterion("update_time >", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("update_time >=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThan(Date value) {
			addCriterion("update_time <", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
			addCriterion("update_time <=", value, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeIn(List<Date> values) {
			addCriterion("update_time in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotIn(List<Date> values) {
			addCriterion("update_time not in", values, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeBetween(Date value1, Date value2) {
			addCriterion("update_time between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
			addCriterion("update_time not between", value1, value2, "updateTime");
			return (Criteria) this;
		}

		public Criteria andIsLockIsNull() {
			addCriterion("is_lock is null");
			return (Criteria) this;
		}

		public Criteria andIsLockIsNotNull() {
			addCriterion("is_lock is not null");
			return (Criteria) this;
		}

		public Criteria andIsLockEqualTo(String value) {
			addCriterion("is_lock =", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockNotEqualTo(String value) {
			addCriterion("is_lock <>", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockGreaterThan(String value) {
			addCriterion("is_lock >", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockGreaterThanOrEqualTo(String value) {
			addCriterion("is_lock >=", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockLessThan(String value) {
			addCriterion("is_lock <", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockLessThanOrEqualTo(String value) {
			addCriterion("is_lock <=", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockLike(String value) {
			addCriterion("is_lock like", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockNotLike(String value) {
			addCriterion("is_lock not like", value, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockIn(List<String> values) {
			addCriterion("is_lock in", values, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockNotIn(List<String> values) {
			addCriterion("is_lock not in", values, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockBetween(String value1, String value2) {
			addCriterion("is_lock between", value1, value2, "isLock");
			return (Criteria) this;
		}

		public Criteria andIsLockNotBetween(String value1, String value2) {
			addCriterion("is_lock not between", value1, value2, "isLock");
			return (Criteria) this;
		}

		public Criteria andStatusIsNull() {
			addCriterion("status is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("status is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("status =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("status <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("status >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("status >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("status <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("status <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("status like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("status not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("status in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("status not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("status between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("status not between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andImportNameIsNull() {
			addCriterion("import_name is null");
			return (Criteria) this;
		}

		public Criteria andImportNameIsNotNull() {
			addCriterion("import_name is not null");
			return (Criteria) this;
		}

		public Criteria andImportNameEqualTo(String value) {
			addCriterion("import_name =", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameNotEqualTo(String value) {
			addCriterion("import_name <>", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameGreaterThan(String value) {
			addCriterion("import_name >", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameGreaterThanOrEqualTo(String value) {
			addCriterion("import_name >=", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameLessThan(String value) {
			addCriterion("import_name <", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameLessThanOrEqualTo(String value) {
			addCriterion("import_name <=", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameLike(String value) {
			addCriterion("import_name like", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameNotLike(String value) {
			addCriterion("import_name not like", value, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameIn(List<String> values) {
			addCriterion("import_name in", values, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameNotIn(List<String> values) {
			addCriterion("import_name not in", values, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameBetween(String value1, String value2) {
			addCriterion("import_name between", value1, value2, "importName");
			return (Criteria) this;
		}

		public Criteria andImportNameNotBetween(String value1, String value2) {
			addCriterion("import_name not between", value1, value2, "importName");
			return (Criteria) this;
		}

		public Criteria andNumsIsNull() {
			addCriterion("nums is null");
			return (Criteria) this;
		}

		public Criteria andNumsIsNotNull() {
			addCriterion("nums is not null");
			return (Criteria) this;
		}

		public Criteria andNumsEqualTo(Integer value) {
			addCriterion("nums =", value, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsNotEqualTo(Integer value) {
			addCriterion("nums <>", value, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsGreaterThan(Integer value) {
			addCriterion("nums >", value, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsGreaterThanOrEqualTo(Integer value) {
			addCriterion("nums >=", value, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsLessThan(Integer value) {
			addCriterion("nums <", value, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsLessThanOrEqualTo(Integer value) {
			addCriterion("nums <=", value, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsIn(List<Integer> values) {
			addCriterion("nums in", values, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsNotIn(List<Integer> values) {
			addCriterion("nums not in", values, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsBetween(Integer value1, Integer value2) {
			addCriterion("nums between", value1, value2, "nums");
			return (Criteria) this;
		}

		public Criteria andNumsNotBetween(Integer value1, Integer value2) {
			addCriterion("nums not between", value1, value2, "nums");
			return (Criteria) this;
		}

		public Criteria andImportProdIdIsNull() {
			addCriterion("import_prod_id is null");
			return (Criteria) this;
		}

		public Criteria andImportProdIdIsNotNull() {
			addCriterion("import_prod_id is not null");
			return (Criteria) this;
		}

		public Criteria andImportProdIdEqualTo(String value) {
			addCriterion("import_prod_id =", value, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdNotEqualTo(String value) {
			addCriterion("import_prod_id <>", value, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdGreaterThan(String value) {
			addCriterion("import_prod_id >", value, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdGreaterThanOrEqualTo(String value) {
			addCriterion("import_prod_id >=", value, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdLessThan(String value) {
			addCriterion("import_prod_id <", value, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdLessThanOrEqualTo(String value) {
			addCriterion("import_prod_id <=", value, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdIn(List<String> values) {
			addCriterion("import_prod_id in", values, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdNotIn(List<String> values) {
			addCriterion("import_prod_id not in", values, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdBetween(String value1, String value2) {
			addCriterion("import_prod_id between", value1, value2, "importProdId");
			return (Criteria) this;
		}

		public Criteria andImportProdIdNotBetween(String value1, String value2) {
			addCriterion("import_prod_id not between", value1, value2, "importProdId");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table import
	 * 
	 * @mbggenerated
	 */
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

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table import
	 *
	 * @mbggenerated do_not_delete_during_merge
	 */
	public static class Criteria extends GeneratedCriteria {

		protected Criteria() {
			super();
		}
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

}