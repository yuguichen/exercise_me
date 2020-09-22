package javaSE.反射.test.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 员工信息实体
 *
 * @author v_kmhuang
 *
 */

public class StaffInfo implements Serializable {
	/** serialVersionUID Auto-generated field comment */
    private static final long serialVersionUID = 1L;
     
    //默认值
    public static final Integer HC_DEPT_ID = 0; // hc部门id默认值为0
    public static final Integer OA_GROUP_ID = 0; // 所属中心/组 id
    public static final String OA_GROUP_NAME = "默认中心组" ; // 所属中心/组

	private Long id;// 主键ID
	private Long applicantId;// 简历ID
	private String cnName;// 姓名
	private String oaName;// OA帐号
	private Integer gender;// 性别
	private String birthDate;// 出生年月
	private String certificateNumber;// 证件号码
	private String mobilePhoneNumber;// 手机号
	private Integer education;// 学历
	private Integer workBuildingId; //办公大厦Id
	private String workBuildingName; // 办公大厦名称
	private Integer workLocationId;// 地域Id
	private String workLocationName;// 地域
	private Long vendorId;// 供应商id
	private String positionName;// 岗位名称
	private String positionType;// 岗位类型
	private String level;// 级别
	private String productName;// 产品名称
	private String primaryProject;// 一级子项目
	private String secondaryProject;// 二级子项目
	private Integer hcDeptId;// hc部门id
	private Integer oaDeptId;// oa部门id
	private String oaDeptName;// oa部门
	private Integer oaGroupId;// 所属中心/组id
	// @NotBlank(message = "{oaGroupName.not.empty}", groups = { Second.class })
	private String oaGroupName;// 所属中心/组
	// @NotNull(message = "{purchaseType.not.null}", groups = {Second.class})
	private Integer purchaseType;// 采购类别
	private Integer formalOrBack;// 正式(1)/备份(2)
	private Date onboardDate;// 入场时间
	private Date settleStartDate;// 结算开始日期
	private Date settleEndDate;// 结算截止日期
	private String specialPrice;// 特殊报价
	private Integer dimissionType;// 离职类型
	private Integer dimissionReason;// 离职原因
	private Date dimissionRaiseDate;// 离职提出日期
	private Date predictDimissionDate;// 预计离职日期
	private Date canDimissionDate;// 可以离职日期
	private Date dimissionDate;// 离职日期
	private String remark;// 备注-离职详细原因
	private Long statusId;// 状态id
	private String statusName;// 状态名称
	private Integer locationProperty;// 类型
	private String workContent;// 具体工作内容
	private String workPosition; // 工位
	private String supervisorIds;// 导师id
	private String supervisorNames;// 导师姓名
	private String outsourceMgmt;// 外包管理员
	private BigDecimal price;// 单
	private Boolean canOperate;// 可操作
	// 查询条件
	private Date onboardDateStart;// 入场时间
	private Date onboardDateEnd;// 入场时间
	private Date dimissionRaiseDateStart;// 离职提出日期
	private Date dimissionRaiseDateEnd;// 离职提出日期
	private Date predictDimissionDateStart;// 预计离职日期
	private Date predictDimissionDateEnd;// 预计离职日期
	private Date dimissionDateStart;// 离职日期
	private Date dimissionDateEnd;// 离职日期
	private String queryType;// 查询类型
	private String replaceNames;// 被替换人员
	private String webchat;// 微信号，2018-01-05需求推送给HR
	private String accountAlias; // 账号别名
	// 20181121-添加新字段(HCOwner、中心组)
	private String hcOwner;
	
	
	public String getAccountAlias() {
        return accountAlias;
    }

    public void setAccountAlias(String accountAlias) {
        this.accountAlias = accountAlias;
    }

    public String getWebchat() {
		return webchat;
	}

	public void setWebchat(String webchat) {
		this.webchat = webchat;
	}

	public String getWorkPosition() {
		return workPosition;
	}

	public void setWorkPosition(String workPosition) {
		this.workPosition = workPosition;
	}

	public Integer getWorkBuildingId() {
		return workBuildingId;
	}

	public void setWorkBuildingId(Integer workBuildingId) {
		this.workBuildingId = workBuildingId;
	}

	public String getWorkBuildingName() {
		return workBuildingName;
	}

