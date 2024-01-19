const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const entityTable = document.querySelector("tbody");
const selectElement = document.getElementById("entity");

let page = 0;
let action = "";
let totalPages = 0;
let entityData = [];

selectElement.addEventListener("change", function () {
    page = 0;
    //hideAllFields();
    //showFields();
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

    // Añadir encabezado para la columna de opciones
    //const optionsHeaderCell = document.createElement("th");
    //optionsHeaderCell.textContent = "Opciones";
    //headerRow.appendChild(optionsHeaderCell);

    entityTable.appendChild(headerRow);

    currentEntities.forEach(entity => {
        const row = document.createElement("tr");

        for (const key in entity) {
            const cell = document.createElement("td");
            cell.textContent = entity[key];
            row.appendChild(cell);
        }
        /*
        // Añadir botones de opciones (Editar y Eliminar) a cada fila
        const optionsCell = document.createElement("td");

        const editButton = document.createElement("button");
        editButton.textContent = "Editar";
        editButton.classList.add("edit-button");
        editButton.addEventListener("click", () => {
            action = "Editar";
            console.log(action);
        });

        const deleteButton = document.createElement("button");
        deleteButton.textContent = "Eliminar";
        deleteButton.classList.add("delete-button");
        deleteButton.addEventListener("click", () => {
            action = "Eliminar";
            page = 0;
            const requestData = {
                   id: .value,
                   action: action
            };
                postData(`/filterMovies`, requestData);
            });

        optionsCell.appendChild(editButton);
        optionsCell.appendChild(deleteButton);

        row.appendChild(optionsCell);
        */

        entityTable.appendChild(row);
    });
}

document.addEventListener("DOMContentLoaded", function() {
      // Al cargar la página, muestra el campo correspondiente al valor predeterminado
      showFields();
});

function showFields() {
    var selectedOption = selectElement.options[selectElement.selectedIndex].value;

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
}

changePage(`/allCountrys`);


