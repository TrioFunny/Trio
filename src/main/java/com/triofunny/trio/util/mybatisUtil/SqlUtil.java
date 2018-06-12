package com.triofunny.trio.util.mybatisUtil;

import java.util.ArrayList;
import java.util.List;

public class SqlUtil {

	/**
	 * 拼接sql语句 where后 的条件
	 * 
	 * @param spliceType
	 *            操作类型（拼接类型）《枚举》
	 * @param field
	 *            属性名称（字段）
	 * @param value
	 *            值
	 * @return
	 */
	public static String spliceSpl(SpliceType spliceType, String field, Object value) {
		String sql = "生成失败";
		if (value instanceof Integer[]) {
			Integer[] val = (Integer[]) value;
			switch (spliceType) {
			case Between:
				sql = " " + field + " BETWEEN " + "'" + val[0] + "'" + " AND '" + val[1] + "' ";
				break;
			case NotBetween:
				sql = " " + field + " NOT BETWEEN " + "'" + val[0] + "'" + " AND '" + val[1] + "' ";
				break;
			default:
				break;
			}
		}

		switch (spliceType) {
		case EqualTo:
			sql = " " + field + " = '" + value + "' ";
			break;
		case NotEqualTo:
			sql = " " + field + " <> '" + value + "' ";
			break;
		case IsNull:
			sql = " " + field + " IS NULL ";
			break;
		case IsNotNull:
			sql = " " + field + " IS NOT NULL ";
			break;
		case Like:
			sql = " " + field + " LIKE '" + value + "' ";
			break;
		case NotLike:
			sql = " " + field + " NOT LIKE '" + value + "' ";
			break;
		case GreaterThan:
			sql = " " + field + " > '" + value + "' ";
			break;
		case GreaterThanOrEqualTo:
			sql = " " + field + " >= '" + value + "' ";
			break;
		case LessThan:
			sql = " " + field + " < '" + value + "' ";
			break;
		case LessThanOrEqualTo:
			sql = " " + field + " <= '" + value + "' ";
			break;
		}
		if (value instanceof List) {
			List val=new ArrayList<>();
			val.addAll((List) value);
			
			String src=null;
			src="(";
			for (Object object : val) {
				src+=object+",";
			}
			src=src.substring(0, src.length()-1);
			src+=") ";
			switch (spliceType) {
			case In:
				sql = " " + field + " In " + src + " ";
				break;
			case NotIn:
				sql = " " + field + " Not In " + src + " ";
				break;
			}
		}
		return sql;
	}

	public static enum SpliceType {
		/** 等于 **/
		EqualTo,
		/** 不等于 **/
		NotEqualTo,
		/** 在什么之间 **/
		Between,
		/** 不在什么之间 **/
		NotBetween,
		/** 为空 **/
		IsNull,
		/** 不为空 **/
		IsNotNull,
		/** 大于 **/
		GreaterThan,
		/** 大于等于 **/
		GreaterThanOrEqualTo,
		/** 小于 **/
		LessThan,
		/** 小于等于 **/
		LessThanOrEqualTo,
		/** 在里面 **/
		In,
		/** 不在里面 **/
		NotIn,
		/** 相似 **/
		Like,
		/** 不相似 **/
		NotLike;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private int value;
		private String name;

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		SpliceType() {

		}

		SpliceType(int value, String name) {
			this.value = value;
			this.name = name;
		}

	}

	public static void main(String[] args) {
		
	}
}
