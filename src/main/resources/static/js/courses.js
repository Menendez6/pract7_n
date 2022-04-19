
const table = document.getElementById("tabla");
var img = document.createElement('img');
var text;


async function mostrarCourses(){

    fetch("/api/courses") //Devuelve una promise
            .then(response =>  response.json())
            .then(data => {
                console.log(data)
                /*if(data.error){
                    document.querySelector('h1').innerHTML = "Not found";
                    return;
                }*/
                


                //Miramos a ver si hay más páginas antes o después de la actual
                
                for(let i = 0;i<data.length;i++){
                    
                    text = document.createTextNode("Sign up");
                    var btn = document.createElement("BUTTON");
                    btn.appendChild(text);

                    img = document.createElement('img');
                    img.style.height = '50%';
                    img.style.width = '50%';
                    img.src = "https://www.comillas.edu/images/Noticias/Curso_2017_18/Junio_18/LOGO_NUEVO_WEB.jpg";
                    
                    // Create an empty <tr> element and add it to the last position of the table:
                    var row = table.insertRow();

                    // Insert new cells (<td> elements) of the "new" <tr> element:
                    var cell1 = row.insertCell(0);
                    cell1.classList.add('align-middle');
                    var cell2 = row.insertCell(1);
                    cell2.classList.add('align-middle');
                    var cell3 = row.insertCell(2);
                    cell3.classList.add('align-middle');
                    var cell4 = row.insertCell(3);
                    cell4.classList.add('align-middle');
                    var cell5 = row.insertCell(4);
                    cell5.classList.add('align-middle');
                    
                    

                    // Add some text to the new cells:
                    cell1.appendChild(img);
                    cell2.innerHTML = data[i].courseName;
                    cell3.innerHTML = data[i].semester;
                    cell4.innerHTML = data[i].degree;
                    cell5.appendChild(btn);
                    cell5.appendChild(btn);

                }

        })
    
}


document.addEventListener('DOMContentLoaded',mostrarCourses())