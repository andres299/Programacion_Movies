const prevButton = document.getElementById("prevButton");
const nextButton = document.getElementById("nextButton");
const moviesTable = document.querySelector("#table");

let page = 0;

prevButton.addEventListener('click', async () => {
    if (page > 0) page--;
    await changePage();
});

nextButton.addEventListener('click', async () => {
    page++;
    await changePage();
});

async function changePage() {
    fetch(`/moviesByPage?page=${page}`)
    .then(response => {
        if (!response.ok) console.log("Error");
        else return response.json();
    })
    .then(data => {
        console.log(data);
        //updateUI(data);
    })
    .catch(error => {
        console.error("Error fetching data:", error);
    });
}

// Función para actualizar la interfaz de usuario con los datos recibidos
function updateUI(data) {
console.log(data);
    moviesTable.innerHTML = "";

    data.forEach(movie => {
        const row = document.createElement("tr");
        console.log(movie)
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
        const director = movie.movieCrews.find(crew => crew.job === 'Director');
        if (director) {
            directorCell.textContent = director.person.person_name;
        }
        row.appendChild(directorCell);

        moviesTable.appendChild(row);
    });
}
