const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const moviesTable = document.querySelector("tbody");
const filterType = document.getElementById('filterType');
const keyword = document.getElementById('keyword');
const viewButtons = document.querySelectorAll('.view-button');
let page = 0;
let totalPages = 0;
let moviesData = [];
let infoDataMovies = [];

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

/*
async function changePage(URL) {
    fetch(URL)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            moviesData = data;
            updateUI();
            totalPages = Math.ceil(moviesData.length / 10);
        })
        .catch(error => {
            console.error('Error fetching movies:', error);
        });
}
*/

keyword.addEventListener('input', () => {
    page = 0;
    const requestData = {
        filterType: filterType.value,
        keyword: keyword.value
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
            totalPages = Math.ceil(moviesData.length / 10);
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

    const itemsPerPage = 10;
    const startIndex = page * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const currentMovies = moviesData.slice(startIndex, endIndex);

    currentMovies.forEach(movie => {
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

        viewButton.style.backgroundColor = "royalblue";

        // Agregar estilos adicionales para el hover
        viewButton.style.transition = "background-color 0.3s ease";
        viewButton.style.cursor = "pointer";

        // Agregar evento de hover
        viewButton.addEventListener("mouseover", function () {
            viewButton.style.backgroundColor = "cornflowerblue";
        });

        // Restaurar el color original al quitar el mouse del botón
        viewButton.addEventListener("mouseout", function () {
            viewButton.style.backgroundColor = "royalblue";
        });

        const optionsCell = document.createElement("td");
        optionsCell.appendChild(viewButton);
        row.appendChild(optionsCell);

        // Agregar evento al botón "View"
        viewButton.addEventListener("click", function () {
            const movieIdValue = this.value;
            console.log(movieIdValue);
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
        const movieIdValue = this.value;
        console.log(movieIdValue);
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

function handleInfoDataMovies(infoDataMovies) {
    const movieTitleElement = document.getElementById("movieTitle");
    const actorTableBody = document.getElementById("actorTableBody");

    // Inicializamos el contenido del título de la película
    movieTitleElement.textContent = "";

    // Limpiamos el cuerpo de la tabla antes de agregar nuevas filas
    actorTableBody.innerHTML = "";

    // Iteramos a través de las películas en infoDataMovies
    infoDataMovies.forEach(movie => {
        // Agregamos el título de la película al elemento correspondiente
        movieTitleElement.textContent += `${movie.title}\n`;

        // Verificamos si characterName es un array
        const characterNames = Array.isArray(movie.characterName) ? movie.characterName : [movie.characterName];

        // Verificamos si actorName es una cadena
        const actorNames = Array.isArray(movie.actorName) ? movie.actorName : [movie.actorNames];

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

//changePage(`/allMovies`);
