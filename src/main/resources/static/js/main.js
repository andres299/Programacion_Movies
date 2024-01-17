const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const moviesTable = document.querySelector("tbody");

let page = 0;
let moviesData = [];

prevButton.addEventListener('click', async () => {
    if (page > 0) page--;
    updateUI();
});

nextButton.addEventListener('click', async () => {
    page++;
    updateUI();
});

async function changePage() {
    fetch(`/allMovies`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            // Páginación en el lado del cliente
            moviesData = data;
            updateUI();
        })
        .catch(error => {
            console.error('Error fetching movies:', error);
        });
}

// Función para actualizar la interfaz de usuario con los datos recibidos
function updateUI() {
    console.log(moviesData);
    moviesTable.innerHTML = "";

    const itemsPerPage = 10;
    const startIndex = page * itemsPerPage;
    const endIndex = startIndex + itemsPerPage;
    const currentMovies = moviesData.slice(startIndex, endIndex);

    currentMovies.forEach(movie => {
        const row = document.createElement("tr");
        const columns = [
            "movie_id", "title", "budget", "overview",
            "popularity", "release_date", "revenue", "vote_average"
        ];

        columns.forEach(column => {
            const cell = document.createElement("td");
            cell.textContent = movie[column];
            row.appendChild(cell);
        });

        const directorCell = document.createElement("td");

        row.appendChild(directorCell);

        moviesTable.appendChild(row);
    });
}

changePage();
