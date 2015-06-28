package com.salk.legacy.product.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.salk.legacy.domain.Import;
import com.salk.legacy.domain.ImportExample;

public interface ImportMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int countByExample(ImportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int deleteByExample(ImportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int insert(Import record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int insertSelective(Import record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	List<Import> selectByExample(ImportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	Import selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") Import record,
			@Param("example") ImportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") Import record,
			@Param("example") ImportExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKeySelective(Import record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds
	 * to the database table import
	 * 
	 * @mbggenerated
	 */
	int updateByPrimaryKey(Import record);

	int deleteByPrimaryKeys(@Param("ids") String[] ids);

	List<Import> select4Facet(@Param("importType") String importType);

}