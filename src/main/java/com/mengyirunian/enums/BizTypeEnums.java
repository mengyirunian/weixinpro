package com.mengyirunian.enums;

public enum BizTypeEnums {

    /**
     * default
     */
    DEFAULT(0L, "未知", 0, "未知", "无"),
    /**
     * 结算通宝
     */
    JSTB(1L, "结算通宝(万元)", 0, "中银结算通宝\n" + "释义：针对在我行结算的中小企业无贷户，以其结算流水和存款沉淀作为主要参考指标，最高可推荐200万元营销额度的信用贷款。本产品可采用信用授信，以及抵质押、保证或组合担保的方式制定综合授信方案。\n" + "来源与时间：2018年向全辖推送的第三批名单。", "0"),
    /**
     * 外贸通宝
     */
    WMTB(2L, "外贸通宝(万元)", 0, "暂无", "0"),
    /**
     * 人才贷
     */
    RCD(3L, "人才贷(万元)", 0, "暂无", "0"),
    /**
     * 高新贷
     */
    GXD(4L, "高新贷(万元)", 0, "暂无", "0"),
    /**
     * 知贷通
     */
    ZDT(5L, "知贷通(万元)", 0, "中银知贷通\n"+"释义：我行与江苏省知识产权局合作开发，以企业合法拥有的、依法可以转让的专利权等知识产权作为质押，提供信用授信。江苏省知识产权局根据企业知识产权创造、运用、保护和管理水平，将企业划分为A、B、C三类，分别对应最高500万、350万和200万元信用授信。\n"+"更新时间：2018年7月。", "0"),
    /**
     * 科技贷
     */
    KJD(6L, "科技贷(是否)", 0, "暂无", "否"),
    /**
     * 独角兽
     */
    DJS(7L, "独角兽(万元)", 0, "暂无", "0"),
    /**
     * 苏贸贷
     */
    SMD(8L, "苏贸贷(万元)", 0, "暂无", "0"),
    /**
     * 苏科贷
     */
    SKD(9L, "苏科贷(是否)", 0, "苏科贷入库企业\n"+"释义：我行对进入《江苏省（或地方）科技金融风险补偿资金备选企业库》的企业发放授信。根据企业规模等因素，省级和地方两级科技金融风险补偿资金承担一定比例本金损失。苏科贷分为苏科贷Ⅰ-1，苏科贷Ⅰ-2，苏科贷Ⅰ-3和苏科贷Ⅱ。\n"+"更新时间：2017年7月。", "否"),
    /**
     * 速易贷
     */
    SYD(10L, "速易贷(级别)", 0, "暂无", "无"),
    /**
     * 转化贷
     */
    ZHD(11L, "转化贷(是否)", 0, "中银转化贷\n"+"释义：江苏省财政拨款设立的“江苏省科技成果转化专项资金”重点提供支持的、承担着江苏省重大科技成果项目的转化与产业化实施任务的科技型企业。我行可营销中银转化贷，该产品用于支持企业科技成果转化和产品市场推广的贷款。\n"+"更新时间：2018年。", "否"),
    /**
     * 中信保
     */
    ZXB(12L, "中信保(是否投保)", 0, "暂无", "未投保"),
    /**
     * 科技类型
     */
    KJLX(13L, "科技类型(类型)", 0, "科技类型\n"+"释义：企业属于高新技术企业、高新技术培育企业以及独角兽等企业类型。\n"+"更新时间：2018年。", "无"),
    /**
     * 高新技术
     */
    GXJS(14L, "高新技术(是否)", 0, "暂无", "否"),
    /**
     * 农业龙头
     */
    NYLT(15L, "农业龙头(是否)", 0, "省级农业产业化重点龙头企业\n"+"释义：可营销“中银扶农通宝”产品，即我行与江苏省农业信贷担保有限责任公司合作，并按照2:8共担风险的低息贷款业务。\n"+"更新时间：2017年12月。", "否"),
    /**
     * 蹬羚羊
     */
    DLY(16L, "蹬羚羊(是否)", 0, "暂无", "否"),
    /**
     * 金融机构
     */
    JRSX(17L, "金融授信(万元)", 0, "金融机构授信\n"+"释义：企业贷款情况（余额5000万元以下），以及发放贷款的金融机构个数。\n"+"更新时间：2018年5月。", "0"),
    /**
     * 上市情况
     */
    SSQK(18L, "上市情况(类型)", 0, "上市情况\n"+"释义：注册地在江苏的上交所和深交所上市企业。\n"+"更新时间：2018年7月。", "无"),
    /**
     * 新三板
     */
    XSB(19L, "新三板(是否)", 0, "新三板挂牌\n"+"释义：注册地在江苏的新三板挂牌企业。\n"+"更新时间：2018年7月。", "否"),
    /**
     * 高特精
     */
    GTJ(20L, "高特精(级别)", 1, "暂无", "无"),
    /**
     * 出口金额
     */
    JCK(21L, "进出口金额(万美元)", 1, "出口金额\n"+"释义：企业近两年的出口金额。\n"+"更新时间：2016年、2017年。", "0")
    ;

    BizTypeEnums(Long code, String desc, Integer type, String detail, String defaultValue) {
        this.code = code;
        this.desc = desc;
        this.type = type;
        this.detail = detail;
        this.defaultValue = defaultValue;
    }

    private Long code;
    private String desc;
    private Integer type;
    private String detail;
    private String defaultValue;

    public Long getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDetail() {
        return detail;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}