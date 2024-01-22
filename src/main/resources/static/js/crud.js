const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const entityTable = document.querySelector("tbody");
const selectElement = document.getElementById("entity");
const insertButton = document.getElementById("insertButton");
const updateButton = document.getElementById("updateButton");
const deleteButton = document.getElementById("deleteButton");
//const keyword = document.getElementById('keyword');

let page = 0;
let action = "";
let totalPages = 0;
let entityData = [];

selectElement.addEventListener("change", function () {
    page = 0;
    var selectedValue = selectElement.value;

    const requestData = {
        selectedValue: selectedValue,
    };
    postData(`/infoEntities`, requestData);
});

prevButton.addEventListener('click', async () => {
    if (page > 0) page--;
    updateUI();
});

nextButton.addEventListener('click', async () => {
    if (page < totalPages - 1) {
        page++;
        updateUI();
    }
});

async function changePage(URL) {
    fetch(URL)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data);
            entityData = data;
            updateUI();
            totalPages = Math.ceil(entityData.length / 10);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

async function postData(URL, data) {
    const formData = new FormData();
    for (const key in data) {
        formData.append(key, data[key]);
    }

    fetch(URL, {
        method: 'POST',
        body: formData,
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(responseData => {
            console.log(responseData);
            entityData = responseData;
            updateUI();
            totalPages = Math.ceil(entityData.length / 10);
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

// Función para actualizar la interfaz de usuario con los datos recibidos
function updateUI() {
    entityTable.innerHTML = "";

    if (entityData.length === 0) {
        // Si el array está vacío, mostrar un mensaje
        const noResultsRow = document.createElement("tr");
        const noResultsCell = document.createElement("td");
        noResultsCell.colSpan = Object.keys(entityData[0]).length + 2;
        noResultsCell.textContent = "No se encontraron resultados.";
        noResultsRow.appendChild(noResultsCell);
        entityTable.appendChild(noResultsRow);
        return;
    }

    const itemsPerPage = 10;
    const startIndex = page * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const currentEntities = entityData.slice(startIndex, endIndex);

    const headerRow = document.createElement("tr");

    for (const key in currentEntities[0]) {
        const headerCell = document.createElement("th");
        headerCell.textContent = key;
        headerRow.appendChild(headerCell);
    }

    entityTable.appendChild(headerRow);

    currentEntities.forEach(entity => {
        const row = document.createElement("tr");

        for (const key in entity) {
            const cell = document.createElement("td");
            cell.textContent = entity[key];
            row.appendChild(cell);
        }
        entityTable.appendChild(row);
    });
}

document.addEventListener("DOMContentLoaded", function () {
    showFields();
});

function showFields() {
    var selectedOption = selectElement.options[selectElement.selectedIndex].value;
    console.log(selectedOption);
    // Oculta todos los campos
    var allFields = document.querySelectorAll(".hidden");
    allFields.forEach(function (field) {
        field.style.display = "none";
    });

    // Muestra el campo correspondiente al valor seleccionado
    var selectedFields = document.getElementById(selectedOption + "Fields");
    console.log(selectedFields);
    if (selectedFields) {
        selectedFields.style.display = "block";
    }
    // Muestra el campo correspondiente al valor seleccionado (para actualización)
    var selectedUpdateFields = document.getElementById(selectedOption + "UpdateFields");
    console.log(selectedUpdateFields);
    if (selectedUpdateFields) {
        selectedUpdateFields.style.display = "block";
    }
}

changePage(`/allCountrys`);

let id;
let operation;
insertButton.addEventListener('click', () => {
    const selectedOption = selectElement.value;
    console.log(selectedOption);
    // Obtener todos los inputs del formulario actualmente seleccionado
    const inputs = Array.from(document.getElementById(selectedOption + "Fields").querySelectorAll("input"));
    //console.log("Inputs:", inputs);
    operation = 'insert';
    // Construir el objeto requestData
    const requestData = {
        operation: operation,
        entity: selectedOption,
        id: null,
        input1: inputs[0].value,
        input2: inputs[1] ? inputs[1].value : null,
    };

    postDataEntity('/operationEntities', requestData);
});

updateButton.addEventListener('click', () => {
    const selectedOption = selectElement.value;
    console.log(selectedOption);
    // Obtener todos los inputs del formulario actualmente seleccionado
    const inputs = Array.from(document.getElementById(selectedOption + "UpdateFields").querySelectorAll("input"));
    //console.log("Inputs:", inputs);
    operation = 'update';
    // Construir el objeto requestData
    const requestData = {
        operation: operation,
        entity: selectedOption,
        id: inputs[0].value,
        input1: inputs[1].value,
        input2: inputs[2] ? inputs[2].value : null,
    };
    postDataEntity('/operationEntities', requestData);
});
/*
keyword.addEventListener('input', () => {
    page = 0;
    const selectedOption = selectElement.value;
    operation = 'search';
    const requestData = {
           operation: operation,
           entity: selectedOption,
           id: keyword.value,
           input1: null,
           input2: null,
    };
    postData(`/filterMovies`, requestData);
    document.dispatchEvent(new KeyboardEvent('keydown', {'key': 'Enter'}));
})
*/

async function postDataEntity(URL, data) {
    const response = await fetch(URL, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    try {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const responseData = await response.text();
        console.log(response);
        alert(responseData);
    } catch (error) {
        alert("Error al procesar la solicitud: " + error.message);
    }
}

document.addEventListener('DOMContentLoaded', function () {
    var deleteButton = document.getElementById('deleteButton');
    var deleteModal = document.getElementById('deleteModal');
    var closeModalButton = deleteModal.querySelector('.close');
    var modalDeleteButton = deleteModal.querySelector('.modal-delete');
    var modalCancelButton = deleteModal.querySelector('.modal-cancel');

    // Mostrar el modal al hacer clic en el botón Eliminar
    deleteButton.addEventListener('click', function () {
        deleteModal.style.display = 'block';
    });

    // Ocultar el modal al hacer clic en el botón cerrar (X)
    closeModalButton.addEventListener('click', function () {
        deleteModal.style.display = 'none';
    });

    // Imprimir "Hola" en la consola al hacer clic en el botón Sí, eliminar
    modalDeleteButton.addEventListener('click', function () {
        const selectedOption = selectElement.value;
        console.log(selectedOption);
        // Obtener todos los inputs del formulario actualmente seleccionado
        const inputs = document.getElementById("deleteId");
        operation = 'delete';
        // Construir el objeto requestData
        const requestData = {
            operation: operation,
            entity: selectedOption,
            id: inputs.value,
            input1: inputs.value,
            input2: inputs[2] ? inputs[2].value : null,
        };
        postDataEntity('/operationEntities', requestData);
        deleteModal.style.display = 'none'; // Ocultar el modal después de imprimir en la consola
    });

    // Ocultar el modal al hacer clic en el botón No, cancelar
    modalCancelButton.addEventListener('click', function () {
        deleteModal.style.display = 'none';
    });
});
