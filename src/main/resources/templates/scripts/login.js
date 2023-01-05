
function signin() {
    let signin = document.getElementById("signin");
    signin.addEventListener("click", function(e) {
       let email = document.getElementById("email");
       let pwd = document.getElementById("password");
       let postData = {
                          "email": email.value,
                          "password": pwd.value
                      };

       fetch("http://localhost:8888/api/auth/signin", {
        method: "POST",
        headers: {
         "Accept": "application/json",
         "Content-Type": "application/json"
         }
       , body: JSON.stringify(postData)})
       .then(function(data) { alert(data.json()); })
       .catch(function(error) { alert(error); })

    });
}

signin();