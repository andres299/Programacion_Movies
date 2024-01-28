const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const moviesTable = document.querySelector("tbody");
const filterType = document.getElementById('filterType');
const keyword = document.getElementById('keyword');
const viewButtons = document.querySelectorAll('.view-button');

let page = 0;
let moviesData = [];
var infoDataMovies = [];

prevButton.addEventListener('click', async () => {
    if (page > 0) page--;
    if (keyword.value.trim() === '') {
        const requestData = {
            page: page
        };
        await postData(`/changePageMovies`, requestData);
    } else {
        const requestData = {
            filterType: filterType.value,
            keyword: keyword.value,
            page: page
        };
        postData(`/filterMovies`, requestData);
    }
    updateUI();
});

nextButton.addEventListener('click', async () => {
    page++;
    console.log(page);

    if (keyword.value.trim() === '') {
        const requestData = {
            page: page
        };
        await postData(`/changePageMovies`, requestData);
    } else {
        const requestData = {
            filterType: filterType.value,
            keyword: keyword.value,
            page: page
        };
        postData(`/filterMovies`, requestData);
    }
    updateUI();
});

keyword.addEventListener('input', () => {
    page = 0;
    const requestData = {
        filterType: filterType.value,
        keyword: keyword.value,
        page: page
    };
    postData(`/filterMovies`, requestData);
    document.dispatchEvent(new KeyboardEvent('keydown', { 'key': 'Enter' }));
})

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
        })
        .catch(error => {
            console.error('Error fetching data:', error);
        });
}

// Función para actualizar la interfaz de usuario con los datos recibidos
function updateUI() {
    moviesTable.innerHTML = "";

    if (moviesData.length === 0) {
        // Si el array está vacío, mostrar un mensaje
        const noResultsRow = document.createElement("tr");
        const noResultsCell = document.createElement("td");
        noResultsCell.colSpan = 8;
        noResultsCell.textContent = "No se encontraron resultados.";
        noResultsRow.appendChild(noResultsCell);
        moviesTable.appendChild(noResultsRow);
        return;
    }

    moviesData.forEach(movie => {
        const row = document.createElement("tr");
        const columns = [
            "title", "budget", "overview",
            "popularity", "releaseDate", "revenue", "voteAverage"
        ];

        columns.forEach(column => {
            const cell = document.createElement("td");
            cell.textContent = movie[column];
            row.appendChild(cell);
        });

        // Crear botón "View" en la columna de "Options"
        const viewButton = document.createElement("button");
        viewButton.classList.add("view-button");
        viewButton.textContent = "View";
        viewButton.value = movie.movieId;

        const optionsCell = document.createElement("td");
        optionsCell.appendChild(viewButton);
        row.appendChild(optionsCell);

        // Agregar evento al botón "View"
        viewButton.addEventListener("click", function () {
            const movieIdValue = this.value;
            const data = {
                movieId: parseInt(movieIdValue)
            };
            infoMoviesData(`/infoMovies`, data);

            // Mostrar el modal
            const modal = document.getElementById("myModal");
            const movieIdSpan = document.getElementById("movieIdSpan");

            modal.style.display = "flex";

            // Agregar evento para cerrar el modal haciendo clic en la 'x'
            const closeButton = document.getElementsByClassName("close")[0];
            closeButton.addEventListener("click", function () {
                modal.style.display = "none";
            });

            // Cerrar el modal si se hace clic fuera del contenido del modal
            window.addEventListener("click", function (event) {
                if (event.target === modal) {
                    modal.style.display = "block";
                }
            });
        });

        moviesTable.appendChild(row);
    });
}

viewButtons.forEach(viewButton => {
    viewButton.addEventListener("click", function () {
        var movieIdValue = this.value;
        const data = {
            movieId: parseInt(movieIdValue)
        };
        infoMoviesData(`/infoMovies`, data);

        // Mostrar el modal
        const modal = document.getElementById("myModal");
        const movieIdSpan = document.getElementById("movieIdSpan");

        modal.style.display = "flex";

        // Agregar evento para cerrar el modal haciendo clic en la 'x'
        const closeButton = document.getElementsByClassName("close")[0];
        closeButton.addEventListener("click", function () {
            modal.style.display = "none";
        });

        // Cerrar el modal si se hace clic fuera del contenido del modal
        window.addEventListener("click", function (event) {
            if (event.target === modal) {
                modal.style.display = "block";
            }
        });
    });
})

// Definición de la función infoMoviesData
function infoMoviesData(url, data) {
    fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.json())
        .then(result => {
            infoDataMovies = result;
            console.log(infoDataMovies);
            handleInfoDataMovies(infoDataMovies);
        })
        .catch(error => {
            console.error('Error en la solicitud:', error);
        });
}

