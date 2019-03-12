CREATE TABLE `task_manage` (
  `taskId` bigint(20) NOT NULL AUTO_INCREMENT,
  `taskTitle` varchar(255) DEFAULT NULL,
  `taskContent` varchar(255) DEFAULT NULL,
  `taskDegree` int(1) DEFAULT NULL,
  `userId` int(4) DEFAULT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `sendUserId` int(4) DEFAULT NULL,
  `sendUserName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`taskId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;




CREATE TABLE `user` (
  `userId` int(4) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  `pwd` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




CREATE TABLE `sy_company` (
  `companyId` bigint(20) unsigned NOT NULL COMMENT '用户ID',
  `username` varchar(20) NOT NULL COMMENT '登陆用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '登陆密码',
  `companyName` varchar(64) DEFAULT NULL COMMENT '企业名称',
  `companyType` tinyint(4) NOT NULL COMMENT '用户类型：1、管理员；2、生产商；3、出口商、4、进口商；5、代理商、6、经销商；',
  `companyContactsName` varchar(64) DEFAULT NULL COMMENT '联系人姓名',
  `companyContactsTel` varchar(16) NOT NULL COMMENT '联系人电话',
  `companyContactsEmail` varchar(64) NOT NULL COMMENT '联系人邮箱',
  `companyContactsMobile` varchar(16) DEFAULT NULL COMMENT '联系人手机',
  `companyWorkAddress` varchar(256) DEFAULT NULL COMMENT '企业办公地址',
  `companyRegisterAddress` varchar(256) DEFAULT NULL COMMENT '企业注册地址',
  `companyLegal` varchar(64) DEFAULT NULL COMMENT '企业法人',
  `companyLegalTel` varchar(16) DEFAULT NULL COMMENT '企业法人手机',
  `companyLicenseImg` varchar(256) DEFAULT NULL COMMENT '营业执照',
  `companyComment` varchar(256) DEFAULT NULL COMMENT '备注说明',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `lastOpTime` datetime DEFAULT NULL COMMENT '最后一次操作时间',
  `companyStatus` tinyint(4) DEFAULT '1' COMMENT '企业状态：1-未激活；2-正常；3-禁用',
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='企业信息';



CREATE TABLE `sy_area` (
  `areaId` bigint(20) unsigned NOT NULL COMMENT '国家ID',
  `areaNameCn` varchar(50) NOT NULL COMMENT '国家中文名称',
  `areaNameEn` varchar(50) NOT NULL COMMENT '国家英文名称',
  `createTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`areaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



