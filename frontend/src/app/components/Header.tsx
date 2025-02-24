import NavBar from "./NavBar";
import "./../styles/globals.css";

const Header = () => {
  return (
    <header className="p-2 bg-gray-800 sticky top-0 z-[20] mx-auto flex w-full items-center justify-between">
      <div className="flex items-center pl-6">
        <h1 className="pl-4 font-sans text-2xl font-medium">Descubre.io</h1>
        <div className="gap-8 flex items-center pl-64 font-sans font-medium text-2xl">
          <h2 className="pr-4 pl-4 rounded-full bg-gray-500">Welcome!</h2>
          <h2>|</h2>
          <h2 className="pr-4 pl-4 rounded-full bg-gray-500">¡Bienvenidos!</h2>
        </div>
      </div>
      <NavBar />
    </header>
  );
};

export default Header;
