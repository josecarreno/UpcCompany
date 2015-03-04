 //seleccionar un departamento que no sea default
 $.validator.addMethod("valueNotEquals", function(value, element, arg){
  return arg !== value;
 }, "Value must not equal arg.");
 
$().ready(function () {
    $("#formEmpleado").validate({
        rules: {
            txtDNI: {
                required: true,
                digits: true,
                minlength: 8,
                maxlength: 8
            },
            txtNombre: {
                required: true,
                maxlength: 50
            },
            txtApellido: {
                required: true,
                maxlength: 50
            },
            selDepartamento: {
                valueNotEquals: "default"
            }
        },
        messages: {
            txtDNI: {
                digits: "Solo numeros",
                required: "DNI requerido",
                minlength: "El DNI debe tener 8 caracteres",
                maxlength: "El DNI debe tener 8 caracteres"
            },
            txtNombre: {
                required: "Nombre requerido",
                maxlength: "Maximo 50 caracteres"
            },
            txtApellido: {
                required: "Apellido requerido",
                maxlength: "Maximo 50 caracteres"
            },
            selDepartamento: {
                valueNotEquals: "Departamento requerido"
            }
        }
    });
    $("#formDepartamento").validate({
        rules: {
            txtNombre: {
                required: true,
                minlength: 3,
                maxlength: 50
            }
        },
        messages: {
            txtNombre: {
                required: "Nombre de departamento requerido",
                minlength: "El nombre debe tener al menos 3 letras",
                maxlength: "Maximo 50 caracteres"
            }
        }
    });
});
