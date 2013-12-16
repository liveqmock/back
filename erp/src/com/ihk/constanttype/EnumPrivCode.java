package com.ihk.constanttype;

/**
 * 权限枚举类
 * @author dtc
 * 2012-9-27
 * 
 * 用三层的表示方式,例如:交易管理_楼盘初始_查询(SALEUNIT_INIT_FIND)
 * 如果是两层，也要有两个下划线,售前客户_新建客户(PRECUSTOMER__CREATE)
 * 
 * 售前客户:PRECUSTOMER
 * 		（没有第二层的关系）
 * 交易管理:SALEUNIT
 * 		楼盘初始:INIT
 * 		组团管理:GROUP
 * 		销控中心:CENTER
 * 		认筹管理:CHIP
 * 		付款方式:PAYWAY
 * 报表:REPORT
 * 		售前客户:PRECUSTOMER
 * 		销控报表:SALEUNIT
 * 		财务报表:FINANCIAL
 * 系统管理:SYSTEM
 * 		公告:NOTICE
 * 		用户管理:USER
 * 		超级管理:POWER
 * 		
 * 
 * 增查改删:CRUD:CREATE,RETRIEVE,UPDATE,DELETE
 * 操作定义:统计STAT,导出DOWNLOAD,
 * 
 */
public enum EnumPrivCode{
	
	/**
	 * 售前客户__新建
	 */
	PRECUSTOMER__CREATE,

	/**
	 * 售前客户__查找
	 */
	PRECUSTOMER__RETRIEVE,

	/**
	 * 售前客户__修改
	 */
	PRECUSTOMER__UPDATE,

	/**
	 * 售前客户__删除
	 */
	PRECUSTOMER__DELETE,

	/**
	 * 售前客户__导出
	 */
	PRECUSTOMER__DOWNLOAD,

	/**
	 * 售前客户__项目内管理
	 */
	PRECUSTOMER__PROJECT,

    /**
     * 售前客户_查询客户_查看电话号码
     */
    PRECUSTOMER_RETRIEVE_TEL,
    /**
     * 售前客户_查询客户_下载电话号码
     */
    PRECUSTOMER_DOWNLOAD_TEL,
    /**
     * 售前客户_查询客户_作废恢复
     */
    PRECUSTOMER_RESUME,

    /**
	 * 交易管理_楼盘初始_新建
	 */
	SALEUNIT_INIT_CREATE,

	/**
	 * 交易管理_楼盘初始_查找
	 */
	SALEUNIT_INIT_RETRIEVE,

	/**
	 * 交易管理_楼盘初始_修改
	 */
	SALEUNIT_INIT_UPDATE,

    /**
     *  交易管理_楼盘初始_合同管理
     */
    SALEUNIT_INIT_CONTRACTMANAGER,

	/**
	 * 交易管理_楼盘初始_删除
	 */
	SALEUNIT_INIT_DELETE,
	

	/**
	 * 交易管理_组团管理_新建
	 */
	SALEUNIT_GROUP_CREATE,

	/**
	 * 交易管理_组团管理_查找
	 */
	SALEUNIT_GROUP_RETRIEVE,

	/**
	 * 交易管理_组团管理_修改
	 */
	SALEUNIT_GROUP_UPDATE,

	/**
	 * 交易管理_组团管理_删除
	 */
	SALEUNIT_GROUP_DELETE,
	

	/**
	 * 交易管理_销控中心_新建
	 */
	SALEUNIT_CENTER_CREATE,

	/**
	 * 交易管理_销控中心_查找
	 */
	SALEUNIT_CENTER_RETRIEVE,

	/**
	 * 交易管理_销控中心_修改
	 */
	SALEUNIT_CENTER_UPDATE,

	/**
	 * 交易管理_销控中心_删除
	 */
	SALEUNIT_CENTER_DELETE,


	/**
	 * 交易管理_认筹管理_新建
	 */
	SALEUNIT_CHIP_CREATE,

	/**
	 * 交易管理_认筹管理_查找
	 */
	SALEUNIT_CHIP_RETRIEVE,

	/**
	 * 交易管理_认筹管理_修改
	 */
	SALEUNIT_CHIP_UPDATE,

	/**
	 * 交易管理_认筹管理_删除
	 */
	SALEUNIT_CHIP_DELETE,


	/**
	 * 交易管理_付款方式_新建
	 */
	SALEUNIT_PAYWAY_CREATE,

