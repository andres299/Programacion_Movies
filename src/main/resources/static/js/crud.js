const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const entityTable = document.querySelector("tbody");
const selectElement = document.getElementById("entity");
const insertButton = document.getElementById("insertButton");
const updateButton = document.getElementById("updateButton");
const deleteButton = document.getElementById("deleteButton");
const keyword = document.getElementById('keyword');

let page = 0;
let action = "";
let totalPages = 0;
let entityData = [];
let id;
let operation;

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
            console.log('HTTP Status Code:', response.status);
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

function updateUI() {
    entityTable.innerHTML = "";

    if (entityData === null || entityData.length === 0) {
        console.log("vacio");
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

    // Obtén los nombres de las columnas de la primera fila de resultados
    const columnNames = Object.keys(currentEntities[0]);
    console.log(columnNames);
    // Utiliza los nombres de las columnas para crear los encabezados
    columnNames.forEach(columnName => {
        const headerCell = document.createElement("th");
        headerCell.textContent = columnName;
        headerRow.appendChild(headerCell);
    });

    entityTable.appendChild(headerRow);

    currentEntities.forEach(entity => {
        const row = document.createElement("tr");

        // Utiliza los nombres de las columnas para obtener los valores correspondientes
        columnNames.forEach(columnName => {
            const cell = document.createElement("td");
            cell.textContent = entity[columnName];
            row.appendChild(cell);
        });

        entityTable.appendChild(row);
    });
}

document.addEventListener("DOMContentLoaded", function () {
    showFields();
});

function showFields() {
    var selectedOption = selectElement.options[selectElement.selectedIndex].value;
    //localStorage.setItem("selectedEntity", selectedOption);
    console.log(selectedOption);
    // Oculta todos los campos
    var allFields = document.querySelectorAll(".hidden");
    allFields.forEach(function (field) {
        field.style.display = "none";
    });

    // Muestra el campo correspondiente al valor seleccionado
    var selectedFields = document.getElementById(selectedOption + "Fields");
    if (selectedFields) {
        selectedFields.style.display = "block";
    }
    // Muestra el campo correspondiente al valor seleccionado (para actualización)
    var selectedUpdateFields = document.getElementById(selectedOption + "UpdateFields");
    if (selectedUpdateFields) {
        selectedUpdateFields.style.display = "block";
    }
}

changePage(`/allCountrys`);

insertButton.addEventListener('click', () => {
    const selectedOption = selectElement.value;
    if (selectedOption === "movies") {
        handleMoviesInsert();
    } else {
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
    }
});

// Función específica para manejar la inserción de movies
function handleMoviesInsert() {
    const selectedOption = selectElement.value;
    operation = 'insert';
    // Obtener todos los inputs del formulario actualmente seleccionado
    const inputs = Array.from(document.getElementById(selectedOption + "Fields").querySelectorAll("input"));
    // Construir el objeto requestData
    const requestData = {
        operation: operation,
        movie_id: null,
        title: inputs[0].value,
        budget: inputs[1] ? inputs[1].value : null,
        homepage: inputs[2] ? inputs[2].value : null,
        overview: inputs[3] ? inputs[3].value : null,
        popularity: inputs[4] ? inputs[4].value : null,
        release_date: inputs[5] ? inputs[5].value : null,
        revenue: inputs[6] ? inputs[6].value : null,
        runtime: inputs[7] ? inputs[7].value : null,
        movie_status: inputs[8] ? inputs[8].value : null,
        tagline: inputs[9] ? inputs[9].value : null,
        vote_average: inputs[10] ? inputs[10].value : null,
        vote_count: inputs[11] ? inputs[11].value : null,
    };
    postDataEntity('/operationMovies', requestData);
}


updateButton.addEventListener('click', () => {
    const selectedOption = selectElement.value;
    if (selectedOption === "movies") {
            handleMoviesUpdate();
    } else {
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
    }
});

function handleMoviesUpdate() {
    const selectedOption = selectElement.value;
    operation = 'update';
    // Obtener todos los inputs del formulario actualmente seleccionado
    const inputs = Array.from(document.getElementById(selectedOption + "UpdateFields").querySelectorAll("input"));
    // Construir el objeto requestData
    const requestData = {
        operation: operation,
        movie_id: inputs[0].value,
        title: inputs[1].value,
        budget: inputs[2] ? inputs[2].value : null,
        homepage: inputs[3] ? inputs[3].value : null,
        overview: inputs[4] ? inputs[4].value : null,
        popularity: inputs[5] ? inputs[5].value : null,
        release_date: inputs[6] ? inputs[6].value : null,
        revenue: inputs[7] ? inputs[7].value : null,
        runtime: inputs[8] ? inputs[8].value : null,
        movie_status: inputs[9] ? inputs[9].value : null,
        tagline: inputs[10] ? inputs[10].value : null,
        vote_average: inputs[11] ? inputs[11].value : null,
        vote_count: inputs[12] ? inputs[12].value : null,
    };
    postDataEntity('/operationMovies', requestData);
}

keyword.addEventListener('input', () => {
    page = 0;
    const selectedOption = selectElement.value;
    operation = 'search';
    console.log(keyword.value);
    const requestData = {
        operation: operation,
        entity: selectedOption,
        id: null,
        input1: keyword.value,
        input2: null,
    };
    searchDataEntity(`/searchEntities`, requestData);
    document.dispatchEvent(new KeyboardEvent('keydown', { 'key': 'Enter' }));
})

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

async function searchDataEntity(URL, data) {
    try {
        const response = await fetch(URL, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        const responseData = await response.json();
        entityData = responseData;
        updateUI();
        totalPages = Math.ceil(entityData.length / 10);
    } catch (error) {
        console.error('Error fetching data:', error);
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
         if (selectedOption === "movies") {
                handleMoviesDelete();
         } else {
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
        }
        deleteModal.style.display = 'none'; // Ocultar el modal después de imprimir en la consola
    });

    // Ocultar el modal al hacer clic en el botón No, cancelar
    modalCancelButton.addEventListener('click', function () {
        deleteModal.style.display = 'none';
    });
});

function handleMoviesDelete() {
    const selectedOption = selectElement.value;
    operation = 'delete';
    // Obtener todos los inputs del formulario actualmente seleccionado
    const inputs = document.getElementById("deleteId");
    // Construir el objeto requestData
    const requestData = {
        operation: operation,
        movie_id: inputs.value,
        title: inputs.value,
        budget: null,
        homepage: null,
        overview: null,
        popularity: null,
        release_date: null,
        revenue: null,
        runtime:null,
        movie_status: null,
        tagline: null,
        vote_average: null,
        vote_count: null,
    };
    postDataEntity('/operationMovies', requestData);
}