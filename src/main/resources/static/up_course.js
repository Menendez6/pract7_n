// Hacer el javascript del curso, que aparezca el nombre de las variables => Cargas desde el session storage, haces el request
// a la base de datos 
// Comprobar que modifica las variables iniciales
// Comprobar que el curso nuevo introducido no está en la base de datos

const form = document.getElementById("update");
const name_course = document.getElementById('typeNameX');
const semester = document.getElementById('typeSemesterX');
const degree = document.getElementById('typeDegreeX');
const errorBD = document.getElementById('errorBD');
const error = document.getElementById('error');
var id_course;


document.addEventListener('DOMContentLoaded', function(event){
    id_course = sessionStorage.getItem("courseId");
    api = "api/courses/"+id_course;
    fetch(api)
    .then(response =>  response.json())
    .then(data => {
        console.log(data);
        name_course.value = data.courseName;
        semester.value = data.semester;
        degree.value = data.degree;
    })
})

form.addEventListener("click", function (event) {
	// stop form submission
	event.preventDefault();
    if (validateForm()){
        mandarInfo();
    }
});

function validateForm(){

    if (name_course.value.trim() === ""){
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
    let request = await fetch("api/update_course",{
        method: "POST",
        credentials: "same-origin",
        headers: {
            "Content-type": "application/json"
        },
        body: JSON.stringify({
            id: id_course, 
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