<template>
  <div :style='{"padding":"30px","background":"url(http://codegen.caihongy.cn/20220730/4b6f6d88fde34446904f3e1cd2807e39.png) center center/cover fixed no-repeat","height":"calc(100vh - 120px)"}'>
    <el-form
	  :style='{"padding":"30px","boxShadow":"0px 4px 10px 0px rgba(0,0,0,0.3020)","borderRadius":"0","flexWrap":"wrap","background":"#fff","display":"flex"}'
      class="add-update-preview"
      ref="ruleForm"
      :model="ruleForm"
      label-width="100px"
    >  
     <el-row>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}'   v-if="flag=='xuesheng'"  label="学生学号" prop="xueshengxuehao">
          <el-input v-model="ruleForm.xueshengxuehao" readonly              placeholder="学生学号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}'   v-if="flag=='xuesheng'"  label="学生姓名" prop="xueshengxingming">
          <el-input v-model="ruleForm.xueshengxingming"               placeholder="学生姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}' v-if="flag=='xuesheng'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in xueshengxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}'   v-if="flag=='xuesheng'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}'   v-if="flag=='xuesheng'"  label="地点" prop="didian">
          <el-input v-model="ruleForm.didian"               placeholder="地点" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}' v-if="flag=='xuesheng'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="xueshengtouxiangUploadChange"
          ></file-upload>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}'   v-if="flag=='jianzhirenyuan'"  label="账号" prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" readonly              placeholder="账号" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}'   v-if="flag=='jianzhirenyuan'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}' v-if="flag=='jianzhirenyuan'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in jianzhirenyuanxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}'   v-if="flag=='jianzhirenyuan'"  label="电话" prop="dianhua">
          <el-input v-model="ruleForm.dianhua"               placeholder="电话" clearable></el-input>
        </el-form-item>
        <el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}' v-if="flag=='jianzhirenyuan'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="jianzhirenyuantouxiangUploadChange"
          ></file-upload>
        </el-form-item>
		<el-form-item :style='{"width":"100%","margin":"0 0 20px 0"}' v-if="flag=='users'" label="用户名" prop="username">
			<el-input v-model="ruleForm.username" placeholder="用户名"></el-input>
		</el-form-item>
		<el-form-item :style='{"width":"100%","padding":"0","margin":"0"}'>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0","margin":"0 20px 0 0","outline":"none","color":"rgba(255, 255, 255, 1)","borderRadius":"30px","background":"#4662A1","width":"128px","lineHeight":"40px","fontSize":"14px","height":"40px"}' type="primary" @click="onUpdateHandler">修 改</el-button>
		</el-form-item>
      </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      ruleForm: {},
      flag: '',
      usersFlag: false,
      xueshengxingbieOptions: [],
      jianzhirenyuanxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.xueshengxingbieOptions = "男,女".split(',')
    this.jianzhirenyuanxingbieOptions = "男,女".split(',')
  },
  methods: {
    xueshengtouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    jianzhirenyuantouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.xueshengxuehao)&& 'xuesheng'==this.flag){
        this.$message.error('学生学号不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'xuesheng'==this.flag){
        this.$message.error('密码不能为空');
        return
      }


      if((!this.ruleForm.xueshengxingming)&& 'xuesheng'==this.flag){
        this.$message.error('学生姓名不能为空');
        return
      }






      if( 'xuesheng' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }




        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.zhanghao)&& 'jianzhirenyuan'==this.flag){
        this.$message.error('账号不能为空');
        return
      }


      if((!this.ruleForm.mima)&& 'jianzhirenyuan'==this.flag){
        this.$message.error('密码不能为空');
        return
      }


      if((!this.ruleForm.xingming)&& 'jianzhirenyuan'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }






      if( 'jianzhirenyuan' ==this.flag && this.ruleForm.dianhua&&(!isMobile(this.ruleForm.dianhua))){
        this.$message.error(`电话应输入手机格式`);
        return
      }


        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }




      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
	.el-date-editor.el-input {
		width: auto;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  color: #000;
	  	  font-weight: 500;
	  	  width: 100px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 100px;
	}
	
	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border: 2px solid #4662A1;
	  	  border-radius: 0;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border: 2px solid #4662A1;
	  	  border-radius: 0;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 2px solid #4662A1;
	  	  border-radius: 0;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: auto;
	  	  font-size: 14px;
	  	  height: 40px;
	  	}
	
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px dashed #4662A1;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #4662A1;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px dashed #4662A1;
	  	  cursor: pointer;
	  	  border-radius: 6px;
	  	  color: #4662A1;
	  	  width: 90px;
	  	  font-size: 32px;
	  	  line-height: 90px;
	  	  text-align: center;
	  	  height: 90px;
	  	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border: 2px solid #4662A1;
	  	  border-radius: 0;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px rgba(64, 158, 255, .5);
	  	  outline: none;
	  	  color: #000;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  height: 120px;
	  	}
</style>
