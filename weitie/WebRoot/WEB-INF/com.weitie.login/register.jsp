<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html lang="en">
<head>
	<meta charset="utf-8" />
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	<title>欢迎注册</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <link rel="icon" type="image/png" href="<%=path %>/common/img/favicon.ico">
    <link href="<%=path %>/common/css/bootstrap.min.css" rel="stylesheet" />
	<link href="<%=path %>/common/css/gsdk-base.css" rel="stylesheet" />
    
    <link href="http://netdna.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.css" rel="stylesheet">
</head>

<body>
<div class="image-container set-full-height" style="background-image: url('<%=path %>/common/img/wizard.jpg')">
    <!--   Big container   -->
    <div class="container">
        <div class="row"> 
        <div class="col-sm-8 col-sm-offset-2">
           
            <!--      Wizard container        -->   
            <div class="wizard-container"> 
                
                <div class="card wizard-card ct-wizard-orange" id="wizardProfile">
                    <form action="<%=path %>/login/register" name="registerForm" method="post">
                <!--        You can switch "ct-wizard-orange"  with one of the next bright colors: "ct-wizard-blue", "ct-wizard-green", "ct-wizard-orange", "ct-wizard-red"             -->
                
                    	<div class="wizard-header">
                        	<h3>
                        	   WELCOME TO REGISTER  <br>
                        	   <small>Please fill the form Below</small>
                        	</h3>
                    	</div>
                              <div class="row">
                                  <h4 class="info-text"> Let's start with the basic information (with validation)</h4>
                                  <div class="col-sm-4 col-sm-offset-1">
                                     <div class="picture-container">
                                          <div class="picture">
                                              <img src="<%=path %>/common/img/default-avatar.png" class="picture-src" id="wizardPicturePreview" title=""/>
                                              <input type="file" id="wizard-picture">
                                          </div>
                                          <h6>Choose Picture</h6>
                                      </div>
                                  </div>
                                  <div class="col-sm-6">
                                      <div class="form-group">
                                        <label>Email <small>(required)</small></label>
                                        <input name="email" id="email" type="email" class="form-control" placeholder="andrew@creative-tim.com">
                                      </div>
                                      <div class="form-group">
                                        <label>Password  <small>(required)</small></label>
                                        <input name="password" type="text" class="form-control" placeholder="Smith...">
                                      </div>
                                      <div class="form-group">
                                        <label>ValidCode  <small>(required)</small></label><img src="<%=path %>/login/registergetValidateCode"  />
                                        <input name="valiCode" id="valiCode" type="text" class="form-control" >
                                      </div>
                                  </div> 
                              </div>
                       
                        <div class="wizard-footer">
                            <div class="pull-right">
                                <input type='submit' id ="submit" class='btn btn-next btn-fill btn-warning btn-wd btn-sm' name='next' value='Next' />
                                <input type='button' class='btn btn-finish btn-fill btn-warning btn-wd btn-sm' name='finish' value='Finish' />
        
                            </div>
                            
                            <div class="pull-left">
                                <input type='button' class='btn btn-previous btn-fill btn-default btn-wd btn-sm' name='previous' value='Previous' />
                            </div>
                            <div class="clearfix"></div>
                        </div>	
                    </form>
                </div>
            </div> <!-- wizard container -->
        </div>
        </div><!-- end row -->
    </div> <!--  big container -->
    
    
    <div class="footer">
        <div class="container">
             Made with <i class="fa fa-heart heart"></i> by <a href="http://www.baidu.com">sunqi</a>
        </div>
    </div>

</div>

</body>
    <script src="<%=path %>/common/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="<%=path %>/common/js/bootstrap.min.js" type="text/javascript"></script>
    <!--  More information about jquery.validate here: http://jqvueryvalidation.org/	 -->
	<script src="<%=path %>/common/js/jquery.validate.min.js"></script>
    <!--  methods for manipulating the wizard and the validation -->
	<script>
  var path="<%=path%>";
  function getValiCode(){
	  document.getElementById("valiCode").src="/weitie/login/registergetValidateCode?cache="+Math.random();
  }
  function validate(){
	    
	    $(".wizard-card form").validate({
			rules: {
				firstname: "required",
				password: "required",
				email: {
					required: true,
					email: true,
					remote: {
					    url: path+"/login/registercheck",     //后台处理程序
					    type: "post",               //数据发送方式
					    dataType: "json",           //接受数据格式   
					    data: {
					    	email: function() {
					    		return $("#email").val();
					        },
					        cache:function(){
					        	return Math.random();
					        }
			  				
					    }
					}
				}
				
	/*  other possible input validations
				,username: {
					required: true,
					minlength: 2
				},
				password: {
					required: true,
					minlength: 5
				},
				confirm_password: {
					required: true,
					minlength: 5,
					equalTo: "#password"
				},
			
				topic: {
					required: "#newsletter:checked",
					minlength: 2
				},
				agree: "required"
	*/			

			},
			messages: {
				password: "Please enter your Password",
				email: "Please enter a valid email address",

	/*   other posible validation messages
				username: {
					required: "Please enter a username",
					minlength: "Your username must consist of at least 2 characters"
				},
				password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long"
				},
				confirm_password: {
					required: "Please provide a password",
					minlength: "Your password must be at least 5 characters long",
					equalTo: "Please enter the same password as above"
				},
				email: "Please enter a valid email address",
				agree: "Please accept our policy",
				topic: "Please select at least 2 topics"
	*/
					
			}
		}); 
		
		if(!$(".wizard-card form").valid()){
	    	//form is invalid
	    	return false;
		}
		
		return true;
	}
  $(function(){  
	  $("#valiCode").click(getValiCode);
	//  $("#submit").click(validate);
	});  
</script>
</html>