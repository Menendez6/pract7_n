const form = document.getElementById("signup");
const user = document.getElementById('typeUserX');
const email = document.getElementById('typeEmailX');
const pass = document.getElementById('typePasswordX');
const pass2 = document.getElementById('typePassword2X');
const errorUser = document.getElementById('errorUsuario');
const errorPassword = document.getElementById('errorPassword');
const errorEmail = document.getElementById('errorCorreo');
var num;
var ok = 1;

function validateEmail(input) {
	// check if the value is not empty
	if (input.trim()==="") {
		return false;
	}
	// validate email format
	const emailRegex =
		/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

	//const email = input.trim();
	if (!emailRegex.test(input)) {
        return false;
		//return showError(input);
	}
	return true;
}


form.addEventListener("click", function (event) {
	// stop form submission
	event.preventDefault();
    if (validateForm()){
        mandarInfo();
    }
});

function validateForm(){
    
    fetch("api/v1/customers")
        .then(response => response.json())
        .then(data => {

            num = data.length +1;
            for(let i=0;i<data.length;i++){
                if (data[i].customerName == user.value){
                    errorUser.style.visibility = "visible";
                    return false
                }
            }
        })
    if (user.value.trim() === ""){
        errorUser.style.visibility = "visible";
        return false;
    }
    if(pass.value != pass2.value || pass.value.trim() === ""){
        errorPassword.style.visibility = "visible";
        pass.value = "";
        pass2.value = "";
        return false;
    }
    if (!validateEmail(email.value)){
        errorEmail.style.visibility = "visible";
        return false;
    }
    return true;
    
}

user.addEventListener("input", function (event) {

    errorUser.style.visibility = "hidden";

});

email.addEventListener("input", function (event) {

    errorEmail.style.visibility = "hidden";

});

pass.addEventListener("input", function (event) {

    errorPassword.style.visibility = "hidden";

});

async function mandarInfo(){
    let request = await fetch("api/v1/customers",{
        method: "POST",
        credentials: "same-origin",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            id: num, 
            customerName: user.value,
            customerPassword: pass.value,
            customerEmail: email.value
        }),
        datatype: "json",
    }).catch(console.error);

    if (request.ok){
        window.location.href = "./index.html";
        console.log(await request.json());
    }
}