	/**
	 * 交易管理_付款方式_查找
	 */
	SALEUNIT_PAYWAY_RETRIEVE,

	/**
	 * 交易管理_付款方式_修改
	 */
	SALEUNIT_PAYWAY_UPDATE,

	/**
	 * 交易管理_付款方式_删除
	 */
	SALEUNIT_PAYWAY_DELETE,
	
	
	/**
	 * 报表_售前客户_统计
	 */
	REPORT_PRECUSTOMER_STAT,
	
	/**
	 * 售前客户用 （原报表_售前客户_导出）
	 */
	REPORT_PRECUSTOMER_DOWNLOAD,

	/**
	 * 报表_销控中心_统计
	 */
	REPORT_SALEUNIT_STAT,
	
	/**
	 * 报表_销控中心_导出
	 */
	REPORT_SALEUNIT_DOWNLOAD,


	/**
	 * 报表_财务_统计
	 */
	REPORT_FINANCIAL_STAT,
	
	/**
	 * 报表_财务_导出
	 */
	REPORT_FINANCIAL_DOWNLOAD,

	
	/**
	 * 系统管理_公告_新建
	 */
	SYSTEM_NOTICE_CREATE,

	/**
	 * 系统管理_公告_查找
	 */
	SYSTEM_NOTICE_RETRIEVE,

	/**
	 * 系统管理_公告_修改
	 */
	SYSTEM_NOTICE_UPDATE,

	/**
	 * 系统管理_公告_删除
	 */
	SYSTEM_NOTICE_DELETE,

	/**
	 * 系统管理_用户管理_新建
	 */
	SYSTEM_USER_CREATE,

	/**
	 * 系统管理_用户管理_查找
	 */
	SYSTEM_USER_RETRIEVE,

	/**
	 * 系统管理_用户管理_修改
	 */
	SYSTEM_USER_UPDATE,

	/**
	 * 系统管理_用户管理_删除
	 */
	SYSTEM_USER_DELETE,


	/**
	 * 系统管理_超级管理_新建
	 */
	SYSTEM_POWER_CREATE,

	/**
	 * 系统管理_超级管理_查找
	 */
	SYSTEM_POWER_RETRIEVE,

	/**
	 * 系统管理_超级管理_修改
	 */
	SYSTEM_POWER_UPDATE,

	/**
	 * 系统管理_超级管理_删除
	 */
	SYSTEM_POWER_DELETE,


	
	
	//以下是恒大系统的权限
	/**
	 * 锁定销售数据
	 */
	LOCK_SALE	,//锁定销售数据

	/**
	 * 新增预售数据
	 */
	ADD_PRESALE	,//新增预售数据

	/**
	 * 查询预售数据
	 */
	FIND_PRESALE	,//查询预售数据

	/**
	 * 汇总预售数据
	 */
	SUM_PRESALE,	//汇总预售数据

    /**
     * 报表_售前客户_导出
     */
    REPORT_PRECUSTOMER_EXCEL,

    //菜单权限
    MENU_PRECUSTOMER,  //售前客户管理
    MENU_VIPCUSTOMER,  //VIP客户管理
    MENU_TRANCUSTOMER, //成交客户管理
    MENU_TRANS,//交易管理
    MENU_FINANCIAL,//财务管理
    MENU_BACK,  //后台管理
    MENU_REPORT,  //综合报表

    FINANCIAL_CHECKFEE_READ, //财务管理_对数管理_查询
    FINANCIAL_CHECKFEE_CREATE, //财务管理_对数管理_新增
    FINANCIAL_CHECKFEE_UPDATE, //财务管理_对数管理_修改

    FINANCIAL_CHECKCOMMISSION_READ, //财务管理_对佣管理
    FINANCIAL_CHECKCOMMISSION_CREATE, //财务管理_对佣管理_新增
    FINANCIAL_CHECKCOMMISSION_UPDATE, //财务管理_对佣管理_修改
    FINANCIAL_MANAGER,  //财务管理_成交单元管理
    FINANCIAL_RESULTCOMMISSION,   //财务管理_结佣管理
    SALEUNIT_INIT_UNITINFO, //交易管理_楼盘初始_单元信息
    SALEUNIT_INIT_UNITINFOMANAGER, //交易管理_楼盘初始_单元资料管理
    SALEUNIT_INIT_QUESTION, //交易管理_楼盘初始_售后客户问卷
    PRECUSTOMER_QUESTION  //售前客户_客户问卷
}