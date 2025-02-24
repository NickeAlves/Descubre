"use client";

import "./styles/globals.css";
import Header from "./components/Header";

function Home() {
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

        <div
          className="relative flex flex-col items-center justify-center h-screen bg-cover bg-center"
          style={{ backgroundImage: "url('/images/inverno-segovia.jpg')" }}
        >
          <div className="absolute inset-0 bg-black/30 backdrop-blur-md"></div>

          <h2 className="relative text-center text-6xl font-extrabold font-sans text-white z-10">
            Cities
          </h2>
          <p className="text-2xl relative text-start font-sans p-12 text-white z-10">
            Spain has a diverse climate due to its geographical location and
            varied terrain. In general, the country experiences three main
            climate types: Mediterranean, oceanic, and continental.
          </p>
        </div>
      </main>

      <footer></footer>
    </>
  );
}

export default Home;
