<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- <%@ include file = "/WEB-INF/views/template/header.jsp" %> --%>

<c:import url="/WEB-INF/views/template/header.jsp"/>

<style>
	.sign-box {
		margin-top: 30px;
	}
	.sign_title {
		border-bottom: 1px solid #D8D8D8;
		margin-bottom: 10px;
	}
</style>

<div class="container">
	<div class="sign-box">
		<div class="sign_title">
			<h3 style="color: #8e8989db;">회원가입</h3>
		</div>
		<form>
			<div class="sign_body">
				<div class="form-group">
					<input type="text" id="id" class="form-control" placeholder="아이디"/>
				</div>
				<div class="form-group">
					<input type="text" id="name" class="form-control" placeholder="이름"/>
				</div>
				<div class="form-group">
					<input type="text" id="nickname" class="form-control" placeholder="닉네임"/>
				</div>
				<div class="form-group">
					<input type="password" id="pwd" class="form-control" placeholder="비밀번호"/>
				</div>
				<div class="form-group">
					<input type="password" id="pwd2" class="form-control" placeholder="비밀번호 확인"/>
				</div> 
				<div class="form-group">
					<input type="text" id="email" class="form-control" placeholder="이메일"/>
				</div>
				<div class="form-group">
					<a href="javascript: sign();" class="btn btn-primary form-control">가입하기</a>
				</div>
			</div>
		</form>
	</div>
</div>

<script>
	function validationCheck() {
		if($("#id").val() == "" ) {
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		if($("#nickname").val() == "") {
			alert("닉네임을 입력해주세요.");
			$("#nickname").focus();
			return false;
		}
		if($("#pwd").val() == "" || checkPwd($("#pwd").val())) {
			alert("비밀번호를 입력해주세요.");
			$("#pw").focus();
			return false;
		}else if($("#pwd2").val() == "") {
			alert("비밀번호가 다릅니다. 확인해주세요.");
			$("#pwd2").focus();
			return false;
		}else if($("#pwd").val() != $("#pwd2").val()){
			alert("비밀번호가 일치하지 않습니다.");
			$("#pwd").focus();
			return false;
		}
		if($("#email").val()=="" || !checkEmail($("#email").val())) {
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		return true;
	}
	
	function sign() {
		
		var paramObj = {};
		
		if(validationCheck()) {
			if(!confirm("회원가입을 하시겠습니까?")) {
				return;
			}

			paramObj.userId = $("#id").val();
			paramObj.name = $("#name").val();
			paramObj.password = $("#pwd").val();
			paramObj.nickname = $("#nickname").val();
			paramObj.email = $("#email").val();
			paramObj.uesFlag = "Y";
			
			$.ajax({
				type: "POST",
				url : "<c:url value='/accounts/sign.do'/>",
				data : paramObj,
				success: function(data) {
					console.log("result ::: ",data.result);
					if(data.result > 0) {
						alert("회원가입이 완료되었습니다.");
					}else{
						alert("회원가입에 실패했습니다.");
					}
					location.href = "<c:url value='/main.do'/>";
				}
			});
		}
	}
	
	function checkEmail(email) {
		var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		
		if(email.match(regExp) != null) return true;
		else return false;
	}
	
	function checkPwd(pw) {
		var regExp = /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/;
		if(pw.length<6) {
		    alert("비밀번호는 영문,숫자,특수문자(!@$%^&* 만 허용)를 사용하여 6~16자까지, 영문은 대소문자를 구분합니다.");
		    return false;
		}
		if(pw.match(regExp) == null) {
		  alert("비밀번호는 영문,숫자,특수문자(!@$%^&* 만 허용)를 사용하여 6~16자까지, 영문은 대소문자를 구분합니다.");
		  return false;
		}
	}
</script>



<%@ include file = "/WEB-INF/views/template/footer.jsp" %>
