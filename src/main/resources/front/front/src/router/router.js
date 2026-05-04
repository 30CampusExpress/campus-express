import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Forum from '../pages/forum/list'
import ForumAdd from '../pages/forum/add'
import ForumDetail from '../pages/forum/detail'
import MyForumList from '../pages/forum/myForumList'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import xueshengList from '../pages/xuesheng/list'
import xueshengDetail from '../pages/xuesheng/detail'
import xueshengAdd from '../pages/xuesheng/add'
import jianzhirenyuanList from '../pages/jianzhirenyuan/list'
import jianzhirenyuanDetail from '../pages/jianzhirenyuan/detail'
import jianzhirenyuanAdd from '../pages/jianzhirenyuan/add'
import paotuidingdanList from '../pages/paotuidingdan/list'
import paotuidingdanDetail from '../pages/paotuidingdan/detail'
import paotuidingdanAdd from '../pages/paotuidingdan/add'
import paotuijiedanList from '../pages/paotuijiedan/list'
import paotuijiedanDetail from '../pages/paotuijiedan/detail'
import paotuijiedanAdd from '../pages/paotuijiedan/add'
import dingdanpeisongList from '../pages/dingdanpeisong/list'
import dingdanpeisongDetail from '../pages/dingdanpeisong/detail'
import dingdanpeisongAdd from '../pages/dingdanpeisong/add'
import dingdanqianshouList from '../pages/dingdanqianshou/list'
import dingdanqianshouDetail from '../pages/dingdanqianshou/detail'
import dingdanqianshouAdd from '../pages/dingdanqianshou/add'
import fuwupingjiaList from '../pages/fuwupingjia/list'
import fuwupingjiaDetail from '../pages/fuwupingjia/detail'
import fuwupingjiaAdd from '../pages/fuwupingjia/add'
import zaixianliuyanList from '../pages/zaixianliuyan/list'
import zaixianliuyanDetail from '../pages/zaixianliuyan/detail'
import zaixianliuyanAdd from '../pages/zaixianliuyan/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'forum',
					component: Forum
				},
				{
					path: 'forumAdd',
					component: ForumAdd
				},
				{
					path: 'forumDetail',
					component: ForumDetail
				},
				{
					path: 'myForumList',
					component: MyForumList
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'xuesheng',
					component: xueshengList
				},
				{
					path: 'xueshengDetail',
					component: xueshengDetail
				},
				{
					path: 'xueshengAdd',
					component: xueshengAdd
				},
				{
					path: 'jianzhirenyuan',
					component: jianzhirenyuanList
				},
				{
					path: 'jianzhirenyuanDetail',
					component: jianzhirenyuanDetail
				},
				{
					path: 'jianzhirenyuanAdd',
					component: jianzhirenyuanAdd
				},
				{
					path: 'paotuidingdan',
					component: paotuidingdanList
				},
				{
					path: 'paotuidingdanDetail',
					component: paotuidingdanDetail
				},
				{
					path: 'paotuidingdanAdd',
					component: paotuidingdanAdd
				},
				{
					path: 'paotuijiedan',
					component: paotuijiedanList
				},
				{
					path: 'paotuijiedanDetail',
					component: paotuijiedanDetail
				},
				{
					path: 'paotuijiedanAdd',
					component: paotuijiedanAdd
				},
				{
					path: 'dingdanpeisong',
					component: dingdanpeisongList
				},
				{
					path: 'dingdanpeisongDetail',
					component: dingdanpeisongDetail
				},
				{
					path: 'dingdanpeisongAdd',
					component: dingdanpeisongAdd
				},
				{
					path: 'dingdanqianshou',
					component: dingdanqianshouList
				},
				{
					path: 'dingdanqianshouDetail',
					component: dingdanqianshouDetail
				},
				{
					path: 'dingdanqianshouAdd',
					component: dingdanqianshouAdd
				},
				{
					path: 'fuwupingjia',
					component: fuwupingjiaList
				},
				{
					path: 'fuwupingjiaDetail',
					component: fuwupingjiaDetail
				},
				{
					path: 'fuwupingjiaAdd',
					component: fuwupingjiaAdd
				},
				{
					path: 'zaixianliuyan',
					component: zaixianliuyanList
				},
				{
					path: 'zaixianliuyanDetail',
					component: zaixianliuyanDetail
				},
				{
					path: 'zaixianliuyanAdd',
					component: zaixianliuyanAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