	public void setWorkBuildingName(String workBuildingName) {
		this.workBuildingName = workBuildingName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getOaName() {
		return oaName;
	}

	public void setOaName(String oaName) {
		this.oaName = oaName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public Integer getEducation() {
		return education;
	}

	public void setEducation(Integer education) {
		this.education = education;
	}

	public Integer getWorkLocationId() {
		return workLocationId;
	}

	public void setWorkLocationId(Integer workLocationId) {
		this.workLocationId = workLocationId;
	}

	public String getWorkLocationName() {
		return workLocationName;
	}

	public void setWorkLocationName(String workLocationName) {
		this.workLocationName = workLocationName;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getHcDeptId() {
		return hcDeptId;
	}

	public void setHcDeptId(Integer hcDeptId) {
		this.hcDeptId = hcDeptId;
	}

	public Integer getOaDeptId() {
		return oaDeptId;
	}

	public void setOaDeptId(Integer oaDeptId) {
		this.oaDeptId = oaDeptId;
	}

	public String getOaDeptName() {
		return oaDeptName;
	}

	public void setOaDeptName(String oaDeptName) {
		this.oaDeptName = oaDeptName;
	}

	public Integer getOaGroupId() {
		return oaGroupId;
	}

	public void setOaGroupId(Integer oaGroupId) {
		this.oaGroupId = oaGroupId;
	}

	public String getOaGroupName() {
		return oaGroupName;
	}

	public void setOaGroupName(String oaGroupName) {
		this.oaGroupName = oaGroupName;
	}

	public String getSupervisorIds() {
		return supervisorIds;
	}

	public void setSupervisorIds(String supervisorIds) {
		this.supervisorIds = supervisorIds;
	}

	public String getSupervisorNames() {
		return supervisorNames;
	}

	public void setSupervisorNames(String supervisorNames) {
		this.supervisorNames = supervisorNames;
	}

	public Integer getPurchaseType() {
		return purchaseType;
	}

	public void setPurchaseType(Integer purchaseType) {
		this.purchaseType = purchaseType;
	}

	public Integer getFormalOrBack() {
		return formalOrBack;
	}

	public void setFormalOrBack(Integer formalOrBack) {
		this.formalOrBack = formalOrBack;
	}

	public Date getOnboardDate() {
		return onboardDate;
	}

	public void setOnboardDate(Date onboardDate) {
		this.onboardDate = onboardDate;
	}

	public Date getSettleStartDate() {
		return settleStartDate;
	}

	public void setSettleStartDate(Date settleStartDate) {
		this.settleStartDate = settleStartDate;
	}

	public String getSpecialPrice() {
		return specialPrice;
	}

	public void setSpecialPrice(String specialPrice) {
		this.specialPrice = specialPrice;
	}

	public Integer getDimissionType() {
		return dimissionType;
	}

	public void setDimissionType(Integer dimissionType) {
		this.dimissionType = dimissionType;
	}

	public Date getDimissionRaiseDate() {
		return dimissionRaiseDate;
	}

	public void setDimissionRaiseDate(Date dimissionRaiseDate) {
		this.dimissionRaiseDate = dimissionRaiseDate;
	}

	public Date getPredictDimissionDate() {
		return predictDimissionDate;
	}

	public void setPredictDimissionDate(Date predictDimissionDate) {
		this.predictDimissionDate = predictDimissionDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Date getSettleEndDate() {
		return settleEndDate;
	}

	public void setSettleEndDate(Date settleEndDate) {
		this.settleEndDate = settleEndDate;
	}

	public Date getDimissionDate() {
		return dimissionDate;
	}

	public void setDimissionDate(Date dimissionDate) {
		this.dimissionDate = dimissionDate;
	}

	public Date getOnboardDateStart() {
		return onboardDateStart;
	}

	public void setOnboardDateStart(Date onboardDateStart) {
		this.onboardDateStart = onboardDateStart;
	}

	public Date getOnboardDateEnd() {
		return onboardDateEnd;
	}

	public void setOnboardDateEnd(Date onboardDateEnd) {
		this.onboardDateEnd = onboardDateEnd;
	}

	public Date getDimissionRaiseDateStart() {
		return dimissionRaiseDateStart;
	}

	public void setDimissionRaiseDateStart(Date dimissionRaiseDateStart) {
		this.dimissionRaiseDateStart = dimissionRaiseDateStart;
	}

	public Date getDimissionRaiseDateEnd() {
		return dimissionRaiseDateEnd;
	}

	public void setDimissionRaiseDateEnd(Date dimissionRaiseDateEnd) {
		this.dimissionRaiseDateEnd = dimissionRaiseDateEnd;
	}

	public Date getPredictDimissionDateStart() {
		return predictDimissionDateStart;
	}

	public void setPredictDimissionDateStart(Date predictDimissionDateStart) {
		this.predictDimissionDateStart = predictDimissionDateStart;
	}

	public Date getPredictDimissionDateEnd() {
		return predictDimissionDateEnd;
	}

	public void setPredictDimissionDateEnd(Date predictDimissionDateEnd) {
		this.predictDimissionDateEnd = predictDimissionDateEnd;
	}

	public Date getCanDimissionDate() {
		return canDimissionDate;
	}

	public void setCanDimissionDate(Date canDimissionDate) {
		this.canDimissionDate = canDimissionDate;
	}

	public Date getDimissionDateStart() {
		return dimissionDateStart;
	}

	public void setDimissionDateStart(Date dimissionDateStart) {
		this.dimissionDateStart = dimissionDateStart;
	}

	public Date getDimissionDateEnd() {
		return dimissionDateEnd;
	}

	public void setDimissionDateEnd(Date dimissionDateEnd) {
		this.dimissionDateEnd = dimissionDateEnd;
	}

	public Integer getDimissionReason() {
		return dimissionReason;
	}

	public void setDimissionReason(Integer dimissionReason) {
		this.dimissionReason = dimissionReason;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getPrimaryProject() {
		return primaryProject;
	}

	public void setPrimaryProject(String primaryProject) {
		this.primaryProject = primaryProject;
	}

	public String getSecondaryProject() {
		return secondaryProject;
	}

	public void setSecondaryProject(String secondaryProject) {
		this.secondaryProject = secondaryProject;
	}

	public String getOutsourceMgmt() {
		return outsourceMgmt;
	}

	public void setOutsourceMgmt(String outsourceMgmt) {
		this.outsourceMgmt = outsourceMgmt;
	}

	public Integer getLocationProperty() {
		return locationProperty;
	}

	public void setLocationProperty(Integer locationProperty) {
		this.locationProperty = locationProperty;
	}

	public Boolean getCanOperate() {
		return canOperate;
	}

	public void setCanOperate(Boolean canOperate) {
		this.canOperate = canOperate;
	}

	public String getWorkContent() {
		return workContent;
	}

	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getReplaceNames() {
		return replaceNames;
	}

	public void setReplaceNames(String replaceNames) {
		this.replaceNames = replaceNames;
	}

	public String getHcOwner() {
		return hcOwner;
	}

	public void setHcOwner(String hcOwner) {
		this.hcOwner = hcOwner;
	}

}
