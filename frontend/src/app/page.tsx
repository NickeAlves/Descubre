"use client";

import "./styles/globals.css";
import Header from "./components/Header";
import api from "./helpers/java-api";
import { useState, useEffect } from "react";
import { usePathname } from "next/navigation";
import Link from "next/link";

interface City {
  id: string;
  name: string;
  postalCode: string;
  country: string;
}

function Home() {
  const [cities, setCities] = useState<City[]>([]);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);
  const pathname = usePathname();

  useEffect(() => {
    fetchCities();
  }, []);

  const fetchCities = async () => {
    try {
      const data = await api.getCities();
      setCities(data);
    } catch (err) {
      console.error("Error fetching cities: ", err);
      setError("Failed to load cities. Please, try again later.");
    } finally {
      setLoading(false);
    }
  };

  return (
    <>
      <Header />

      <main>
        <div
          className="relative flex flex-col items-center justify-center h-screen bg-cover bg-center"
          style={{ backgroundImage: "url('/images/spain-379535_1280.jpg')" }}
        >
          <div className="absolute inset-0 bg-black/30 backdrop-blur-md"></div>

          <h2 className="p-4 rounded-full bg-red-500 relative text-center text-6xl font-extrabold font-sans text-white z-10">
            Spain
          </h2>
          <p className="text-2xl relative text-start font-sans p-12 text-white z-10">
            Spain is a vibrant country in southwestern Europe, known for its
            rich history, diverse culture, and stunning landscapes. From the
            artistic heritage of cities like Madrid and Barcelona to the
            charming villages of Andalusia, Spain offers a unique blend of
            tradition and modernity. <br />
            <br /> Famous for its delicious cuisine, lively festivals, and
            beautiful Mediterranean beaches, it is a top destination for
            travelers seeking history, adventure, and relaxation.
          </p>
        </div>

        <div
          className="relative flex flex-col items-center justify-center h-screen bg-cover bg-center"
          style={{ backgroundImage: "url('/images/inverno-segovia.jpg')" }}
        >
          <div className="absolute inset-0 bg-black/30 backdrop-blur-md"></div>

          <h2 className="p-4 rounded-full bg-blue-400 relative text-center text-6xl font-extrabold font-sans text-white z-10">
            Climate
          </h2>
          <p className="text-2xl relative text-start font-sans p-12 text-white z-10">
            Spain has a diverse climate due to its geographical location and
            varied terrain. In general, the country experiences three main
            climate types: Mediterranean, oceanic, and continental.
            <br />
            <br /> The Mediterranean climate, predominant in most of the
            territory, is characterized by hot, dry summers and mild, rainy
            winters. Regions like Madrid, Barcelona, and Valencia experience
            this climate, making summers ideal for tourism and beach activities.
            <br />
            <br />
            In the north of the country, especially in Galicia, Asturias, and
            País Vasco, the oceanic climate prevails. These areas have moderate
            temperatures throughout the year and high rainfall, resulting in
            lush, green landscapes.
            <br />
            <br /> The continental climate, found in the interior, such as in
            central Spain and some areas of Castilla y León, is marked by cold
            winters and very hot summers, with significant temperature
            variations throughout the year. Additionally, in the Islas Canarias,
            the climate is subtropical, providing pleasant temperatures all year
            round. In the south, cities like Sevilla and Córdoba can experience
            extremely hot summers, with temperatures often exceeding 40°C.{" "}
            <br />
            <br />
            This climate diversity makes Spain an attractive destination
            throughout the year, offering options for those seeking sun, snow,
            or a cooler and more humid environment.
          </p>
        </div>

        <div className="gap-6 relative flex flex-col items-center justify-center min-h-screen bg-cover bg-center bg-gray-800">
          <h2 className="relative text-center text-5xl pb-12 font-extrabold font-sans text-white z-10">
            Cities
          </h2>

          {loading && <p className="text-white">Loading cities...</p>}
          {error && <p className="text-red-500">{error}</p>}

          {!loading && !error && (
            <div className="grid grid-cols-1 md:grid-cols-3 lg:grid-cols-3 gap-6 p-6 items-center w-full max-w-7xl">
              {cities.map((city) => (
                <div
                  key={city.id}
                  className="bg-white/10 rounded-lg p-6 text-white flex flex-col items-center justify-between h-full"
                >
                  <h3 className="text-2xl font-bold text-center mb-4">
                    {city.name}
                  </h3>
                  <Link href={`/cities/${city.id}`} passHref>
                    <button
                      className={`font-sans px-6 py-2 rounded-full transition-colors ${
                        pathname === "/"
                          ? "bg-red-500 text-white"
                          : "text-white hover:bg-red-400"
                      }`}
                    >
                      Learn more
                    </button>
                  </Link>
                </div>
              ))}
            </div>
          )}
        </div>
      </main>

      <footer></footer>
    </>
  );
}

export default Home;
