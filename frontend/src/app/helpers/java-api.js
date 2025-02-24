const API_BASE_URL = "http://localhost:8080";

const getHeaders = (isJson = true) => {
  const headers = new Headers();
  if (isJson) {
    headers.append("Content-Type", "application/json");
  }
  return headers;
};

const api = {
  async getCities() {
    try {
      const response = await fetch(`${API_BASE_URL}/cities`, {
        headers: getHeaders(true),
      });

      if (!response.ok) {
        throw new Error(`HTTP error! status: ${response.status}`);
      }

      const data = await response.json();
      if (!data || !Array.isArray(data)) {
        throw new Error("Invalid response: expected an array of cities");
      }

      return data;
    } catch (err) {
      console.error("Error fetching cities: ", err);
      throw new Error(`Failed to fetch cities: ${err.message}`);
    }
  },
};

export default api;
