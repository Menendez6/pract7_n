const form = document.getElementById("login");
const user = document.getElementById('typeUserX');
const pass = document.getElementById('typePasswordX');
const error = document.getElementById('error');


form.addEventListener("click", function (event) {
	// stop form submission
	event.preventDefault();
	validateForm();

});

async function validateForm(){
    fetch("api/v1/customers")
        .then(response => response.json())
        .then(data => {

            for(let i=0;i<data.length;i++){
                if (data[i].customerName == user.value && data[i].customerPassword == pass.value){
                    window.location.href = "./burger.html?user="+data[i].id;
                    break
                }
            }

            error.style.visibility = "visible";
            pass.value = "";




        })
}

user.addEventListener("input", function (event) {

    error.style.visibility = "hidden";

});

pass.addEventListener("input", function (event) {

    error.style.visibility = "hidden";

});