var movieId;

function handleInfoDataMovies(infoDataMovies) {
    const movieTitleElement = document.getElementById("movieTitle");
    const actorTableBody = document.getElementById("actorTableBody");
    const genreTableBody = document.getElementById("genreTableBody");
    const directorTableBody = document.getElementById("directorTableBody");
    movieId = infoDataMovies[0].movieId;
    console.log(infoDataMovies);
    console.log(infoDataMovies[0].movieId);
    // Inicializamos el contenido del título de la película
    movieTitleElement.textContent = "";

    // Limpiamos el cuerpo de la tabla antes de agregar nuevas filas
    actorTableBody.innerHTML = "";
    genreTableBody.innerHTML = "";
    directorTableBody.innerHTML = "";

    // Iteramos a través de las películas en infoDataMovies
    infoDataMovies.forEach(movie => {
        // Agregamos el título de la película
        movieTitleElement.textContent += `${movie.title}\n`;

        // Verificamos si characterName es un array
        const characterNames = Array.isArray(movie.characterName) ? movie.characterName : [movie.characterName];

        // Verificamos si actorName es una cadena
        const actorNames = Array.isArray(movie.actorName) ? movie.actorName : [movie.actorNames];

        // Llenamos la tabla de género
        const genres = Array.isArray(movie.genre) ? movie.genre : [movie.genre];

        genres.forEach(genre => {
            const genreRow = genreTableBody.insertRow();
            const genreCell = genreRow.insertCell(0);
            genreCell.textContent = genre;
        });

        // Llenamos la tabla de directores
        movie.directorName.forEach(director => {
            const directorRow = directorTableBody.insertRow();
            const directorCell = directorRow.insertCell(0);
            directorCell.textContent = director;
        });
        // Iteramos a través de los actores y personajes en la película
        for (let i = 0; i < Math.max(characterNames.length, actorNames.length); i++) {
            // Creamos una nueva fila en la tabla
            const newRow = actorTableBody.insertRow();

            // Añadimos celdas a la fila para characterName y actorName
            const characterNameCell = newRow.insertCell(0);
            const actorNameCell = newRow.insertCell(1);

            // Agregamos los datos a las celdas
            characterNameCell.textContent = (characterNames[i] || '').trim();
            actorNameCell.textContent = (actorNames[i] || '').trim();
        }
    });
}

// Obtener elementos del DOM
var modal = document.getElementById('modal-options');
var btn = document.getElementById('options');
var closeBtn = document.getElementsByClassName('close')[0];

// Funciones para mostrar y ocultar el modal
function openModal() {
    modal.style.display = 'block';
}

function closeModal() {
    modal.style.display = 'none';
}

btn.onclick = function () {
    openModal();
    fillActorSelect();
    fillDirectorSelect();
    fillGenreSelect();
};

closeBtn.onclick = closeModal;

// Función para llenar el select con opciones de actorName
function fillActorSelect() {
    // Obtener el select y el div contenedor
    var actorSelectDelete = document.getElementById('actorSelectDelete');
    // Limpiar opciones actuales
    actorSelectDelete.innerHTML = '';

    infoDataMovies.forEach(movie => {
        const actorNames = Array.isArray(movie.actorName) ? movie.actorName : [movie.actorNames];

        actorNames.forEach(actor => {
            var option = document.createElement('option');
            option.value = actor;
            option.text = actor;
            actorSelectDelete.add(option);
        });
    });
}

function fillDirectorSelect() {
    // Obtener el select y el div contenedor
    var directorSelectDelete = document.getElementById('directorSelectDelete');
    // Limpiar opciones actuales
    directorSelectDelete.innerHTML = '';

    infoDataMovies.forEach(movie => {
        const directorNames = Array.isArray(movie.directorName) ? movie.directorName : [movie.directorName];

        directorNames.forEach(director => {
            var option = document.createElement('option');
            option.value = director;
            option.text = director;
            directorSelectDelete.add(option);
        });
    });
}

function fillGenreSelect() {
    // Obtener el select y el div contenedor
    var genreSelectDelete = document.getElementById('genreSelectDelete');
    // Limpiar opciones actuales
    genreSelectDelete.innerHTML = '';

    infoDataMovies.forEach(movie => {
        const genres = Array.isArray(movie.genre) ? movie.genre : [movie.genre];

        genres.forEach(genre => {
            var option = document.createElement('option');
            option.value = genre;
            option.text = genre;
            genreSelectDelete.add(option);
        });
    });
}

