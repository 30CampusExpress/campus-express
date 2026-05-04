const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootrv41o/",
            name: "springbootrv41o",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootrv41o/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于JAVAWeb的校园跑腿系统"
        } 
    }
}
export default base
