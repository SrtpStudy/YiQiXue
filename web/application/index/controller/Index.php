<?php
namespace app\index\controller;
use think\Controller;
use think\Loader;
use think\Session;
use think\Db;

class Index extends BaseController {
    public function index() {
        return '<style type="text/css">*{ padding: 0; margin: 0; } .think_default_text{ padding: 4px 48px;} a{color:#2E5CD5;cursor: pointer;text-decoration: none} a:hover{text-decoration:underline; } body{ background: #fff; font-family: "Century Gothic","Microsoft yahei"; color: #333;font-size:18px} h1{ font-size: 100px; font-weight: normal; margin-bottom: 12px; } p{ line-height: 1.6em; font-size: 42px }</style><div style="padding: 24px 48px;"> <h1>:)</h1><p> ThinkPHP V5<br/><span style="font-size:30px">十年磨一剑 - 为API开发设计的高性能框架</span></p><span style="font-size:22px;">[ V5.0 版本由 <a href="http://www.qiniu.com" target="qiniu">七牛云</a> 独家赞助发布 ]</span></div><script type="text/javascript" src="http://tajs.qq.com/stats?sId=9347272" charset="UTF-8"></script><script type="text/javascript" src="http://ad.topthink.com/Public/static/client.js"></script><thinkad id="ad_bd568ce7058a1091"></thinkad>';
    }
    public function test() {
    	$this->assign('user', 111);
		return $this->fetch('test');
    	 
    }

    public function randUser() {
    	//生成随机数据
    	for ($i=0; $i<10; $i++) {
    		$data[$i]['name'] = '031402'.$this->getRand(0);
    		$data[$i]['nickname'] = $this->getRand(1);
    		$data[$i]['picture'] = null;
    		$data[$i]['sex'] = '男';
    		$data[$i]['department'] = '计算机';
    		$data[$i]['birthday'] = $this->getRand(2);
    		$data[$i]['telephone'] = $this->getRand(3);
    		$data[$i]['email'] = $this->getRand(4);
    		$data[$i]['resume'] = $this->getRand(5);
    		$data[$i]['active'] = 0;
    		$data[$i]['password'] = $data[$i]['name'];
       	}
       	Db::table('user')->insertAll($data);       	
    }
    public function getRand($type = 0) {
    	// 0 : 101-699
    	switch ($type) {
    		case 0:
    			return mt_rand(101,699);
    		break;
    		    
    		case 1:
    			$arr = array(
				'才','放','去','个','给','齐','民','陈','燊','黄','胡','伟','炜','心','王','婷','许','颖','玲','郑','杨','羊','涛','阳','直','通','蔡','菜','辣','鸡','国','林','展','富','云','家','瑞','奇','豪','昊'
				);
				$rand1 = rand(0,39);
				$rand2 = rand(0,39);
				$rand3 = rand(0,39);
				return $arr[$rand1].$arr[$rand2].$arr[$rand3];
    		break;
    		
    		case 2:
    			return mt_rand(1000000000,1500000000);
    		break;
    		
    		case 3:
    		    $arr = array(
				'1','2','3','4','5','6','7','8','9','0'
				);
				$tel = '';
				$tel .='136';
				for ($i=0; $i <7 ; $i++) { 
					$tel .=$arr[rand(0,9)];
				}
    			return $tel;
    		break;

    		case 4:
    		    $arr = array(
				'1','2','3','4','5','6','7','8','9','0','q','w','e','r','t','y','u','i','o','p','a','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m','Q','W','E','R','T','Y','U','I','O','P','A','S','D','F','G','H','J','K','L','Z','X','C','V','B','N','M'
				);
				$str = '';
				for($i=0; $i<6; $i++) {
					$str.=$arr[rand(0,61)];
				}
				$str.='@';
				$email = array(
					'qq.com','163.com','gmail.com','edu.com'
					);
				$str.=$email[rand(0,3)];
    			return $str;
    		break;

    		case 5:
    			$arr = array(
				'才','放','去','个','给','齐','民','陈','燊','黄','胡','伟','炜','心','王','婷','许','颖','玲','郑','杨','羊','涛','阳','直','通','蔡','菜','辣','鸡','国','林','展','富','云','家','瑞','奇','豪','昊'
				);
				$str = '';
				for ($i=0; $i<10; $i++) {
					$str .=$arr[rand(0,39)];
				}
				return $str;
    		break;
    		

    		default:
    
    			break;
    	}
    }
}




























