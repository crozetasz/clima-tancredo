const apiKey = 'SUA_CHAVE_API'; // Substitua com a sua chave da API OpenWeatherMap

function getWeather() {
  const city = document.getElementById('city').value;
  if (!city) {
    alert("Por favor, insira o nome da cidade.");
    return;
  }

  const url = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&units=metric&lang=pt_br`;

  fetch(url)
    .then(response => response.json())
    .then(data => {
      if (data.cod !== 200) {
        alert("Cidade não encontrada. Tente novamente.");
        return;
      }

      const cityName = data.name;
      const temperature = `${data.main.temp}°C`;
      const description = data.weather[0].description;

      document.getElementById('city-name').textContent = cityName;
      document.getElementById('temperature').textContent = `Temperatura: ${temperature}`;
      document.getElementById('description').textContent = `Descrição: ${description}`;

      document.getElementById('weather-info').style.display = 'block';
    })
    .catch(error => {
      console.error('Erro ao buscar os dados do clima:', error);
      alert('Ocorreu um erro ao buscar os dados. Tente novamente mais tarde.');
    });
}
