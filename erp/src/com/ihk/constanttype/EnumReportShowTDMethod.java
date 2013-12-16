package com.ihk.constanttype;

/*
 * ReportShowTD中的Method
 * 这里的每个枚举，至少对应ReportShowUtils.setShowTDByMethod_()的一个方法
 * 直接考虑把这个枚举类作废，代码更容易懂
 */
public enum EnumReportShowTDMethod{
	
	/**
	 * 表:单元;分类:房间类型,楼层;方法:条数求和	
	 */
	UNIT_ROOM_TYPE_FLOOR_NUM_COUNT,//表:单元;分类:房间类型,楼层;方法:条数求和
	
	/**
	 * 表:单元;分类:房间类型,楼层;方法:建筑面积,累计和
	 */
	UNIT_ROOM_TYPE_FLOOR_NUM_BUILD_AREA_SUM,//表:单元;分类:房间类型,楼层;方法:建筑面积,累计和

	/**
	 * 表:单元;分类:房间类型,楼层;方法:标准总价,累计和
	 */
	UNIT_ROOM_TYPE_FLOOR_NUM_SUM_PRICE_SUM,//表:单元;分类:房间类型,楼层;方法:标准总价,累计和

	/**
	 * 表:单元;分类:规格，户型，付款方式;方法:条数求和
	 */
	UNIT_ROOM_NUM_HALL_NUM_TOILET_NUM_HOUSE_TYPE_PAY_WAY_COUNT,//表:单元;分类:规格，户型，付款方式;方法:条数求和

	/**
	 * 表:单元;分类:单价区间，总价区间;方法:条数求和	(单价总价区分开)
	 */
	UNIT_BUILD_PRICE_SUM_PRICE,//表:单元;分类:单价区间，总价区间;方法:条数求和	(单价总价区分开)

	/**
	 * 表:单元;分类:总分类;方法:条数求和
	 */
	UNIT_COUNT,//表:单元;分类:总分类;方法:条数求和	
}