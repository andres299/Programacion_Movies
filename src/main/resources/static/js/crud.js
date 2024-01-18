 function changeFormAction() {
        var accionSelect = document.getElementById("accion");
        var dynamicForm = document.getElementById("dynamicForm");

        var accionSeleccionada = accionSelect.value;

        if (accionSeleccionada === "agregar") {
            dynamicForm.action = "procesar-agregar";
        } else if (accionSeleccionada === "modificar") {
            dynamicForm.action = "procesar-modificar";
        } else if (accionSeleccionada === "borrar") {
            dynamicForm.action = "procesar-borrar";
        }
 }