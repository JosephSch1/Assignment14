			var user = sessionStorage.getItem("user")
			
			if (user == null) {
				let name = prompt("What's your name?", "Guest")
				while (name === '' || name == null) {
					name = prompt("What's your name?", "Guest")
				}
				fetch('/users', {
					method: 'POST',
					body: name
				}).then(response => response.json())
				.then(user => {
					sessionStorage.setItem('user', JSON.stringify(user));
				})
			} else {
				user = JSON.parse(sessionStorage.getItem("user"))
				console.log(user)
			}