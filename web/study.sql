-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: 2017-03-08 09:03:23
-- 服务器版本： 5.6.28
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `study`
--

-- --------------------------------------------------------

--
-- 表的结构 `ac_good`
--

CREATE TABLE `ac_good` (
  `acgid` int(10) UNSIGNED NOT NULL COMMENT '回答评论点赞ID',
  `acid` int(10) UNSIGNED NOT NULL COMMENT '回答评论ID',
  `uid` int(10) UNSIGNED NOT NULL COMMENT '点赞用户ID'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='回答评论点赞表';

-- --------------------------------------------------------

--
-- 表的结构 `answer`
--

CREATE TABLE `answer` (
  `aid` int(10) UNSIGNED NOT NULL,
  `a_contents` varchar(500) NOT NULL,
  `a_good` int(11) NOT NULL,
  `a_time` varchar(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `qid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `a_comments`
--

CREATE TABLE `a_comments` (
  `acid` int(10) UNSIGNED NOT NULL COMMENT '回答评论ID',
  `ac_comments` varchar(500) NOT NULL COMMENT '内容',
  `ac_good` int(11) NOT NULL COMMENT '点赞数',
  `ac_time` varchar(11) NOT NULL COMMENT '时间',
  `uid` int(10) UNSIGNED NOT NULL COMMENT '所属用户ID',
  `qid` int(10) UNSIGNED NOT NULL COMMENT '所属题目ID'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='回答评论表';

-- --------------------------------------------------------

--
-- 表的结构 `a_good`
--

CREATE TABLE `a_good` (
  `agid` int(10) UNSIGNED NOT NULL COMMENT '点赞ID',
  `aid` int(11) NOT NULL,
  `uid` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='回答点赞表';

-- --------------------------------------------------------

--
-- 表的结构 `campaign`
--

CREATE TABLE `campaign` (
  `cid` int(10) UNSIGNED NOT NULL COMMENT '线下活动ID',
  `c_type` varchar(20) NOT NULL COMMENT '类型',
  `c_title` varchar(100) NOT NULL COMMENT '标题',
  `c_time` varchar(11) NOT NULL COMMENT '时间',
  `c_place` varchar(100) NOT NULL COMMENT '地点',
  `c_contents` varchar(500) NOT NULL COMMENT '内容',
  `uid` int(10) UNSIGNED NOT NULL COMMENT '所属用户ID',
  `c_numbers` int(11) NOT NULL COMMENT '评论人数'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='线下活动';

-- --------------------------------------------------------

--
-- 表的结构 `c_comment`
--

CREATE TABLE `c_comment` (
  `ccid` int(10) UNSIGNED NOT NULL COMMENT '线下活动评论ID',
  `cc_contents` varchar(500) NOT NULL COMMENT '内容',
  `cc_time` varchar(11) NOT NULL COMMENT '时间',
  `uid` int(10) UNSIGNED NOT NULL COMMENT '所属用户ID',
  `cid` int(10) UNSIGNED NOT NULL COMMENT '所属活动ID'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- 表的结构 `question`
--

CREATE TABLE `question` (
  `qid` int(10) UNSIGNED NOT NULL COMMENT '问题ID',
  `q_title` varchar(100) NOT NULL COMMENT '题目',
  `q_contents` varchar(500) DEFAULT NULL COMMENT '内容',
  `q_type` varchar(20) CHARACTER SET utf32 NOT NULL COMMENT '分类',
  `q_time` varchar(11) NOT NULL COMMENT '时间',
  `q_numbers` int(11) DEFAULT NULL COMMENT '回答个数',
  `uid` int(11) NOT NULL COMMENT '所属用户ID'
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COMMENT='问题表';

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE `user` (
  `uid` int(5) UNSIGNED NOT NULL COMMENT '用户自增id',
  `name` varchar(20) NOT NULL COMMENT '用户账号',
  `nickname` varchar(20) NOT NULL COMMENT '用户昵称',
  `picture` varchar(200) NOT NULL COMMENT '用户头像',
  `sex` varchar(1) NOT NULL COMMENT '性别',
  `department` varchar(20) NOT NULL COMMENT '系别',
  `birthday` varchar(11) NOT NULL COMMENT '生日',
  `telephone` varchar(13) NOT NULL COMMENT '手机',
  `email` varchar(25) NOT NULL COMMENT '邮箱',
  `resume` varchar(100) NOT NULL COMMENT '简介',
  `active` int(11) NOT NULL COMMENT '活跃度',
  `password` varchar(20) NOT NULL COMMENT '密码'
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`uid`, `name`, `nickname`, `picture`, `sex`, `department`, `birthday`, `telephone`, `email`, `resume`, `active`, `password`) VALUES
(181, '031402111', '齐羊民', '', '男', '计算机', '1041306584', '1364601661', '8e05wo@qq.com', '羊才云燊展颖羊通颖家', 0, '031402111'),
(182, '031402283', '昊家奇', '', '男', '计算机', '1204879761', '1363154404', 'hmVzI9@gmail.com', '林心奇云云豪鸡个国民', 0, '031402283'),
(183, '031402479', '通婷直', '', '男', '计算机', '1355165659', '1366455650', 'BHXoyx@qq.com', '鸡陈婷王豪辣伟富阳黄', 0, '031402479'),
(184, '031402370', '涛蔡才', '', '男', '计算机', '1403612411', '1368354989', 'ufaqsq@qq.com', '通许涛家齐国胡杨鸡豪', 0, '031402370'),
(185, '031402261', '林涛羊', '', '男', '计算机', '1373171483', '1361231965', 'tay5QR@163.com', '国昊涛富通昊许杨给民', 0, '031402261'),
(186, '031402633', '国通家', '', '男', '计算机', '1415136422', '1368553575', 'vx1NOa@qq.com', '林瑞家陈菜云国羊郑国', 0, '031402633'),
(187, '031402545', '豪昊云', '', '男', '计算机', '1385705787', '1362851505', 'Df6iZm@163.com', '家伟直给个羊昊伟黄云', 0, '031402545'),
(188, '031402210', '放林王', '', '男', '计算机', '1477813960', '1368847922', 'ZW6ffz@163.com', '蔡婷放豪胡心涛婷许给', 0, '031402210'),
(189, '031402480', '婷辣心', '', '男', '计算机', '1175829377', '1363826690', 'rO4gWT@163.com', '昊放豪颖辣王郑蔡直展', 0, '031402480'),
(190, '031402367', '黄昊黄', '', '男', '计算机', '1008223279', '1364407779', 'ryUqlh@qq.com', '云才家心才奇炜颖通蔡', 0, '031402367');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ac_good`
--
ALTER TABLE `ac_good`
  ADD PRIMARY KEY (`acgid`);

--
-- Indexes for table `answer`
--
ALTER TABLE `answer`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `a_comments`
--
ALTER TABLE `a_comments`
  ADD PRIMARY KEY (`acid`);

--
-- Indexes for table `a_good`
--
ALTER TABLE `a_good`
  ADD PRIMARY KEY (`agid`);

--
-- Indexes for table `campaign`
--
ALTER TABLE `campaign`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `c_comment`
--
ALTER TABLE `c_comment`
  ADD PRIMARY KEY (`ccid`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`qid`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `answer`
--
ALTER TABLE `answer`
  MODIFY `aid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- 使用表AUTO_INCREMENT `a_comments`
--
ALTER TABLE `a_comments`
  MODIFY `acid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '回答评论ID';
--
-- 使用表AUTO_INCREMENT `a_good`
--
ALTER TABLE `a_good`
  MODIFY `agid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '点赞ID';
--
-- 使用表AUTO_INCREMENT `campaign`
--
ALTER TABLE `campaign`
  MODIFY `cid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '线下活动ID';
--
-- 使用表AUTO_INCREMENT `c_comment`
--
ALTER TABLE `c_comment`
  MODIFY `ccid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '线下活动评论ID';
--
-- 使用表AUTO_INCREMENT `question`
--
ALTER TABLE `question`
  MODIFY `qid` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '问题ID';
--
-- 使用表AUTO_INCREMENT `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(5) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户自增id', AUTO_INCREMENT=191;