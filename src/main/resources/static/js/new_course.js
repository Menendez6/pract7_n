const form = document.getElementById("add");
const name_course = document.getElementById('typeNameX');
const semester = document.getElementById('typeSemesterX');
const degree = document.getElementById('typeDegreeX');
const errorBD = document.getElementById('errorBD');
const error = document.getElementById('error');
const errorEmail = document.getElementById('errorCorreo');
var num;
var ok = 1;


form.addEventListener("click", function (event) {
	// stop form submission
	event.preventDefault();
    if (validateForm()){
        mandarInfo();
    }
});

function validateForm(){

    if (name_course.value.trim() === "" || degree.value.trim() === "" || semester.value.trim() === ""){
        error.style.visibility = "visible";
        return false;
    }
    
    fetch("api/courses")
        .then(response => response.json())
        .then(data => {

            for(let i=0;i<data.length;i++){
                if (data[i].courseName == name_course.value && data[i].degree == degree.value){
                    errorBD.style.visibility = "visible";
                    return false
                }
            }
        })

    return true;
    
}

name_course.addEventListener("input", function (event) {

    error.style.visibility = "hidden";
    errorBD.style.visibility = "hidden";

});

semester.addEventListener("input", function (event) {

    error.style.visibility = "hidden";
    errorBD.style.visibility = "hidden";

});

degree.addEventListener("input", function (event) {

    error.style.visibility = "hidden";
    errorBD.style.visibility = "hidden";

});

async function mandarInfo(){
    let request = await fetch("api/add_course",{
        method: "POST",
        credentials: "same-origin",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            id: 0, 
            courseName: name_course.value,
            semester: semester.value,
            degree: degree.value
        }),
        datatype: "json",
    }).catch(console.error);

    if (request.ok){
        window.location.href = "./admin.html";
        console.log(await request.json());
    }
}