function showContent(contentType) {
    // Ocultar todos los contenidos
    document.getElementById('actorContent').style.display = 'none';
    document.getElementById('directorContent').style.display = 'none';
    document.getElementById('genreContent').style.display = 'none';

    // Mostrar el contenido correspondiente
    switch (contentType) {
        case 'actor':
            document.getElementById('actorContent').style.display = 'flex';
            break;
        case 'director':
            document.getElementById('directorContent').style.display = 'flex';
            break;
        case 'genre':
            document.getElementById('genreContent').style.display = 'flex';
            break;
        default:
            break;
    }
}

var actorInsertButton = document.getElementById('actorInsertButton');
var actorDeleteButton = document.getElementById('actorDeleteButton');
var DeleteActor = document.getElementById('actorSelectDelete');
var genderSelect = document.getElementById('genderSelect');
var genderSelect2 = document.getElementById('genderSelect2');
var genderSelect3 = document.getElementById('genderSelect3');

// Obtener el valor seleccionado
let operation;
let selectedOption;
console.log(movieId);
// Añadir event listeners
actorInsertButton.addEventListener('click', function () {
    selectedOption = 'Actor';
    operation = 'insert';
    var selectedGenderValue = genderSelect.value;
    // Obtener el contenedor del formulario
    const formContainer = document.getElementById(operation + selectedOption + 'Fields');
    const inputs = Array.from(formContainer.querySelectorAll('input'));
    console.log(movieId);
    const requestData = {
        movieId: movieId,
        operation: operation,
        entity: selectedOption,
        input1: inputs[0] ? inputs[0].value : null,
        input2: inputs[1] ? inputs[1].value : null,
        selected: null,
        gender: selectedGenderValue
    };
    postDataInfoMovies('/operationInfoMovies', requestData);
});

actorDeleteButton.addEventListener('click', function () {
    selectedOption = 'Actor';
    operation = 'delete';
    var selectedValueDelete = DeleteActor.value;
    console.log("movie" + movieId);
    // Obtener el contenedor del formulario
    const formContainer = document.getElementById(operation + selectedOption + 'Fields');
    const requestData = {
        movieId: movieId,
        operation: operation,
        entity: selectedOption,
        input1: null,
        input2: null,
        selected: selectedValueDelete
    };
    postDataInfoMovies('/operationInfoMovies', requestData);
});

// Event listener al botón de insertar Director
document.getElementById('DirectorInsertButton').addEventListener('click', function () {
    selectedOption = 'Director';
    operation = 'insert';
    var selectedGenderValue3 = genderSelect3.value;
    const formContainer = document.getElementById(operation + selectedOption + 'Fields');
    const inputs = Array.from(formContainer.querySelectorAll('input'));
    const requestData = {
        movieId: movieId,
        operation: operation,
        entity: selectedOption,
        input1: inputs[0].value,
        input2: null,
        selected: null,
        gender: selectedGenderValue3
    };
    postDataInfoMovies('/operationInfoMovies', requestData);
});

// Event listener al botón de insertar Director
document.getElementById('DirectorDeleteButton').addEventListener('click', function () {
    selectedOption = 'Director';
    operation = 'delete';
    var selectedGenderValue3 = genderSelect3.value;
    const formContainer = document.getElementById(operation + selectedOption + 'Fields');
    const inputs = Array.from(formContainer.querySelectorAll('input'));
    const SelectDelete = document.getElementById("directorSelectDelete");
    const directorSelectDelete = SelectDelete.value;
    const requestData = {
        movieId: movieId,
        operation: operation,
        entity: selectedOption,
        input1: null,
        input2: null,
        selected: directorSelectDelete,
        gender: selectedGenderValue3
    };
    postDataInfoMovies('/operationInfoMovies', requestData);
});

// Event listener al botón de insertar Genre
document.getElementById('GenreInsertButton').addEventListener('click', function () {
    selectedOption = 'Genre';
    operation = 'insert';
    const formContainer = document.getElementById(operation + selectedOption + 'Fields');
    const inputs = Array.from(formContainer.querySelectorAll('input'));
    const requestData = {
        movieId: movieId,
        operation: operation,
        entity: selectedOption,
        input1: inputs[0].value,
        input2: null,
        selected: null
    };
    postDataInfoMovies('/operationInfoMovies', requestData);
});

// Agregar event listener al botón de eliminar Genre
document.getElementById('GenreDeleteButton').addEventListener('click', function () {
    selectedOption = 'Genre';
    operation = 'delete';
    const select = document.getElementById('genreSelectDelete');
    const selectedValue = select.value;
    const requestData = {
        movieId: movieId,
        operation: operation,
        entity: selectedOption,
        input1: null,
        input2: null,
        selected: selectedValue
    };
    postDataInfoMovies('/operationInfoMovies', requestData);
});

async function postDataInfoMovies(URL, data) {
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