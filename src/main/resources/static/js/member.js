let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		$("#btn-login").on("click", () => {
			this.login();
		});
	},

	save: function() {

		let data = {
			name: $("#name").val(),
			password: $("#password").val(),
			email: $("#email").val(),
			address: $("#address").val(),
		};

		$.ajax({
			type: "POST",
			url: "/join",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json",
		})
			.done(function(resp) {
				alert("회원가입이 완료되었습니다.");
				location.href = "/join";
				console.log(resp);
			})
			.fail(function() {
				alert(JSON.stringify(error));
			});
	},

	login: function() {

		let data = {
			name: $("#name").val(),
			password: $("#password").val(),
		};

		$.ajax({
			type: "POST",
			url: "/home",
			data: JSON.stringify(data), //JSON형태로 데이터를 뽑는다
			contentType: "application/json; charset=utf-8", //body data가 어떤타입인지
			dataType: "json", // 요청에 대한 응답이 왔을때 json으로 받겠다(응답은 기본적으로 String으로 온다)
		})
			.done(function(resp) {
				alert("로그인이 완료되었습니다.");
				location.href = "/success";
				console.log(resp);
			})
			.fail(function() {
				alert(JSON.stringify(error));
			});
	},
};
index.init();
