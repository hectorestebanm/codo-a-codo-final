const nombre = document.querySelector(".form__nombre");
const apellido = document.querySelector(".form__apellido");
const email = document.querySelector(".form__email");
const nombreError = document.querySelector(".form__nombre__error");
const apellidoError = document.querySelector(".form__apellido__error");
const emailError = document.querySelector(".form__email__error");
const cantidad = document.querySelector(".form__cantidad__input");
const categoria = document.querySelector(".form__categoria__select");
const pagar = document.querySelector(".total__pagar");
const borrar = document.querySelector(".form__btn__borrar");
const resumen = document.querySelector(".form__btn__resumen");

// Declaración de variables a usar para el cálculo de tickets
const ticket = 200;
const descEstudiante = 0.8;
const descTrainee = 0.5;
const descJunior = 0.15;

// Evento asociado al botón Borrar, que se encarga de limpiar la información
// ingresada en los campos 
borrar.addEventListener("click", ()=>
{
    nombre.value = "";
    nombreError.style.display = "none";
    apellido.value = "";
    apellidoError.style.display = "none";
    email.value = "";
    emailError.style.display = "none";
    cantidad.value = "";
    pagar.textContent = "El valor es: $";
    // Mensaje por alert() que informa que se limpiaran los campos
    alert("Se borrará el contenido de todos los campos ingresados");
});

// Evento asociado al botón Resumen, que se encarga de calcular el total de tickets
// y la verificación de campos vacíos
resumen.addEventListener("click", (e)=>
{
    e.preventDefault();
    // En caso que el campo "Nombre" quede vacio al momento de enviar los datos
    // se notificará por un mensaje de error en pantalla
    if(nombre.value === "")
    {
        nombreError.style.display = "block";
    }
    else
    {
        nombreError.style.display = "none";
    }
    // En caso que el campo "Apellido" quede vacio al momento de enviar los datos
    // se notificará por un mensaje de error en pantalla
    if(apellido.value === "")
    {
        apellidoError.style.display = "block";
    }
    else
    {
        apellidoError.style.display = "none";
    }
    // En caso que el campo "Correo" no corresponda a un correo válido
    // se notificará por un mensaje de error en pantalla
    if(!email.value.includes("@"))
    {
        emailError.style.display = "block";
    }
    else
    {
        emailError.style.display = "none";
    }
    // Switch que se encarga de aplicar el descuento según la categoría elegida
    switch(categoria.value)
    {
        // Cálculo de tickets por descuento de Estudiante
        case "Estudiante":
            total = cantidad.value * ticket - cantidad.value * ticket * descEstudiante;
            // Imprimo en la página el resultado, y un alert informando la categoría elegida
            pagar.textContent = `El valor es: $${total}`;
            alert("Elegiste categoria Estudiante");
            break;
        // Cálculo de tickets por descuento de Trainee
        case "Trainee":
            total = cantidad.value * ticket - cantidad.value * ticket * descTrainee;
            // Imprimo en la página el resultado, y un alert informando la categoría elegida
            pagar.textContent = `El valor es: $${total}`;
            alert("Elegiste categoria Trainee");
            break;
        // Cálculo de tickets por descuento de Junior
        case "Junior":
            total = cantidad.value * ticket - cantidad.value * ticket * descJunior;
            // Imprimo en la página el resultado, y un alert informando la categoría elegida
            pagar.textContent = `El valor es: $${total}`;
            alert("Elegiste categoria Junior");
            break;
        // No realizo cálculo si no se eligio categoría, y lo informo por un alert
        default:
            pagar.textContent = "El valor es: $";
            alert("No elegiste Categoria");
    }
    // Si los campos fueron ingresados correctamente, se informa por medio de un alert
    if(nombre.value !== "" && apellido.value !== "" && email.value !== "")
    {
        alert("Los campos de información fueron ingresados correctamente");
    }
});
