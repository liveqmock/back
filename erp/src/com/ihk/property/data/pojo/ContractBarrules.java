package com.ihk.property.data.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ContractBarrules implements Serializable{
	private static final long serialVersionUID = 1L;
    
		private int id;
		private int contractManagerId;
		private Date startDate;
		private Date endDate;
		private String memo;
		private String oprF1;
		private String oprF2;
		private String oprF3;
		private String oprF4;
		private String oprF5;
		private String oprF6;
		private String oprF7;
		private String oprF8;

		private String oprB1;
		private String oprB2;
		private String oprB3;
		private String oprB4;
		private String oprB5;
		private String oprB6;
		private String oprB7;
		private String oprB8;

		private int dataF1;
		private int dataF2;
		private int dataF3;
		private int dataF4;
		private int dataF5;
		private int dataF6;
		private int dataF7;
		private int dataF8;

		private int dataB1;
		private int dataB2;
		private int dataB3;
		private int dataB4;
		private int dataB5;
		private int dataB6;
		private int dataB7;
		private int dataB8;

		private BigDecimal commission;
		private String status;
		private String isDeleted;
		private int createdId;
		private Date createdTime;
		private int modId;
		private Date modTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public int getContractManagerId() {
		return contractManagerId;
	}

	public void setContractManagerId(int contractManagerId) {
		this.contractManagerId = contractManagerId;
	}
    
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
    
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
    
	public String getOprF1() {
		return oprF1;
	}

	public void setOprF1(String oprF1) {
		this.oprF1 = oprF1;
	}
    
	public String getOprF2() {
		return oprF2;
	}

	public void setOprF2(String oprF2) {
		this.oprF2 = oprF2;
	}
    
	public String getOprF3() {
		return oprF3;
	}

	public void setOprF3(String oprF3) {
		this.oprF3 = oprF3;
	}
    
	public String getOprF4() {
		return oprF4;
	}

	public void setOprF4(String oprF4) {
		this.oprF4 = oprF4;
	}
    
	public String getOprF5() {
		return oprF5;
	}

	public void setOprF5(String oprF5) {
		this.oprF5 = oprF5;
	}
    
	public String getOprF6() {
		return oprF6;
	}

	public void setOprF6(String oprF6) {
		this.oprF6 = oprF6;
	}
    
	public String getOprB1() {
		return oprB1;
	}

	public void setOprB1(String oprB1) {
		this.oprB1 = oprB1;
	}
    
	public String getOprB2() {
		return oprB2;
	}

	public void setOprB2(String oprB2) {
		this.oprB2 = oprB2;
	}
    
	public String getOprB3() {
		return oprB3;
	}

	public void setOprB3(String oprB3) {
		this.oprB3 = oprB3;
	}
    
	public String getOprB4() {
		return oprB4;
	}

	public void setOprB4(String oprB4) {
		this.oprB4 = oprB4;
	}
    
	public String getOprB5() {
		return oprB5;
	}

	public void setOprB5(String oprB5) {
		this.oprB5 = oprB5;
	}
    
	public String getOprB6() {
		return oprB6;
	}

	public void setOprB6(String oprB6) {
		this.oprB6 = oprB6;
	}
    
	public int getDataF1() {
		return dataF1;
	}

	public void setDataF1(int dataF1) {
		this.dataF1 = dataF1;
	}
    
	public int getDataF2() {
		return dataF2;
	}

	public void setDataF2(int dataF2) {
		this.dataF2 = dataF2;
	}
    
	public int getDataF3() {
		return dataF3;
	}

	public void setDataF3(int dataF3) {
		this.dataF3 = dataF3;
	}
    
	public int getDataF4() {
		return dataF4;
	}

	public void setDataF4(int dataF4) {
		this.dataF4 = dataF4;
	}
    
	public int getDataF5() {
		return dataF5;
	}

	public void setDataF5(int dataF5) {
		this.dataF5 = dataF5;
	}
    
	public int getDataF6() {
		return dataF6;
	}

	public void setDataF6(int dataF6) {
		this.dataF6 = dataF6;
	}
    
	public int getDataB1() {
		return dataB1;
	}

	public void setDataB1(int dataB1) {
		this.dataB1 = dataB1;
	}
    
	public int getDataB2() {
		return dataB2;
	}

	public void setDataB2(int dataB2) {
		this.dataB2 = dataB2;
	}
    
	public int getDataB3() {
		return dataB3;
	}

	public void setDataB3(int dataB3) {
		this.dataB3 = dataB3;
	}
    
	public int getDataB4() {
		return dataB4;
	}

	public void setDataB4(int dataB4) {
		this.dataB4 = dataB4;
	}
    
	public int getDataB5() {
		return dataB5;
	}

	public void setDataB5(int dataB5) {
		this.dataB5 = dataB5;
	}
    
	public int getDataB6() {
		return dataB6;
	}

	public void setDataB6(int dataB6) {
		this.dataB6 = dataB6;
	}
    
	public BigDecimal getCommission() {
		return commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}
    
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
    
	public int getCreatedId() {
		return createdId;
	}

	public void setCreatedId(int createdId) {
		this.createdId = createdId;
	}
    
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
    
	public int getModId() {
		return modId;
	}

	public void setModId(int modId) {
		this.modId = modId;
	}
    
	public Date getModTime() {
		return modTime;
	}

	public void setModTime(Date modTime) {
		this.modTime = modTime;
	}

    public String getOprF7() {
        return oprF7;
    }

    public void setOprF7(String oprF7) {
        this.oprF7 = oprF7;
    }

    public String getOprF8() {
        return oprF8;
    }

    public void setOprF8(String oprF8) {
        this.oprF8 = oprF8;
    }

    public String getOprB7() {
        return oprB7;
    }

    public void setOprB7(String oprB7) {
        this.oprB7 = oprB7;
    }

    public String getOprB8() {
        return oprB8;
    }

    public void setOprB8(String oprB8) {
        this.oprB8 = oprB8;
    }

    public int getDataF7() {
        return dataF7;
    }

    public void setDataF7(int dataF7) {
        this.dataF7 = dataF7;
    }

    public int getDataF8() {
        return dataF8;
    }

    public void setDataF8(int dataF8) {
        this.dataF8 = dataF8;
    }

    public int getDataB7() {
        return dataB7;
    }

    public void setDataB7(int dataB7) {
        this.dataB7 = dataB7;
    }

    public int getDataB8() {
        return dataB8;
    }

    public void setDataB8(int dataB8) {
        this.dataB8 = dataB8;
    }

    public ContractBarrules(){};

	public ContractBarrules(    
		int id,
        		int contractManagerId,
        		Date startDate,
        		Date endDate,
        		String memo,
        		String oprF1,
        		String oprF2,
        		String oprF3,
        		String oprF4,
        		String oprF5,
        		String oprF6,
        		String oprF7,
        		String oprF8,
        		String oprB1,
        		String oprB2,
        		String oprB3,
        		String oprB4,
        		String oprB5,
        		String oprB6,
        		String oprB7,
        		String oprB8,
        		int dataF1,
        		int dataF2,
        		int dataF3,
        		int dataF4,
        		int dataF5,
        		int dataF6,
        		int dataF7,
        		int dataF8,
        		int dataB1,
        		int dataB2,
        		int dataB3,
        		int dataB4,
        		int dataB5,
        		int dataB6,
        		int dataB7,
        		int dataB8,
        		BigDecimal commission,
        		String status,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();  
		this.id = id;
		this.contractManagerId = contractManagerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.memo = memo;
		this.oprF1 = oprF1;
		this.oprF2 = oprF2;
		this.oprF3 = oprF3;
		this.oprF4 = oprF4;
		this.oprF5 = oprF5;
		this.oprF6 = oprF6;
		this.oprF6 = oprF7;
		this.oprF6 = oprF8;
		this.oprB1 = oprB1;
		this.oprB2 = oprB2;
		this.oprB3 = oprB3;
		this.oprB4 = oprB4;
		this.oprB5 = oprB5;
		this.oprB6 = oprB6;
		this.oprB6 = oprB7;
		this.oprB6 = oprB8;
		this.dataF1 = dataF1;
		this.dataF2 = dataF2;
		this.dataF3 = dataF3;
		this.dataF4 = dataF4;
		this.dataF5 = dataF5;
		this.dataF6 = dataF6;
		this.dataF6 = dataF7;
		this.dataF6 = dataF8;
		this.dataB1 = dataB1;
		this.dataB2 = dataB2;
		this.dataB3 = dataB3;
		this.dataB4 = dataB4;
		this.dataB5 = dataB5;
		this.dataB6 = dataB6;
		this.dataB6 = dataB7;
		this.dataB6 = dataB8;
		this.commission = commission;
		this.status = status;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
	public ContractBarrules(    
		int contractManagerId,
        		Date startDate,
        		Date endDate,
        		String memo,
        		String oprF1,
        		String oprF2,
        		String oprF3,
        		String oprF4,
        		String oprF5,
        		String oprF6,
        		String oprF7,
        		String oprF8,
        		String oprB1,
        		String oprB2,
        		String oprB3,
        		String oprB4,
        		String oprB5,
        		String oprB6,
        		String oprB7,
        		String oprB8,
        		int dataF1,
        		int dataF2,
        		int dataF3,
        		int dataF4,
        		int dataF5,
        		int dataF6,
        		int dataF7,
        		int dataF8,
        		int dataB1,
        		int dataB2,
        		int dataB3,
        		int dataB4,
        		int dataB5,
        		int dataB6,
        		int dataB7,
        		int dataB8,
        		BigDecimal commission,
        		String status,
        		String isDeleted,
        		int createdId,
        		Date createdTime,
        		int modId,
        		Date modTime
        ) {
		super();		
		this.contractManagerId = contractManagerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.memo = memo;
		this.oprF1 = oprF1;
		this.oprF2 = oprF2;
		this.oprF3 = oprF3;
		this.oprF4 = oprF4;
		this.oprF5 = oprF5;
		this.oprF6 = oprF6;
		this.oprF6 = oprF7;
		this.oprF6 = oprF8;
		this.oprB1 = oprB1;
		this.oprB2 = oprB2;
		this.oprB3 = oprB3;
		this.oprB4 = oprB4;
		this.oprB5 = oprB5;
		this.oprB6 = oprB6;
		this.oprB6 = oprB7;
		this.oprB6 = oprB8;
		this.dataF1 = dataF1;
		this.dataF2 = dataF2;
		this.dataF3 = dataF3;
		this.dataF4 = dataF4;
		this.dataF5 = dataF5;
		this.dataF6 = dataF6;
		this.dataF6 = dataF7;
		this.dataF6 = dataF8;
		this.dataB1 = dataB1;
		this.dataB2 = dataB2;
		this.dataB3 = dataB3;
		this.dataB4 = dataB4;
		this.dataB5 = dataB5;
		this.dataB6 = dataB6;
		this.dataB6 = dataB7;
		this.dataB6 = dataB8;
		this.commission = commission;
		this.status = status;
		this.isDeleted = isDeleted;
		this.createdId = createdId;
		this.createdTime = createdTime;
		this.modId = modId;
		this.modTime = modTime;
	}
}
