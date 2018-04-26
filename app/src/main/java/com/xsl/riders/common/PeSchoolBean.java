package com.xsl.riders.common;

import java.util.List;

/**
 * Email:1479714932@qq.com
 *
 * @author:xsl Date:2018/2/22,Time:13:12
 * Description:
 */

public class PeSchoolBean {



    private DataBean data;
    private int errorCode;
    private Object message;
    private PagingBean paging;
    private boolean success;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public PagingBean getPaging() {
        return paging;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean {

        private String baomingButtonText;
        private int baomingCount;
        private List<ItemListBean> itemList;

        public String getBaomingButtonText() {
            return baomingButtonText;
        }

        public void setBaomingButtonText(String baomingButtonText) {
            this.baomingButtonText = baomingButtonText;
        }

        public int getBaomingCount() {
            return baomingCount;
        }

        public void setBaomingCount(int baomingCount) {
            this.baomingCount = baomingCount;
        }

        public List<ItemListBean> getItemList() {
            return itemList;
        }

        public void setItemList(List<ItemListBean> itemList) {
            this.itemList = itemList;
        }

        public static class ItemListBean {


            private String address;
            private int baomingCount;
            private int certificationStatus;
            private String cityCode;
            private String cityName;
            private int coachCount;
            private String code;
            private int cooperationType;
            private int courseCount;
            private int dianpingCount;
            private int imageCount;
            private String introduction;
            private String logo;
            private int logoHeight;
            private int logoWidth;
            private String name;
            private String pinyin;
            private int price;
            private double rankScore;
            private int realStudentCount;
            private double score;
            private int studentCount;
            private String originCityCode;
            private String originCityName;
            private String countyName;
            private int jiaxiaoId;
            private ScoreDetailBean scoreDetail;
            private int distance;
            private int jiaxiaoDistance;
            private boolean showDiscipline;
            private int storePrice;
            private String examFieldName;
            private String examFieldIconURL;
            private boolean ownExamField;
            private String online;
            private boolean showOnline;
            private int cityRank;
            private int rankDiff;
            private int weeklyStudentCount;
            private int totalStudentCount;
            private boolean showMarketingActivityIcon;
            private String marketingActivityIcon;
            private int marketingActivityCount;
            private int marketingActivityBaomingCount;
            private String marketingActivityPrivilege;
            private LatestDianpingBean latestDianping;
            private IndexBean index;
            private List<LabelsBean> labels;
            private List<Level1LabelsBean> level1Labels;
            private List<CoursesBean> courses;
            private List<String> phoneList;
            private List<?> serviceFeatures;
            private List<MarketingActivityListBean> marketingActivityList;

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getBaomingCount() {
                return baomingCount;
            }

            public void setBaomingCount(int baomingCount) {
                this.baomingCount = baomingCount;
            }

            public int getCertificationStatus() {
                return certificationStatus;
            }

            public void setCertificationStatus(int certificationStatus) {
                this.certificationStatus = certificationStatus;
            }

            public String getCityCode() {
                return cityCode;
            }

            public void setCityCode(String cityCode) {
                this.cityCode = cityCode;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public int getCoachCount() {
                return coachCount;
            }

            public void setCoachCount(int coachCount) {
                this.coachCount = coachCount;
            }

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public int getCooperationType() {
                return cooperationType;
            }

            public void setCooperationType(int cooperationType) {
                this.cooperationType = cooperationType;
            }

            public int getCourseCount() {
                return courseCount;
            }

            public void setCourseCount(int courseCount) {
                this.courseCount = courseCount;
            }

            public int getDianpingCount() {
                return dianpingCount;
            }

            public void setDianpingCount(int dianpingCount) {
                this.dianpingCount = dianpingCount;
            }

            public int getImageCount() {
                return imageCount;
            }

            public void setImageCount(int imageCount) {
                this.imageCount = imageCount;
            }

            public String getIntroduction() {
                return introduction;
            }

            public void setIntroduction(String introduction) {
                this.introduction = introduction;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public int getLogoHeight() {
                return logoHeight;
            }

            public void setLogoHeight(int logoHeight) {
                this.logoHeight = logoHeight;
            }

            public int getLogoWidth() {
                return logoWidth;
            }

            public void setLogoWidth(int logoWidth) {
                this.logoWidth = logoWidth;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPinyin() {
                return pinyin;
            }

            public void setPinyin(String pinyin) {
                this.pinyin = pinyin;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public double getRankScore() {
                return rankScore;
            }

            public void setRankScore(double rankScore) {
                this.rankScore = rankScore;
            }

            public int getRealStudentCount() {
                return realStudentCount;
            }

            public void setRealStudentCount(int realStudentCount) {
                this.realStudentCount = realStudentCount;
            }

            public double getScore() {
                return score;
            }

            public void setScore(double score) {
                this.score = score;
            }

            public int getStudentCount() {
                return studentCount;
            }

            public void setStudentCount(int studentCount) {
                this.studentCount = studentCount;
            }

            public String getOriginCityCode() {
                return originCityCode;
            }

            public void setOriginCityCode(String originCityCode) {
                this.originCityCode = originCityCode;
            }

            public String getOriginCityName() {
                return originCityName;
            }

            public void setOriginCityName(String originCityName) {
                this.originCityName = originCityName;
            }

            public String getCountyName() {
                return countyName;
            }

            public void setCountyName(String countyName) {
                this.countyName = countyName;
            }

            public int getJiaxiaoId() {
                return jiaxiaoId;
            }

            public void setJiaxiaoId(int jiaxiaoId) {
                this.jiaxiaoId = jiaxiaoId;
            }

            public ScoreDetailBean getScoreDetail() {
                return scoreDetail;
            }

            public void setScoreDetail(ScoreDetailBean scoreDetail) {
                this.scoreDetail = scoreDetail;
            }

            public int getDistance() {
                return distance;
            }

            public void setDistance(int distance) {
                this.distance = distance;
            }

            public int getJiaxiaoDistance() {
                return jiaxiaoDistance;
            }

            public void setJiaxiaoDistance(int jiaxiaoDistance) {
                this.jiaxiaoDistance = jiaxiaoDistance;
            }

            public boolean isShowDiscipline() {
                return showDiscipline;
            }

            public void setShowDiscipline(boolean showDiscipline) {
                this.showDiscipline = showDiscipline;
            }

            public int getStorePrice() {
                return storePrice;
            }

            public void setStorePrice(int storePrice) {
                this.storePrice = storePrice;
            }

            public String getExamFieldName() {
                return examFieldName;
            }

            public void setExamFieldName(String examFieldName) {
                this.examFieldName = examFieldName;
            }

            public String getExamFieldIconURL() {
                return examFieldIconURL;
            }

            public void setExamFieldIconURL(String examFieldIconURL) {
                this.examFieldIconURL = examFieldIconURL;
            }

            public boolean isOwnExamField() {
                return ownExamField;
            }

            public void setOwnExamField(boolean ownExamField) {
                this.ownExamField = ownExamField;
            }

            public String getOnline() {
                return online;
            }

            public void setOnline(String online) {
                this.online = online;
            }

            public boolean isShowOnline() {
                return showOnline;
            }

            public void setShowOnline(boolean showOnline) {
                this.showOnline = showOnline;
            }

            public int getCityRank() {
                return cityRank;
            }

            public void setCityRank(int cityRank) {
                this.cityRank = cityRank;
            }

            public int getRankDiff() {
                return rankDiff;
            }

            public void setRankDiff(int rankDiff) {
                this.rankDiff = rankDiff;
            }

            public int getWeeklyStudentCount() {
                return weeklyStudentCount;
            }

            public void setWeeklyStudentCount(int weeklyStudentCount) {
                this.weeklyStudentCount = weeklyStudentCount;
            }

            public int getTotalStudentCount() {
                return totalStudentCount;
            }

            public void setTotalStudentCount(int totalStudentCount) {
                this.totalStudentCount = totalStudentCount;
            }

            public boolean isShowMarketingActivityIcon() {
                return showMarketingActivityIcon;
            }

            public void setShowMarketingActivityIcon(boolean showMarketingActivityIcon) {
                this.showMarketingActivityIcon = showMarketingActivityIcon;
            }

            public String getMarketingActivityIcon() {
                return marketingActivityIcon;
            }

            public void setMarketingActivityIcon(String marketingActivityIcon) {
                this.marketingActivityIcon = marketingActivityIcon;
            }

            public int getMarketingActivityCount() {
                return marketingActivityCount;
            }

            public void setMarketingActivityCount(int marketingActivityCount) {
                this.marketingActivityCount = marketingActivityCount;
            }

            public int getMarketingActivityBaomingCount() {
                return marketingActivityBaomingCount;
            }

            public void setMarketingActivityBaomingCount(int marketingActivityBaomingCount) {
                this.marketingActivityBaomingCount = marketingActivityBaomingCount;
            }

            public String getMarketingActivityPrivilege() {
                return marketingActivityPrivilege;
            }

            public void setMarketingActivityPrivilege(String marketingActivityPrivilege) {
                this.marketingActivityPrivilege = marketingActivityPrivilege;
            }

            public LatestDianpingBean getLatestDianping() {
                return latestDianping;
            }

            public void setLatestDianping(LatestDianpingBean latestDianping) {
                this.latestDianping = latestDianping;
            }

            public IndexBean getIndex() {
                return index;
            }

            public void setIndex(IndexBean index) {
                this.index = index;
            }

            public List<LabelsBean> getLabels() {
                return labels;
            }

            public void setLabels(List<LabelsBean> labels) {
                this.labels = labels;
            }

            public List<Level1LabelsBean> getLevel1Labels() {
                return level1Labels;
            }

            public void setLevel1Labels(List<Level1LabelsBean> level1Labels) {
                this.level1Labels = level1Labels;
            }

            public List<CoursesBean> getCourses() {
                return courses;
            }

            public void setCourses(List<CoursesBean> courses) {
                this.courses = courses;
            }

            public List<String> getPhoneList() {
                return phoneList;
            }

            public void setPhoneList(List<String> phoneList) {
                this.phoneList = phoneList;
            }

            public List<?> getServiceFeatures() {
                return serviceFeatures;
            }

            public void setServiceFeatures(List<?> serviceFeatures) {
                this.serviceFeatures = serviceFeatures;
            }

            public List<MarketingActivityListBean> getMarketingActivityList() {
                return marketingActivityList;
            }

            public void setMarketingActivityList(List<MarketingActivityListBean> marketingActivityList) {
                this.marketingActivityList = marketingActivityList;
            }

            public static class ScoreDetailBean {
                /**
                 * avgScore : 4.1
                 * display : true
                 * score1 : 4.1
                 * score2 : 4.1
                 * score3 : 4.1
                 * scoreCount : 129
                 */

                private double avgScore;
                private boolean display;
                private double score1;
                private double score2;
                private double score3;
                private int scoreCount;

                public double getAvgScore() {
                    return avgScore;
                }

                public void setAvgScore(double avgScore) {
                    this.avgScore = avgScore;
                }

                public boolean isDisplay() {
                    return display;
                }

                public void setDisplay(boolean display) {
                    this.display = display;
                }

                public double getScore1() {
                    return score1;
                }

                public void setScore1(double score1) {
                    this.score1 = score1;
                }

                public double getScore2() {
                    return score2;
                }

                public void setScore2(double score2) {
                    this.score2 = score2;
                }

                public double getScore3() {
                    return score3;
                }

                public void setScore3(double score3) {
                    this.score3 = score3;
                }

                public int getScoreCount() {
                    return scoreCount;
                }

                public void setScoreCount(int scoreCount) {
                    this.scoreCount = scoreCount;
                }
            }

            public static class LatestDianpingBean {
                /**
                 * avatar : http://avatar.user.mucang.cn/user-avatar/2018/01/13/19/0dc71c08103241c69130d80e057cbdb7!100x100
                 * content : 张海教练很负责，拿证快哈哈哈哈哈哈哈
                 * id : 28044565
                 * nickname : 倩姐
                 * placeToken : f1c24bac914c468bbdf47b7d9802f8e7
                 * score1 : 5
                 * score2 : 5
                 * score3 : 5
                 * topic : 14697
                 */

                private String avatar;
                private String content;
                private int id;
                private String nickname;
                private String placeToken;
                private int score1;
                private int score2;
                private int score3;
                private String topic;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getPlaceToken() {
                    return placeToken;
                }

                public void setPlaceToken(String placeToken) {
                    this.placeToken = placeToken;
                }

                public int getScore1() {
                    return score1;
                }

                public void setScore1(int score1) {
                    this.score1 = score1;
                }

                public int getScore2() {
                    return score2;
                }

                public void setScore2(int score2) {
                    this.score2 = score2;
                }

                public int getScore3() {
                    return score3;
                }

                public void setScore3(int score3) {
                    this.score3 = score3;
                }

                public String getTopic() {
                    return topic;
                }

                public void setTopic(String topic) {
                    this.topic = topic;
                }
            }

            public static class IndexBean {
                /**
                 * cityIndex : 1000
                 * nationIndex : 278
                 */

                private int cityIndex;
                private int nationIndex;

                public int getCityIndex() {
                    return cityIndex;
                }

                public void setCityIndex(int cityIndex) {
                    this.cityIndex = cityIndex;
                }

                public int getNationIndex() {
                    return nationIndex;
                }

                public void setNationIndex(int nationIndex) {
                    this.nationIndex = nationIndex;
                }
            }

            public static class LabelsBean {
                /**
                 * name : LARGE_STUDENT_COUNT
                 * description : 驾校排行榜前10%的驾校
                 * label : 1
                 * iconUrl : http://jiaxiaozhijia.image.mucang.cn/jiaxiaozhijia/2017/09/18/12/c150d2f0c55e4162afe1b63166247603.png
                 * labelDetail : 规模大
                 */

                private String name;
                private String description;
                private int label;
                private String iconUrl;
                private String labelDetail;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getLabel() {
                    return label;
                }

                public void setLabel(int label) {
                    this.label = label;
                }

                public String getIconUrl() {
                    return iconUrl;
                }

                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                public String getLabelDetail() {
                    return labelDetail;
                }

                public void setLabelDetail(String labelDetail) {
                    this.labelDetail = labelDetail;
                }
            }

            public static class Level1LabelsBean {
                /**
                 * name : PICK_UP
                 * description : 班车或教练接送
                 * label : 3
                 * iconUrl : http://jiaxiaozhijia.image.mucang.cn/jiaxiaozhijia/2018/01/30/14/88edb58461734b3d8c7873c0a25ea9e0.png
                 * labelDetail : 接送
                 */

                private String name;
                private String description;
                private int label;
                private String iconUrl;
                private String labelDetail;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public int getLabel() {
                    return label;
                }

                public void setLabel(int label) {
                    this.label = label;
                }

                public String getIconUrl() {
                    return iconUrl;
                }

                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                public String getLabelDetail() {
                    return labelDetail;
                }

                public void setLabelDetail(String labelDetail) {
                    this.labelDetail = labelDetail;
                }
            }

            public static class CoursesBean {
                /**
                 * carType : 桑塔纳
                 * category : C
                 * chargeMode : -1
                 * description : 周一至周天都可练车，练车时间自由安排，陪同接送考试，一费到底学车期间没有二次收费。
                 * name : 全周班特惠班
                 * otherInfo : null
                 * pickUpType : 0
                 * price : 4880
                 * sourceType : 0
                 * trainingTime : 2
                 * type : C1
                 * jiaxiaoCourseId : 11891
                 * courseGroup : 1
                 * goods : null
                 * storePrice : 5400
                 * desc : C1  四人一车  教练接送
                 * pickUpTypeName : 教练接送
                 * trainingTimeDesc : 周一到周日训练
                 * studentsPerCarDesc : 四人一车
                 * studentsPerCar : 4
                 */

                private String carType;
                private String category;
                private int chargeMode;
                private String description;
                private String name;
                private Object otherInfo;
                private int pickUpType;
                private int price;
                private int sourceType;
                private int trainingTime;
                private String type;
                private int jiaxiaoCourseId;
                private int courseGroup;
                private Object goods;
                private int storePrice;
                private String desc;
                private String pickUpTypeName;
                private String trainingTimeDesc;
                private String studentsPerCarDesc;
                private int studentsPerCar;

                public String getCarType() {
                    return carType;
                }

                public void setCarType(String carType) {
                    this.carType = carType;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public int getChargeMode() {
                    return chargeMode;
                }

                public void setChargeMode(int chargeMode) {
                    this.chargeMode = chargeMode;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public Object getOtherInfo() {
                    return otherInfo;
                }

                public void setOtherInfo(Object otherInfo) {
                    this.otherInfo = otherInfo;
                }

                public int getPickUpType() {
                    return pickUpType;
                }

                public void setPickUpType(int pickUpType) {
                    this.pickUpType = pickUpType;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public int getSourceType() {
                    return sourceType;
                }

                public void setSourceType(int sourceType) {
                    this.sourceType = sourceType;
                }

                public int getTrainingTime() {
                    return trainingTime;
                }

                public void setTrainingTime(int trainingTime) {
                    this.trainingTime = trainingTime;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public int getJiaxiaoCourseId() {
                    return jiaxiaoCourseId;
                }

                public void setJiaxiaoCourseId(int jiaxiaoCourseId) {
                    this.jiaxiaoCourseId = jiaxiaoCourseId;
                }

                public int getCourseGroup() {
                    return courseGroup;
                }

                public void setCourseGroup(int courseGroup) {
                    this.courseGroup = courseGroup;
                }

                public Object getGoods() {
                    return goods;
                }

                public void setGoods(Object goods) {
                    this.goods = goods;
                }

                public int getStorePrice() {
                    return storePrice;
                }

                public void setStorePrice(int storePrice) {
                    this.storePrice = storePrice;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getPickUpTypeName() {
                    return pickUpTypeName;
                }

                public void setPickUpTypeName(String pickUpTypeName) {
                    this.pickUpTypeName = pickUpTypeName;
                }

                public String getTrainingTimeDesc() {
                    return trainingTimeDesc;
                }

                public void setTrainingTimeDesc(String trainingTimeDesc) {
                    this.trainingTimeDesc = trainingTimeDesc;
                }

                public String getStudentsPerCarDesc() {
                    return studentsPerCarDesc;
                }

                public void setStudentsPerCarDesc(String studentsPerCarDesc) {
                    this.studentsPerCarDesc = studentsPerCarDesc;
                }

                public int getStudentsPerCar() {
                    return studentsPerCar;
                }

                public void setStudentsPerCar(int studentsPerCar) {
                    this.studentsPerCar = studentsPerCar;
                }
            }

            public static class MarketingActivityListBean {
                /**
                 * activityId : 36718
                 * activityPrivilege : 报名立减400元
                 * isRemainingTime : true
                 * icon : http://jiaxiaozhijia.image.mucang.cn/jiaxiaozhijia/2017/03/31/09/febaff9aed9540fd94eafcfa7208548a.png
                 * name : 限时特惠
                 * actionImage : http://jiaxiaozhijia.image.mucang.cn/jiaxiaozhijia/2017/08/18/14/5912ce9bb02f49219e3437bb33313bf5.png
                 * activityType : 1
                 * mustLogin : false
                 * baomingCount : 5
                 * remainingTime : 62872231
                 */

                private int activityId;
                private String activityPrivilege;
                private boolean isRemainingTime;
                private String icon;
                private String name;
                private String actionImage;
                private int activityType;
                private boolean mustLogin;
                private int baomingCount;
                private int remainingTime;

                public int getActivityId() {
                    return activityId;
                }

                public void setActivityId(int activityId) {
                    this.activityId = activityId;
                }

                public String getActivityPrivilege() {
                    return activityPrivilege;
                }

                public void setActivityPrivilege(String activityPrivilege) {
                    this.activityPrivilege = activityPrivilege;
                }

                public boolean isIsRemainingTime() {
                    return isRemainingTime;
                }

                public void setIsRemainingTime(boolean isRemainingTime) {
                    this.isRemainingTime = isRemainingTime;
                }

                public String getIcon() {
                    return icon;
                }

                public void setIcon(String icon) {
                    this.icon = icon;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getActionImage() {
                    return actionImage;
                }

                public void setActionImage(String actionImage) {
                    this.actionImage = actionImage;
                }

                public int getActivityType() {
                    return activityType;
                }

                public void setActivityType(int activityType) {
                    this.activityType = activityType;
                }

                public boolean isMustLogin() {
                    return mustLogin;
                }

                public void setMustLogin(boolean mustLogin) {
                    this.mustLogin = mustLogin;
                }

                public int getBaomingCount() {
                    return baomingCount;
                }

                public void setBaomingCount(int baomingCount) {
                    this.baomingCount = baomingCount;
                }

                public int getRemainingTime() {
                    return remainingTime;
                }

                public void setRemainingTime(int remainingTime) {
                    this.remainingTime = remainingTime;
                }
            }
        }
    }

    public static class PagingBean {
        /**
         * page : 1
         * total : 168
         */

        private int page;
        private int total;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
