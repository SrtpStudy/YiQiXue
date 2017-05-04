<?php
namespace app\index\controller;
use think\Controller;
use think\Loader;
use think\Session;
use think\Db;

class Index extends BaseController {
    public function index() {
        $answers = Db::table('answer')->alias('a')
                                      ->join('question q','a.qid = q.qid')
                                      ->order('a_time desc')
                                      ->field('q_contents,q_title,q_type,a_good,a_comments')
                                      ->limit(10)->select();

        return json_encode($answers);
    }
}