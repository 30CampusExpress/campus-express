export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["新增","查看","修改","删除"],"menu":"学生","menuJump":"列表","tableName":"xuesheng"}],"menu":"学生管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["新增","查看","修改","删除","审核","报表"],"menu":"兼职人员","menuJump":"列表","tableName":"jianzhirenyuan"}],"menu":"兼职人员管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["查看","修改","删除","报表"],"menu":"跑腿订单","menuJump":"列表","tableName":"paotuidingdan"}],"menu":"跑腿订单管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改","删除"],"menu":"跑腿接单","menuJump":"列表","tableName":"paotuijiedan"}],"menu":"跑腿接单管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","修改","删除"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除"],"menu":"订单签收","menuJump":"列表","tableName":"dingdanqianshou"}],"menu":"订单签收管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改","删除","评价统计"],"menu":"服务评价","menuJump":"列表","tableName":"fuwupingjia"}],"menu":"服务评价管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","修改","删除"],"menu":"在线留言","menuJump":"列表","tableName":"zaixianliuyan"}],"menu":"在线留言管理"},{"child":[{"appFrontIcon":"cuIcon-group","buttons":["查看","修改","删除"],"menu":"交流论坛","tableName":"forum"}],"menu":"交流论坛"},{"child":[{"appFrontIcon":"cuIcon-goodsnew","buttons":["查看","修改"],"menu":"关于我们","tableName":"aboutus"},{"appFrontIcon":"cuIcon-rank","buttons":["查看","修改"],"menu":"系统简介","tableName":"systemintro"},{"appFrontIcon":"cuIcon-pic","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"公告信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","接单"],"menu":"跑腿订单列表","menuJump":"列表","tableName":"paotuidingdan"}],"menu":"跑腿订单模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"兼职人员","menuJump":"列表","tableName":"jianzhirenyuan"}],"menu":"兼职人员管理"},{"child":[{"appFrontIcon":"cuIcon-brand","buttons":["新增","查看","修改","删除"],"menu":"跑腿订单","menuJump":"列表","tableName":"paotuidingdan"}],"menu":"跑腿订单管理"},{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看"],"menu":"跑腿接单","menuJump":"列表","tableName":"paotuijiedan"}],"menu":"跑腿接单管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","签收"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除","支付","评价"],"menu":"订单签收","menuJump":"列表","tableName":"dingdanqianshou"}],"menu":"订单签收管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","修改","删除"],"menu":"服务评价","menuJump":"列表","tableName":"fuwupingjia"}],"menu":"服务评价管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["新增","查看","修改","删除"],"menu":"在线留言","menuJump":"列表","tableName":"zaixianliuyan"}],"menu":"在线留言管理"},{"child":[{"appFrontIcon":"cuIcon-news","buttons":["查看"],"menu":"公告信息","tableName":"news"}],"menu":"系统管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","接单"],"menu":"跑腿订单列表","menuJump":"列表","tableName":"paotuidingdan"}],"menu":"跑腿订单模块"}],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"学生","tableName":"xuesheng"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-discover","buttons":["查看","修改","删除","配送"],"menu":"跑腿接单","menuJump":"列表","tableName":"paotuijiedan"}],"menu":"跑腿接单管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","修改","删除"],"menu":"订单配送","menuJump":"列表","tableName":"dingdanpeisong"}],"menu":"订单配送管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看"],"menu":"订单签收","menuJump":"列表","tableName":"dingdanqianshou"}],"menu":"订单签收管理"},{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看"],"menu":"服务评价","menuJump":"列表","tableName":"fuwupingjia"}],"menu":"服务评价管理"},{"child":[{"appFrontIcon":"cuIcon-link","buttons":["查看","审核"],"menu":"在线留言","menuJump":"列表","tableName":"zaixianliuyan"}],"menu":"在线留言管理"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","接单"],"menu":"跑腿订单列表","menuJump":"列表","tableName":"paotuidingdan"}],"menu":"跑腿订单模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"兼职人员","tableName":"jianzhirenyuan"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
