const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const entityTable = document.querySelector("tbody");

let page = 0;
let action = "";
let totalPages = 0;
let entityData = [];

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
            moviesData = responseData;
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

changePage(`/allCountrys`);

function showFields() {
    // Obtener el valor seleccionado en el select
    var selectedEntity = document.getElementById("entity").value;
    console.log(selectedEntity);
    // Ocultar todos los campos
    hideAllFields();

    // Mostrar los campos correspondientes al valor seleccionado
    if (selectedEntity === "country") {
        document.getElementById("countryFields").classList.remove("hidden");
    } else if (selectedEntity === "language") {
        document.getElementById("languageFields").classList.remove("hidden");
    } else if (selectedEntity === "language_role") {
        document.getElementById("languageroleFields").classList.remove("hidden");
    } else if (selectedEntity === "genre") {
        document.getElementById("genreFields").classList.remove("hidden");
    } else if (selectedEntity === "keyword") {
        document.getElementById("keywordFields").classList.remove("hidden");
    } else if (selectedEntity === "production_company") {
        document.getElementById("production_companyFields").classList.remove("hidden");
    } else if (selectedEntity === "gender") {
        document.getElementById("genderFields").classList.remove("hidden");
    } else if (selectedEntity === "person") {
        document.getElementById("personFields").classList.remove("hidden");
    } else if (selectedEntity === "department") {
        document.getElementById("departmentFields").classList.remove("hidden");
    }
}

function hideAllFields() {
    var fields = document.querySelectorAll(".hidden");
        fields.forEach(function (field) {
            field.classList.add("hidden");
        });
}

showFields();